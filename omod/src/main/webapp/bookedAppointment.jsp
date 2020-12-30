<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>
<%@ include file="templates/mohAppointmentLocalHeader.jsp"%>

<b class="boxHeader">Schedule summary</b>
<div class="box">
<c:set var="schedule" value="${providerSchedule}" />
	<table>
		<tr>
			<td>Provider:</td>
			<td><b>${schedule.serviceProvider.name}</b></td>
			<td>Departement</td>
			<td> <b>${schedule.serviceDefinition.specialty.name}</b></td>		
		</tr>
		<tr>
			<td>Service:</td>
			<td><b>{schedule.serviceDefinition.name}</b></td>
		</tr>
		<tr>
			<td>Schedule ID:</td>
			<td><b>{schedule.providerScheduleId}</b></td>
		</tr>
		<tr>
			<td>Working Date :</td>
			<td><b>{schedule.workingDate}</b></td>
		</tr>
	</table>
</div>
<br />

<b class="boxHeader"> Booked appointments on {providerSchedule.workingDate} </b>
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
		<c:forEach items="${timeSlots}" var="timeSlot" varStatus="status">
			<tr>
				<td class="rowValue ${(status.count%2!=0)?'even':''}">${timeSlot.startTime}</td>
				<td class="rowValue ${(status.count%2!=0)?'even':''}" >${timeSlot.endTime}</td>
				<td class="rowValue ${(status.count%2!=0)?'even':''}" >Faustin MANI</td>
				<td class="rowValue ${(status.count%2!=0)?'even':''}" >Oncology</td>
				<td class="rowValue ${(status.count%2!=0)?'even':''}">Consultation</td>
				<td class="rowValue ${(status.count%2!=0)?'even':''}" >Scheduled</td>
				<td class="rowValue ${(status.count%2!=0)?'even':''}"><a 
					href="providerSchedule.form?scheduleId=${schedule.providerScheduleId}">Add appointment</a>
			</tr>
		</c:forEach>
	</table>
</div>
<%@ include file="/WEB-INF/template/footer.jsp"%>
