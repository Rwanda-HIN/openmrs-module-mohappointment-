

<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>
<%@ include file="templates/mohAppointmentLocalHeader.jsp"%>

<b class="boxHeader">search appointment form </b>
<div class="box">
	<form action="appointment.form" method="post">
		<table>
			<tr>

				<td>Patient:</td>
				<td><openmrs:fieldGen type="org.openmrs.Patient"
						formFieldName="patientId" val="${patient}" /></td>
				<td><input type="hidden" name="scheduleId"	value="${providerSchedule.providerScheduleId}" /></td>
				<td><input type="hidden" name="timeSlotId" 	value="${timeSlot.timeSlotId}" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Search appointment Form" /></td>
				<td></td>
			</tr>
		</table>
	</form>
</div>
<br>
<!-- Appontment Form to be filled -->
<c:if test="${patient!=null }">

<b class="boxHeader">Appointment Form</b>
<div class="box">
	<form
		action="appointment.form?scheduleId=${providerSchedule.providerScheduleId}&timeSlotId=${timeSlot.timeSlotId}&save=true"
		method="post">
		<table>
			<tr>
				<th>Name</th>
				<td><input type="text" name="name" value="${patient.familyName}"	size="25" disabled="disabled" /></td>
				<td><input type="hidden" name="patientId" value="${patient.patientId}"	size="25"/></td>
			</tr>
			<tr>
				<th>Provider</th>
				<td><input type="text" name="providerName"
					value="${providerSchedule.serviceProvider.name}" size="15"
					disabled="disabled" /></td>

			</tr>
			<tr>
				<th>Service</th>
				<td><input type="text" name="serviceName"
					value="${providerSchedule.serviceDefinition.name}" size="15"
					disabled="disabled" /></td>

			</tr>
			<tr>
				<th>Appointment Type</th>
				<td><input type="text" name="appointmentType"
					value="${providerSchedule.serviceType.name}" size="20"
					disabled="disabled" /></td>
			</tr>
			<tr>
				<th>Appointment Date</th>
				<td><input type="text" name="appointmentDate"
					value="${providerSchedule.workingDate}" size="20"
					disabled="disabled" /></td>
			</tr>
			<tr>
				<th></th>
				<th>End Time</th>
				<th>Start Time</th>
			</tr>
			<tr>
				<td></td>
				<td><input type="time" name="startTime"
					value="${timeSlot.startTime}" size="15" disabled="disabled" /></td>
				<td><input type="time" name="endTime"
					value="${timeSlot.endTime}" size="15" disabled="disabled" /></td>
			</tr>
			<tr>
				<th>Comment</th>
				<td><textarea name="description" rows="2" cols="30"></textarea>
				</td>

			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="Save appointment Form" /></td>
			</tr>
		</table>
	</form>
</div>
</c:if>
<%@ include file="/WEB-INF/template/footer.jsp"%>