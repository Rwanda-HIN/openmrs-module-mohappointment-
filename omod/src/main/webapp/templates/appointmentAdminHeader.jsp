<!-- 
<openmrs:hasPrivilege privilege="View Appointment Administration">
 -->
<ul id="menu">
	<li
		class="<c:if test='<%=request.getRequestURI().contains("home")%>'> active</c:if>">
		<a href="home.page">Appointment Home</a>
	</li>

	<li
		<c:if test='<%= request.getRequestURI().contains("specialities") %>'>class="active"</c:if>>
		<a href="specialities.list">Manage Speciality</a>	
		
	</li>
	<li
		<c:if test='<%= request.getRequestURI().contains("serviceDefinitionList") %>'>class="active"</c:if>>
		<a href="medservices.list">Manage Service</a>
	</li>
	<li
		<c:if test='<%= request.getRequestURI().contains("appoinmentServiceTypeList") %>'>class="active"</c:if>>
		<a href="appointmentTypes.list">Manage appointment Type</a>
	</li>
	<li
		<c:if test='<%= request.getRequestURI().contains("medServiceProvidersList") %>'>class="active"</c:if>>
		<a href="medServiceProvider.list">Manage service Provider</a>
	</li>
<!-- 
</openmrs:hasPrivilege>
 -->

<!-- Here I would like to set the totals at the bottom -->
<style>
.columnHeader {
	background: none repeat scroll 0 0 #E6E6E6;
	border: 1px solid #D3D3D3;
	color: #555555;
	cursor: pointer;
	font-size: 0.8em;
	font-weight: normal;
	margin: 0;
	padding: 3px 0 3px 5px;
	text-align: left;
}

.rowValue {
	font-size: 0.8em;
	font-weight: normal;
	margin: 0;
	padding: 5px;
	vertical-align: top;
	border-top: 1px solid cadetblue;
}

.rowAmountValue {
	font-size: 0.8em;
	font-weight: normal;
	margin: 0;
	padding: 5px;
	/* Here I would like to set the totals at the bottom*/
	vertical-align: bottom;
	border-top: 1px solid cadetblue;
	border-right: 1px solid cadetblue;
	border-left: 1px solid cadetblue;
}

.rowTotalValue {
	font-size: 0.8em;
	font-weight: normal;
	margin: 0;
	padding: 5px;
	vertical-align: top;
	border-top: 1px solid cadetblue;
	border-right: 1px solid cadetblue;
	border-bottom: 1px solid cadetblue;
	border-left: 1px solid cadetblue;
}

.even {
	background-color: whitesmoke;
}

.numbers {
	text-align: right;
	background-color: whitesmoke;
}

.amount {
	text-align: right;
	background-color: #C9DAFF;
	border: 2px solid #000000;
	font-weight: bold;
}

.right {
	text-align: right;
}

.center {
	text-align: center;
}

.searchRow:hover {
	background: #F0E68C;
	cursor: pointer;
}
</style>