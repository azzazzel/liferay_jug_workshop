<%@ include file="/META-INF/resources/init.jspf" %>

<%
	long eventId = ParamUtil.getLong(request, "eventId");	
	String backURL = ParamUtil.getString(request, "backURL");
	RowChecker sessionsRowChecker = new EventSessionsRowChecker(renderResponse, eventId);

%>

<liferay-frontend:management-bar
	includeCheckBox="<%= true %>"
	searchContainerId="talks"
>

</liferay-frontend:management-bar>

<portlet:actionURL name="updateEventSessions" var="updateEventSessionsURL">
	<portlet:param name="navigation" value="events" />
</portlet:actionURL>

<aui:form action="<%= updateEventSessionsURL %>" cssClass="container-fluid-1280" name="fm">
	<liferay-ui:search-container 
		id="talks" 
		rowChecker="<%=sessionsRowChecker %>" 
		emptyResultsMessage="no-talks-found"
		total="<%= TalkLocalServiceUtil.countGroupTalks(company.getCompanyId(), scopeGroupId) %>"
		iteratorURL="<%= currentURLObj %>"
		>

    	<%-- 
    		Now we need to give the search container a list of items to display.
    		For this we'll call `TalkLocalServiceUtil.getGroupTalks(companyId, groupId)` which is automatically
    		generated static utility from the code we wrote in 'TalkLocalServiceImpl` 
    		
    		It is somewhat counterintuitive that `scopeGroupId` variable is already provided by 
    		<liferay-theme:defineObjects /> tag but `companyId` is not. 
    		Luckily we can get it from the `company` object.
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
	        modelVar="talk"
	    >
					
	        <liferay-ui:search-container-column-text 
	        	property="title" 
	        	cssClass="table-cell-content"
	        	/>
	
	    </liferay-ui:search-container-row>
	
		<liferay-ui:search-iterator displayStyle="<%= displayStyle %>" markupView="lexicon" />
		
	</liferay-ui:search-container>
	
	<aui:input type="hidden" name="eventId" value="<%=eventId %>" />

     <aui:button-row>
          <aui:button type="submit" name="save"/>
          <aui:button onClick="<%= backURL %>" type="cancel"  />
     </aui:button-row>


</aui:form>

<aui:script sandbox="<%= true %>">
	var form = $(document.<portlet:namespace />fm);

	$('#<portlet:namespace />updateEventSessionsURL').on(
		'click',
		function() {
			if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-delete-this" />')) {
				submitForm(form);
			}
		}
	);
</aui:script>