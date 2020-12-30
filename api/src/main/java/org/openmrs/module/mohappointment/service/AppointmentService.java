/**
 * 
 */
package org.openmrs.module.mohappointment.service;

import java.util.Date;
import java.util.List;

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

/**
 * @author Faustin
 *
 */
/**
 * @author HP
 *
 */
/**
 * @author HP
 *
 */
/**
 * @author HP
 *
 */
public interface AppointmentService {


	public List<Speciality> getAllSpecialities();
	
	/**
	 * Gets the  matching specialty by a given  specialtyId
	 * @param specialtyId
	 * @return the  specialty  matched
	 */
	public Speciality getSpecialty(int specialtyId);
	
	/**
	 * Saves the specialty in the database
	 * @param specialty is the  specialty to be  saved into db
	 */
	public void  saveSpecialty(Speciality specialty);
	
	/**
	 * gets a  list of appointment services
	 * @return a List of  appointment services
	 */
	public List<AppointmentServiceDefinition> getAllAppointmentServicesDefinition();
	
	/**
	 * Saves the  the  appointment service  definition into the DB
	 * @param appointmentService to be saved
	 * @return saved  appointmentService defintion
	 */
	public AppointmentServiceDefinition saveAppointmentServiceDefinition (AppointmentServiceDefinition appointmentService);

	/**
	 * Gets  a list of all med  service providers from  DB
	 * @return a list of  MedServiceProviders
	 */
	public List<MedServiceProvider> getAllMedServiceProviders();

	/**
	 * Gets a list of  service  types from  DB
	 * @return a list of  service type
	 */
	public List<AppointmentServiceType> getAllAppoinmentServiceTypes();

	/**
	 * Gets a list of  all  providers 
	 * @return
	 */
	public List<ProviderSchedule> getAllProvidersSchedules();

	/**
	 * Get appointmentServicedefinition by serviceId
	 * @param serviceId matching with the  appointmentServiceDefinition
	 * @return AppointmentServiceDefinition
	 */
	public AppointmentServiceDefinition getAppointmentServiceDefinition(Integer serviceId);

	/**
	 * saves  weekday (day,time )into DB
	 * @param weeklyAvailablity
	 * @return the  saved weeklyAvailblity
	 */
	public ServiceWeeklyAvailability saveWeeklyAvailablity(ServiceWeeklyAvailability weeklyAvailablity);

	/**
	 * Get appointment service Type by a given serviceTypeId
	 * @param serviceTypeId matching  with the appointment service Type  we are looking for
	 * @return appointmentServiceType
	 */
	public AppointmentServiceType getAppointmentServiceType(Integer serviceTypeId);

	/**
	 * Saves AppointmentServiceType into DB
	 * @param apptServiceType the appointmentmentService Type
	 * @return the saved appointment service Type
	 */
	public AppointmentServiceType saveAppointmentServiceType(AppointmentServiceType apptServiceType);

	/**
	 * Gets service provider by service provider id
	 * @param serviceProviderId
	 * @return MedServiceProvider matching  with the given  serviceProviderId
	 */
	public MedServiceProvider getMedServiceProvider(Integer serviceProviderId);

	/**
	 * Gets provider schedules by service provider
	 * @param provider matching  with 
	 * @return a list of providerschedule
	 */
	public List<ProviderSchedule> getProviderSchedulesByProvider(MedServiceProvider provider);

	/**
	 * Gets all  Time slots
	 * @return a list of Time slots objects
	 */
	public List<TimeSlot> getAllTimeSlots();
	
	
	/**
	 * Creates or updates the given time slot in the database.
	 * @param timeSlot to be saved into database
	 * @return a saved a time slot
	 */
	public TimeSlot saveTimeSlot(TimeSlot timeSlot);

	/**
	 * Gets provider schedule by a given provider schedule Id 
	 * @param providSchedulerId matching with the provider schedule we  are looking for 
	 * @return provider schedule 
	 */
	public ProviderSchedule getProviderSchedule(Integer providSchedulerId);

	/**
	 * Gets TimeSlot by a given timeSlot
	 * @param timeSlotId
	 * @return timeSlot matching with the given time slot
	 */
	public TimeSlot getTimeSlot(Integer timeSlotId);

	/**
	 * Saves provider schedule
	 * @param schedule to be saved
	 * @return Provider Schedule(saved schedule)
	 */
	public ProviderSchedule saveProviderSchedule(ProviderSchedule schedule);

	/**
	 * saves appointment
	 * @param appointment
	 */
	public void savePatientAppointment(PatientAppointment appointment);
	/**
	 * Gets all patients appointments
	 * @return a list of appointments 
	 */
	public List<PatientAppointment> getAllPatientAppointments();

	/**
	 * Gets patient appointment by patientId
	 * @param patientId matching with a given patientId
	 * @return a list of patient appointments
	 */
	public List<PatientAppointment> getAppointmentsByPatient(Patient patient);
	
	/**
	 * @param provider for whom we  are looking the schedule(availablity)
	 * @param StartDate the date matching with the provider scheduling date (starting date
	 * @param endDate the  date matching with the provider schedule date (ending date
	 * @return a list of providerschedule
	 */
	public List<ProviderSchedule> getAllProvidersSchedules(MedServiceProvider provider,Date StartDate,Date endDate);
	
	public List<ProviderSchedule> getAllProviderSchedulesByServicesBetweenDates(AppointmentServiceDefinition service,Date startDate,Date endDate);
	
    public List<ProviderSchedule> getAllProviderSchedulesByService(AppointmentServiceDefinition service,MedServiceProvider provider,Date startingDate,Date endingDate);

	public void saveMedServiceProvider(MedServiceProvider serviceProvider);

	/**
	 * Gets serviceDefinitions linked to every service provider
	 * @param person
	 * @return a List of servicedefinition
	 */
	public List<AppointmentServiceDefinition> getAllServiceDefinitionsByProvider(Person provider);
	/**
	 * @param serviceDefinition  for which we are looking appointments
	 * @param startDate
	 * @param endDate
	 * @return a list of appointments
	 */
	public List<PatientAppointment> getAppointmentsWithinServiceBetweenDates(AppointmentServiceDefinition serviceDefinition, Date startDate, Date endDate);

	/**
	 * Gets a List of medServiceProviders
	 * @param provider 
	 * @return a list of service providers(MedServiceProvider)
	 */
	public List<MedServiceProvider> getMedServiceProvider(Person provider);

	/**
	 * Gets provider schedule  by service provider 
	 * @param serviceProvider matching with the service provider we are looking for appointment
	 * @param workingDate
	 * @return providerSchedule
	 */
	public ProviderSchedule getProviderScheduleByServiceProvider(MedServiceProvider serviceProvider, Date workingDate);
	
	
	/**
	 * Gets a list of timeslots for  agiven providerschedule
	 * @param schedule matching with the given schedule
	 * @return a list of timeslots
	 */
	List<TimeSlot> getTimeSlotsByProviderSchedule(ProviderSchedule schedule);

	/**
	 * Gets patient appointment
	 * @param timeSlot matching with appointment we are looking for
	 * @return the patient appointment
	 */
	public PatientAppointment getPatientAppointmentByTimeSlot(TimeSlot timeSlot);

	/**
	 * Gets appointment status by ID
	 * @param appointmentStatusId
	 * @return AppointmentStatus
	 */
	public AppointmentStatus getAppointmentStatus(int appointmentStatusId);

	/**
	 * Gets a list of service by speciality
	 * @param speciality
	 * @return a list of  services
	 */
	public List<AppointmentServiceDefinition> getServicesInSpeciality(Speciality speciality);

	/**
	 * Gets provider schedule by service,workingDate,provider
	 * @param provider
	 * @param service
	 * @param workingDate
	 * @return provider schedule
	 */
	public ProviderSchedule getProviderScheduleByServiceProvider(MedServiceProvider provider,
			AppointmentServiceDefinition service, Date workingDate);

	/**
	 * Gets a list of appointment status
	 * @return list of appointment status
	 */
	public List<AppointmentStatus> getAllAppointmentStatuses();

		
	
	
	
	
	

}
