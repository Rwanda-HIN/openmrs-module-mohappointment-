<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>
<%@ include file="templates/mohAppointmentLocalHeader.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<openmrs:htmlInclude file="/scripts/calendar/calendar.js" />


<form action="appointmentNew.form?search=true" method="post">
	<fieldset>
		<b class="boxHeader">1. Select a patient:</b>
		<div class="box">
			<table>
				<tr>
					<td>Patient:</td>
					<td><openmrs:fieldGen type="org.openmrs.Patient"
							formFieldName="patientId" val="${patient}" /></td>
				</tr>
			</table>
		</div>
		<br /> <b class="boxHeader">2.Define Appointment Properties:</b>
		<div class="box">
			<table>
				<tr>
					<th>Working Date:</th>
					<td><input type="text" name="workingDate" size="18" value="${workingDate}"  onclick="showCalendar(this)" /></td>
				</tr>
				<tr>s
					<th>Service :</th>
					<td><select name="serviceId">
							<option value="">--select--</option>
							<c:forEach items="${serviceDefinitions}" var="serviceDefinition">
								<option value="${serviceDefinition.appointmentServiceId}"
									${serviceDefinition.appointmentServiceId==chosenService.appointmentServiceId? 'selected' : ''}>${serviceDefinition.name}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<th>Provider:</th>
					<td><select name="medSvceProviderId">
							<option value="">--select--</option>
							<c:forEach items="${serviceProviders}" var="svceProvider">
								<option value="${svceProvider.medServiceProviderId}"
									${svceProvider.medServiceProviderId==serviceProvider.medServiceProviderId ? 'selected' : ''}>${svceProvider.name}</option>
							</c:forEach>

					</select></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Find Available Times" /></td>
					<td></td>
				</tr>
			</table>
		</div>
		<br /> <b class="boxHeader">3.Provider availablity:</b>

		<div class="box">
			<table style="width: 100%">
				<tr>

					<th style="width: 8%">Provider</th>
					<th style="width: 8%">Appointment Type</th>

					<th style="width: 8%">Service</th>
					<th style="width: 8%">Working Date</th>
					<th style="width: 8%">Start Time</th>
					<th style="width: 8%">End Time</th>
					<th style="width: 8%"># Appointments</th>
					<th style="width: 8%">Action</th>
				</tr>
				<tr>

					<td>${provSchedule.serviceProvider.name }</td>
					<td>${provSchedule.serviceType.name }</td>
					<td>${provSchedule.serviceDefinition.name }</td>
					<td><fmt:formatDate value="${provSchedule.workingDate}"		pattern="dd-MM-yyyy" /></td>
					<td>${provSchedule.startTime}</td>
					<td>${provSchedule.endTime}</td>
					<td>${provSchedule.appointments.size()}</td>
					<td><a
						href="searchAppointment.form?patientId=${patient.patientId}&&providSchedulerId=${provSchedule.providerScheduleId}">Add	appointment</a></td>
				</tr>

			</table>

		</div>
	</fieldset>

</form>
<%@ include file="/WEB-INF/template/footer.jsp"%>