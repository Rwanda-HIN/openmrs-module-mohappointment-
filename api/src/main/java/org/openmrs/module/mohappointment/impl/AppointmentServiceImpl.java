/**
 * 
 */
package org.openmrs.module.mohappointment.impl;

import java.util.Date;
import java.util.List;

import org.openmrs.Patient;
import org.openmrs.Person;
import org.openmrs.module.mohappointment.db.AppointmentDAO;
import org.openmrs.module.mohappointment.model.AppointmentServiceDefinition;
import org.openmrs.module.mohappointment.model.AppointmentServiceType;
import org.openmrs.module.mohappointment.model.AppointmentStatus;
import org.openmrs.module.mohappointment.model.MedServiceProvider;
import org.openmrs.module.mohappointment.model.PatientAppointment;
import org.openmrs.module.mohappointment.model.ProviderSchedule;
import org.openmrs.module.mohappointment.model.ServiceWeeklyAvailability;
import org.openmrs.module.mohappointment.model.Speciality;
import org.openmrs.module.mohappointment.model.TimeSlot;
import org.openmrs.module.mohappointment.service.AppointmentService;

/**
 * @author Faustin
 * 
 */
public class AppointmentServiceImpl implements AppointmentService {

	private AppointmentDAO appointmentDAO;

	public AppointmentDAO getAppointmentDAO() {
		return appointmentDAO;
	}

	public void setAppointmentDAO(AppointmentDAO appointmentDAO) {
		this.appointmentDAO = appointmentDAO;
	}

	@Override
	public List<Speciality> getAllSpecialities() {
		// TODO Auto-generated method stub
		return appointmentDAO.getAllSpecialities();
	}

	/**
	 *gets speciqlty by speciqlity Id
	 */
	@Override
	public Speciality getSpecialty(int specialtyId) {
		// TODO Auto-generated method stub
		return appointmentDAO.getSpecialty(specialtyId);
	}

	/**
	 *saves the specialty into DB
	 */
	@Override
	public void saveSpecialty(Speciality specialty) {
		// TODO Auto-generated method stub
		appointmentDAO.saveSpecialty(specialty);
		
	}

	@Override
	public List<AppointmentServiceDefinition> getAllAppointmentServicesDefinition() {
		// TODO Auto-generated method stub
		return appointmentDAO.getAllAppointmentServicesDefinition();
	}

	@Override
	public AppointmentServiceDefinition saveAppointmentServiceDefinition(
			AppointmentServiceDefinition appointmentService) {
		// TODO Auto-generated method stub
		return appointmentDAO.saveAppointmentServiceDefinition(appointmentService);
	}

	@Override
	public List<MedServiceProvider> getAllMedServiceProviders() {
		// TODO Auto-generated method stub
		return appointmentDAO.getAllMedServiceProviders();
	}

	/**
	 *
	 */
	@Override
	public List<AppointmentServiceType> getAllAppoinmentServiceTypes() {
		// TODO Auto-generated method stub
		return appointmentDAO.getAllAppoinmentServiceTypes();
	}

	@Override
	public List<ProviderSchedule> getAllProvidersSchedules() {
		// TODO Auto-generated method stub
		return appointmentDAO.providerSchedules();
	}

	@Override
	public AppointmentServiceDefinition getAppointmentServiceDefinition(Integer serviceId) {
		// TODO Auto-generated method stub
		return appointmentDAO.getAppointmentServiceDefinition(serviceId);
	}

	/**
	 *Saves the  weeklyAvailablity 
	 *return the  saved WeeklyAvailablity
	 */
	@Override
	public ServiceWeeklyAvailability saveWeeklyAvailablity(ServiceWeeklyAvailability weeklyAvailablity) {
		// TODO Auto-generated method stub
		return appointmentDAO.saveWeeklyAvailablity(weeklyAvailablity);
	}

	/**
	 *Get appointmentserviceType by serviceTypeId
	 *return the  matched appointmentserviceType
	 */
	@Override
	public AppointmentServiceType getAppointmentServiceType(Integer serviceTypeId) {
		// TODO Auto-generated method stub
		return appointmentDAO.getAppointmentServiceType(serviceTypeId);
	}

	/**
	 *saves the appointmentservice Type into DB
	 *return the saved appointmentService Type
	 */
	@Override
	public AppointmentServiceType saveAppointmentServiceType(AppointmentServiceType apptServiceType) {
		// TODO Auto-generated method stub
		return appointmentDAO.saveAppointmentServiceType(apptServiceType);
	}

	/**
	 *Gets service provider by service provider ID
	 */
	@Override
	public MedServiceProvider getMedServiceProvider(Integer serviceProviderId) {
		// TODO Auto-generated method stub
		return appointmentDAO.getMedServiceProvider(serviceProviderId);
	}

	/**
	 *Gets a list of provider schedules  by provider
	 */
	@Override
	public List<ProviderSchedule> getProviderSchedulesByProvider(MedServiceProvider provider) {
		// TODO Auto-generated method stub
		return appointmentDAO.getProviderSchedulesByProvider(provider);
	}

	@Override
	public List<TimeSlot> getAllTimeSlots() {
		// TODO Auto-generated method stub
		return appointmentDAO.getAllTimeSlots();
	}

	@Override
	public TimeSlot saveTimeSlot(TimeSlot timeSlot) {
		// TODO Auto-generated method stub
		return appointmentDAO.saveTimeSlot(timeSlot);
	}

	/**
	 *Gets provider schedule 
	 */
	@Override
	public ProviderSchedule getProviderSchedule(Integer providSchedulerId) {
		// TODO Auto-generated method stub
		return appointmentDAO.getProviderSchedule(providSchedulerId);
	}

	/**
	 *Gets TimeSlot matching with the given Time slot Id
	 */
	@Override
	public TimeSlot getTimeSlot(Integer timeSlotId) {
		// TODO Auto-generated method stub
		return appointmentDAO.getTimeSlot(timeSlotId);
	}

	@Override
	public ProviderSchedule saveProviderSchedule(ProviderSchedule schedule) {
		// TODO Auto-generated method stub
		return appointmentDAO.saveProviderSchedule(schedule);
	}

	@Override
	public void savePatientAppointment(PatientAppointment appointment) {
		appointmentDAO.savePatientAppointment(appointment);
		
	}

	@Override
	public List<PatientAppointment> getAllPatientAppointments() {
		// TODO Auto-generated method stub
		return appointmentDAO.getAllPatientAppointments();
	}

	@Override
	public List<PatientAppointment> getAppointmentsByPatient(Patient patient) {
		// TODO Auto-generated method stub
		return appointmentDAO.getAppointmentsByPatient(patient);
	}

	/**
	 * Gets booked appointment for a given schedule and time slot
	 * @param providerSchedule
	 * @param timeSlot
	 * @return booked patient appointment
	 */
	@Override
	public List<ProviderSchedule> getAllProvidersSchedules(MedServiceProvider provider, Date StartDate, Date endDate) {
		// TODO Auto-generated method stub
		return appointmentDAO.getAllProvidersSchedules(provider,StartDate,endDate);
	}

	@Override
	public List<ProviderSchedule> getAllProviderSchedulesByServicesBetweenDates(AppointmentServiceDefinition service,
			Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return appointmentDAO.getAllProviderSchedulesByServicesBetweenDates(service,startDate,endDate);
	}
	@Override
	public List<ProviderSchedule> getAllProviderSchedulesByService(AppointmentServiceDefinition service,
			MedServiceProvider provider, Date startingDate, Date endingDate) {
		// TODO Auto-generated method stub
		return appointmentDAO.getAllProviderSchedulesByService(service,provider,startingDate,endingDate);
	}
	@Override
	public void saveMedServiceProvider(MedServiceProvider serviceProvider) {
		// TODO Auto-generated method stub
		appointmentDAO.saveMedServiceProvider(serviceProvider);
	}
	/**
	 *Gets a list of  serviceDefinitions by provider
	 */
	@Override
	public List<AppointmentServiceDefinition> getAllServiceDefinitionsByProvider(Person provider) {
		// TODO Auto-generated method stub
		return appointmentDAO.getAllServiceDefinitionsByProvider(provider);
	}

	/**
	 *Gets  a list of  appointments  within services  between two selected  dates
	 */
	@Override
	public List<PatientAppointment> getAppointmentsWithinServiceBetweenDates(
			AppointmentServiceDefinition serviceDefinition, Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return appointmentDAO.getAppointmentsWithinServiceBetweenDates(serviceDefinition,startDate,endDate);
	}	
	/**
	 *Gets a list of medService Providers per provider
	 */
	@Override
	public List<MedServiceProvider> getMedServiceProvider(Person provider) {
		// TODO Auto-generated method stub
		return appointmentDAO.getMedServiceProvider(provider);
	}
	/**
	 *Gets provider schedule by service provider on selected dates
	 */
	@Override
	public ProviderSchedule getProviderScheduleByServiceProvider(MedServiceProvider serviceProvider, Date workingDate) {
		// TODO Auto-generated method stub
		return appointmentDAO.getProviderScheduleByServiceProvider(serviceProvider,workingDate) ;
	}

	/**
	 *Gets a list of time slot for schedule
	 */
	@Override
	public List<TimeSlot> getTimeSlotsByProviderSchedule(ProviderSchedule schedule) {
		// TODO Auto-generated method stub
		return appointmentDAO.getTimeSlotsByProviderSchedule(schedule);
	}
	/**
	 *Gets patient appointment associated with time slot
	 */
	@Override
	public PatientAppointment getPatientAppointmentByTimeSlot(TimeSlot timeSlot) {
		// TODO Auto-generated method stub
		return appointmentDAO.getPatientAppointmentByTimeSlot(timeSlot);
	}

	@Override
	public AppointmentStatus getAppointmentStatus(int appointmentStatusId) {
		// TODO Auto-generated method stub
		return appointmentDAO.getAppointmentStatus(appointmentStatusId);
	}

	/**
	 *Gets a list of  services by speciality
	 */
	@Override
	public List<AppointmentServiceDefinition> getServicesInSpeciality(Speciality speciality) {
		
		return appointmentDAO.getServicesInSpeciality(speciality);
	}

	/**
	 *Gets provider  schedule
	 */
	@Override
	public ProviderSchedule getProviderScheduleByServiceProvider(MedServiceProvider provider,
			AppointmentServiceDefinition service, Date workingDate) {
		
		return appointmentDAO.getProviderScheduleByServiceProvider(provider,service,workingDate);
	}

	@Override
	public List<AppointmentStatus> getAllAppointmentStatuses() {
		// TODO Auto-generated method stub
		return appointmentDAO.getAllAppointmentStatuses() ;
	}

}
