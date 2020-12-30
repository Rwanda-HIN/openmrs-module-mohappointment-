/**
 * 
 */
package org.openmrs.module.mohappointment.web.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openmrs.api.context.Context;
import org.openmrs.module.mohappointment.model.Speciality;
import org.openmrs.module.mohappointment.service.AppointmentService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.ParameterizableViewController;

/**
 * @author Faustin
 * 
 */
public class AppointmentSpecialitiesController extends ParameterizableViewController {
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
				
		ModelAndView mav = new ModelAndView();
		
		AppointmentService apptService = Context.getService(AppointmentService.class);
		
		List<Speciality> specialities = apptService.getAllSpecialities();
				
		mav.addObject("specialities",specialities);
		mav.setViewName(getViewName());
					
		return mav;
	}

}
