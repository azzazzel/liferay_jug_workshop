<%@ include file="/META-INF/resources/init.jspf" %>

<%
	long eventId = ParamUtil.getLong(request, "eventId");
	Event event = null;
	if (eventId > 0) {
		event = EventLocalServiceUtil.getEvent(eventId);
	}
%>

<div class="container-fluid-1280 main-content-body">

	<aui:form action="<%= saveEventURL %>" name="fm">
	
	        <aui:model-context bean="<%= event %>" model="<%= Event.class %>" />
	
	        <aui:input type="hidden" name="eventId"
	            value='<%= event == null ? "" : event.getEventId() %>' />
	
	        <aui:fieldset>
	             <aui:input name="name" />
	             <aui:input name="date" />
	             <aui:select name="venueId" label="venue" >
             		<aui:option label="no-venue" value="" />
	             	<c:forEach items="<%=VenueLocalServiceUtil.getGroupVenues(themeDisplay, -1, -1) %>" var="venue">
	             		<aui:option label="${venue.name}" value="${venue.venueId}" selected="${venue.venueId == venueId}"/>
	             	</c:forEach>
	             </aui:select>
	             <aui:input name="website" />
	        </aui:fieldset>

	        <aui:button-row>
	             <aui:button type="submit" />
	             <aui:button onClick="<%= eventsURL %>" type="cancel"  />
	        </aui:button-row>
	</aui:form>
	

</div>