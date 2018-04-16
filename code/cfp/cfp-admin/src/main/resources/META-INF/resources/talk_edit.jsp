<%@ include file="/META-INF/resources/init.jspf" %>

<%
	long talkId = ParamUtil.getLong(request, "talkId");
	Talk talk = null;
	long structureId;
	boolean isUpdate = false;
	if (talkId > 0) {
		talk = TalkLocalServiceUtil.getTalk(talkId);
		structureId =  talk.getStructureId();
		isUpdate = true;
	} else {
		structureId =  ParamUtil.getLong(request, "structureId", 0);
	}
	
	DDMStructure structure = DDMStructureLocalServiceUtil.fetchDDMStructure(structureId);
	
	List<DDMTemplate> formTemplates = DDMTemplateLocalServiceUtil.getTemplates(
			scopeGroupId, 
			ClassNameLocalServiceUtil.getClassNameId(DDMStructure.class.getName()), 
			structureId, 
			DDMTemplateConstants.TEMPLATE_TYPE_FORM);

	List<DDMTemplate> displayTemplates = DDMTemplateLocalServiceUtil.getTemplates(
			scopeGroupId, 
			ClassNameLocalServiceUtil.getClassNameId(DDMStructure.class.getName()), 
			structureId, 
			DDMTemplateConstants.TEMPLATE_TYPE_DISPLAY);

	DDMTemplate template = null;
	DDMFormValues formValues = null;

	if (isUpdate) {
		for (DDMTemplate t : formTemplates) {
			if (t.getMode().equals(DDMTemplateConstants.TEMPLATE_MODE_EDIT)) {
				template = t;
				break;
			}
		}

		DDMFormValuesJSONDeserializer ddmFormValuesJSONDeserializer = (DDMFormValuesJSONDeserializer)request.getAttribute("ddmFormValuesJSONDeserializer");
		formValues = ddmFormValuesJSONDeserializer.deserialize(structure.getDDMForm(), talk.getData());

	} 
	
	if (!isUpdate || template == null) {
		for (DDMTemplate t : formTemplates) {
			if (t.getMode().equals(DDMTemplateConstants.TEMPLATE_MODE_CREATE)) {
				template = t;
				break;
			}
		}
	}
	
%>

<div class="container-fluid-1280 main-content-body">

	<c:choose>
		<c:when test="<%= structure == null %>">
			<aui:alert type="danger" >
				<liferay-ui:message key="no-structure-for-talk" />
			</aui:alert>
		</c:when>
		<c:when test="<%= isUpdate && template == null %>">
			<aui:alert type="danger" >
				<liferay-ui:message key="no-update-template-for-talk-structure" arguments="<%=structure.getName(locale) %>" />
			</aui:alert>
		</c:when>
		<c:when test="<%= template == null %>">
			<aui:alert type="danger" >
				<liferay-ui:message key="no-create-template-for-talk-structure" arguments="<%=structure.getName(locale) %>" />
			</aui:alert>
		</c:when>
		<c:otherwise>
			 <aui:form action="<%= saveTalkURL %>" name="fm" enctype="multipart/form-data" method="post">
		 	        <aui:model-context bean="<%= talk %>" model="<%= Talk.class %>" />
			        <aui:input type="hidden" name="talkId"
			            value='<%= talk == null ? "" : talk.getTalkId() %>' />
			        <aui:input type="hidden" name="structureId" value='<%= structureId %>' />
			        <aui:fieldset>
			            <aui:input name="title" />
						<aui:select name="templateId" id="templateSelector">
							<% for (DDMTemplate t : displayTemplates) { %>
								<aui:option label="<%= t.getName() %>" value="<%= t.getTemplateId() %>"/>
							<% } %>
						</aui:select>
						<liferay-ddm:html
							classNameId="<%=ClassNameLocalServiceUtil.getClassNameId(DDMTemplate.class.getName()) %>"
							classPK="<%=formTemplates.get(0).getTemplateId() %>"
							ddmFormValues="<%=formValues %>"
						/> 
			        </aui:fieldset>
			        <aui:button-row>
			             <aui:button type="submit" />
			             <aui:button onClick="<%= talksURL %>" type="cancel"  />
			        </aui:button-row>
			</aui:form>
		</c:otherwise>
	</c:choose>

	

</div>