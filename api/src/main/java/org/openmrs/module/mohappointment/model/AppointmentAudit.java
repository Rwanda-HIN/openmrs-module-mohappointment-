/**
 * 
 */
package org.openmrs.module.mohappointment.model;

import java.util.Date;

import org.openmrs.User;

/**
 * @author Faustin
 *
 */
public class AppointmentAudit {

	private Integer appointmentAuditId;

	private PatientAppointment appointment;

	private String notes;

	private AppointmentStatus status;

	private User creator;

	private Date createdDate;

	private boolean voided = false;

	private User voidedBy;

	private Date voidedDate;

	private String voidReason;

	private User changedBy;

	private Date changedDate;

}
