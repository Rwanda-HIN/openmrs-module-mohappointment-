/**
 * 
 */
package org.openmrs.module.mohappointment.model;

import java.sql.Time;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import org.openmrs.Location;
import org.openmrs.User;
/**
 * @author Faustin
 *
 */
public class AppointmentServiceDefinition {
	private Integer appointmentServiceId;
	private String name;
	private String description ;
	private Speciality specialty;
	private Time startTime;
	private Time endTime;
	private Integer maxAppointmentsLimit;
	private Location location;	
		
	private User creator;
	private Date createdDate;
	private boolean voided = false;
	private User voidedBy;
	private Date voidedDate;
	private String voidReason;
	private User changedBy;
	private Date changedDate;
	//private Set<ServiceWeeklyAvailability> weeklyAvailabilities ;
	//private Set<AppointmentServiceType> serviceTypes;

	/**
	 * @return the appointmentServiceId
	 */
	public Integer getAppointmentServiceId() {
		return appointmentServiceId;
	}
	/**
	 * @param appointmentServiceId the appointmentServiceId to set
	 */
	public void setAppointmentServiceId(Integer appointmentServiceId) {
		this.appointmentServiceId = appointmentServiceId;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the specialty
	 */
	public Speciality getSpecialty() {
		return specialty;
	}
	/**
	 * @param specialty the specialty to set
	 */
	public void setSpecialty(Speciality specialty) {
		this.specialty = specialty;
	}
	/**
	 * @return the startTime
	 */
	public Time getStartTime() {
		return startTime;
	}
	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}
	/**
	 * @return the endTime
	 */
	public Time getEndTime() {
		return endTime;
	}
		
	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	/**
	 * @return the location
	 */
	public Location getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(Location location) {
		this.location = location;
	}
	/**
	 * @return the creator
	 */
	public User getCreator() {
		return creator;
	}
	/**
	 * @param creator the creator to set
	 */
	public void setCreator(User creator) {
		this.creator = creator;
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
	/**
	 * @return the maxAppointmentsLimit
	 */
	public Integer getMaxAppointmentsLimit() {
		return maxAppointmentsLimit;
	}
	/**
	 * @param maxAppointmentsLimit the maxAppointmentsLimit to set
	 */
	public void setMaxAppointmentsLimit(Integer maxAppointmentsLimit) {
		this.maxAppointmentsLimit = maxAppointmentsLimit;
	}
	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}
	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	/**
	 * @return the voided
	 */
	public boolean isVoided() {
		return voided;
	}
	/**
	 * @param voided the voided to set
	 */
	public void setVoided(boolean voided) {
		this.voided = voided;
	}
	/**
	 * @return the voidedBy
	 */
	public User getVoidedBy() {
		return voidedBy;
	}
	/**
	 * @param voidedBy the voidedBy to set
	 */
	public void setVoidedBy(User voidedBy) {
		this.voidedBy = voidedBy;
	}
	/**
	 * @return the voidedDate
	 */
	public Date getVoidedDate() {
		return voidedDate;
	}
	/**
	 * @param voidedDate the voidedDate to set
	 */
	public void setVoidedDate(Date voidedDate) {
		this.voidedDate = voidedDate;
	}
	/**
	 * @return the voidReason
	 */
	public String getVoidReason() {
		return voidReason;
	}

	/**
	 * @return the changedBy
	 */
	public User getChangedBy() {
		return changedBy;
		}

	/**
	 * @param changedBy the changedBy to set
	 */
	public void setChangedBy(User changedBy) {
		this.changedBy = changedBy;
	}
	/**
	 * @return the changedDate
	 */
	public Date getChangedDate() {
		return changedDate;
	}
	/**
	 * @param changedDate the changedDate to set
	 */
	public void setChangedDate(Date changedDate) {
		this.changedDate = changedDate;
	}
	/**
	 * @param voidReason the voidReason to set
	 */
	public void setVoidReason(String voidReason) {
		this.voidReason = voidReason;
	}
	
	

}
