<%@ include file="/META-INF/resources/init.jspf" %>

<%
	DDMTemplate displayTemplate = (DDMTemplate)renderRequest.getAttribute("displayTemplate");
	String error = (String)renderRequest.getAttribute("error");
	Talk talk = (Talk) renderRequest.getAttribute("talk");
	DDMStructure structure = (DDMStructure)renderRequest.getAttribute("structure");
%>

<div class="container-fluid-1280 main-content-body">

	<c:choose>
		<c:when test="<%= talk == null %>">
			<aui:alert type="info" >
				<liferay-ui:message key="no-talk-to-display" />
			</aui:alert>
		</c:when>
		<c:when test="<%= error != null && !error.isEmpty() %>">
			<aui:alert type="danger" >
				<liferay-ui:message key="<%= error %>" arguments="<%=structure.getName(locale) %>" />
			</aui:alert>
		</c:when>
		<c:otherwise>
		
			<%= renderRequest.getAttribute("result") %>

		</c:otherwise>
	</c:choose>

</div>