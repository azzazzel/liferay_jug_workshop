<%@page import="javax.portlet.ActionRequest"%>
<%@ include file="/META-INF/resources/init.jspf" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
String editTalkURL = (String)request.getAttribute("editTalkURL");
Talk talk = (Talk)row.getObject();
%>

<liferay-ui:icon-menu direction="left-side" icon="" markupView="lexicon" message="" showWhenSingleIcon="<%= true %>">

	
	<liferay-ui:icon
		label="<%= true %>"
		message="edit"
		url="<%= editTalkURL %>"
	/>

	<portlet:renderURL var="previewURL">
		<portlet:param name="mvcRenderCommandName" value="preview" />
		<portlet:param name="talkId" value="<%= String.valueOf(talk.getTalkId()) %>" />
		<portlet:param name="navigation" value="talks" />
	</portlet:renderURL>
	
	<liferay-ui:icon
		label="<%= true %>"
		message="preview"
		url="<%= previewURL %>"
	/>

	
	<liferay-security:permissionsURL
		modelResource="<%= Talk.class.getName() %>"
		modelResourceDescription="<%= talk.getTitle() %>"
		resourcePrimKey="<%= String.valueOf(talk.getTalkId()) %>"
		var="permissionsURL"
		windowState="<%= LiferayWindowState.POP_UP.toString() %>"
	/>

	<liferay-ui:icon
		message="permissions"
		method="get"
		url="<%= permissionsURL %>"
		useDialog="<%= true %>"
	/>
	
	<portlet:actionURL name="deleteTalk" var="deleteURL">
		<portlet:param name="redirect" value="<%= currentURL %>" />
		<portlet:param name="talkId" value="<%= String.valueOf(talk.getTalkId()) %>" />
		<portlet:param name="navigation" value="talks" />
	</portlet:actionURL>
	
	<liferay-ui:icon-delete
		url="<%= deleteURL %>"
		/>
</liferay-ui:icon-menu>
