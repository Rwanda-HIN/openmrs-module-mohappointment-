<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>
<%@ include file="templates/appointmentAdminHeader.jsp"%>


<p>
	<a href="medServiceProvider.list">View Provider schedule list </a>
</p>
<!-- div: creating  -->
<b class="boxHeader">Provider summary</b>
<form 	action="medServiceProvider.form?medProviderId=${medServiceProvider.medServiceProviderId}&save=true" method="post">
	<div class="box">

		<table cellpadding="3" cellspacing="0">
			<tr>
				<th>Provider :</th>
				<td><openmrs_tag:userField roles="Provider" formFieldName="providerId" initialValue="${provider.userId}" /></td>
			</tr>
			<tr>
				<th>Title:</th>
				<td><input type="text" name="title"	value="${medServiceProvider.title}" /></td>
			</tr>
			<tr>
				<th>Service:</th>
				<td><select name="serviceId" id="service">
					<option value="">--</option>
					<c:forEach items="${serviceDefinitions}" var="serviceDefinition">
						<option value="${serviceDefinition.appointmentServiceId}">${serviceDefinition.name}</option>
					</c:forEach>
				</select>
			</td>
			</tr>			
			<tr>
				<td></td>
				<td><input type="submit" value="Save Service Provider" /></td>
			</tr>

		</table>
	</div>
</form>
<%@ include file="/WEB-INF/template/footer.jsp"%>