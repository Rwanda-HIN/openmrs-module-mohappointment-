/**
 * 
 */
package org.openmrs.module.mohappointment.model;

/**
 * @author Faustin
 *
 */
public class AppointmentStatus {
	
	private Integer appointmentStateId;
	private String description;
	/**
	 * @return the appointmentStateId
	 */
	public Integer getAppointmentStateId() {
		return appointmentStateId;
	}
	/**
	 * @param appointmentStateId the appointmentStateId to set
	 */
	public void setAppointmentStateId(Integer appointmentStateId) {
		this.appointmentStateId = appointmentStateId;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
}
