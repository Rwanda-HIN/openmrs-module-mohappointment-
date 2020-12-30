<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>
<%@ include file="templates/appointmentAdminHeader.jsp"%>

<h2>Services management</h2>


<a href="medservices.form">Add new Service</a>
<br/><br/>

<b class="boxHeader">Current Services </b>
<div class="box">
<c:set var="mappedServices" value="${mappedServices}" />

<table style="width:100%">


	<tr>
		<th  style="width:5%">#.</th>
		<th style="width:8%">Service Name</th>
		<th style="width:8%">Department</th>	
		<th style="width:8%">Speciality</th>
		<th style="width:8%">Description</th>
		<th style="width:8%">Action</th>				
	</tr>	
	
		<c:forEach items="${services}" var="service" varStatus="status">
			<tr>
			<td class="rowValue ${(status.count%2!=0)?'even':''}">${status.count}</td>
			<td class="rowValue ${(status.count%2!=0)?'even':''}"><a href="service.form?serviceId=${service.appointmentServiceId}">${service.name}</a></td>
			<td class="rowValue ${(status.count%2!=0)?'even':''}">${service.specialty.name}</td>
			<td class="rowValue ${(status.count%2!=0)?'even':''}">${service.specialty.name}</td>			
			<td class="rowValue ${(status.count%2!=0)?'even':''}">${service.name}</td>
			<td class="rowValue ${(status.count%2!=0)?'even':''}"><a href="service.form?editService=true&editServiceId=${service.appointmentServiceId}">Edit</a>
			|<a href="service.form?deleteService=true&deleteServiceId=${service.appointmentServiceId}">Delete</a></td>
								
		</tr>
	</c:forEach>
	 
</table>

</div>

<%@ include file="/WEB-INF/template/footer.jsp"%>