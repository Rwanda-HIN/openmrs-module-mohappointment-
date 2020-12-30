<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>
<%@ include file="templates/mohAppointmentLocalHeader.jsp"%>

<c:if test="${not empty providerSchedule }">
<b class="boxHeader">Schedule summary</b>
<div class="box">
	<c:set var="schedule" value="${providerSchedule}" />

	<table>
		<tr>
			<td>Provider:</td>
			<td><b>${schedule.serviceProvider.name}</b></td>
			<td>Department</td>
			<td><b>${schedule.serviceDefinition.specialty.name}</b></td>
		</tr>
		<tr>
			<td>Service:</td>
			<td><b>${schedule.serviceDefinition.name}</b></td>
		</tr>
		<tr>
			<td>Schedule ID:</td>
			<td><b>${schedule.providerScheduleId}</b></td>
		</tr>
		<tr>
			<td>Working Date :</td>
			<td><b>${schedule.workingDate}</b></td>
		</tr>
	</table>
</div>
<br />

<b class="boxHeader">Booked appointments on ${schedule.workingDate}
</b>
<c:set var="appointments" value="${schedule.appointments}" />

<div class="box">
	<table style="width: 100%">
		<tr>
			<th>Start Time.</th>
			<th>End Time</th>
			<th>Patient Names</th>
			<th>Service</th>
			<th>Service Type</th>
			<th>Status</th>
			<th>Action</th>
		</tr>
		<!-- Display booked appointments -->

		<c:forEach items="${appointmentViews}" var="appointmentView" 	varStatus="status">
			<c:if test="${not empty appointmentView.appointment}">

				<tr>
					<td class="rowValue ${(status.count%2!=0)?'even':''}">${appointmentView.appointment.timeSlot.startTime}</td>
					<td class="rowValue ${(status.count%2!=0)?'even':''}">${appointmentView.appointment.timeSlot.endTime}</td>
					<td class="rowValue ${(status.count%2!=0)?'even':''}">${appointmentView.appointment.patient.familyName }</td>
					<td class="rowValue ${(status.count%2!=0)?'even':''}">${appointmentView.appointment.providerSchedule.serviceDefinition.name}</td>
					<td class="rowValue ${(status.count%2!=0)?'even':''}">${appointmentView.appointment.providerSchedule.serviceType.name}</td>
					<td class="rowValue ${(status.count%2!=0)?'even':''}">${appointmentView.appointment.status.description}</td>
					<td class="rowValue ${(status.count%2!=0)?'even':''}"><a
						href="appointment.form?timeSlotId=${timeSlot.timeSlotId}&scheduleId=${schedule.providerScheduleId}">Cancel
							appointment</a></td>
				</tr>
			 </c:if>
		</c:forEach>

	</table>
</div>
<br />
<b class="boxHeader">Time slots not yet booked on ${schedule.workingDate}
</b>
<c:set var="appointments" value="${schedule.appointments}" />



<div class="box">
	<table style="width: 100%">
		<tr>
			<th>Start Time.</th>
			<th>End Time</th>
			<th>Patient Names</th>
			<th>Service</th>
			<th>Service Type</th>
			<th>Status</th>
			<th>Action</th>
		</tr>
		<!-- Display not booked timeslots -->

		<c:forEach items="${notBookedTimeSlots}" var="timeSlot" 	varStatus="status">
		   
			
				<tr>
					<td class="rowValue ${(status.count%2!=0)?'even':''}">${timeSlot.startTime}</td>
					<td class="rowValue ${(status.count%2!=0)?'even':''}">${timeSlot.endTime}</td>
					<td class="rowValue ${(status.count%2!=0)?'even':''}">-</td>
					<td class="rowValue ${(status.count%2!=0)?'even':''}">-</td>
					<td class="rowValue ${(status.count%2!=0)?'even':''}">-</td>
					<td class="rowValue ${(status.count%2!=0)?'even':''}">-</td>
					<td class="rowValue ${(status.count%2!=0)?'even':''}"><a
						href="appointment.form?timeSlotId=${timeSlot.timeSlotId}&scheduleId=${schedule.providerScheduleId}&appt=true"">Add
							appointment</a></td>
				</tr>
			
		</c:forEach>

	</table>
</div>
 </c:if>
<%@ include file="/WEB-INF/template/footer.jsp"%>
