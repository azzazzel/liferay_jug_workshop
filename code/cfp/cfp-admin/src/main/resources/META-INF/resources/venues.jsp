<%@ include file="/META-INF/resources/init.jspf" %>

<liferay-frontend:management-bar
	includeCheckBox="<%= true %>"
	searchContainerId="venues"
>
	<liferay-frontend:management-bar-buttons>
	
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
			id='deleteSelectedVenues' 
			label="delete"
		/>
	</liferay-frontend:management-bar-action-buttons>
</liferay-frontend:management-bar>


<aui:form action="<%= deleteVenueURL %>" cssClass="container-fluid-1280" name="fm">
	<liferay-ui:search-container 
		id="venues" 
		rowChecker="<%=rowChecker %>" 
		emptyResultsMessage="no-venues-found"
		>

	    <liferay-ui:search-container-results
	        results="<%= VenueLocalServiceUtil.getGroupVenues(themeDisplay,
	            searchContainer.getStart(), searchContainer.getEnd()) %>"
	         
	        />
	
	    <liferay-ui:search-container-row
	        className="bg.jug.workshop.liferay.cfp.model.Venue" 
	        keyProperty="venueId"
	        modelVar="venue">
	
	
			<c:choose>
				<c:when test='<%= "descriptive".equals(displayStyle)  %>'>
					<liferay-ui:search-container-column-icon
						icon="home"
						toggleRowChecker="<%= true %>"
					/>

					<liferay-ui:search-container-column-text
						colspan="<%= 2 %>"
					>
						<h5>
							<%= venue.getName() %>
						</h5>

						<h6 class="text-default">
							<span><%= venue.getAddress() %></span>
						</h6>
					</liferay-ui:search-container-column-text>

					<liferay-ui:search-container-column-jsp
						path="/venue_actions.jsp"
					/>
				</c:when>
				<c:when test='<%= "icon".equals(displayStyle)  %>'>

					<%
					row.setCssClass("entry-card lfr-asset-item");
					%>

					<liferay-ui:search-container-column-text>
						<liferay-frontend:icon-vertical-card
							actionJsp="/venue_actions.jsp"
							actionJspServletContext="<%= application %>"
							icon="home"
							resultRow="<%= row %>"
							rowChecker="<%= searchContainer.getRowChecker() %>"
							title="<%= venue.getName() %>"
						>
							<liferay-frontend:vertical-card-footer>
								<span><%= venue.getAddress() %></span>
							</liferay-frontend:vertical-card-footer>
						</liferay-frontend:icon-vertical-card>
					</liferay-ui:search-container-column-text>
				</c:when>
				<c:when test='<%= "list".equals(displayStyle)  %>'>
			        <liferay-ui:search-container-column-text 
			        	property="name" 
			        	cssClass="table-cell-content"
			        	/>
			        <liferay-ui:search-container-column-text 
			        	property="address" 
			        	cssClass="table-cell-content"
			        	/>
			
					<liferay-ui:search-container-column-jsp
						path="/venue_actions.jsp"
					/>
				</c:when>
			</c:choose>
	
	    </liferay-ui:search-container-row>
	
		<liferay-ui:search-iterator displayStyle="<%= displayStyle %>" markupView="lexicon" />
	    
	</liferay-ui:search-container>

	<liferay-frontend:add-menu>
		<liferay-frontend:add-menu-item title='<%= LanguageUtil.get(request, "add-venue") %>' url="<%= editVenueURL %>" />
	</liferay-frontend:add-menu>
</aui:form>

<aui:script sandbox="<%= true %>">
	var form = $(document.<portlet:namespace />fm);

	$('#<portlet:namespace />deleteSelectedVenues').on(
		'click',
		function() {
			if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-delete-this" />')) {
				submitForm(form);
			}
		}
	);
</aui:script>