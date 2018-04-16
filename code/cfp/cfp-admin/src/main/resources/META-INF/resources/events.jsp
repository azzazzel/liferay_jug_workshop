<%@ include file="/META-INF/resources/init.jspf" %>


<liferay-frontend:management-bar
	includeCheckBox="<%= true %>"
	searchContainerId="events"
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
			id='deleteSelectedEvents' 
			label="delete"
		/>
	</liferay-frontend:management-bar-action-buttons>
</liferay-frontend:management-bar>

<aui:form action="<%= deleteEventURL %>" cssClass="container-fluid-1280" name="fm">
	<liferay-ui:search-container 
		id="events" 
		rowChecker="<%=rowChecker %>" 
		emptyResultsMessage="no-events-found"
		>

	    <liferay-ui:search-container-results
	        results="<%= EventLocalServiceUtil.getGroupEvents(themeDisplay,
	            searchContainer.getStart(), searchContainer.getEnd()) %>"
	         
	        />
	
	    <liferay-ui:search-container-row
	        className="bg.jug.workshop.liferay.cfp.model.Event" 
	        keyProperty="eventId"
	        modelVar="event">
	
			<portlet:renderURL var="editEventURL" >
				<portlet:param name="mvcPath" value="/event_edit.jsp" />
				<portlet:param name="eventId" value="<%= String.valueOf(event.getEventId()) %>" />
				<portlet:param name="navigation" value="events" />
			</portlet:renderURL>
			<% request.setAttribute("editEventURL", editEventURL); %>
	
			<c:choose>
				<c:when test='<%= "descriptive".equals(displayStyle)  %>'>
					<liferay-ui:search-container-column-icon
						icon="calendar"
						toggleRowChecker="<%= true %>"
					/>

					<liferay-ui:search-container-column-text
						colspan="<%= 2 %>"
					>
						<h5>
							<%= event.getName() %>
						</h5>

						<h6 class="text-default">
							<span><%= event.getDate() %></span>
						</h6>
					</liferay-ui:search-container-column-text>

					<liferay-ui:search-container-column-jsp
						path="/event_actions.jsp"
					/>
				</c:when>
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
				<c:when test='<%= "list".equals(displayStyle)  %>'>
			        <liferay-ui:search-container-column-text 
			        	property="name" 
			        	cssClass="table-cell-content"
			        	href="<%=editEventURL %>"
			        	/>
			        <liferay-ui:search-container-column-text 
			        	property="date" 
			        	cssClass="table-cell-content"
			        	href="<%=editEventURL %>"
			        	/>
			
					<liferay-ui:search-container-column-jsp
						path="/event_actions.jsp"
					/>
				</c:when>
			</c:choose>
	
	    </liferay-ui:search-container-row>
	
		<liferay-ui:search-iterator displayStyle="<%= displayStyle %>" markupView="lexicon" />
	    
	</liferay-ui:search-container>

	<liferay-frontend:add-menu>
		<portlet:renderURL var="editEventURL" >
			<portlet:param name="mvcPath" value="/event_edit.jsp" />
			<portlet:param name="navigation" value="events" />
		</portlet:renderURL>
		<liferay-frontend:add-menu-item title='<%= LanguageUtil.get(request, "add-event") %>' url="<%= editEventURL %>" />
	</liferay-frontend:add-menu>
</aui:form>

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