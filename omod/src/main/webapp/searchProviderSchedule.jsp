<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>
<%@ include file="templates/mohAppointmentLocalHeader.jsp"%>
<openmrs:htmlInclude file="/scripts/calendar/calendar.js" />
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



<form action="searchProviderSchedule.form?search=true" method="post" >
	<fieldset style="clear: both">	<legend>Choose properties</legend>
		<div style="margin: 0.5em 0;">
			<table>
				<tr>
					<td>Service :</td>
					<td><select name="serviceId">
							<c:forEach items="${serviceDefinitions}" var="serviceDefinition">
								<option value="${serviceDefinition.appointmentServiceId}" ${serviceDefinition.appointmentServiceId==chosenService.appointmentServiceId? 'selected' : ''}>${serviceDefinition.name}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
				<td>Provider:</td>
				<td><select name="medSvceProviderId">
							<option value="">--select--</option>
							<c:forEach items="${serviceProviders}" var="svceProvider">
								<option value="${svceProvider.medServiceProviderId}" ${svceProvider.medServiceProviderId==serviceProvider.medServiceProviderId ? 'selected' : ''}>${svceProvider.name}</option>
							</c:forEach>
				
					</select></td>
				</tr>
				<tr>				
					<td>starting Date :</td>
					<td><input type="text" size="11" value="${startDate}" 	name="startDate" onclick="showCalendar(this)" /></td>
					
					<td>Ending Date:</td>
					<td><input type="text" size="11" value="${startDate}" 	name="endDate" onclick="showCalendar(this)" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Search" /></td>
					<td></td>
				</tr>
			</table>
		</div>
	</fieldset>
</form>
<br />
<br />
<a href="providerScheduling.form" style="float: right;">Add new provider
	schedule</a>
<br />
<br />
<b class="boxHeader">Current provider schedules </b>
<div class="box">
	<table style="width: 100%">
		<tr>
			<th style="width: 5%">#.</th>
			<th style="width: 8%">Provider</th>
			<th style="width: 8%">Appointment Type</th>

			<th style="width: 8%">Service</th>
			<th style="width: 8%">Working Date</th>
			<th style="width: 8%">Start Time</th>
			<th style="width: 8%">End Time</th>
			<th style="width: 8%"># Appointments</th>
			<th style="width: 8%">Action</th>
		</tr>
		<c:forEach items="${providerSchedules}" var="provSchedule"
			varStatus="status">
			<tr>
				<td class="rowValue ${(status.count%2!=0)?'even':''}">${status.count}</td>
				<td class="rowValue ${(status.count%2!=0)?'even':''}">${provSchedule.serviceProvider.name }</td>
				<td class="rowValue ${(status.count%2!=0)?'even':''}">${provSchedule.serviceType.name }</td>
				<td class="rowValue ${(status.count%2!=0)?'even':''}">${provSchedule.serviceDefinition.name }</td>
				<td class="rowValue ${(status.count%2!=0)?'even':''}"><fmt:formatDate value="${provSchedule.workingDate}" pattern="dd-MM-yyyy"/></td>
				<td class="rowValue ${(status.count%2!=0)?'even':''}">${provSchedule.startTime}</td>
				<td class="rowValue ${(status.count%2!=0)?'even':''}">${provSchedule.endTime}</td>
				<td class="rowValue ${(status.count%2!=0)?'even':''}">${provSchedule.appointments.size()}</td>
				<td class="rowValue ${(status.count%2!=0)?'even':''}"><a
					href="searchAppointment.form?providSchedulerId=${provSchedule.providerScheduleId}">View
						appointment</a>
			</tr>
		</c:forEach>
	</table>
</div>