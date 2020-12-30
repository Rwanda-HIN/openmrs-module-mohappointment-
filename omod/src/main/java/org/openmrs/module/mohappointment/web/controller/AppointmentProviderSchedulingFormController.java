/**
 * 
 */
package org.openmrs.module.mohappointment.web.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openmrs.api.context.Context;

import org.openmrs.module.mohappointment.model.AppointmentServiceDefinition;
import org.openmrs.module.mohappointment.model.AppointmentServiceType;
import org.openmrs.module.mohappointment.model.MedServiceProvider;
import org.openmrs.module.mohappointment.model.ProviderSchedule;
import org.openmrs.module.mohappointment.model.TimeSlot;
import org.openmrs.module.mohappointment.service.AppointmentService;
import org.openmrs.module.mohappointment.utils.AppointmentUtil;
import org.openmrs.module.mohappointment.utils.DateConversion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.ParameterizableViewController;
import org.springframework.web.servlet.view.RedirectView;

/**
 * @author Faustin
 *
 */
public class AppointmentProviderSchedulingFormController extends ParameterizableViewController {

	/**
	 *
	 */
	@SuppressWarnings("deprecation")
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ModelAndView mav = new ModelAndView();

		AppointmentService apptService = Context.getService(AppointmentService.class);

		List<MedServiceProvider> serviceProviders = apptService.getAllMedServiceProviders();
		List<AppointmentServiceDefinition> serviceDefinitions = apptService.getAllAppointmentServicesDefinition();
		List<AppointmentServiceType> serviceTypes = apptService.getAllAppoinmentServiceTypes();

		if (request.getParameter("save") != null) {
			Date workingDate = null;

			Date starDate = DateConversion.convertToDate(request.getParameter("startDate"));
			Date endDate = DateConversion.convertToDate(request.getParameter("endDate"));

			String startTime = request.getParameter("startTime");
			String endTime = request.getParameter("endTime");
			String timeSlotLength = "15";
			Integer slotLength = Integer.parseInt(timeSlotLength);

			Integer serviceProviderId = Integer.valueOf(request.getParameter("medSvceProviderId"));

			Integer serviceTypeId = Integer.valueOf(request.getParameter("serviceTypeId"));
			Integer serviceId = Integer.valueOf(request.getParameter("serviceId"));

			// Get the calculated schedule length between start time and end time in Minutes
			long scheduleLengthInMinutes = AppointmentUtil.getscheduleLengthInMinutes(startTime, endTime);
			int howManyTimeSlotsToCreate = (int) (scheduleLengthInMinutes / slotLength);
			System.out.println("howManyTimeSlotsToCreate>>>>>>>" + howManyTimeSlotsToCreate);

			MedServiceProvider serviceProvider = apptService.getMedServiceProvider(serviceProviderId);
			AppointmentServiceType serviceType = apptService.getAppointmentServiceType(serviceTypeId);
			AppointmentServiceDefinition service = apptService.getAppointmentServiceDefinition(serviceId);

			long days = DateConversion.daysBetweenDates(starDate, endDate);
			System.out.println("days>><<<<<>>>>>" + days + "between" + starDate + "and " + endDate);

			// convert date to calendar
			Calendar c = Calendar.getInstance();
			SimpleDateFormat format = new SimpleDateFormat("HH:mm");

			if (starDate.compareTo(new Date()) > 0 & endDate.compareTo(new Date()) > 0) {

				for (int i = 0; i <= days; i++) {

					c.setTime(starDate); // manipulate date
					c.add(Calendar.DATE, i);
					workingDate = c.getTime();

					// create a new schedule for each day
					ProviderSchedule schedule = new ProviderSchedule();

					schedule.setServiceDefinition(service);
					schedule.setServiceProvider(serviceProvider);
					schedule.setServiceType(serviceType);
					schedule.setWorkingDate(workingDate);
					schedule.setStartTime(startTime);
					schedule.setEndTime(endTime);
					schedule.setCreator(Context.getAuthenticatedUser());
					schedule.setCreatedDate(new Date());

					schedule = apptService.saveProviderSchedule(schedule);
					// create time slots

					String startingTime = startTime;
					String endingTime = startTime;

					for (int j = 0; j < howManyTimeSlotsToCreate - 1; j++) {

						c.setTime(format.parse(startingTime));
						c.add(Calendar.MINUTE, slotLength); // add slotLength minutes
						endingTime = format.format(c.getTime());
						TimeSlot timeSlot = new TimeSlot(schedule, startingTime, endingTime,
								Context.getAuthenticatedUser(), new Date());
						apptService.saveTimeSlot(timeSlot);
						startingTime = endingTime;

					}
				}
				 request.getSession().setAttribute("openmrs_msg","The provider schedule  for - " + serviceProvider.getName()+"- is created successfully !" );
				
			}
			else {
				request.getSession().setAttribute("openmrs_error", "Scheduling  date must be in the future! - " + starDate + " - belongs to the past...");
							
			}
				

			return new ModelAndView(new RedirectView("searchProviderSchedule.form"));
		}
		mav.addObject("serviceProviders", serviceProviders);
		mav.addObject("serviceDefinitions", serviceDefinitions);
		mav.addObject("serviceTypes", serviceTypes);

		mav.setViewName(getViewName());

		return mav;
	}

}
