/**
 * 
 */
package org.openmrs.module.mohappointment.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openmrs.api.context.Context;
import org.openmrs.module.mohappointment.model.MedServiceProvider;
import org.openmrs.module.mohappointment.service.AppointmentService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.ParameterizableViewController;

/**
 * @author Faustin
 *
 */
public class AppointmentMedServiceProvidersListController extends ParameterizableViewController {
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView mav = new ModelAndView();
		AppointmentService apptService = Context.getService(AppointmentService.class);
		List<MedServiceProvider> medServiceProviders = apptService.getAllMedServiceProviders();
		
System.out.println("How many providers  do we have >>>>>>>>"+medServiceProviders.size());
		
		
		mav.addObject("medServiceProviders", medServiceProviders);
		mav.setViewName(getViewName());	
				
		return mav ;
	}

}
