<%@ include file="/META-INF/resources/init.jspf" %>

<%
	//
	//search containter adds the current raw in the request attribute so we get the current item fron there
	//
	ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Event event = (Event)row.getObject();
	//
	// we also have the edit URL that we stored ourselves in the parent page
	//
	String editEventURL = (String)request.getAttribute("editEventURL");
%>

<liferay-ui:icon-menu direction="left-side" icon="" markupView="lexicon" message="" showWhenSingleIcon="<%= true %>">

	<%--
		Add a button to edit event
	 --%>
	<liferay-ui:icon
		label="<%= true %>"
		message="edit"
		url="<%= editEventURL %>"
	/>
	
	<%--
		Generate a URL and add a button to add talks to event
	 --%>
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
	
	<%--
		Generate a URL and add a button to update event's permission
	 --%>
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
	
	<%--
		Generate a URL and add a button to delete event
	 --%>
	<portlet:actionURL name="deleteEvent" var="deleteURL">
		<portlet:param name="redirect" value="<%= currentURL %>" />
		<portlet:param name="eventId" value="<%= String.valueOf(event.getEventId()) %>" />
		<portlet:param name="navigation" value="events" />
	</portlet:actionURL>
	<liferay-ui:icon-delete
		url="<%= deleteURL %>"
		/>
</liferay-ui:icon-menu>
