<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>
<%@ include file="templates/mohAppointmentLocalHeader.jsp"%>
<openmrs:htmlInclude file="/scripts/calendar/calendar.js" />
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<form action="appointments.list?search=true" method="post">
	<fieldset style="clear: both">
		<legend>Choose properties</legend>
		<div style="margin: 0.5em 0;">
			<table>
				<tr>
					<th>Between Dates:</th>
					<td><input type="text" name="fromDate" size="18" value=" "
						onclick="showCalendar(this)" /> and <input type="text"
						name="toDate" size="18" value=" " onclick="showCalendar(this)" /></td>
				</tr>
				<tr>
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
					<th>Appointment Types:</th>
					<td><select name="serviceTypeId">
							<option value="">--select--</option>
							<c:forEach items="${serviceTypes}" var="serviceType">
								<option value="${serviceType.serviceTypeId}">${serviceType.name}</option>
							</c:forEach>

					</select></td>
				</tr>

				<tr>
					<td></td>
					<td><input type="submit" value="Apply Filters" /></td>
					<td></td>
				</tr>
			</table>
		</div>
	</fieldset>
</form>

<br />
<br />
<a href="appointmentNew.form" style="float: right;">Schedule new
	Appointment</a>
<br />
<br />
<b class="boxHeader">Patient appointments List</b>
<div class="box">
	<table style="width: 100%">
		<tr>
			<th style="width: 5%">#.</th>
			<th style="width: 8%">Patient</th>
			<th style="width: 8%">Date</th>
			<th style="width: 8%">Time</th>
			<th style="width: 8%">Provider</th>
			<th style="width: 8%">Service</th>
			<th style="width: 8%">Appointment Type</th>
			<th style="width: 8%">Status</th>
		</tr>
		<c:forEach items="${providerSchedules}" var="providerSchedule" >
		<c:forEach items="${providerSchedule.appointments}" var="appointment" 	varStatus="status">
					<tr>
					<td class="rowValue ${(status.count%2!=0)?'even':''}">${status.count}</td>
				    <td class="rowValue ${(status.count%2!=0)?'even':''}">${appointment.patient.familyName }</td>
				    <td class="rowValue ${(status.count%2!=0)?'even':''}"><fmt:formatDate value="${providerSchedule.workingDate}" pattern="dd-MM-yyyy"/></td>
				    <td class="rowValue ${(status.count%2!=0)?'even':''}">${appointment.timeSlot.startTime}</td>
					<td class="rowValue ${(status.count%2!=0)?'even':''}">${providerSchedule.serviceProvider.name}</td>							
					<td class="rowValue ${(status.count%2!=0)?'even':''}">${appointment.providerSchedule.serviceDefinition.name}</td>
					<td class="rowValue ${(status.count%2!=0)?'even':''}">${appointment.providerSchedule.serviceType.name}</td>
					<td class="rowValue ${(status.count%2!=0)?'even':''}">${appointment.status.description}</td>
				</tr>
			</c:forEach>
		</c:forEach>
	</table>
</div>

<%@ include file="/WEB-INF/template/footer.jsp"%>