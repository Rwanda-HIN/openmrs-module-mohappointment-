/*
 * Decompiled with CFR 0_123.
 *
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.openmrs.Concept
 *  org.openmrs.ConceptAnswer
 *  org.openmrs.Encounter
 *  org.openmrs.GlobalProperty
 *  org.openmrs.Location
 *  org.openmrs.Obs
 *  org.openmrs.Patient
 *  org.openmrs.Person
 *  org.openmrs.User
 *  org.openmrs.api.context.Context
 *  org.openmrs.module.mohappointment.model.Appointment
 *  org.openmrs.module.mohappointment.model.AppointmentState
 *  org.openmrs.module.mohappointment.model.BookedAppointment
 *  org.openmrs.module.mohappointment.model.ServiceProviders
 *  org.openmrs.module.mohappointment.model.Services
 *  org.openmrs.module.mohappointment.service.IAppointmentService
 */
package org.openmrs.module.mohappointment.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.User;
import org.openmrs.api.context.Context;
import org.openmrs.module.mohappointment.model.AppointmentServiceDefinition;
import org.openmrs.module.mohappointment.model.BookedAppointment;
import org.openmrs.module.mohappointment.model.PatientAppointment;
import org.openmrs.module.mohappointment.model.Speciality;
import org.openmrs.module.mohappointment.model.TimeSlot;
import org.openmrs.module.mohappointment.service.AppointmentService;

public class AppointmentUtil {
	private static Log log = LogFactory.getLog(AppointmentUtil.class);

	private static AppointmentService getAppointmentService() {

		return Context.getService(AppointmentService.class);
	}

	public static List<TimeSlot> getTimeSlotNotYeBooked(List<TimeSlot> timeSlots, List<TimeSlot> bookedTimeSlots) {
		// TODO Auto-generated method stub
		List<TimeSlot> notBookedTimeSlots = new ArrayList<TimeSlot>();

		for (TimeSlot timeSlot : timeSlots) {

			if (bookedTimeSlots.contains(timeSlot) == false) {
				notBookedTimeSlots.add(timeSlot);

			}

		}

		return notBookedTimeSlots;
	}

	public static Object[] getAppointmentBooking(List<TimeSlot> timeSlots, Set<PatientAppointment> appointments) {
		Object appointmentHistory[] = null;
		List<TimeSlot> bookedTimeSlots = new ArrayList<TimeSlot>();
		List<BookedAppointment> bookedAppointments = new ArrayList<BookedAppointment>();// only for booked appointments

		for (TimeSlot timeSlot : timeSlots) {
			BookedAppointment bookedAppointment;

			for (PatientAppointment appointment : appointments) {

				if (timeSlot == appointment.getTimeSlot()) {
					bookedTimeSlots.add(timeSlot);

					bookedAppointment = new BookedAppointment(timeSlot, appointment);
					bookedAppointments.add(bookedAppointment);
				}

			}
		}
		// store the appointment at zero index,index 1 for booked timeslots
		appointmentHistory = new Object[] { bookedAppointments, bookedTimeSlots };
		return appointmentHistory;
	}

	public static List<PatientAppointment> getTodayAppointmentsForProvider(User authUser, Date startDate,
			Date endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Gets schedule lenthtime in minutes
	 * 
	 * @param startTime
	 * @param endTime
	 * @return calculated length
	 * @throws ParseException
	 */
	public static long getscheduleLengthInMinutes(String startTime, String endTime) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		Date date1 = format.parse(startTime);
		Date date2 = format.parse(endTime);
		long scheduleLengthInMinutes = (date2.getTime() - date1.getTime()) / 60000;
		return scheduleLengthInMinutes;
	}

	/**
	 * @param specialities
	 * @return a hashMpa
	 */
	public static HashMap<Speciality, List<AppointmentServiceDefinition>> getMappedServices(
			List<Speciality> specialities) {

		HashMap<Speciality, List<AppointmentServiceDefinition>> mappedServices = new HashMap<Speciality, List<AppointmentServiceDefinition>>();

		for (Speciality speciality : specialities) {

			List<AppointmentServiceDefinition> servicesInSpeciality = getAppointmentService()
					.getServicesInSpeciality(speciality);

			if (servicesInSpeciality != null) {

				mappedServices.put(speciality, servicesInSpeciality);

			}

		}

		return mappedServices;
	}

}