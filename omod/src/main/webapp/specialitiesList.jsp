<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>
<%@ include file="templates/appointmentAdminHeader.jsp"%>

<h2>Service Provider  management</h2>

<a href="speciality.form">Add new specialty</a>
<br/>
<br/>

<b class="boxHeader">Current specialities</b>
<div class="box">
<table style="width:100%">
	<tr>
		<th style="width:3%">#.</th>
		<th style="width:10%">Name</th>
		<th style="width:10%">Description</th>
		<th style="width:3%">Services</th>
	</tr>
	<c:forEach items="${specialities}" var="speciality" varStatus="status">
		<tr>
			<td class="rowValue ${(status.count%2!=0)?'even':''}">${status.count}</td>
			<td class="rowValue ${(status.count%2!=0)?'even':''}"><a href="specialty.form?specialityId=${speciality.specialityId}">${speciality.name}</a></td>			
			<td class="rowValue ${(status.count%2!=0)?'even':''}">${speciality.description}</td>
			<td class="rowValue ${(status.count%2!=0)?'even':''}"><a href="services.list?departmentId=${speciality.specialityId}">view</a></td>
		 </tr>		
	</c:forEach>
</table>
</div>


<%@ include file="/WEB-INF/template/footer.jsp"%>