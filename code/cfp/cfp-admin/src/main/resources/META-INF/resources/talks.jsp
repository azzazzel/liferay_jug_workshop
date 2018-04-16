<%@ include file="/META-INF/resources/init.jspf" %>


<liferay-frontend:management-bar
	includeCheckBox="<%= true %>"
	searchContainerId="talks"
>
		<liferay-frontend:management-bar-buttons>
		
<%-- 			<liferay-portlet:actionURL name="changeDisplayStyle" varImpl="changeDisplayStyleURL">
						<portlet:param name="redirect" value="<%= currentURL %>" />
			</liferay-portlet:actionURL>
 --%>		
			<liferay-frontend:management-bar-display-buttons
				displayViews='<%= new String[] {"icon", "descriptive", "list"} %>'
				portletURL="<%= changeDisplayStyleURL %>"
				selectedDisplayStyle="<%= displayStyle %>"
			/>
		</liferay-frontend:management-bar-buttons>

	<liferay-frontend:management-bar-action-buttons>
		<liferay-frontend:management-bar-button 
			href='javascript:;' 
			icon='trash' 
			id='deleteSelectedTalks' 
			label="delete"
		/>
	</liferay-frontend:management-bar-action-buttons>
</liferay-frontend:management-bar>

<aui:form action="<%= deleteTalkURL %>" cssClass="container-fluid-1280" name="fm">
	<liferay-ui:search-container 
		id="talks" 
		rowChecker="<%=rowChecker %>" 
		emptyResultsMessage="no-talks-found"
		total="<%= TalkLocalServiceUtil.countGroupTalks(company.getCompanyId(), scopeGroupId) %>"
		iteratorURL="<%= currentURLObj %>"
		>

    	<%-- 
    		Now wee need to give the search container a list of items to display.
    		For this we'll call `TalkLocalServiceUtil.getGroupTalks(companyId, groupId)` which is automatically
    		generated static utility from the code we wrote in 'TalkLocalServiceImpl` 
    		
    		No idea how come that `scopeGroupId` variable is already provided by <liferay-theme:defineObjects />
    		but companyId is not. Luckily we can get it from the `company` object.
    	--%>
	    <liferay-ui:search-container-results
	        results="<%= TalkLocalServiceUtil.getGroupTalks(
	        		company.getCompanyId(), 
	        		scopeGroupId, 
	        		searchContainer.getStart(),
	        		searchContainer.getEnd()
	        	) %>"
	        />
	
	    <liferay-ui:search-container-row
	        className="bg.jug.workshop.liferay.cfp.model.Talk" 
	        keyProperty="talkId"
	        modelVar="talk">
	
			<portlet:renderURL var="editTalkURL" >
				<portlet:param name="mvcPath" value="/talk_edit.jsp" />
				<portlet:param name="talkId" value="<%= String.valueOf(talk.getTalkId()) %>" />
				<portlet:param name="navigation" value="talks" />
			</portlet:renderURL>
			<% request.setAttribute("editTalkURL", editTalkURL); %>
	
			<c:choose>
				<c:when test='<%= "descriptive".equals(displayStyle)  %>'>
					<liferay-ui:search-container-column-icon
						icon="bullhorn"
						toggleRowChecker="<%= true %>"
					/>

					<liferay-ui:search-container-column-text
						colspan="<%= 2 %>"
					>
						<h5>
							<aui:a href="<%=editTalkURL %>"><%= talk.getTitle() %></aui:a>
						</h5>

					</liferay-ui:search-container-column-text>

					<liferay-ui:search-container-column-jsp
						path="/talk_actions.jsp"
					/>
				</c:when>
				<c:when test='<%= "icon".equals(displayStyle)  %>'>

					<%
					row.setCssClass("entry-card lfr-asset-item");
					%>

					<liferay-ui:search-container-column-text>
						<liferay-frontend:icon-vertical-card
							actionJsp="/talk_actions.jsp"
							actionJspServletContext="<%= application %>"
							icon="bullhorn"
							resultRow="<%= row %>"
							rowChecker="<%= searchContainer.getRowChecker() %>"
							title="<%= talk.getTitle() %>"
						>
						</liferay-frontend:icon-vertical-card>
					</liferay-ui:search-container-column-text>
				</c:when>
				<c:when test='<%= "list".equals(displayStyle)  %>'>
			        <liferay-ui:search-container-column-text 
			        	property="title" 
			        	cssClass="table-cell-content"
			        	href="<%=editTalkURL %>"
			        	/>
			
					<liferay-ui:search-container-column-jsp
						path="/talk_actions.jsp"
					/>
				</c:when>
			</c:choose>
	
	    </liferay-ui:search-container-row>
	
		<liferay-ui:search-iterator 
			displayStyle="<%= displayStyle %>" 
			markupView="lexicon" />
	    
	</liferay-ui:search-container>

	<liferay-frontend:add-menu>
<%
	List<DDMStructure> structures = DDMStructureLocalServiceUtil.getStructures(
			scopeGroupId,
			ClassNameLocalServiceUtil.getClassNameId(Talk.class.getName()));
	String languageId = LanguageUtil.getLanguageId(renderRequest);
	for (DDMStructure structure : structures) {
		String talkType = structure.getName(languageId);
%>

		<portlet:renderURL var="editTalkURL">
			<portlet:param name="mvcPath" value="/talk_edit.jsp" />
			<portlet:param name="navigation" value="talks" />
			<portlet:param name="structureId" value="<%= String.valueOf(structure.getStructureId()) %>" />
		</portlet:renderURL>

		<liferay-frontend:add-menu-item title='<%= LanguageUtil.get(request, "add") + " " + talkType %>' url="<%= editTalkURL %>" />
<%
	}
%>
	</liferay-frontend:add-menu>
</aui:form>

<aui:script sandbox="<%= true %>">
	var form = $(document.<portlet:namespace />fm);

	$('#<portlet:namespace />deleteSelectedTalks').on(
		'click',
		function() {
			if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-delete-this" />')) {
				submitForm(form);
			}
		}
	);
</aui:script>