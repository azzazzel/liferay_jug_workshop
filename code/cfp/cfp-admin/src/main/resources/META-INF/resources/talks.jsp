<%@ include file="/META-INF/resources/init.jspf" %>

<%-- 
	First we'll use <liferay-frontend:management-bar ...> tag library 
	to provide a common management bar for operation on collections 
	such as "select all" and "delete selected"
	
	The `searchContainerId` property indicates on which collection those actions operate.
--%>
<liferay-frontend:management-bar
	includeCheckBox="<%= true %>"
	searchContainerId="talks"
>

	<%-- 
		Here is a group of buttons that allows to change the display style
	--%>
	<liferay-frontend:management-bar-buttons>
		<liferay-frontend:management-bar-display-buttons
			displayViews='<%= new String[] {"icon", "descriptive", "list"} %>'
			portletURL="<%= changeDisplayStyleURL %>"
			selectedDisplayStyle="<%= displayStyle %>"
		/>
	</liferay-frontend:management-bar-buttons>

	<%-- 
		Then there is button that allows to delete selected items
	--%>
	<liferay-frontend:management-bar-action-buttons>
		<liferay-frontend:management-bar-button 
			href='javascript:;' 
			icon='trash' 
			id='deleteSelectedTalks' 
			label="delete"
		/>
	</liferay-frontend:management-bar-action-buttons>
</liferay-frontend:management-bar>


<%-- 
	Then we create an HTML form that we'll use to submit request to the server 
	intercepting it with some JavaScript for batch operations
--%>
<aui:form action="<%= deleteTalkURL %>" cssClass="container-fluid-1280" name="fm">

	<%-- 
		We'll use <liferay-ui:search-container ...> tag library to iterate over a collection of items 
		and display them. Search container can automatically paginate and display friendly message
		if the collection is empty 
	--%>
	<liferay-ui:search-container 
		id="talks" 
		rowChecker="<%=rowChecker %>" 
		emptyResultsMessage="no-talks-found"
		total="<%= TalkLocalServiceUtil.countGroupTalks(company.getCompanyId(), scopeGroupId) %>"
		iteratorURL="<%= currentURLObj %>"
		>

    	<%-- 
    		Now we need to give the search container a list of items to display.
    		For this we'll call `TalkLocalServiceUtil.getGroupTalks(...)` which is automatically
    		generated static utility from the code we wrote in 'TalkLocalServiceImpl` 
    		
    		NOTE: I have no idea how come that `scopeGroupId` variable is already provided by <liferay-theme:defineObjects />
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
	
    	<%-- 
    		The <liferay-ui:search-container-row ...> defines how a single element is displayed. 
    		In the past it used to only generate table rows, thus the name. 
    		Today it basically indicates a record which can be rendered in may different ways
    		as we'll see below.
    	--%>
	    <liferay-ui:search-container-row
	        className="bg.jug.workshop.liferay.cfp.model.Talk" 
	        keyProperty="talkId"
	        modelVar="talk">
	
	    	<%-- 
	    		For each entity we generate a portlet URL that will open the edit page
	    		and we save the URL as request attribute to be able to use it later on 
	    		in included pages
	    	--%>
			<portlet:renderURL var="editTalkURL" >
				<portlet:param name="mvcPath" value="/talk_edit.jsp" />
				<portlet:param name="talkId" value="<%= String.valueOf(talk.getTalkId()) %>" />
				<portlet:param name="navigation" value="talks" />
			</portlet:renderURL>
			<% request.setAttribute("editTalkURL", editTalkURL); %>
	
	    	<%-- 
	    		Now we can render a record in one of the 3 different display style
	    		we've defined above
	    	--%>
			<c:choose>
			
				<%--
					For "descriptive" style we'll have 3 columns
				 --%>
				<c:when test='<%= "descriptive".equals(displayStyle)  %>'>
					<%--
						First column will have an icon
					 --%>
					<liferay-ui:search-container-column-icon
						icon="bullhorn"
						toggleRowChecker="<%= true %>"
					/>
					<%--
						Second column will have the talk's title
					 --%>
					<liferay-ui:search-container-column-text colspan="<%= 2 %>">
						<h5>
							<aui:a href="<%=editTalkURL %>"><%= talk.getTitle() %></aui:a>
						</h5>
					</liferay-ui:search-container-column-text>
					<%--
						Third column will have the action buttons which we'll define in separate page 
					 --%>
					<liferay-ui:search-container-column-jsp
						path="/talk_actions.jsp"
					/>
				</c:when>
				
				<%--
					For "icon" style we'll have just one "column". It's actually not a column but a floating card.
					We'll use <liferay-frontend:icon-vertical-card ...> tag library and lexiconcss to style it.
				 --%>
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

				<%--
					For "list" style we'll have a traditional table.
				 --%>
				<c:when test='<%= "list".equals(displayStyle)  %>'>
					<%--
						First column will have talk's title
					 --%>
			        <liferay-ui:search-container-column-text 
			        	property="title" 
			        	cssClass="table-cell-content"
			        	href="<%=editTalkURL %>"
			        	/>
					<%--
						Second column will have the action buttons which we'll define in separate page 
					 --%>
					<liferay-ui:search-container-column-jsp
						path="/talk_actions.jsp"
					/>
				</c:when>
			</c:choose>
	    </liferay-ui:search-container-row>
	
		<%--
			Now that we've prepared the instructions for the search container, 
			we can ask it to render the result 
		 --%>
		<liferay-ui:search-iterator 
			displayStyle="<%= displayStyle %>" 
			markupView="lexicon" />
	    
	</liferay-ui:search-container>

	<%--
		On the bottom of the page, we'll add a button to add new talks.
	 --%>
	<liferay-frontend:add-menu>

		<%--
			For each talk type (structure) we find
		 --%>
		<%
			List<DDMStructure> structures = DDMStructureLocalServiceUtil.getStructures(
					scopeGroupId,
					ClassNameLocalServiceUtil.getClassNameId(Talk.class.getName()));
			String languageId = LanguageUtil.getLanguageId(renderRequest);
			for (DDMStructure structure : structures) {
				String talkType = structure.getName(languageId);
		%>
				<%--
					we generate the portlet URL with the proper parameters and 
				 --%>
				<portlet:renderURL var="editTalkURL">
					<portlet:param name="mvcPath" value="/talk_edit.jsp" />
					<portlet:param name="navigation" value="talks" />
					<portlet:param name="structureId" value="<%= String.valueOf(structure.getStructureId()) %>" />
				</portlet:renderURL>
				<%--
					and add e menu item to the button with that URL
				 --%>
				<liferay-frontend:add-menu-item title='<%= LanguageUtil.get(request, "add") + " " + talkType %>' url="<%= editTalkURL %>" />
		<%
			}
		%>
	</liferay-frontend:add-menu>
</aui:form>

<%--
	Finally a little JavaScript to act upon batch item deletion
 --%>
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