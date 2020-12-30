<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>
<openmrs:htmlInclude file="/scripts/calendar/calendar.js" />
<openmrs:htmlInclude file="/moduleResources/@MODULE_ID@/style/listing.css" />
<h2 style="display: inline;">
	<spring:message code="mohappointment.appointment" />
</h2>
:
<span class="boldTitle"><spring:message
		code="mohappointment.appointment.today" /></span>
<br />
<br />

<form action="providerDashboard.form" method="get">
	<div class="searchParameterBox" style="display: ${display_filter};">
		<table>
			<tr>
				<td><b><spring:message
							code="mohappointment.general.filter_message" /></b></td>
				<td><select name="serviceDefinitionId">
						<option value="">--</option>
						<c:forEach items="${serviceDefinitions}" var="serviceDefinition">
							<option value="${serviceDefinition.appointmentServiceId}"
								<c:if test="${serviceDefinition.appointmentServiceId==param.serviceDefinitionId}">selected='selected'</c:if>>${serviceDefinition.name}</option>
						</c:forEach>
				</select></td>
				<td><input type="text" size="11" value="${todayDate}"
					name="todayDate" onclick="showCalendar(this)" /></td>
				<td><input type="submit" name="select_service" value="Filter" /></td>
			</tr>
		</table>
	</div>
</form>
<br />
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
<c:set var="appointments" value="${providerSchedule.appointments}" />

<div class="box">
	<table style="width: 100%">
		<tr>
			<th>Start Time.</th>
			<th>End Time</th>
			<th>Patient Names</th>
			<th>Service</th>
			<th>Service Type</th>
			<th>Status</th>
			
		</tr>
		<!-- Display booked appointments -->
        
		<c:forEach items="${appointments}" var="appointment" 	varStatus="status">
			
				<tr>
					<td class="rowValue ${(status.count%2!=0)?'even':''}">${appointment.timeSlot.startTime}</td>
					<td class="rowValue ${(status.count%2!=0)?'even':''}">${appointment.timeSlot.endTime}</td>
					<td class="rowValue ${(status.count%2!=0)?'even':''}">${appointment.patient.familyName }</td>
					<td class="rowValue ${(status.count%2!=0)?'even':''}">${appointment.providerSchedule.serviceDefinition.name}</td>
					<td class="rowValue ${(status.count%2!=0)?'even':''}">${appointment.providerSchedule.serviceType.name}</td>
					<td class="rowValue ${(status.count%2!=0)?'even':''}">Scheduled</td>
				</tr>
			
		</c:forEach>

	</table>
</div>

<%@ include file="/WEB-INF/template/footer.jsp"%>