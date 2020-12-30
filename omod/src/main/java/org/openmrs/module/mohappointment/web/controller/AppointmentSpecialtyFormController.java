/**
 * 
 */
package org.openmrs.module.mohappointment.web.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openmrs.api.context.Context;
import org.openmrs.module.mohappointment.model.Speciality;
import org.openmrs.module.mohappointment.service.AppointmentService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.ParameterizableViewController;
import org.springframework.web.servlet.view.RedirectView;

/**
 * @author Faustin
 *
 */
public class AppointmentSpecialtyFormController extends ParameterizableViewController {
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		AppointmentService appointmentService = Context.getService(AppointmentService.class);

		ModelAndView mav = new ModelAndView();

		if (request.getParameter("save") != null) {

			String name = request.getParameter("specialtyName");
			String description = request.getParameter("description");
			Speciality specialty = null;

			if (request.getParameter("specialtyId") != null && !request.getParameter("specialtyId").equals("")) {

				specialty = appointmentService.getSpecialty(Integer.valueOf(request.getParameter("specialtyId")));

			} else
				specialty = new Speciality();

			specialty.setName(name);
			specialty.setDescription(description);
			specialty.setCreatedDate(new Date());
			specialty.setCreator(Context.getAuthenticatedUser());

			// save the specialty
			appointmentService.saveSpecialty(specialty);
			
			return new ModelAndView(new RedirectView("specialities.list"));
			
		}

		mav.setViewName(getViewName());
		return mav;
	}

}
