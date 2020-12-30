/**
 * 
 */
package org.openmrs.module.mohappointment.model;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import org.openmrs.User;

/**
 * @author Faustin
 *
 */
public class ProviderSchedule {

	private Integer providerScheduleId;

	private MedServiceProvider serviceProvider;

	private AppointmentServiceDefinition serviceDefinition;

	private AppointmentServiceType serviceType;

	private Date workingDate;

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

	Set<PatientAppointment> appointments;
	
	private Set<TimeSlot> timeSlots;

	/**
	 * @return the providerScheduleId
	 */
	public Integer getProviderScheduleId() {
		return providerScheduleId;
	}
	/**
	 * @param providerScheduleId the providerScheduleId to set
	 */
	public void setProviderScheduleId(Integer providerScheduleId) {
		this.providerScheduleId = providerScheduleId;
	}

	/**
	 * @return the workingDate
	 */
	public Date getWorkingDate() {
		return workingDate;
	}

	/**
	 * @param workingDate the workingDate to set
	 */
	public void setWorkingDate(Date workingDate) {
		this.workingDate = workingDate;
	}

	/**
	 * @return the serviceProvider
	 */
	public MedServiceProvider getServiceProvider() {
		return serviceProvider;
	}

	/**
	 * @param serviceProvider the serviceProvider to set
	 */
	public void setServiceProvider(MedServiceProvider serviceProvider) {
		this.serviceProvider = serviceProvider;
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
	 * @return the serviceType
	 */
	public AppointmentServiceType getServiceType() {
		return serviceType;
	}

	/**
	 * @param serviceType the serviceType to set
	 */
	public void setServiceType(AppointmentServiceType serviceType) {
		this.serviceType = serviceType;
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
	 * @return the timeSlots
	 */
	public Set<TimeSlot> getTimeSlots() {
		
		Set<TimeSlot> ret1 = new TreeSet<TimeSlot>();

		if (this.timeSlots != null) {
			for (TimeSlot timeSlot : this.timeSlots)
				ret1.addAll(timeSlots);
			// this should be all thats needed unless the encounter has been built by hand
			// if (o.isVoided() == false && o.isObsGrouping() == false)
			// ret.add(o);
		}

		return ret1;		
		
	}
	/**
	 * @param timeSlots the timeSlots to set
	 */
	public void setTimeSlots(Set<TimeSlot> timeSlots) {
		this.timeSlots = timeSlots;
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
	 * @return the appointments
	 */
	public Set<PatientAppointment> getAppointments() {

		Set<PatientAppointment> ret = new TreeSet<PatientAppointment>();

		if (this.appointments != null) {
			for (PatientAppointment appointment : this.appointments)
				ret.addAll(appointments);
			// this should be all thats needed unless the encounter has been built by hand
			// if (o.isVoided() == false && o.isObsGrouping() == false)
			// ret.add(o);
		}

		return ret;

	}

	/**
	 * @param appointments the appointments to set
	 */
	public void setAppointments(Set<PatientAppointment> appointments) {
		this.appointments = appointments;
	}

	/**
	 * @param changedDate the changedDate to set
	 */
	public void setChangedDate(Date changedDate) {
		this.changedDate = changedDate;
	}

}
