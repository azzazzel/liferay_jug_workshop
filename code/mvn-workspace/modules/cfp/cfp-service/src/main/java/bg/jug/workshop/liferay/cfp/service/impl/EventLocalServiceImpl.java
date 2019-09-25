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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.liferay.calendar.model.Calendar;
import com.liferay.calendar.model.CalendarBooking;
import com.liferay.calendar.service.CalendarBookingLocalService;
import com.liferay.calendar.service.CalendarLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Resource;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import bg.jug.workshop.liferay.cfp.exception.NoSuchEventException;
import bg.jug.workshop.liferay.cfp.exception.NoSuchVenueException;
import bg.jug.workshop.liferay.cfp.model.Event;
import bg.jug.workshop.liferay.cfp.model.Talk;
import bg.jug.workshop.liferay.cfp.model.Venue;
import bg.jug.workshop.liferay.cfp.service.EventLocalService;
import bg.jug.workshop.liferay.cfp.service.TalkLocalService;
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

	private static Logger logger = LoggerFactory.getLogger(EventLocalServiceImpl.class);

	@ServiceReference (type = CalendarLocalService.class)
	CalendarLocalService calendarLocalService;
	
	@ServiceReference (type = CalendarBookingLocalService.class)
	CalendarBookingLocalService calendarBookingLocalService;

	/**
	 * Returns a list of all events for given platform instance (company) and site (group)
	 * 
	 * @param companyId the id of the portal instance (guarantees data sharding in multi-tenant environments)
	 * @param groupId the id of the site (guarantees data sharding in multi-hosting environments)
	 */
	public List<Event> getGroupEvents(long companyId, long groupId) {
		return eventPersistence.findByCompanyAndGroup(companyId, groupId);
	}

	/**
	 * Returns a subset (page) of events for given platform instance (company) and site (group)
	 * 
	 * @param companyId the id of the portal instance (guarantees data sharding in multi-tenant environments)
	 * @param groupId the id of the site (guarantees data sharding in multi-hosting environments)
	 * @param start the record to start from
	 * @param end the record to end at
	 */
	public List<Event> getGroupEvents(long companyId, long groupId, int start, int end) {
		return eventPersistence.findByCompanyAndGroup(companyId, groupId, start, end);
	}

	public int countGroupEvents(long companyId, long groupId) {
		return eventPersistence.countByCompanyAndGroup(companyId, groupId);
	}

	/** 
	 * This method creates a new event or updates an existing one. 
	 * <p>
	 * If there is {@code eventId} provided it updates the event with that id. Otherwise it creates a new event.
	 * <p>
	 * This method also creates/updates :
	 * <ul>
	 * 	<li> respective {@link Resource} entity. This is needed to link the event with the resource framework 
	 * which among other things is used to manage resources' permissions 
	 * </ul>
	 * <strong>NOTE: Important information for wrapping this method: </strong>
	 * <ul>
	 * 	<li> it uses  {@code counterLocalService.increment(Event.class.getName())} as opposite to {@code counterLocalService.increment()}.
	 * Take that into account to avoid id collisions if you modify the event creation process. 
	 * </ul>
	 *  
	 * 	@param eventId the id of the event to save. If provided the it MUST be positive value.
	 *  @param name the event's name
	 *  @param eventDate the event'd date
	 *  @param venueId the venue's id
	 *  @param website the event's website
	 * 	@param serviceContext the context of the service request (generated by the caller from servlet or portlet requests)
	 * 
	 * 	@throws IllegalArgumentException if {@code eventId} is provided but it is not a positive value
	 * 	@throws NoSuchVenueException if {@code eventId} is provided but a event with such id can not be found
	 * 	@throws PortalException if any error occur 
	 */
	public Event saveEvent(
			Optional<Long> eventId, 
			String name, 
			Date eventDate, 
			Optional<Long> venueId, 
			String website, 
			ServiceContext serviceContext) throws PortalException {

		/*
		 * For detailed description of what exactly we do in this method and why,
		 * please see TalkLocalServiceImpl class. It has almost identical method
		 * `saveTalk` which is well documented.
		 */

		Event event;
		if (eventId.isPresent()) {
			long id = eventId.get();
			if (id <= 0) throw new IllegalArgumentException();
			event = getEvent(id);
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
			/*
			 * create a calendar booking for this event
			 */
			addCalendarBooking(event, venue, serviceContext);
			
			/*
			 * create a resource for this event
			 */
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
			
			/*
			 * If the event had calendar booking, then update it. 
			 * Otherwise create a calendar booking for this event
			 */
			CalendarBooking calendarBooking = calendarBookingLocalService.fetchCalendarBooking(event.getCalendarBookingId());
			if (calendarBooking == null) {
				addCalendarBooking(event, venue, serviceContext);
			} else {
				calendarBooking.setStartTime(event.getDate().getTime());
				calendarBooking.setEndTime(event.getDate().getTime());
				calendarBookingLocalService.updateCalendarBooking(calendarBooking);
			}
			
			/*
			 * update the resource for this event (in case permissions have changed)
			 */
			resourceLocalService.updateResources(
				companyId,								// the id of the instance (useful in mutli-tenant environment)
				groupId,								// the id of the site
				Event.class.getName(), 					// the type of the model to add resource for
				event.getEventId(), 					// the id of the model entity to add resource for
			    serviceContext.getGroupPermissions(), 	// the new group permissions 
			    serviceContext.getGuestPermissions()	// the new guest permissions
			    );
		}

		return super.updateEvent(event);
	}	
	

	/**
	 * Adds list of talks to this event
	 * 
	 * @param eventId the event to add talks to
	 * @param the talks to be added
	 */
	public void updateTalks(long eventId, List<Long> talks) throws PortalException {
		List<Talk> eventTalks = talkLocalService.getEventTalks(eventId);
		if (eventTalks != null) {
			/*
			 * If the event already has talks, we need to remove those 
			 * who are no longer in the list 
			 */
			List<Talk> talks2delete = new LinkedList<>();
			for (Talk talk : eventTalks) {
				if (!talks.contains(talk.getTalkId())) {
					talks2delete.add(talk);
				}
			}
			talkLocalService.deleteEventTalks(eventId, talks2delete);
		}
		/*
		 * Then we can update the list of talks 
		 */
		talkLocalService.addEventTalks(eventId, talks.stream().mapToLong(l -> l).toArray());
	}
	
	/** 
	 * Deletes given event and it's respective resource entity (if present). 
	 *  
	 * 	@param eventId the id of the event to delete
	 * 	@param serviceContext the context of the service request (generated by the caller from servlet or portlet requests)
	 * 
	 * 	@throws PortalException if any error occur 
	 */
	public Event deleteEvent(long eventId, ServiceContext serviceContext) throws PortalException {

		Event event = fetchEvent(eventId);
		
		/*
		 * Throw exception if we can't find the event. We can't remove what does not exists.
		 */
		if (event == null) {
			throw new NoSuchEventException();
		}

		/*
		 * delete the calendar booking
		 */
		calendarBookingLocalService.deleteCalendarBooking(event.getCalendarBookingId());

		/*
		 * delete the resource
		 */
		resourceLocalService.deleteResource(
				serviceContext.getCompanyId(),			// the id of the instance (useful in mutli-tenant environment)
				Event.class.getName(), 					// the type of the model to add resource for
                ResourceConstants.SCOPE_INDIVIDUAL,
                eventId);
		
		/*
		 * delete the event itself
		 */
		return super.deleteEvent(eventId);
	}
	
	
	/**
	 * Adds calendar booking to site's calendar 
	 * 
	 * @param event the event to add booking for
	 * @param venue the venue of that event
	 * @param serviceContext the context of the service request (generated by the caller from servlet or portlet requests)
	 * @throws PortalException if any error occur 
	 */
	private void addCalendarBooking(Event event, Venue venue, ServiceContext serviceContext)
			throws PortalException {
		
		/*
		 * NOTE: Unfortunately `calendarLocalService` does not provide a method 
		 * to easily get a calendar(s) but companyId and groupId :(
		 * To get the group's default calendar we'll therefore get all calendars
		 * and filter them in memory to find the one we need.
		 */
		List<Calendar> calendars = calendarLocalService.getCalendars(-1, -1);
		Calendar calendar = calendars.stream()
			.filter(c -> c.getCompanyId() == serviceContext.getCompanyId())
			.filter(c -> c.getGroupId() == serviceContext.getScopeGroupId())
			.filter(c -> c.isDefaultCalendar())
			.findFirst()
			.orElse(null);

		/*
		 * Calendar bookings titles are localized so we need to prepare
		 * a map containing titles in different languages (1 in pur case). 		
		 */
		Map<Locale, String> titleMap = new HashMap<>();
		titleMap.put(serviceContext.getLocale(), event.getName());
		
		/*
		 * With that in place we can now add a calendar booking
		 */
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
		
		/*
		 * Finally we store the calendar booking id in our event so we delete it
		 * when the event is deleted
		 */
		event.setCalendarBookingId(calendarBooking.getCalendarBookingId());
	}
	
	
	/* 
	 * ==================================================
	 * NOTE: While service builder generates many convenient methods, once we've changed 
	 * the basic CRUD logic, those must not be used. To not confuse callers and wrappers 
	 * we should deprecate and override those automatically generated methods that appear
	 * to be useful but collide with the changed CRUD logic.
	 * ==================================================  
	 */

	/**
	 * This automatically generated method must not be used and was overridden to throw {@link UnsupportedOperationException}.  
	 * Please use {@link EventLocalService#saveEvent(Optional, String, Date, Optional, String, ServiceContext)} instead.
	 * 
	 *  @throws UnsupportedOperationException
	 */
	@Override
	@Deprecated
	public Event addEvent(Event event) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * This automatically generated method must not be used and was overridden to throw {@link UnsupportedOperationException}.  
	 * Please use {@link EventLocalService#saveEvent(Optional, String, Date, Optional, String, ServiceContext)} instead.
	 * 
	 *  @throws UnsupportedOperationException
	 */
	@Override
	@Deprecated
	public Event updateEvent(Event event) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * This automatically generated method must not be used and was overridden to throw {@link UnsupportedOperationException}.  
	 * Please use {@link EventLocalService#deleteEvent(long, ServiceContext)} instead.
	 * 
	 *  @throws UnsupportedOperationException
	 */
	@Override
	@Deprecated
	public Event deleteEvent(Event event) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * This automatically generated method must not be used and was overridden to throw {@link UnsupportedOperationException}.  
	 * Please use {@link TalkLocalService#deleteTalk(long, ServiceContext)} instead.
	 * 
	 *  @throws UnsupportedOperationException
	 */
	@Override
	@Deprecated
	public Event deleteEvent(long eventId) throws PortalException {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public List<Event> getEvents(int start, int end) {
		logger.warn("This method does not take multi-tenancy and multi-hosting into account. Most likely this is not what you want!");
		return super.getEvents(start, end);
	}
	
	@Override
	public int getEventsCount() {
		logger.warn("This method does not take multi-tenancy and multi-hosting into account. Most likely this is not what you want!");
		return super.getEventsCount();
	}
	
}
