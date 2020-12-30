/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.mohappointment.db;

import java.util.Date;
import java.util.List;

import org.openmrs.Obs;
import org.openmrs.Patient;
import org.openmrs.Person;
import org.openmrs.module.mohappointment.model.AppointmentServiceDefinition;
import org.openmrs.module.mohappointment.model.AppointmentServiceType;
import org.openmrs.module.mohappointment.model.AppointmentStatus;
import org.openmrs.module.mohappointment.model.MedServiceProvider;
import org.openmrs.module.mohappointment.model.PatientAppointment;
import org.openmrs.module.mohappointment.model.ProviderSchedule;
import org.openmrs.module.mohappointment.model.ServiceWeeklyAvailability;
import org.openmrs.module.mohappointment.model.Speciality;
import org.openmrs.module.mohappointment.model.TimeSlot;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Faustin
 * 
 *         All services to be used by the Appointment Management module are
 *         defined (contracted) in this class. This is the DB Access layer side.
 */
@Transactional
public interface AppointmentDAO {


	public List<Speciality> getAllSpecialities();

	/**
	 * Gets specialty matching with specialtyId
	 * @param specialtyId
	 * @return specialty
	 */
	public Speciality getSpecialty(int specialtyId);

	/**
	 * saves speciality into DB
	 * @param specialty
	 */
	public void saveSpecialty(Speciality specialty);

	/**
	 * Gets  a list of medical  services
	 * @return a list of  AppoinmentService
	 */
	public List<AppointmentServiceDefinition> getAllAppointmentServicesDefinition();

	/**
	 * save the  appointmentservicedefinition to be saved
	 * @param appointmentService to be  saved
	 * @return the  saved appoinmentServiceDefinition
	 */
	public AppointmentServiceDefinition saveAppointmentServiceDefinition(
			AppointmentServiceDefinition appointmentService);

	/**
	 * Gets a list of  med  service providers
	 * @return a list of med service providers
	 */
	public List<MedServiceProvider> getAllMedServiceProviders();

	/**
	 * Gets a list of all  service type
	 * @return a list of all service type
	 */
	public List<AppointmentServiceType> getAllAppoinmentServiceTypes();

	/**
	 * Gets a list of provider  schedules 
	 * @return Listof provider  schedules
	 */
	public List<ProviderSchedule> providerSchedules();

	/**
	 * Gets AppointmentServiceDefinition  by service ID
	 * @param serviceId matching with AppointmentServiceDefinition 
	 * @return AppointmentServiceDefinition
	 */
	public AppointmentServiceDefinition getAppointmentServiceDefinition(Integer serviceId);

	/**
	 * Saves weeklyAvailablity into DB
	 * @param weeklyAvailablity
	 * @return the  saved weeklyAvailablity
	 */
	public ServiceWeeklyAvailability saveWeeklyAvailablity(ServiceWeeklyAvailability weeklyAvailablity);

	/**
	 * Gets appointment service Type by service Type Id
	 * @param serviceTypeId matcghing with the appointment service Type Id 
	 * @return appointmentService Type
	 */
	public AppointmentServiceType getAppointmentServiceType(Integer serviceTypeId);

	/**
	 * saves appointmentServiceType into DB
	 * @param apptServiceType to be  saved
	 * @return the  saved apptServiceType
	 */
	public AppointmentServiceType saveAppointmentServiceType(AppointmentServiceType apptServiceType);

	public MedServiceProvider getMedServiceProvider(Integer serviceProviderId);

	public List<ProviderSchedule> getProviderSchedulesByProvider(MedServiceProvider provider);
	/**
	 * Gets a list of Time slots 
	 * @return a list of Time  slots object
	 */
	public List<TimeSlot> getAllTimeSlots();

	/**
	 * Saves  and update time slot in database
	 * @return a saved time slot time into database
	 */
	public TimeSlot saveTimeSlot(TimeSlot timeSlot);

	/**
	 * Gets provider schedule 
	 * @param providSchedulerId matching with the provider schedule
	 * @return a searched provider schedule
	 */
	public ProviderSchedule getProviderSchedule(Integer providSchedulerId);

	/**
	 * Gets the time slot matching with the given time slot Id
	 * @param timeSlotId matching with the given time  slot id
	 * @return Time slot
	 */
	public TimeSlot getTimeSlot(Integer timeSlotId);

	/**
	 * Saves provider  schedule 
	 * @param schedule to be saved
	 * @return saved schedule 
	 */
	public ProviderSchedule saveProviderSchedule(ProviderSchedule schedule);

	/**
	 * saves appointment
	 * @param appointment to be  saved
	 */
	public void savePatientAppointment(PatientAppointment appointment);

	/**
	 * Gets a list of  appointments
	 * @return a List of  appointments
	 */
	public List<PatientAppointment> getAllPatientAppointments();

	/**
	 * @param patient
	 * @return a list of appointments
	 */
	public List<PatientAppointment> getAppointmentsByPatient(Patient patient);

	public PatientAppointment getBookedAppointmentOnTimeSlotByProviderSchedule(ProviderSchedule providerSchedule,
			TimeSlot timeSlot);

	public List<ProviderSchedule> getAllProvidersSchedules(MedServiceProvider provider, Date startDate, Date endDate);

	public List<ProviderSchedule> getAllProviderSchedulesByServicesBetweenDates(AppointmentServiceDefinition service,
			Date startDate, Date endDate);

	public List<ProviderSchedule> getAllProviderSchedulesByService(AppointmentServiceDefinition service,
			MedServiceProvider provider, Date startingDate, Date endingDate);

	public void saveMedServiceProvider(MedServiceProvider serviceProvider);

	/**
	 * Gets a list of appointmentserviceDefinitions by provider
	 * @param provider who is the provider we are looking for serviceDefinitions
	 * @return a list of  appointemntServiceDefinitions
	 */
	public List<AppointmentServiceDefinition> getAllServiceDefinitionsByProvider(Person provider);

	/**
	 * Gets a ,list of appointments
	 * @param serviceDefinition which is the service we are looking for  appointments
	 * @param startDate 
	 * @param endDate
	 * @return a list of appointments
	 */
	public List<PatientAppointment> getAppointmentsWithinServiceBetweenDates(
			AppointmentServiceDefinition serviceDefinition, Date startDate, Date endDate);

	/**
	 * Gets a list of medservice providers
	 * @param provider
	 * @return a list of med  service providers
	 */
	public List<MedServiceProvider> getMedServiceProvider(Person provider);

	/**
	 * Gets provider schedule by service provider on selected date
	 * @param serviceProvider
	 * @param workingDate
	 * @return provider schedule
	 */
	public ProviderSchedule getProviderScheduleByServiceProvider(MedServiceProvider serviceProvider,
			Date workingDate);

	/**
	 * Gets timeSlots 
	 * @param schedule
	 * @return
	 */
	public List<TimeSlot> getTimeSlotsByProviderSchedule(ProviderSchedule schedule);

	public PatientAppointment getPatientAppointmentByTimeSlot(TimeSlot timeSlot);

	public AppointmentStatus getAppointmentStatus(int appointmentStatusId);

	/**Gets a list of  services  by speciality
	 * @param speciality
	 * @return a list of  services 
	 */
	public List<AppointmentServiceDefinition> getServicesInSpeciality(Speciality speciality);

	/**
	 * Gets providerSchedule
	 * @param provider
	 * @param service
	 * @param workingDate
	 * @return providerschedule 
	 */
	public ProviderSchedule getProviderScheduleByServiceProvider(MedServiceProvider provider,
			AppointmentServiceDefinition service, Date workingDate);

	public List<AppointmentStatus> getAllAppointmentStatuses();






}

