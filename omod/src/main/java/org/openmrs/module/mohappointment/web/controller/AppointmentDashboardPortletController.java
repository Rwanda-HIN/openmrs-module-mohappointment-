/*
 * Decompiled with CFR 0_123.
 *
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 *  org.apache.commons.logging.Log
 *  org.openmrs.Patient
 *  org.openmrs.api.context.Context
 *  org.openmrs.module.mohappointment.model.Appointment
 *  org.openmrs.module.mohappointment.service.IAppointmentService
 *  org.openmrs.module.mohappointment.utils.AppointmentUtil
 *  org.openmrs.web.controller.PortletController
 */
package org.openmrs.module.mohappointment.web.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.openmrs.api.context.Context;
import org.openmrs.module.mohappointment.service.AppointmentService;
import org.openmrs.web.controller.PortletController;

public class AppointmentDashboardPortletController
		extends PortletController {
	protected void populateModel(HttpServletRequest request, Map<String, Object> model) {
		AppointmentService ias = (AppointmentService)Context.getService(AppointmentService.class);
		
		super.populateModel(request, model);
	}
}