/**
 * 
 */
package org.openmrs.module.mohappointment.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openmrs.api.context.Context;
import org.openmrs.module.mohappointment.model.ProviderSchedule;
import org.openmrs.module.mohappointment.service.AppointmentService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.ParameterizableViewController;

/**
 * @author HP
 *
 */
public class AppoinmentProviderScheduleListController extends ParameterizableViewController {
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView mav = new ModelAndView();
		AppointmentService  apptService = Context.getService(AppointmentService.class);
		
		List<ProviderSchedule> providerSchedules = apptService.getAllProvidersSchedules();
				System.out.println("Provider schedules list >>>>>>>>"+providerSchedules);
		mav.addObject("providerSchedules", providerSchedules);
		
		
		mav.setViewName(getViewName());	
			
		return mav;
	}

}
