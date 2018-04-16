<%@ include file="/META-INF/resources/init.jspf" %>

<%
	//
	//search containter adds the current raw in the request attribute so we get the current item fron there
	//
	ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Venue venue = (Venue)row.getObject();
	//
	// we also have the edit URL that we stored ourselves in the parent page
	//
	String editVenueURL = (String)request.getAttribute("editVenueURL");
%>

<liferay-ui:icon-menu direction="left-side" icon="" markupView="lexicon" message="" showWhenSingleIcon="<%= true %>">
	
	<%--
		Add a button to edit venue
	 --%>
	<liferay-ui:icon
		label="<%= true %>"
		message="edit"
		url="<%= editVenueURL %>"
	/>
	
	<%--
		Generate a URL and add a button to edit venue's permissions
	 --%>
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
	
	<%--
		Generate a URL and add a button to delete venue
	 --%>
	<portlet:actionURL name="deleteVenue" var="deleteURL">
		<portlet:param name="redirect" value="<%= currentURL %>" />
		<portlet:param name="venueId" value="<%= String.valueOf(venue.getVenueId()) %>" />
		<portlet:param name="navigation" value="venues" />
	</portlet:actionURL>
	<liferay-ui:icon-delete
		url="<%= deleteURL %>"
		/>
</liferay-ui:icon-menu>
