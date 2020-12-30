/**
 * 
 */
package org.openmrs.module.mohappointment.model;

import java.util.Date;

import org.openmrs.User;
import org.openmrs.util.OpenmrsUtil;

/**
 * @author Faustin
 *
 */
public class TimeSlot implements Comparable<TimeSlot>{
	
	private Integer timeSlotId;
	
	private ProviderSchedule providerSchedule;
	
	private String startTime;
	
	private String endTime;
	
	private User creator;

	private Date createdDate;

	private boolean voided = false;

	private User voidedBy;

	private Date voidedDate;

	private String voidReason;

	private User changedBy;

	private Date changedDate;
	


	/**
	 * 
	 */
	public TimeSlot() {
		
	}

	/**
	 * @param providerSchedule
	 * @param startTime
	 * @param endTime
	 * @param creator
	 * @param createdDate
	 */
	public TimeSlot(ProviderSchedule providerSchedule, String startTime, String endTime, User creator,
			Date createdDate) {		
		this.providerSchedule = providerSchedule;
		this.startTime = startTime;
		this.endTime = endTime;
		this.creator = creator;
		this.createdDate = createdDate;
	}

	/**
	 * @return the timeSlotId
	 */
	public Integer getTimeSlotId() {
		return timeSlotId;
	}

	/**
	 * @param timeSlotId the timeSlotId to set
	 */
	public void setTimeSlotId(Integer timeSlotId) {
		this.timeSlotId = timeSlotId;
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
	 * @return the providerSchedule
	 */
	public ProviderSchedule getProviderSchedule() {
		return providerSchedule;
	}

	/**
	 * @param providerSchedule the providerSchedule to set
	 */
	public void setProviderSchedule(ProviderSchedule providerSchedule) {
		this.providerSchedule = providerSchedule;
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

	@Override
	public int compareTo(TimeSlot other) {
		
		int ret = other.getTimeSlotId().compareTo(this.getTimeSlotId());
		if (ret == 0)
			ret = OpenmrsUtil.compareWithNullAsGreatest(this.getCreatedDate(),other.getCreatedDate());
		if (ret == 0 && this.getCreatedDate() != null)
			ret = OpenmrsUtil.compareWithNullAsGreatest(this.hashCode(),other.hashCode());
		return ret;
	}

}
