/**
 * 
 */
package org.openmrs.module.mohappointment.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openmrs.Patient;
import org.openmrs.api.context.Context;
import org.openmrs.module.mohappointment.model.BookedAppointment;
import org.openmrs.module.mohappointment.model.PatientAppointment;
import org.openmrs.module.mohappointment.model.ProviderSchedule;
import org.openmrs.module.mohappointment.model.TimeSlot;
import org.openmrs.module.mohappointment.service.AppointmentService;
import org.openmrs.module.mohappointment.utils.AppointmentUtil;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.ParameterizableViewController;

/**
 * @author HP
 *
 */
public class AppointmentSearchAppointmentController extends ParameterizableViewController {

	@SuppressWarnings("unused")
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView mav = new ModelAndView();
		AppointmentService apptService = Context.getService(AppointmentService.class);
		
		if (request.getParameter("patientId")!=null && !request.getParameter("patientId").equals("")) {
			
			Integer patientId =Integer.valueOf(request.getParameter("patientId"));
			Patient patient = Context.getPatientService().getPatient(patientId);
			List<PatientAppointment> appointments = apptService.getAppointmentsByPatient(patient);	
			System.out.println("patient appointment  sizeeee"+appointments);
			mav.addObject("appointments", appointments);
			mav.addObject("patient", patient);
			}
		
		if (request.getParameter("providSchedulerId")!=null && ! request.getParameter("providSchedulerId").equals("")) {
			Integer providerScheduleId = Integer.valueOf(request.getParameter("providSchedulerId"));

			ProviderSchedule providerSchedule = apptService.getProviderSchedule(providerScheduleId);
			TreeSet<TimeSlot> timeSlots = (TreeSet<TimeSlot>) providerSchedule.getTimeSlots();
			
			List<BookedAppointment> bookedAppointments = new ArrayList<BookedAppointment>();
			List<TimeSlot>notBookedTimeSlots =new ArrayList<TimeSlot>();
			
			//get booked appt for each time slot	 
			
			for (TimeSlot timeSlot : timeSlots.descendingSet()){
				
				PatientAppointment patientAppt = apptService.getPatientAppointmentByTimeSlot(timeSlot);
								
				if (patientAppt!=null) {
					BookedAppointment bookedAppointment = new BookedAppointment(timeSlot, patientAppt);
					bookedAppointments.add(bookedAppointment);
					
				}
				else {
					notBookedTimeSlots.add(timeSlot);
					
				}
							
			}							

			/*
			 * Object[] appointmentBooking =
			 * AppointmentUtil.getAppointmentBooking(timeSlots,appointments);
			 * List<BookedAppointment> bookedAppointments =(List<BookedAppointment>)
			 * appointmentBooking[0]; List<TimeSlot> bookedTimeSlots =(List<TimeSlot>)
			 * appointmentBooking[1];
			 * 
			 * List<TimeSlot>notBookedTimeSlots
			 * =AppointmentUtil.getTimeSlotNotYeBooked(timeSlots,bookedTimeSlots);
			 */
		
					
			mav.addObject("providerSchedule", providerSchedule);
			mav.addObject("timeSlots", timeSlots);
			mav.addObject("appointmentViews", bookedAppointments);
			mav.addObject("notBookedTimeSlots", notBookedTimeSlots);

			}

		mav.setViewName(getViewName());

		return mav;
	}

}
