/**
 * 
 */
package org.openmrs.module.mohappointment.web.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openmrs.api.context.Context;
import org.openmrs.module.mohappointment.model.AppointmentServiceDefinition;
import org.openmrs.module.mohappointment.model.Speciality;
import org.openmrs.module.mohappointment.service.AppointmentService;
import org.openmrs.module.mohappointment.utils.AppointmentUtil;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.ParameterizableViewController;

/**
 * @author Faustin
 *
 */
public class AppointmentMedServiceListController extends ParameterizableViewController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ModelAndView mav = new ModelAndView();	
		
		
		AppointmentService apptService = Context.getService(AppointmentService.class);
		List<AppointmentServiceDefinition> services = apptService.getAllAppointmentServicesDefinition();
		List<Speciality> specialities = apptService.getAllSpecialities();
		
		HashMap<Speciality, List<AppointmentServiceDefinition>> mappedServices =AppointmentUtil.getMappedServices(specialities);
		
		mav.addObject("services",services);
		mav.addObject("mappedServices",mappedServices);
		System.out.println("The mapped  service"+mappedServices);
		
		mav.setViewName(getViewName());
		
		return mav;
	}

}
