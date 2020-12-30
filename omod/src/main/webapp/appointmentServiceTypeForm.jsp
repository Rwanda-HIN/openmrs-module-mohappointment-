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

<h2>Appointment Type Management</h2>

<p>
	<a href="appointmentTypes.list">View appointment Type </a>
</p>
<!-- div: creating new service Type -->
<b class="boxHeader">Service Type summary</b>
<form
	action="serviceType.form?serviceTypeId=${serviceType.appointmentServiceId}&save=true" 	method="post">
	<div class="box">

		<table cellpadding="3" cellspacing="0">
			<tr>
				<th>Name</th>
				<td><input type="text" name="serviceName"
					value="${serviceType.name}" /></td>
			</tr>
			<tr>
				<th>Description</th>
				<td><textarea name="description" cols="30" rows="3">${serviceType.description}</textarea></td>
			</tr>
			<tr>
				<th>Service</th>
				<td><select name="serviceId">
						<c:forEach items="${services}" var="service">
							<option value="${service.appointmentServiceId}">${service.name}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<th>Service duration</th>
				<td><input type="text" name="serviceDuration"
					value="${serviceType.duration}" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Save Appointment Service Type" /></td>
			</tr>

		</table>
	</div>
</form>
<%@ include file="/WEB-INF/template/footer.jsp"%>