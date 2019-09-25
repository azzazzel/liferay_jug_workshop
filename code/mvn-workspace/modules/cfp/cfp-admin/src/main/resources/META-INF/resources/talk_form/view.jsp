<%@ include file="/META-INF/resources/init.jspf" %>

<%
	List<DDMStructure> structures = DDMStructureLocalServiceUtil.getStructures(
			scopeGroupId,
			ClassNameLocalServiceUtil.getClassNameId(Talk.class.getName()));
	
	String languageId = LanguageUtil.getLanguageId(renderRequest);
	
	long currentStructure = ParamUtil.getLong(request, "structureId", structures.get(0).getStructureId()) ;
	
	List<DDMTemplate> templates = DDMTemplateLocalServiceUtil.getTemplates(
			scopeGroupId, 
			ClassNameLocalServiceUtil.getClassNameId(DDMStructure.class.getName()), 
			currentStructure, 
			DDMTemplateConstants.TEMPLATE_TYPE_FORM);
	
%>

<div class="container-fluid-1280 main-content-body">

	<portlet:actionURL name="saveTalk" var="addTalkURL">
		<portlet:param name="mvcPath" value="/talk_form/thank_you.jsp" />
	</portlet:actionURL>

	 <aui:form action="<%= addTalkURL %>" name="fm" enctype="multipart/form-data" method="post">
 	        <aui:model-context model="<%= Talk.class %>" />
	        
	        <aui:select id="structureSelector" name="structureId" label="talk-type">
	        	<% for (DDMStructure structure : structures) { %>
	        		<aui:option 
	        			label="<%=structure.getName() %>" 
	        			value="<%= structure.getStructureId() %>"
	        			selected="<%= structure.getStructureId() == currentStructure %>"
	        			/>
       			<% } %>
	        </aui:select>
	        
	        <aui:fieldset>
	            <aui:input name="title" />
				<liferay-ddm:html
					classNameId="<%=ClassNameLocalServiceUtil.getClassNameId(DDMTemplate.class.getName()) %>"
					classPK="<%=templates.get(0).getTemplateId() %>"
				/> 
	        </aui:fieldset>
	        <aui:button-row>
	             <aui:button type="submit" />
	        </aui:button-row>
	</aui:form>
	

<aui:script>
	$('#<portlet:namespace />structureSelector').on(
		'change',
		function() {
			var renderURL = Liferay.PortletURL.createRenderURL();
			renderURL.setParameter("structureId", document.getElementById('<portlet:namespace />structureSelector').value)
			renderURL.setPortletId('<%=PortalUtil.getPortletId(request) %>');
			renderURL.setPortletMode("view");
			renderURL.setWindowState("normal");
			window.location.href = renderURL;
		}
	);	
</aui:script>
</div>