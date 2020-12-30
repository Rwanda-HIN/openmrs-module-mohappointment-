/**
 * 
 */
package org.openmrs.module.mohappointment.web.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openmrs.Patient;
import org.openmrs.api.context.Context;
import org.openmrs.module.mohappointment.model.AppointmentServiceDefinition;
import org.openmrs.module.mohappointment.model.AppointmentServiceType;
import org.openmrs.module.mohappointment.model.MedServiceProvider;
import org.openmrs.module.mohappointment.model.ProviderSchedule;
import org.openmrs.module.mohappointment.service.AppointmentService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.ParameterizableViewController;

/**
 * @author HP
 *
 */
public class AppointmentNewFormController extends ParameterizableViewController {
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ModelAndView mav = new ModelAndView();

		AppointmentService apptService = Context.getService(AppointmentService.class);
		List<MedServiceProvider> serviceProviders = apptService.getAllMedServiceProviders();
		List<AppointmentServiceDefinition> serviceDefinitions = apptService.getAllAppointmentServicesDefinition();
		List<AppointmentServiceType> serviceTypes = apptService.getAllAppoinmentServiceTypes();

		Date workingDate = (request.getParameter("workingDate") != null
				&& (request.getParameter("workingDate").trim().compareTo("") != 0)
						? (Date) Context.getDateFormat().parse(request.getParameter("workingDate"))
						: null);
		String patientIdStr = (request.getParameter("patientId") != null
				&& request.getParameter("patientId").trim().compareTo("") != 0)
						? request.getParameter("patientId")
						: null;

		String medSvceProviderId = (request.getParameter("medSvceProviderId") != null
				&& request.getParameter("medSvceProviderId").trim().compareTo("") != 0)
						? request.getParameter("medSvceProviderId")
						: null;
		String serviceIdStr = (request.getParameter("serviceId") != null
				&& request.getParameter("serviceId").trim().compareTo("") != 0) ? request.getParameter("serviceId")
						: null;

		String appointmentTypeIdStr = (request.getParameter("serviceTypeId") != null
				&& request.getParameter("serviceTypeId").trim().compareTo("") != 0)
						? request.getParameter("serviceTypeId")
						: null;

		if (request.getParameter("search") != null) {
			
			Patient patient = Context.getPatientService().getPatient(Integer.parseInt(patientIdStr));
			

			Integer serviceProviderId = Integer.valueOf(medSvceProviderId);
			Integer serviceId = Integer.valueOf(serviceIdStr);

			AppointmentServiceDefinition service = apptService.getAppointmentServiceDefinition(serviceId);
			MedServiceProvider provider = apptService.getMedServiceProvider(serviceProviderId);

			ProviderSchedule providerSchedule = apptService.getProviderScheduleByServiceProvider(provider, service,
					workingDate);
			mav.addObject("chosenService",service);
			mav.addObject("patient",patient);
			mav.addObject("chosenService",service);
			mav.addObject("serviceProvider",provider);
			mav.addObject("workingDate",workingDate);
			
		
			mav.addObject("provSchedule", providerSchedule);
		}

		mav.addObject("serviceProviders", serviceProviders);
		mav.addObject("serviceDefinitions", serviceDefinitions);
		mav.addObject("serviceTypes", serviceTypes);

		mav.setViewName(getViewName());

		return mav;
	}

}
