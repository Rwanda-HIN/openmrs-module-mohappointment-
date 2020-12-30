/**
 * 
 */
package org.openmrs.module.mohappointment.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openmrs.api.context.Context;
import org.openmrs.module.mohappointment.model.MedServiceProvider;
import org.openmrs.module.mohappointment.model.ProviderSchedule;
import org.openmrs.module.mohappointment.model.TimeSlot;
import org.openmrs.module.mohappointment.service.AppointmentService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.ParameterizableViewController;

/**
 * @author Faustin
 *
 */
public class AppointmentsByProviderController extends ParameterizableViewController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {		

		AppointmentService apptService = Context.getService(AppointmentService.class);
		ModelAndView mav = new ModelAndView();
		
		Integer providSchedulerId = Integer.valueOf(request.getParameter("providSchedulerId"));
		ProviderSchedule providerSchedule = apptService.getProviderSchedule(providSchedulerId);
		
		System.out.println(">>>>>>>>>>>>>>service name"+providerSchedule.getServiceDefinition().getName());
			
		
		List<TimeSlot> timeSlots = apptService.getAllTimeSlots();
		
		mav.addObject("serviceName",providerSchedule.getServiceDefinition().getName());
		mav.addObject("workingDate",providerSchedule.getWorkingDate());
		
		mav.addObject("timeSlots",timeSlots);
		
		mav.setViewName(getViewName());

		return mav;

	}

}
