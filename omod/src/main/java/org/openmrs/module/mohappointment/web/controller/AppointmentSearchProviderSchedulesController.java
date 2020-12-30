/**
 * 
 */
package org.openmrs.module.mohappointment.web.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openmrs.api.context.Context;
import org.openmrs.module.mohappointment.model.AppointmentServiceDefinition;
import org.openmrs.module.mohappointment.model.MedServiceProvider;
import org.openmrs.module.mohappointment.model.ProviderSchedule;
import org.openmrs.module.mohappointment.service.AppointmentService;
import org.openmrs.util.OpenmrsUtil;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.ParameterizableViewController;

/**
 * @author Faustin
 *
 */
public class AppointmentSearchProviderSchedulesController extends ParameterizableViewController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		ModelAndView mav = new ModelAndView();
		AppointmentService apptService = Context.getService(AppointmentService.class);
		
		List<MedServiceProvider> serviceProviders = apptService.getAllMedServiceProviders();
		List<AppointmentServiceDefinition> serviceDefinitions = apptService.getAllAppointmentServicesDefinition();
		
		Date startDate = (request.getParameter("startDate") != null&&  (request.getParameter("startDate").trim().compareTo("") != 0) ? 
				(Date) Context.getDateFormat().parse(request.getParameter("startDate")):null);
		Date endDate = (request.getParameter("endDate") != null&&  (request.getParameter("endDate").trim().compareTo("") != 0) ? 
				(Date) Context.getDateFormat().parse(request.getParameter("endDate")):null);
		
		String medSvceProviderId = (request.getParameter("medSvceProviderId") != null && request.getParameter("medSvceProviderId").trim().compareTo("") != 0) ? request
				.getParameter("medSvceProviderId"): null;
		String serviceIdStr = (request.getParameter("serviceId") != null && request.getParameter("serviceId").trim().compareTo("") != 0) ? request
						.getParameter("serviceId"): null;
				
				if (request.getParameter("search") !=null) {
					
					Integer serviceProviderId = Integer.valueOf(medSvceProviderId);
					Integer serviceId = Integer.valueOf(serviceIdStr);
					
					AppointmentServiceDefinition service = apptService.getAppointmentServiceDefinition(serviceId);				
					MedServiceProvider provider =apptService.getMedServiceProvider(serviceProviderId);
						
					List<ProviderSchedule> providerSchedules = apptService.getAllProviderSchedulesByService(service, provider,startDate, endDate);
					
				
					mav.addObject("chosenService", service);
					mav.addObject("providerSchedules", providerSchedules);
					mav.addObject("serviceProvider", provider);
												
				}
				
			
	
		mav.addObject("serviceProviders", serviceProviders);
		mav.addObject("serviceDefinitions", serviceDefinitions);
		

		mav.setViewName(getViewName());

		return mav;
	}

}
