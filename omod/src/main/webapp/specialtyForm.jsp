<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>
<%@ include file="templates/appointmentAdminHeader.jsp"%>

<h2>New Speciality</h2>

<p><a href="specialities.list">View Current Specialties</a> </p>

<!-- div: creating new Specialty -->
<div class="box">
	<form action="speciality.form?specialtyId=${speciality.specialityId}&save=true" method="post">
		<table>
			<tr>
				<td>Name</td>
				<td><input type="text" name="specialtyName"  value="${speciality.name}"/></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><textarea name="description"  cols="70" rows="5">${speciality.description}</textarea></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Save speciality"/></td>
			</tr>
		</table>
	</form>
</div>
<%@ include file="/WEB-INF/template/footer.jsp"%>