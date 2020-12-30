<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>
<%@ include file="templates/appointmentAdminHeader.jsp"%>

<h2>Appoinmtment Type management</h2>

<a href="serviceType.form">Add new Appointment Type </a>
<br />
<br />

<b class="boxHeader">Current appointment Types </b>
<div class="box">
	<table style="width: 100%">
		<tr>
			<th  style="width:5%">Appointment Type</th>
			<th  style="width:5%">Service</th>
			<th  style="width:5%">Duration</th>
			<th  style="width:5%">Action</th>
		</tr>
		<c:forEach items="${appointmentServiceTypes}" var="serviceType" varStatus="status">
			<tr>
				<td class="rowValue ${(status.count%2!=0)?'even':''}">${serviceType.name}</td>
				<td class="rowValue ${(status.count%2!=0)?'even':''}">${serviceType.serviceDefinition.name}</td>
				<td class="rowValue ${(status.count%2!=0)?'even':''}">${serviceType.duration}</td>
				<td class="rowValue ${(status.count%2!=0)?'even':''}"><a href="">Edit</a>|<a href="">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</div>
<%@ include file="/WEB-INF/template/footer.jsp"%>