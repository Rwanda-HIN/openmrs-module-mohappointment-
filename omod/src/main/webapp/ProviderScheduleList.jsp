<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>
<%@ include file="templates/mohAppointmentLocalHeader.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h2>Schedule management</h2>

<a href="schedule.form">Add new provider schedule</a>
<br/><br/>

<b class="boxHeader">Current provider schedules </b>
<div class="box">
<table style="width:100%">
	<tr>
		<th  style="width:5%">#.</th>
		<th style="width:8%">Provider </th>
		<th style="width:8%">Appointment Type </th>
			<th style="width:8%">Service</th>			
		<th style="width:8%">Working Date </th>		
		<th style="width:8%">Start Time</th>
		<th style="width:8%">End Time</th>
		<th style="width:8%"># Appointments</th>
		<th style="width:8%">Action</th>	
	</tr>
	<c:forEach items="${providerSchedules}" var="provSchedule" varStatus="status">
			<tr>
			<td class="rowValue ${(status.count%2!=0)?'even':''}">${status.count}</td>
			<td class="rowValue ${(status.count%2!=0)?'even':''}">${provSchedule.serviceProvider.name }</td>
			<td class="rowValue ${(status.count%2!=0)?'even':''}">${provSchedule.serviceType.name }</td>				
			<td class="rowValue ${(status.count%2!=0)?'even':''}">${provSchedule.serviceDefinition.name }</td>			
			<td class="rowValue ${(status.count%2!=0)?'even':''}"><fmt:formatDate value="${provSchedule.workingDate}" pattern="yyyy/MM/dd"/></td>		
			<td class="rowValue ${(status.count%2!=0)?'even':''}">${provSchedule.startTime}</td>
			<td class="rowValue ${(status.count%2!=0)?'even':''}">${provSchedule.endTime}</td>
			<td class="rowValue ${(status.count%2!=0)?'even':''}">0</td>			
			<td class="rowValue ${(status.count%2!=0)?'even':''}"><a href="searchAppointment.form?providSchedulerId=${provSchedule.providerScheduleId}">View appointment</a>
		 </tr>
	</c:forEach>	 
</table>
</div>
<%@ include file="/WEB-INF/template/footer.jsp"%>