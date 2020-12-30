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
import org.openmrs.module.mohappointment.model.Days;
import org.openmrs.module.mohappointment.model.ServiceWeeklyAvailability;
import org.openmrs.module.mohappointment.model.Speciality;
import org.openmrs.module.mohappointment.service.AppointmentService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.ParameterizableViewController;
import org.springframework.web.servlet.view.RedirectView;

/**
 * @author Faustin
 *
 */
public class AppointmentMedServiceFormController extends ParameterizableViewController {
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView mav = new ModelAndView();

		AppointmentService apptService = Context.getService(AppointmentService.class);

		if (request.getParameter("save") != null) {
			
			//Get service parameters
			String serviceName = request.getParameter("serviceName");
			String description = request.getParameter("description");
			Integer specialtyId = Integer.valueOf(request.getParameter("specialtyId"));
						
			//get weekday parameters
			
			String weekDay = request.getParameter("weekDay");
			String startTime = request.getParameter("startTime");
			String endTime = request.getParameter("endTime");
			
			System.out.println(">>>>>>>>>>>>>>>>>>start time  from interface>>>>"+startTime);

			
			AppointmentServiceDefinition serviceDefinition = null;
			ServiceWeeklyAvailability weeklyAvailablity =null;

			if (request.getParameter("serviceId") != null && !request.getParameter("serviceId").equals("")) {
				
				Integer serviceId = Integer.valueOf(request.getParameter("serviceId"));
				serviceDefinition = apptService.getAppointmentServiceDefinition(serviceId);
			} else
				serviceDefinition = new AppointmentServiceDefinition();

			serviceDefinition.setName(serviceName);
			serviceDefinition.setDescription(description);
			
			serviceDefinition.setSpecialty(apptService.getSpecialty(specialtyId));
			serviceDefinition.setCreator(Context.getAuthenticatedUser());
			serviceDefinition.setCreatedDate(new Date());
			
			//we first save appointmentServiceDefinition
			
			 serviceDefinition = apptService.saveAppointmentServiceDefinition(serviceDefinition);	
			 System.out.println(">>>>>>>>>>>>>>>>>saveddddsceDefinition saved "+serviceDefinition.getAppointmentServiceId());
			
			//populate he  weekly availablity and then  save it
						 
			 weeklyAvailablity = new ServiceWeeklyAvailability();
			 weeklyAvailablity.setServiceDefinition(serviceDefinition);
			 weeklyAvailablity.setDayOfWeek(weekDay);
			 weeklyAvailablity.setStartTime(startTime);			
			 weeklyAvailablity.setEndTime(endTime);
			 weeklyAvailablity.setCreator(Context.getAuthenticatedUser());
			 weeklyAvailablity.setCreatedDate(new Date());
			 System.out.println("Save weekly availablity>>>>"+apptService.saveWeeklyAvailablity(weeklyAvailablity));
			 
			 weeklyAvailablity = apptService.saveWeeklyAvailablity(weeklyAvailablity);
			
			 return new ModelAndView(new RedirectView("medservices.list"));

		}

		List<Speciality> specialties = apptService.getAllSpecialities();
		// get a list of days in week from ENUM

		Days weekDays[] = Days.values();

		mav.addObject("specialties", specialties);
		mav.addObject("weekDays", weekDays);

		mav.setViewName(getViewName());
		
		return mav;
	}

}
