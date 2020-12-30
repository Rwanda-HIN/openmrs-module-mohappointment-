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
package org.openmrs.module.mohappointment.db.hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.openmrs.Obs;
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

/**
 * @author Faustin
 *
 *         This is the Appointment Services working together with the Hibernate
 */

@SuppressWarnings("unchecked")
public class HibernateAppointmentDAO implements AppointmentDAO {

	private SessionFactory sessionFactory;

	/** Logger for this class and subclasses */
	protected final Log log = LogFactory.getLog(getClass());

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Override
	public List<Speciality> getAllSpecialities() {
		Session session = sessionFactory.getCurrentSession();
		List<Speciality> specialities = session.createCriteria(Speciality.class).list();
		System.out.println(">>>>>>>>>>>>>>specialty list>>>>" + specialities);
		return specialities;
	}

	@Override
	public Speciality getSpecialty(int specialtyId) {

		Session session = sessionFactory.getCurrentSession();

		Speciality specialty = (Speciality) session.load(Speciality.class, specialtyId);

		return specialty;
	}

	@Override
	public void saveSpecialty(Speciality specialty) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(specialty);

	}

	/**
	 * Get a listy of appointment servces
	 */
	@Override
	public List<AppointmentServiceDefinition> getAllAppointmentServicesDefinition() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<AppointmentServiceDefinition> services = session.createCriteria(AppointmentServiceDefinition.class).list();
		System.out.println(">>>>>>>>>>>>>>service definition  list>>>>" + services);
		return services;

	}

	/**
	 * saves the appointment service definition intoo the DB
	 */
	@Override
	public AppointmentServiceDefinition saveAppointmentServiceDefinition(
			AppointmentServiceDefinition appointmentService) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(appointmentService);

		return appointmentService;
	}

	@Override
	public List<MedServiceProvider> getAllMedServiceProviders() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<MedServiceProvider> serviceProviders = session.createCriteria(MedServiceProvider.class).list();
		return serviceProviders;
	}

	@Override
	public List<AppointmentServiceType> getAllAppoinmentServiceTypes() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<AppointmentServiceType> serviceTypes = session.createCriteria(AppointmentServiceType.class).list();
		return serviceTypes;
	}

	@Override
	public List<ProviderSchedule> providerSchedules() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<ProviderSchedule> providerschedules = session.createCriteria(ProviderSchedule.class).list();
		return providerschedules;
	}

	@Override
	public AppointmentServiceDefinition getAppointmentServiceDefinition(Integer serviceId) {
		Session session = sessionFactory.getCurrentSession();

		AppointmentServiceDefinition serviceDefinition = (AppointmentServiceDefinition) session
				.load(AppointmentServiceDefinition.class, serviceId);

		return serviceDefinition;
	}

	/**
	 * Saves weeklyAvailablity into DB return saved weeklyAvailablity
	 */
	@Override
	public ServiceWeeklyAvailability saveWeeklyAvailablity(ServiceWeeklyAvailability weeklyAvailablity) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(weeklyAvailablity);

		return weeklyAvailablity;
	}

	@Override
	public AppointmentServiceType getAppointmentServiceType(Integer serviceTypeId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		AppointmentServiceType apptServiceType = (AppointmentServiceType) session.load(AppointmentServiceType.class,
				serviceTypeId);

		return apptServiceType;
	}

	@Override
	public AppointmentServiceType saveAppointmentServiceType(AppointmentServiceType apptServiceType) {

		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(apptServiceType);

		return apptServiceType;
	}

	@Override
	public MedServiceProvider getMedServiceProvider(Integer serviceProviderId) {
		Session session = sessionFactory.getCurrentSession();
		MedServiceProvider serviceProvider = (MedServiceProvider) session.load(MedServiceProvider.class,
				serviceProviderId);
		return serviceProvider;
	}

	@Override
	public List<ProviderSchedule> getProviderSchedulesByProvider(MedServiceProvider provider) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(ProviderSchedule.class);
		crit.add(Restrictions.eq("serviceProvider", provider));

		List<ProviderSchedule> schedules = crit.list();
		return schedules;
	}

	/**
	 * Gets a list of Time slots
	 */
	@Override
	public List<TimeSlot> getAllTimeSlots() {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(TimeSlot.class);
		List<TimeSlot> timeSlots = crit.list();
		return timeSlots;
	}

	@Override
	public TimeSlot saveTimeSlot(TimeSlot timeSlot) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(timeSlot);
		return timeSlot;
	}

	/**
	 * Gets a provider schedule by a given provider schedule Id
	 */
	@Override
	public ProviderSchedule getProviderSchedule(Integer providSchedulerId) {
		Session session = sessionFactory.getCurrentSession();
		ProviderSchedule providerSchedule = (ProviderSchedule) session.load(ProviderSchedule.class, providSchedulerId);

		return providerSchedule;
	}

	/**
	 * Gets time slot matching with the given time slot return the matched time slot
	 */
	@Override
	public TimeSlot getTimeSlot(Integer timeSlotId) {

		Session session = sessionFactory.getCurrentSession();
		TimeSlot timeSlot = (TimeSlot) session.load(TimeSlot.class, timeSlotId);

		return timeSlot;
	}

	/**
	 * Saves provider schedule
	 */
	@Override
	public ProviderSchedule saveProviderSchedule(ProviderSchedule schedule) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(schedule);
		return schedule;
	}

	/**
	 *
	 */
	@Override
	public void savePatientAppointment(PatientAppointment appointment) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(appointment);
	}

	/**
	 * Gets a list of appointments
	 */
	@Override
	public List<PatientAppointment> getAllPatientAppointments() {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(PatientAppointment.class);
		List<PatientAppointment> appointments = crit.list();
		return appointments;
	}

	@Override
	public List<PatientAppointment> getAppointmentsByPatient(Patient patient) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(PatientAppointment.class);
		crit.add(Restrictions.eq("patient", patient));

		List<PatientAppointment> appointments = crit.list();

		return appointments;

	}

	@Override
	public PatientAppointment getBookedAppointmentOnTimeSlotByProviderSchedule(ProviderSchedule providerSchedule,
			TimeSlot timeSlot) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(PatientAppointment.class);
		crit.add(Restrictions.eq("providerSchedule", providerSchedule));
		crit.add(Restrictions.eq("timeSlot", timeSlot));
		return null;

	}

	@Override
	public List<ProviderSchedule> getAllProvidersSchedules(MedServiceProvider provider, Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(ProviderSchedule.class);
		crit.add(Restrictions.eq("serviceProvider", provider));
		crit.add(Restrictions.between("workingDate", startDate, endDate));
		List<ProviderSchedule> providerSchedules = crit.list();

		return providerSchedules;

	}

	@Override
	public List<ProviderSchedule> getAllProviderSchedulesByServicesBetweenDates(AppointmentServiceDefinition service,
			Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(ProviderSchedule.class);

		crit.add(Restrictions.eq("serviceDefinition", service));
		crit.add(Restrictions.between("workingDate", startDate, endDate));
		List<ProviderSchedule> providerSchedules = crit.list();

		return providerSchedules;
	}

	@Override
	public List<ProviderSchedule> getAllProviderSchedulesByService(AppointmentServiceDefinition service,
			MedServiceProvider provider, Date startingDate, Date endingDate) {
		// TODO Auto-generated method stub
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(ProviderSchedule.class);

		if (service != null) {
			crit.add(Restrictions.eq("serviceDefinition", service));
		}
		if (provider != null) {
			crit.add(Restrictions.eq("serviceProvider", provider));
		}
		if (startingDate != null && endingDate != null) {
			crit.add(Restrictions.between("workingDate", startingDate, endingDate));
		}
		List<ProviderSchedule> providerSchedules = crit.list();

		return providerSchedules;
	}

	@Override
	public void saveMedServiceProvider(MedServiceProvider serviceProvider) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(serviceProvider);

	}

	/**
	 * Gets a list of appointment service definition
	 */
	@Override
	public List<AppointmentServiceDefinition> getAllServiceDefinitionsByProvider(Person provider) {

		List<AppointmentServiceDefinition> serviceDefinitions = new ArrayList<AppointmentServiceDefinition>();

		if (provider != null) {

			List<MedServiceProvider> serviceProviders = sessionFactory.getCurrentSession()
					.createCriteria(MedServiceProvider.class).add(Restrictions.eq("provider", provider)).list();

			if (serviceProviders != null) {
				System.out.println("service providers >>>+++++++>>>");

				for (MedServiceProvider medServiceProvider : serviceProviders) {
					System.out.println(
							"comparison response ++++>>>>>" + medServiceProvider.getProvider().equals(provider));

					if (medServiceProvider.getProvider().equals(provider)) {

						serviceDefinitions.add(medServiceProvider.getServiceDefinition());

					}

				}
			}

		}
		System.out.println(">>>>>>Service definitions for provider" + provider.getPersonId()
				+ "has a list of services :" + serviceDefinitions);
		return serviceDefinitions;
	}

	/**
	 * Gets a list of appointments within service but between two dates
	 */
	@Override
	public List<PatientAppointment> getAppointmentsWithinServiceBetweenDates(
			AppointmentServiceDefinition serviceDefinition, Date startDate, Date endDate) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(PatientAppointment.class);
		crit.add(Restrictions.eq("serviceDefinition", serviceDefinition));
		crit.add(Restrictions.between("workingDate", startDate, endDate));
		List<PatientAppointment> appointments = crit.list();

		return appointments;
	}

	@Override
	public List<MedServiceProvider> getMedServiceProvider(Person provider) {
		List<MedServiceProvider> serviceProviders = sessionFactory.getCurrentSession()
				.createCriteria(MedServiceProvider.class).add(Restrictions.eq("provider", provider)).list();
		return serviceProviders;
	}

	/**
	 * Gets provider schedule by service provider on selected working dates
	 */
	@Override
	public ProviderSchedule getProviderScheduleByServiceProvider(MedServiceProvider serviceProvider, Date workingDate) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(ProviderSchedule.class);
		crit.add(Restrictions.eq("serviceProvider", serviceProvider));
		crit.add(Restrictions.eq("workingDate", workingDate));
		ProviderSchedule providerschedule = (ProviderSchedule) crit.uniqueResult();

		return providerschedule;
	}	
	
	@Override
	public List<TimeSlot> getTimeSlotsByProviderSchedule(ProviderSchedule schedule) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PatientAppointment getPatientAppointmentByTimeSlot(TimeSlot timeSlot) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(PatientAppointment.class);
		crit.add(Restrictions.eq("timeSlot", timeSlot));
		
		PatientAppointment patientappt = (PatientAppointment) crit.uniqueResult();

		return patientappt;
	}

	@Override
	public AppointmentStatus getAppointmentStatus(int appointmentStatusId) {
		Session session = sessionFactory.getCurrentSession();

		AppointmentStatus apptStatus = (AppointmentStatus) session.load(AppointmentStatus.class, appointmentStatusId);

		return apptStatus;
	}

	@Override
	public List<AppointmentServiceDefinition> getServicesInSpeciality(Speciality speciality) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(AppointmentServiceDefinition.class);
		crit.add(Restrictions.eq("specialty", speciality));
		
		List<AppointmentServiceDefinition> serviceSInSpeciality = crit.list();
		
		return serviceSInSpeciality;
	}

	/**
	 *Gets providerschedule  by Service provider,working date,and service
	 */
	@Override
	public ProviderSchedule getProviderScheduleByServiceProvider(MedServiceProvider provider,
			AppointmentServiceDefinition service, Date workingDate) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(ProviderSchedule.class);
		crit.add(Restrictions.eq("serviceProvider", provider));
		crit.add(Restrictions.eq("serviceDefinition", service));
		crit.add(Restrictions.eq("workingDate", workingDate));
		ProviderSchedule providerschedule = (ProviderSchedule) crit.uniqueResult();

		return providerschedule;
	}

	@Override
	public List<AppointmentStatus> getAllAppointmentStatuses() {
		Session session = sessionFactory.getCurrentSession();
		
		
		
		
		List<AppointmentStatus> allApptStatuses = session.createCriteria(AppointmentStatus.class).list();
		
		return allApptStatuses;
	}

}
