<%@ include file="/META-INF/resources/init.jspf" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
Venue venue = (Venue)row.getObject();
%>

<liferay-ui:icon-menu direction="left-side" icon="" markupView="lexicon" message="" showWhenSingleIcon="<%= true %>">
	<portlet:renderURL var="editURL">
		<portlet:param name="mvcPath" value="/venue_edit.jsp" />
		<portlet:param name="venueId" value="<%= String.valueOf(venue.getVenueId()) %>" />
		<portlet:param name="navigation" value="venues" />
	</portlet:renderURL>
	
	<liferay-ui:icon
		label="<%= true %>"
		message="edit"
		url="<%= editURL %>"
	/>
	
	
	<liferay-security:permissionsURL
		modelResource="<%= Venue.class.getName() %>"
		modelResourceDescription="<%= venue.getName() %>"
		resourcePrimKey="<%= String.valueOf(venue.getVenueId()) %>"
		var="permissionsURL"
		windowState="<%= LiferayWindowState.POP_UP.toString() %>"
	/>

	<liferay-ui:icon
		message="permissions"
		method="get"
		url="<%= permissionsURL %>"
		useDialog="<%= true %>"
	/>
	
	<portlet:actionURL name="deleteVenue" var="deleteURL">
		<portlet:param name="redirect" value="<%= currentURL %>" />
		<portlet:param name="venueId" value="<%= String.valueOf(venue.getVenueId()) %>" />
		<portlet:param name="navigation" value="venues" />
	</portlet:actionURL>
	
	<liferay-ui:icon-delete
		url="<%= deleteURL %>"
		/>
</liferay-ui:icon-menu>
