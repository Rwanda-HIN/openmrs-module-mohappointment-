package org.openmrs.module.mohappointment.utils;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.openmrs.api.context.Context;
import org.openmrs.module.mohappointment.model.Speciality;
import org.openmrs.module.mohappointment.service.AppointmentService;

public class SpecialityUtil {
	
	private static Log log = LogFactory.getLog(SpecialityUtil.class);

	 public static AppointmentService getAppointmentService() {
	        return Context.getService(AppointmentService.class);
	    }

	public static List<Speciality> getAllSpecialities() {
		AppointmentService appointmentService =SpecialityUtil.getAppointmentService();
		System.out.println("specialities lit size within utility>>>>>>"+appointmentService.getAllSpecialities());
        return  appointmentService.getAllSpecialities();
	}

}
