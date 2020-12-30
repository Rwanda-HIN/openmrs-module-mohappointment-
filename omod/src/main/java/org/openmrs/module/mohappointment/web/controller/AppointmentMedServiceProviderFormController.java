/**
 * 
 */
package org.openmrs.module.mohappointment.web.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openmrs.Person;
import org.openmrs.Provider;
import org.openmrs.api.context.Context;
import org.openmrs.module.mohappointment.model.AppointmentServiceDefinition;
import org.openmrs.module.mohappointment.model.MedServiceProvider;
import org.openmrs.module.mohappointment.service.AppointmentService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.ParameterizableViewController;
import org.springframework.web.servlet.view.RedirectView;

/**
 * @author Faustin
 *
 */
public class AppointmentMedServiceProviderFormController extends ParameterizableViewController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView mav = new ModelAndView();
		AppointmentService apptService = Context.getService(AppointmentService.class);
		List<AppointmentServiceDefinition> serviceDefinitions = apptService.getAllAppointmentServicesDefinition();

		if (request.getParameter("save") != null && !request.getParameter("save").equals("")) {

			Integer providerId = Integer.valueOf(request.getParameter("providerId"));
			Integer serviceId = Integer.valueOf(request.getParameter("serviceId"));

			String title = request.getParameter("title");
			Person provider = Context.getUserService().getUser(providerId).getPerson();
			System.out.println(">>>>>>>>>>>>>>>get provider name "+provider.getPersonName()+" id>>>"+providerId);
			
			MedServiceProvider serviceProvider = new MedServiceProvider();

			serviceProvider.setName(provider.getGivenName());
			serviceProvider.setTitle(title);
			serviceProvider.setProvider(provider);
			serviceProvider.setServiceDefinition(apptService.getAppointmentServiceDefinition(serviceId));
			serviceProvider.setCreatedDate(new Date());
			serviceProvider.setCreator(Context.getAuthenticatedUser());
			
			apptService.saveMedServiceProvider(serviceProvider);
			
			 return new ModelAndView(new RedirectView("medServiceProvider.list"));
			
		}

		mav.addObject("serviceDefinitions", serviceDefinitions);

		mav.setViewName(getViewName());

		return mav;

	}
}
