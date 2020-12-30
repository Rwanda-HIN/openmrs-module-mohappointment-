/**
 * 
 */
package org.openmrs.module.mohappointment.web.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openmrs.Patient;
import org.openmrs.api.context.Context;
import org.openmrs.module.mohappointment.model.AppointmentStatus;
import org.openmrs.module.mohappointment.model.PatientAppointment;
import org.openmrs.module.mohappointment.model.ProviderSchedule;
import org.openmrs.module.mohappointment.model.TimeSlot;
import org.openmrs.module.mohappointment.service.AppointmentService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.ParameterizableViewController;
import org.springframework.web.servlet.view.RedirectView;

/**
 * @author Faustin	
 * 
 * */
public class AppointmentFormController extends ParameterizableViewController {
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		AppointmentService apptService = Context.getService(AppointmentService.class);
		
		ModelAndView mav = new ModelAndView();
		Patient patient = null;	
		
		if (request.getParameter("patientId")!=null && !request.getParameter("patientId").equals("")) {
			
			Integer patientId = Integer.valueOf(request.getParameter("patientId"));
			patient = Context.getPatientService().getPatient(patientId);
			mav.addObject("patient",patient);
			 
		}
				
		Integer providerScheduleId  = Integer.valueOf(request.getParameter("scheduleId"));
		Integer timeSlotId = Integer.valueOf(request.getParameter("timeSlotId"));
		
		ProviderSchedule providerSchedule = apptService.getProviderSchedule(providerScheduleId);
		TimeSlot timeSlot = apptService.getTimeSlot(timeSlotId);
		
		if (request.getParameter("save")!=null) {
			AppointmentStatus status = apptService.getAppointmentStatus(1);
			
			Integer patientId = Integer.valueOf(request.getParameter("patientId"));
			patient = Context.getPatientService().getPatient(patientId);
			
			PatientAppointment appointment = new PatientAppointment();
			
			appointment.setPatient(patient);
			appointment.setProviderSchedule(providerSchedule);
			appointment.setStatus(status);			
			appointment.setTimeSlot(timeSlot);
			appointment.setCreatedDate(new Date());
			appointment.setCreator(Context.getAuthenticatedUser());			
			
			apptService.savePatientAppointment(appointment);
		
			 return new ModelAndView(new RedirectView("appointments.list"));
			
		}
	
		mav.addObject("providerSchedule", providerSchedule)	;
		mav.addObject("timeSlot",timeSlot);
		mav.setViewName(getViewName());
		
		return mav;
		
	}
}
