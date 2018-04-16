<%@ include file="/META-INF/resources/init.jspf" %>

<%-- 
	First we'll use <liferay-frontend:management-bar ...> tag library 
	to provide a common management bar for operation on collections 
	such as "select all" and "delete selected"
	
	The `searchContainerId` property indicates on which collection those actions operate.
--%>
<liferay-frontend:management-bar
	includeCheckBox="<%= true %>"
	searchContainerId="events"
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
			id='deleteSelectedEvents' 
			label="delete"
		/>
	</liferay-frontend:management-bar-action-buttons>
</liferay-frontend:management-bar>

<%-- 
	Then we create an HTML form that we'll use to submit request to the server 
	intercepting it with some JavaScript for batch operations
--%>
<aui:form action="<%= deleteEventURL %>" cssClass="container-fluid-1280" name="fm">

	<%-- 
		We'll use <liferay-ui:search-container ...> tag library to iterate over a collection of items 
		and display them. Search container can automatically paginate and display friendly message
		if the collection is empty 
	--%>
	<liferay-ui:search-container 
		id="events" 
		rowChecker="<%=rowChecker %>" 
		emptyResultsMessage="no-events-found"
		>

    	<%-- 
    		Now we need to give the search container a list of items to display.
    		For this we'll call `TalkLocalServiceUtil.getGroupTalks(...)` which is automatically
    		generated static utility from the code we wrote in 'TalkLocalServiceImpl` 
    		
    		NOTE: I have no idea how come that `scopeGroupId` variable is already provided by <liferay-theme:defineObjects />
    		but companyId is not. Luckily we can get it from the `company` object.
    	--%>
	    <liferay-ui:search-container-results
	        results="<%= EventLocalServiceUtil.getGroupEvents(
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
	        className="bg.jug.workshop.liferay.cfp.model.Event" 
	        keyProperty="eventId"
	        modelVar="event">
	
	    	<%-- 
	    		For each entity we generate a portlet URL that will open the edit page
	    		and we save the URL as request attribute to be able to use it later on 
	    		in included pages
	    	--%>
			<portlet:renderURL var="editEventURL" >
				<portlet:param name="mvcPath" value="/event_edit.jsp" />
				<portlet:param name="eventId" value="<%= String.valueOf(event.getEventId()) %>" />
				<portlet:param name="navigation" value="events" />
			</portlet:renderURL>
			<% request.setAttribute("editEventURL", editEventURL); %>
	
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
						icon="calendar"
						toggleRowChecker="<%= true %>"
					/>
					<%--
						Second column will have the event's name
					 --%>
					<liferay-ui:search-container-column-text colspan="<%= 2 %>">
						<h5>
							<aui:a href="<%=editEventURL %>"><%= event.getName() %></aui:a>
						</h5>

						<h6 class="text-default">
							<span><%= event.getDate() %></span>
						</h6>
					</liferay-ui:search-container-column-text>
					<%--
						Third column will have the action buttons which we'll define in separate page 
					 --%>
					<liferay-ui:search-container-column-jsp
						path="/event_actions.jsp"
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
							actionJsp="/event_actions.jsp"
							actionJspServletContext="<%= application %>"
							icon="calendar"
							resultRow="<%= row %>"
							rowChecker="<%= searchContainer.getRowChecker() %>"
							title="<%= event.getName() %>"
						>
							<liferay-frontend:vertical-card-footer>
								<span><%= event.getDate() %></span>
							</liferay-frontend:vertical-card-footer>
						</liferay-frontend:icon-vertical-card>
					</liferay-ui:search-container-column-text>
				</c:when>
				
				<%--
					For "list" style we'll have a traditional table.
				 --%>
				<c:when test='<%= "list".equals(displayStyle)  %>'>
					<%--
						First column will have event's name
					 --%>
			        <liferay-ui:search-container-column-text 
			        	property="name" 
			        	cssClass="table-cell-content"
			        	href="<%=editEventURL %>"
			        	/>
					<%--
						Second column will have event's date 
					 --%>
			        <liferay-ui:search-container-column-text 
			        	property="date" 
			        	cssClass="table-cell-content"
			        	href="<%=editEventURL %>"
			        	/>
					<%--
						Third column will have the action buttons which we'll define in separate page 
					 --%>
					<liferay-ui:search-container-column-jsp
						path="/event_actions.jsp"
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
		On the bottom of the page, we'll add a button to add new events.
	 --%>
	<liferay-frontend:add-menu>
		<%--
			we generate the portlet URL with the proper parameters and 
		 --%>
		<portlet:renderURL var="editEventURL" >
			<portlet:param name="mvcPath" value="/event_edit.jsp" />
			<portlet:param name="navigation" value="events" />
		</portlet:renderURL>
		<%--
			and add e menu item to the button with that URL
		 --%>
		<liferay-frontend:add-menu-item title='<%= LanguageUtil.get(request, "add-event") %>' url="<%= editEventURL %>" />
	</liferay-frontend:add-menu>
</aui:form>

<%--
	Finally a little JavaScript to act upon batch item deletion
 --%>
<aui:script sandbox="<%= true %>">
	var form = $(document.<portlet:namespace />fm);

	$('#<portlet:namespace />deleteSelectedEvents').on(
		'click',
		function() {
			if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-delete-this" />')) {
				submitForm(form);
			}
		}
	);
</aui:script>