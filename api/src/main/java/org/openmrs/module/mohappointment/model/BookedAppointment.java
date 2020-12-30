/**
 * 
 */
package org.openmrs.module.mohappointment.model;

/**
 * @author Faustin
 *
 */
public class BookedAppointment {
	private TimeSlot timeSlot;
	private PatientAppointment appointment;
	
	
	
	
	/**
	 * @param timeSlot
	 * @param appointment
	 */
	public BookedAppointment(TimeSlot timeSlot, PatientAppointment appointment) {
	
		this.timeSlot = timeSlot;
		this.appointment = appointment;
	}
	/**
	 * @return the timeSlot
	 */
	public TimeSlot getTimeSlot() {
		return timeSlot;
	}
	/**
	 * @param timeSlot the timeSlot to set
	 */
	public void setTimeSlot(TimeSlot timeSlot) {
		this.timeSlot = timeSlot;
	}
	/**
	 * @return the appointment
	 */
	public PatientAppointment getAppointment() {
		return appointment;
	}
	/**
	 * @param appointment the appointment to set
	 */
	public void setAppointment(PatientAppointment appointment) {
		this.appointment = appointment;
	}
	

}
