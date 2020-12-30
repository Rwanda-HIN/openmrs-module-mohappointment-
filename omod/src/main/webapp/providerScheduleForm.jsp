
<h2>Provider schedule Management</h2>

<p>
	<a href="providerSchedules.list">View Provider schedule list </a>
</p>
<!-- div: creating provider schedule -->
<b class="boxHeader">Provider schedule summary</b>
<form	action="providerScheduling.form?scheduleId=${providerSchedule.providerScheduleId}&save=true"
	method="post">
	<div class="box">

		<table cellpadding="3" cellspacing="0">
			<tr>
				<th>Provider :</th>
				<td><select name="medSvceProviderId">
						<option value="">--select--</option>
						<c:forEach items="${serviceProviders}" var="svceProvider">
							<option value="${svceProvider.medServiceProviderId}">${svceProvider.name}</option>
						</c:forEach>

				</select></td>
			</tr>
			<tr>
				<th>Service :</th>
				<td><select name="serviceId">
						<c:forEach items="${serviceDefinitions}" var="serviceDefinition">
							<option value="${serviceDefinition.appointmentServiceId}">${serviceDefinition.name}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<th>Appointment Type:</th>
				<td><select name="serviceTypeId">
						<c:forEach items="${serviceTypes}" var="svceType">
							<option value="${svceType.serviceTypeId}">${svceType.name}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
			<th>Working Date :</th>
				<td>
					<fieldset align="center"><legend>Start Date</legend>
						<openmrs_tag:dateField formFieldName="startDate"startValue="${startDate}"/>
					</fieldset>
				</td>
					<td>
					<fieldset align="center"><legend>End Date</legend>
						<openmrs_tag:dateField formFieldName="endDate" startValue="${endDate}"/>
					</fieldset>
				</td>
			</tr>
			<tr>
				<th></th>
				<th>Starting Time</th>
				<th>Ending Time</th>
			</tr>
			<tr>
				<td></td>
				<td><input type="text" name="startTime" size="20"
					value="${status.value}" onfocus="showTimePicker(this)" /></td>

				<td><input type="text" name="endTime" size="20"
					value="${status.value}" onfocus="showTimePicker(this)" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Save Provider Schedule" /></td>
			</tr>

		</table>
	</div>
</form>