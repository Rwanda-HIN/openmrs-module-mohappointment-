<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>
<%@ include file="templates/appointmentAdminHeader.jsp"%>
<openmrs:htmlInclude
	file="/moduleResources/mohappointment/scripts/jquery-clock-timepicker.min.js" />

<script>
	var $t = jQuery.noConflict();
	$t(document).ready(function() {
		$t("#clock").clockTimePicker({
			required : true,
			separator : '.',
			precision : 10,
			duration : true,
			minimum : '01:00',
			maximum : '03:00',
			durationNegative : true
		});
	});
</script>


<h2>New Service Management</h2>

<p>
	<a href=" ">View services</a>
</p>
<!-- div: creating new Specialty -->
<b class="boxHeader">Service summary</b>
<form
	action="medservices.form?medserviceId=${medService.appointmentServiceId}&save=true"
	method="post">
	<div class="box">

		<table cellpadding="3" cellspacing="0">
			<tr>
				<th>Service Name</th>
				<td><input type="text" name="serviceName"	value="${medService.name}" /></td>
			</tr>

			<tr>
				<th>Description</th>
				<td><textarea name="description" cols="30" rows="3">${medService.description}</textarea></td>
			</tr>
			<tr>
				<th>Speciality</th>
				<td><select name="specialtyId">
						<c:forEach items="${specialties}" var="specialty">
							<option value="${specialty.specialityId}">${specialty.name}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
			<tr/>
			<tr>
				<th>Working days</th>
				<th>Start Time</th>
				<th>End Time</th>
			</tr>
				<tr>
				<td><select name="weekDay" style="width:65%">
						<c:forEach items="${weekDays}" var="day">
							<option value="${day}">${day}</option>
						</c:forEach>						
				</select></td>
				<td><input type="text" id="clock" name="startTime" 		value="00:00 AM" /></td>
				<td><input type="text" id="clock" name="endTime" 		value="00:00 PM" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Save service" /></td>
			</tr>

		</table>
	</div>
</form>

<%@ include file="/WEB-INF/template/footer.jsp"%>