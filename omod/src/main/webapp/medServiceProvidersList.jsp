<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>
<%@ include file="templates/appointmentAdminHeader.jsp"%>

<h2>Service Provider  management</h2>

<a href="medServiceProvider.form" style="float: right;">Add new Service Provider </a>
<br />
<br />

<b class="boxHeader">Current Services Providers </b>
<div class="box">
	<table style="width: 100%">
		<tr>
			<th  style="width:5%">Speciality</th>
			<th  style="width:5%">Services</th>
			<th  style="width:5%">Providers</th>
			<th  style="width:5%">Action</th>
		</tr>
		<c:forEach items="${medServiceProviders}" var="medSp" varStatus="status">
			<tr>
				<td class="rowValue ${(status.count%2!=0)?'even':''}">${medSp.serviceDefinition.specialty.name}</td>
				<td class="rowValue ${(status.count%2!=0)?'even':''}">${medSp.serviceDefinition.name}</td>
				<td class="rowValue ${(status.count%2!=0)?'even':''}">${medSp.provider.personName}</td>
				<td class="rowValue ${(status.count%2!=0)?'even':''}"><a href="">Edit</a>|<a href="">Delete</a></td>

			</tr>
		</c:forEach>
	</table>
</div>

<%@ include file="/WEB-INF/template/footer.jsp"%>