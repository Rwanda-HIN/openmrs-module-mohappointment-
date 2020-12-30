<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>
<%@ include file="templates/mohAppointmentLocalHeader.jsp"%>
<openmrs:htmlInclude file="/scripts/calendar/calendar.js" />



<form action="appointments.list?search=true" method="post">
	<fieldset style="clear: both">
		<legend>Choose properties</legend>
		<div style="margin: 0.5em 0;">
			<table>
				<tr>
					<th>Appointment Date:</th>
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
					<th>Appointment status :</th>
					<td><select name="appointmentStatusId">
							<option value="">--select--</option>
							<c:forEach items="${allAppointmentStatuses}" var="appointmentStatus">
								<option value="${AppointmentStatus.appointmentStateId}"
									${AppointmentStatus.appointmentStateId==chosenStatus.appointmentStateId? 'selected' : ''}>${appointmentStatus.description}</option>
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


<%@ include file="/WEB-INF/template/footer.jsp"%>