/**
 * 
 */
package org.openmrs.module.mohappointment.model;

import java.util.Date;

import org.openmrs.Person;
import org.openmrs.User;

/**
 * @author HP
 *
 */
public class MedServiceProvider {
	private Integer medServiceProviderId;
	private String name;
	private String title;
	
	private boolean voided;
	private Date voidedDate;
	private String voidedReason;
	private User voidedBy;
	private Person provider;
	private AppointmentServiceDefinition serviceDefinition;	
	private Date createdDate;
	private Date changedDate;
	private User creator;
	private User changedBy;
	/**
	 * @return the medServiceProviderId
	 */
	public Integer getMedServiceProviderId() {
		return medServiceProviderId;
	}
	/**
	 * @param medServiceProviderId the medServiceProviderId to set
	 */
	public void setMedServiceProviderId(Integer medServiceProviderId) {
		this.medServiceProviderId = medServiceProviderId;
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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @return the provider
	 */
	public Person getProvider() {
		return provider;
	}
	/**
	 * @param provider the provider to set
	 */
	public void setProvider(Person provider) {
		this.provider = provider;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
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
	 * @return the voidedReason
	 */
	public String getVoidedReason() {
		return voidedReason;
	}
	/**
	 * @param voidedReason the voidedReason to set
	 */
	public void setVoidedReason(String voidedReason) {
		this.voidedReason = voidedReason;
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

	
	
}
