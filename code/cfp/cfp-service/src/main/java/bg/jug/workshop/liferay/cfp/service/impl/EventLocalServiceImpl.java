/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package bg.jug.workshop.liferay.cfp.service.impl;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

import com.liferay.calendar.model.Calendar;
import com.liferay.calendar.model.CalendarBooking;
import com.liferay.calendar.service.CalendarBookingLocalService;
import com.liferay.calendar.service.CalendarLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import bg.jug.workshop.liferay.cfp.model.Event;
import bg.jug.workshop.liferay.cfp.model.Talk;
import bg.jug.workshop.liferay.cfp.model.Venue;
import bg.jug.workshop.liferay.cfp.service.base.EventLocalServiceBaseImpl;

/**
 * The implementation of the event local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link bg.jug.workshop.liferay.cfp.service.EventLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EventLocalServiceBaseImpl
 * @see bg.jug.workshop.liferay.cfp.service.EventLocalServiceUtil
 */
public class EventLocalServiceImpl extends EventLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link bg.jug.workshop.liferay.cfp.service.EventLocalServiceUtil} to access the event local service.
	 */

	@ServiceReference (type = CalendarLocalService.class)
	CalendarLocalService calendarLocalService;
	
	@ServiceReference (type = CalendarBookingLocalService.class)
	CalendarBookingLocalService calendarBookingLocalService;

	public List<Event> getGroupEvents(ThemeDisplay themeDisplay, int start, int end) {
		return eventPersistence.findByCompanyAndGroup(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), start, end);
	}

	public Event saveEvent(
			Optional<Long> eventId, 
			String name, 
			Date eventDate, 
			Optional<Long> venueId, 
			String website, 
			ServiceContext serviceContext) throws PortalException {

		Event event;
		if (eventId.isPresent()) {
			event = getEvent(eventId.get());
		} else {
			event = createEvent(counterLocalService.increment(Event.class.getName()));	
		}
		
		Venue venue = null; 
		
		long userId = serviceContext.getUserId();
		long companyId = serviceContext.getCompanyId();
		long groupId = serviceContext.getScopeGroupId();

		
		event.setCompanyId(serviceContext.getCompanyId());
		event.setGroupId(serviceContext.getScopeGroupId());
		event.setUserId(userId);
		event.setUserName(PortalUtil.getUserName(userId, "unknown"));
		Date date = new Date();
		if (event.isNew()) {
			event.setCreateDate(date);
		}
		event.setModifiedDate(date);
		event.setName(name);
		event.setDate(eventDate);
		event.setWebsite(website);
		if (venueId.isPresent()) {
			event.setVenueId(venueId.get());
			venue = venueLocalService.fetchVenue(venueId.get());
		}

		if (event.isNew()) {
			
			addCalendarBooking(event, venue, serviceContext);
			
			resourceLocalService.addResources(
				companyId,					// the id of the instance (useful in mutli-tenant environment)
				groupId,					// the id of the site
				userId,						// the id of the currently logged in user
			    Event.class.getName(), 		// the type of the model to add resource for
			    event.getEventId(), 		// the id of the model entity to add resource for
			    false, 						// is this a portlet resource (if it is not then it is a model resource)
			    true, 						// should the default permissions for the site be used 
			    true						// should the default permissions for the guest user be used
			    );

		} else {
			
			CalendarBooking calendarBooking = calendarBookingLocalService.fetchCalendarBooking(event.getCalendarBookingId());
			if (calendarBooking == null) {
				addCalendarBooking(event, venue, serviceContext);
			} else {
				calendarBooking.setStartTime(event.getDate().getTime());
				calendarBooking.setEndTime(event.getDate().getTime());
				calendarBookingLocalService.updateCalendarBooking(calendarBooking);
			}
			
			resourceLocalService.updateResources(
				companyId,								// the id of the instance (useful in mutli-tenant environment)
				groupId,								// the id of the site
				Event.class.getName(), 					// the type of the model to add resource for
				event.getEventId(), 					// the id of the model entity to add resource for
			    serviceContext.getGroupPermissions(), 	// the new group permissions 
			    serviceContext.getGuestPermissions()	// the new guest permissions
			    );
		}

		return updateEvent(event);
	}	
	
	
	public void updateTalks(long eventId, List<Long> talks) throws PortalException {
		List<Talk> eventTalks = talkLocalService.getEventTalks(eventId);
		if (eventTalks != null) {
			List<Talk> talks2delete = new LinkedList<>();
			for (Talk talk : eventTalks) {
				if (!talks.contains(talk.getTalkId())) {
					talks2delete.add(talk);
				}
			}
			talkLocalService.deleteEventTalks(eventId, talks2delete);
		}
		talkLocalService.addEventTalks(eventId, talks.stream().mapToLong(l -> l).toArray());
	}
	
	public Event deleteEvent(long eventId, ServiceContext serviceContext) throws PortalException {
		resourceLocalService.deleteResource(
				serviceContext.getCompanyId(),			// the id of the instance (useful in mutli-tenant environment)
				Event.class.getName(), 					// the type of the model to add resource for
                ResourceConstants.SCOPE_INDIVIDUAL,
                eventId);
		return super.deleteEvent(eventId);
	}
	
	private void addCalendarBooking(Event event, Venue venue, ServiceContext serviceContext)
			throws PortalException {
		
		List<Calendar> calendars = calendarLocalService.getCalendars(-1, -1);
		Calendar calendar = calendars.stream()
			.filter(c -> c.getCompanyId() == serviceContext.getCompanyId())
			.filter(c -> c.getGroupId() == serviceContext.getScopeGroupId())
			.filter(c -> c.isDefaultCalendar())
			.findFirst()
			.orElse(null);

		
		java.util.Calendar startTime = java.util.Calendar.getInstance();
		startTime.setTime(event.getDate());
		
		Map<Locale, String> titleMap = new HashMap<>();
		titleMap.put(serviceContext.getLocale(), event.getName());
		
		CalendarBooking calendarBooking = calendarBookingLocalService.addCalendarBooking(
			serviceContext.getUserId(),						// userId, 
			calendar.getCalendarId(),						// calendarId, 
			new long[] {},									// childCalendarIds, 
			0l,												// parentCalendarBookingId, 
			titleMap,										// titleMap, 
			Collections.emptyMap(), 						// descriptionMap, 
			venue == null ? null : venue.getAddress(),		// location, 
			event.getDate().getTime(), 						// startTime, 
			event.getDate().getTime(), 						// endTime, 
			true,											// allDay, 
			null,											// recurrence, 
			0l,												// firstReminder, 
			null,											// firstReminderType, 
			0l,												// secondReminder, 
			null,											// secondReminderType, 
			serviceContext									// serviceContext
		);
		
		event.setCalendarBookingId(calendarBooking.getCalendarBookingId());
	}
	
}