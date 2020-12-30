/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.mohappointment.web.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*import org.apache.commons.logging.Log;
 import org.apache.commons.logging.LogFactory;*/
import org.openmrs.User;
import org.openmrs.api.context.Context;
import org.openmrs.module.mohappointment.model.AppointmentServiceDefinition;
import org.openmrs.module.mohappointment.model.MedServiceProvider;
import org.openmrs.module.mohappointment.model.PatientAppointment;
import org.openmrs.module.mohappointment.model.ProviderSchedule;
import org.openmrs.module.mohappointment.service.AppointmentService;
import org.openmrs.module.mohappointment.utils.AppointmentUtil;
import org.openmrs.util.OpenmrsConstants;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.ParameterizableViewController;

/**
 * @author Faustin
 * 
 */
public class AppointmentDashboardByProviderFormController extends ParameterizableViewController {

	// private Log log = LogFactory.getLog(this.getClass());

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ModelAndView mav = new ModelAndView();
		AppointmentService apptService = Context.getService(AppointmentService.class);
		User authUser = Context.getAuthenticatedUser();

		// Check if the Provider is associated to the services and display associated
		// appointments but for today(current time)

		if (request.getParameter("serviceDefinitionId") != null && !request.getParameter("serviceDefinitionId").equals("")) {
			
			Integer  serviceDefinitionId =Integer.valueOf(request.getParameter("serviceDefinitionId"));
			AppointmentServiceDefinition  serviceDefinition = apptService.getAppointmentServiceDefinition(serviceDefinitionId);
			
			//get the providers associated to the authenticated user
			
			List<MedServiceProvider> serviceProviders = apptService.getMedServiceProvider(authUser.getPerson());
			
			MedServiceProvider serviceProvider = null;
			
			for (MedServiceProvider medServiceProvider : serviceProviders) {
				
				if (medServiceProvider.getServiceDefinition().equals(serviceDefinition)) {
					serviceProvider=medServiceProvider;
					break;
				}
				
			}
			//Get provider schedule for authenticated user but TODAY scheduled.
			Date todayDate = (request.getParameter("todayDate") != null&&  (request.getParameter("todayDate").trim().compareTo("") != 0) ? 
					(Date) Context.getDateFormat().parse(request.getParameter("todayDate")):null);
			System.out.println("Today date>>>>>>>>"+todayDate);
		
			ProviderSchedule providerSchedule = apptService.getProviderScheduleByServiceProvider(serviceProvider,todayDate);			
			
			
			mav.addObject("providerSchedule", providerSchedule);
			
		}		
	
		String defaultLoc = authUser.getUserProperties().get(OpenmrsConstants.USER_PROPERTY_DEFAULT_LOCATION);

		mav.setViewName(getViewName());

		mav.addObject("authenticatedUser", authUser);
		mav.addObject("authenticatedUserLoc",(null != defaultLoc) ? Context.getLocationService().getDefaultLocation() : "-");
		mav.addObject("todayDate", new Date());		
		
		List<AppointmentServiceDefinition> servicedefinitions = apptService.getAllServiceDefinitionsByProvider(authUser.getPerson());

		mav.addObject("serviceDefinitions", servicedefinitions);

		// filtering the Waiting Appointments
		// filterWaitingAppointments(request, mav, authUser, service);

		// getting the Upcoming Appointments
		// getUpcomingAppointments(mav, authUser, service);

		return mav;
	}

	/**
	 * Gets the Upcoming Appointments for a logged in Provider
	 * 
	 * @param mav      the Model and View
	 * @param authUser the Provider
	 * @param service  the AppointmentService
	 */
	private void getUpcomingAppointments(ModelAndView mav, User authUser, AppointmentService service) {

	}

	/**
	 * Gets and filters the Waiting Appointments for a logged in Provider
	 * 
	 * @param request  the HttpServletRequest
	 * @param mav      the Model and View
	 * @param authUser the Provider
	 * @param service  the AppointmentService
	 */
	private void filterWaitingAppointments(HttpServletRequest request, ModelAndView mav, User authUser,
			AppointmentService service) {
		String display = "none";
		List<PatientAppointment> waitingAppointment = AppointmentUtil.getTodayAppointmentsForProvider(authUser,
				new Date(), new Date());

	}

}
