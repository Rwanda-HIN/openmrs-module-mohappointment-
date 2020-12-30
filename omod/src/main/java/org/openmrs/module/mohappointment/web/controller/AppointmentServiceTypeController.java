/**
 * 
 */
package org.openmrs.module.mohappointment.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.openmrs.api.context.Context;
import org.openmrs.module.mohappointment.model.AppointmentServiceType;
import org.openmrs.module.mohappointment.service.AppointmentService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.ParameterizableViewController;

/**
 * @author HP
 *
 */
public class AppointmentServiceTypeController extends ParameterizableViewController {
	
@Override
protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
		throws Exception {
	
	ModelAndView mav = new ModelAndView();
	
	AppointmentService  appointService = Context.getService(AppointmentService.class);
	List<AppointmentServiceType> serviceTypes = appointService.getAllAppoinmentServiceTypes();
	mav.addObject("appointmentServiceTypes", serviceTypes);
	mav.setViewName(getViewName());
	
	return  mav;
}

}
