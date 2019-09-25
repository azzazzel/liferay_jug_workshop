
<%@ include file="/META-INF/resources/init.jspf" %>

<%
	String navigation = ParamUtil.getString(request, "navigation", "events");
%>

<aui:nav-bar cssClass="collapse-basic-search" markupView="lexicon">

	<aui:nav cssClass="navbar-nav">
	
		<aui:nav-item
			href="<%= eventsURL %>"
			label="cfp-admin.events"
			selected='<%= navigation.equals("events") %>'
		/>

		<aui:nav-item
			href="<%= venuesURL %>"
			label="cfp-admin.venues"
			selected='<%= navigation.equals("venues") %>'
		/>
		
		<aui:nav-item
			href="<%= talksURL %>"
			label="cfp-admin.talks"
			selected='<%= navigation.equals("talks") %>'
		/>

	</aui:nav>

	<portlet:actionURL name="testAction" var="testActionURL"/>

</aui:nav-bar>

<c:choose>
	<c:when test='<%= navigation.equals("events") %>'>
		<liferay-util:include page="/events.jsp" servletContext="<%= application %>" />
	</c:when>
	<c:when test='<%= navigation.equals("venues") %>'>
		<liferay-util:include page="/venues.jsp" servletContext="<%= application %>" />
	</c:when>
	<c:when test='<%= navigation.equals("talks") %>'>
		<liferay-util:include page="/talks.jsp" servletContext="<%= application %>" />
	</c:when>
	<c:otherwise>
		<liferay-ui:message key="cfp.page-not-found" />
	</c:otherwise>
</c:choose>
