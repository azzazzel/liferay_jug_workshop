<%@ include file="/META-INF/resources/init.jspf" %>

<%
	//
	// search containter adds the current raw in the request attribute so we get the current item fron there
	//
	ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Talk talk = (Talk)row.getObject();
	//
	// we also have the edit URL that we stored ourselves in the parent page
	//
	String editTalkURL = (String)request.getAttribute("editTalkURL");
%>

<liferay-ui:icon-menu direction="left-side" icon="" markupView="lexicon" message="" showWhenSingleIcon="<%= true %>">

	
	<%--
		Add a button to edit talk
	 --%>
	<liferay-ui:icon
		label="<%= true %>"
		message="edit"
		url="<%= editTalkURL %>"
	/>

	<%--
		Generate a URL and add a button to preview a talk
	 --%>
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

	<%--
		Generate a URL and add a button to edit talk's permissions
	 --%>
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
	
	<%--
		Generate a URL and add a button to delete talk
	 --%>
	<portlet:actionURL name="deleteTalk" var="deleteURL">
		<portlet:param name="redirect" value="<%= currentURL %>" />
		<portlet:param name="talkId" value="<%= String.valueOf(talk.getTalkId()) %>" />
		<portlet:param name="navigation" value="talks" />
	</portlet:actionURL>
	<liferay-ui:icon-delete
		url="<%= deleteURL %>"
		/>
</liferay-ui:icon-menu>
