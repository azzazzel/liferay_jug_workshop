<%@ include file="/META-INF/resources/init.jspf" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
Event event = (Event)row.getObject();
%>

<liferay-ui:icon-menu direction="left-side" icon="" markupView="lexicon" message="" showWhenSingleIcon="<%= true %>">
	<portlet:renderURL var="editURL">
		<portlet:param name="mvcPath" value="/event_edit.jsp" />
		<portlet:param name="eventId" value="<%= String.valueOf(event.getEventId()) %>" />
		<portlet:param name="navigation" value="events" />
	</portlet:renderURL>
	
	<liferay-ui:icon
		label="<%= true %>"
		message="edit"
		url="<%= editURL %>"
	/>

	<portlet:renderURL var="editEventTalksURL">
		<portlet:param name="mvcPath" value="/event_talks.jsp" />
		<portlet:param name="eventId" value="<%= String.valueOf(event.getEventId()) %>" />
		<portlet:param name="backURL" value="<%= currentURL %>" />
		<portlet:param name="navigation" value="events" />
	</portlet:renderURL>
	
	<liferay-ui:icon
		label="<%= true %>"
		message="event-talks"
		url="<%= editEventTalksURL %>"
	/>
	
	<liferay-security:permissionsURL
		modelResource="<%= Venue.class.getName() %>"
		modelResourceDescription="<%= event.getName() %>"
		resourcePrimKey="<%= String.valueOf(event.getVenueId()) %>"
		var="permissionsURL"
		windowState="<%= LiferayWindowState.POP_UP.toString() %>"
	/>

	<liferay-ui:icon
		message="permissions"
		method="get"
		url="<%= permissionsURL %>"
		useDialog="<%= true %>"
	/>
	
	<portlet:actionURL name="deleteEvent" var="deleteURL">
		<portlet:param name="redirect" value="<%= currentURL %>" />
		<portlet:param name="eventId" value="<%= String.valueOf(event.getEventId()) %>" />
		<portlet:param name="navigation" value="events" />
	</portlet:actionURL>
	
	<liferay-ui:icon-delete
		url="<%= deleteURL %>"
		/>
</liferay-ui:icon-menu>
