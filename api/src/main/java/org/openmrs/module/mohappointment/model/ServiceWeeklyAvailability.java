/**
 * 
 */
package org.openmrs.module.mohappointment.model;

import java.util.Date;

import org.openmrs.User;

/**
 * @author 
 *
 */
public class ServiceWeeklyAvailability {
	
	private Integer serviceWeeklyAvailabilityId;

	private String dayOfWeek;

	private String startTime;
	
	private String  endTime;

	private AppointmentServiceDefinition serviceDefinition;

	private Integer maxAppointmentsLimit;

	private User creator;
	
	private Date createdDate;
	
	private boolean voided = false;
	
	private User voidedBy;
	
	private Date voidedDate;
	
	private String voidReason;
	
	private User changedBy;
	
	private Date changedDate;

	/**
	 * @return the serviceWeeklyAvailabilityId
	 */
	public Integer getServiceWeeklyAvailabilityId() {
		return serviceWeeklyAvailabilityId;
	}

	/**
	 * @param serviceWeeklyAvailabilityId the serviceWeeklyAvailabilityId to set
	 */
	public void setServiceWeeklyAvailabilityId(Integer serviceWeeklyAvailabilityId) {
		this.serviceWeeklyAvailabilityId = serviceWeeklyAvailabilityId;
	}

	/**
	 * @return the dayOfWeek
	 */
	public String getDayOfWeek() {
		return dayOfWeek;
	}

	/**
	 * @param dayOfWeek the dayOfWeek to set
	 */
	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	/**
	 * @return the startTime
	 */
	public String getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the endTime
	 */
	public String getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	/**
	 * @return the serviceDefinition
	 */
	public AppointmentServiceDefinition getServiceDefinition() {
		return serviceDefinition;
	}

	/**
	 * @param serviceDefinition the serviceDefinition to set
	 */
	public void setServiceDefinition(AppointmentServiceDefinition serviceDefinition) {
		this.serviceDefinition = serviceDefinition;
	}

	/**
	 * @return the maxAppointmentsLimit
	 */
	public Integer getMaxAppointmentsLimit() {
		return maxAppointmentsLimit;
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
	 * @param maxAppointmentsLimit the maxAppointmentsLimit to set
	 */
	public void setMaxAppointmentsLimit(Integer maxAppointmentsLimit) {
		this.maxAppointmentsLimit = maxAppointmentsLimit;
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
	 * @param voidReason the voidReason to set
	 */
	public void setVoidReason(String voidReason) {
		this.voidReason = voidReason;
	}

}
