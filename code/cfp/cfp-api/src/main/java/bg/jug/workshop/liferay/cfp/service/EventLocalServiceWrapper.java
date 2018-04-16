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

package bg.jug.workshop.liferay.cfp.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EventLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EventLocalService
 * @generated
 */
@ProviderType
public class EventLocalServiceWrapper implements EventLocalService,
	ServiceWrapper<EventLocalService> {
	public EventLocalServiceWrapper(EventLocalService eventLocalService) {
		_eventLocalService = eventLocalService;
	}

	/**
	* Adds the event to the database. Also notifies the appropriate model listeners.
	*
	* @param event the event
	* @return the event that was added
	*/
	@Override
	public bg.jug.workshop.liferay.cfp.model.Event addEvent(
		bg.jug.workshop.liferay.cfp.model.Event event) {
		return _eventLocalService.addEvent(event);
	}

	@Override
	public void addTalkEvent(long talkId,
		bg.jug.workshop.liferay.cfp.model.Event event) {
		_eventLocalService.addTalkEvent(talkId, event);
	}

	@Override
	public void addTalkEvent(long talkId, long eventId) {
		_eventLocalService.addTalkEvent(talkId, eventId);
	}

	@Override
	public void addTalkEvents(long talkId,
		java.util.List<bg.jug.workshop.liferay.cfp.model.Event> events) {
		_eventLocalService.addTalkEvents(talkId, events);
	}

	@Override
	public void addTalkEvents(long talkId, long[] eventIds) {
		_eventLocalService.addTalkEvents(talkId, eventIds);
	}

	@Override
	public void clearTalkEvents(long talkId) {
		_eventLocalService.clearTalkEvents(talkId);
	}

	/**
	* Creates a new event with the primary key. Does not add the event to the database.
	*
	* @param eventId the primary key for the new event
	* @return the new event
	*/
	@Override
	public bg.jug.workshop.liferay.cfp.model.Event createEvent(long eventId) {
		return _eventLocalService.createEvent(eventId);
	}

	/**
	* Deletes the event from the database. Also notifies the appropriate model listeners.
	*
	* @param event the event
	* @return the event that was removed
	*/
	@Override
	public bg.jug.workshop.liferay.cfp.model.Event deleteEvent(
		bg.jug.workshop.liferay.cfp.model.Event event) {
		return _eventLocalService.deleteEvent(event);
	}

	/**
	* Deletes the event with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eventId the primary key of the event
	* @return the event that was removed
	* @throws PortalException if a event with the primary key could not be found
	*/
	@Override
	public bg.jug.workshop.liferay.cfp.model.Event deleteEvent(long eventId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _eventLocalService.deleteEvent(eventId);
	}

	@Override
	public bg.jug.workshop.liferay.cfp.model.Event deleteEvent(long eventId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _eventLocalService.deleteEvent(eventId, serviceContext);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _eventLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public void deleteTalkEvent(long talkId,
		bg.jug.workshop.liferay.cfp.model.Event event) {
		_eventLocalService.deleteTalkEvent(talkId, event);
	}

	@Override
	public void deleteTalkEvent(long talkId, long eventId) {
		_eventLocalService.deleteTalkEvent(talkId, eventId);
	}

	@Override
	public void deleteTalkEvents(long talkId,
		java.util.List<bg.jug.workshop.liferay.cfp.model.Event> events) {
		_eventLocalService.deleteTalkEvents(talkId, events);
	}

	@Override
	public void deleteTalkEvents(long talkId, long[] eventIds) {
		_eventLocalService.deleteTalkEvents(talkId, eventIds);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _eventLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _eventLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link bg.jug.workshop.liferay.cfp.model.impl.EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _eventLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link bg.jug.workshop.liferay.cfp.model.impl.EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _eventLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _eventLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _eventLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public bg.jug.workshop.liferay.cfp.model.Event fetchEvent(long eventId) {
		return _eventLocalService.fetchEvent(eventId);
	}

	/**
	* Returns the event matching the UUID and group.
	*
	* @param uuid the event's UUID
	* @param groupId the primary key of the group
	* @return the matching event, or <code>null</code> if a matching event could not be found
	*/
	@Override
	public bg.jug.workshop.liferay.cfp.model.Event fetchEventByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return _eventLocalService.fetchEventByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _eventLocalService.getActionableDynamicQuery();
	}

	/**
	* Returns the event with the primary key.
	*
	* @param eventId the primary key of the event
	* @return the event
	* @throws PortalException if a event with the primary key could not be found
	*/
	@Override
	public bg.jug.workshop.liferay.cfp.model.Event getEvent(long eventId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _eventLocalService.getEvent(eventId);
	}

	/**
	* Returns the event matching the UUID and group.
	*
	* @param uuid the event's UUID
	* @param groupId the primary key of the group
	* @return the matching event
	* @throws PortalException if a matching event could not be found
	*/
	@Override
	public bg.jug.workshop.liferay.cfp.model.Event getEventByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _eventLocalService.getEventByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the events.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link bg.jug.workshop.liferay.cfp.model.impl.EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of events
	* @param end the upper bound of the range of events (not inclusive)
	* @return the range of events
	*/
	@Override
	public java.util.List<bg.jug.workshop.liferay.cfp.model.Event> getEvents(
		int start, int end) {
		return _eventLocalService.getEvents(start, end);
	}

	/**
	* Returns all the events matching the UUID and company.
	*
	* @param uuid the UUID of the events
	* @param companyId the primary key of the company
	* @return the matching events, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<bg.jug.workshop.liferay.cfp.model.Event> getEventsByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return _eventLocalService.getEventsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns a range of events matching the UUID and company.
	*
	* @param uuid the UUID of the events
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of events
	* @param end the upper bound of the range of events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching events, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<bg.jug.workshop.liferay.cfp.model.Event> getEventsByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<bg.jug.workshop.liferay.cfp.model.Event> orderByComparator) {
		return _eventLocalService.getEventsByUuidAndCompanyId(uuid, companyId,
			start, end, orderByComparator);
	}

	/**
	* Returns the number of events.
	*
	* @return the number of events
	*/
	@Override
	public int getEventsCount() {
		return _eventLocalService.getEventsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return _eventLocalService.getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public java.util.List<bg.jug.workshop.liferay.cfp.model.Event> getGroupEvents(
		com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay, int start,
		int end) {
		return _eventLocalService.getGroupEvents(themeDisplay, start, end);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _eventLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _eventLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _eventLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.List<bg.jug.workshop.liferay.cfp.model.Event> getTalkEvents(
		long talkId) {
		return _eventLocalService.getTalkEvents(talkId);
	}

	@Override
	public java.util.List<bg.jug.workshop.liferay.cfp.model.Event> getTalkEvents(
		long talkId, int start, int end) {
		return _eventLocalService.getTalkEvents(talkId, start, end);
	}

	@Override
	public java.util.List<bg.jug.workshop.liferay.cfp.model.Event> getTalkEvents(
		long talkId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<bg.jug.workshop.liferay.cfp.model.Event> orderByComparator) {
		return _eventLocalService.getTalkEvents(talkId, start, end,
			orderByComparator);
	}

	@Override
	public int getTalkEventsCount(long talkId) {
		return _eventLocalService.getTalkEventsCount(talkId);
	}

	/**
	* Returns the talkIds of the talks associated with the event.
	*
	* @param eventId the eventId of the event
	* @return long[] the talkIds of talks associated with the event
	*/
	@Override
	public long[] getTalkPrimaryKeys(long eventId) {
		return _eventLocalService.getTalkPrimaryKeys(eventId);
	}

	@Override
	public boolean hasTalkEvent(long talkId, long eventId) {
		return _eventLocalService.hasTalkEvent(talkId, eventId);
	}

	@Override
	public boolean hasTalkEvents(long talkId) {
		return _eventLocalService.hasTalkEvents(talkId);
	}

	@Override
	public bg.jug.workshop.liferay.cfp.model.Event saveEvent(
		java.util.Optional<java.lang.Long> eventId, java.lang.String name,
		java.util.Date eventDate, java.util.Optional<java.lang.Long> venueId,
		java.lang.String website,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _eventLocalService.saveEvent(eventId, name, eventDate, venueId,
			website, serviceContext);
	}

	@Override
	public void setTalkEvents(long talkId, long[] eventIds) {
		_eventLocalService.setTalkEvents(talkId, eventIds);
	}

	/**
	* Updates the event in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param event the event
	* @return the event that was updated
	*/
	@Override
	public bg.jug.workshop.liferay.cfp.model.Event updateEvent(
		bg.jug.workshop.liferay.cfp.model.Event event) {
		return _eventLocalService.updateEvent(event);
	}

	@Override
	public void updateTalks(long eventId, java.util.List<java.lang.Long> talks)
		throws com.liferay.portal.kernel.exception.PortalException {
		_eventLocalService.updateTalks(eventId, talks);
	}

	@Override
	public EventLocalService getWrappedService() {
		return _eventLocalService;
	}

	@Override
	public void setWrappedService(EventLocalService eventLocalService) {
		_eventLocalService = eventLocalService;
	}

	private EventLocalService _eventLocalService;
}