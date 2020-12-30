/**
 * 
 */
package org.openmrs.module.mohappointment.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openmrs.api.context.Context;
import org.openmrs.module.mohappointment.model.AppointmentServiceDefinition;
import org.openmrs.module.mohappointment.model.AppointmentStatus;
import org.openmrs.module.mohappointment.service.AppointmentService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.ParameterizableViewController;

/**
 * @author HP
 *
 */
public class AppointmentReportController extends ParameterizableViewController {
	
@Override
protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
		throws Exception {
	// TODO Auto-generated method stub
	
	AppointmentService apptService = Context.getService(AppointmentService.class);
	
	ModelAndView mav = new ModelAndView();
	
	List<AppointmentStatus> allAppointmentStatuses = apptService.getAllAppointmentStatuses();
	
	List<AppointmentServiceDefinition> serviceDefinitions = apptService.getAllAppointmentServicesDefinition();
	mav.addObject("allAppointmentStatuses", allAppointmentStatuses);
	mav.addObject("serviceDefinitions", serviceDefinitions);
	
	mav.setViewName(getViewName());
	
	
	return  mav;
}

}
