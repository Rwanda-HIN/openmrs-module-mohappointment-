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
import org.openmrs.module.mohappointment.model.AppointmentServiceType;
import org.openmrs.module.mohappointment.service.AppointmentService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.ParameterizableViewController;
import org.springframework.web.servlet.view.RedirectView;

import net.sf.saxon.value.ValidationErrorValue;

/**
 * @author Faustin
 *
 */
public class AppointmentServiceTypeFormController extends ParameterizableViewController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ModelAndView mav = new ModelAndView();
		AppointmentService apptService = Context.getService(AppointmentService.class);

		if (request.getParameter("save") != null) {

			String serviceName = request.getParameter("serviceName");
			String description = request.getParameter("description");
			Integer duration = Integer.valueOf(request.getParameter("serviceDuration"));
			Integer serviceId = Integer.valueOf(request.getParameter("serviceId"));
			AppointmentServiceDefinition serviceDefinition = apptService.getAppointmentServiceDefinition(serviceId);

			AppointmentServiceType apptServiceType = null;

			if (request.getParameter("serviceTypeId") != null
					&& request.getParameter("serviceTypeId").contentEquals("serviceId")) {
				Integer serviceTypeId = Integer.valueOf(request.getParameter("serviceId"));
				apptServiceType = apptService.getAppointmentServiceType(serviceTypeId);

			} else
				apptServiceType = new AppointmentServiceType();
			apptServiceType.setName(serviceName);
			apptServiceType.setDescription(description);
			apptServiceType.setDuration(duration);
			apptServiceType.setServiceDefinition(serviceDefinition);

			apptServiceType.setCreatedDate(new Date());
			apptServiceType.setCreator(Context.getAuthenticatedUser());

			apptServiceType = apptService.saveAppointmentServiceType(apptServiceType);

			return new ModelAndView(new RedirectView("appointmentTypes.list"));

		}

		List<AppointmentServiceDefinition> services = apptService.getAllAppointmentServicesDefinition();
		

		mav.addObject("services", services);
		mav.setViewName(getViewName());
		return mav;
	}

}
