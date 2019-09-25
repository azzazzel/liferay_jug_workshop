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

import bg.jug.workshop.liferay.cfp.model.Talk;

import com.liferay.exportimport.kernel.lar.PortletDataContext;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Optional;

/**
 * Provides the local service interface for Talk. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see TalkLocalServiceUtil
 * @see bg.jug.workshop.liferay.cfp.service.base.TalkLocalServiceBaseImpl
 * @see bg.jug.workshop.liferay.cfp.service.impl.TalkLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface TalkLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TalkLocalServiceUtil} to access the talk local service. Add custom service methods to {@link bg.jug.workshop.liferay.cfp.service.impl.TalkLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public void addEventTalk(long eventId, long talkId);

	public void addEventTalk(long eventId, Talk talk);

	public void addEventTalks(long eventId, List<Talk> talks);

	public void addEventTalks(long eventId, long[] talkIds);

	/**
	* Adds the talk to the database. Also notifies the appropriate model listeners.
	*
	* @param talk the talk
	* @return the talk that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	@java.lang.Deprecated
	public Talk addTalk(Talk talk);

	public void clearEventTalks(long eventId);

	public int countGroupTalks(long companyId, long groupId);

	/**
	* Creates a new talk with the primary key. Does not add the talk to the database.
	*
	* @param talkId the primary key for the new talk
	* @return the new talk
	*/
	public Talk createTalk(long talkId);

	public void deleteEventTalk(long eventId, long talkId);

	public void deleteEventTalk(long eventId, Talk talk);

	public void deleteEventTalks(long eventId, List<Talk> talks);

	public void deleteEventTalks(long eventId, long[] talkIds);

	/**
	* @throws PortalException
	*/
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	* Deletes the talk with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param talkId the primary key of the talk
	* @return the talk that was removed
	* @throws PortalException if a talk with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	@java.lang.Deprecated
	public Talk deleteTalk(long talkId) throws PortalException;

	/**
	* Deletes given talk, it's respective resource entity (if present) and structure link (if present).
	*
	* @param talkId the id of the talk to delete
	* @param serviceContext the context of the service request (generated by the caller from servlet or portlet requests)
	* @throws PortalException if any error occur
	*/
	public Talk deleteTalk(long talkId, ServiceContext serviceContext)
		throws PortalException;

	/**
	* Deletes the talk from the database. Also notifies the appropriate model listeners.
	*
	* @param talk the talk
	* @return the talk that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	@java.lang.Deprecated
	public Talk deleteTalk(Talk talk);

	public DynamicQuery dynamicQuery();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link bg.jug.workshop.liferay.cfp.model.impl.TalkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end);

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link bg.jug.workshop.liferay.cfp.model.impl.TalkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Talk fetchTalk(long talkId);

	/**
	* Returns the talk matching the UUID and group.
	*
	* @param uuid the talk's UUID
	* @param groupId the primary key of the group
	* @return the matching talk, or <code>null</code> if a matching talk could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Talk fetchTalkByUuidAndGroupId(java.lang.String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	* Returns the eventIds of the events associated with the talk.
	*
	* @param talkId the talkId of the talk
	* @return long[] the eventIds of events associated with the talk
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long[] getEventPrimaryKeys(long talkId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Talk> getEventTalks(long eventId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Talk> getEventTalks(long eventId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Talk> getEventTalks(long eventId, int start, int end,
		OrderByComparator<Talk> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getEventTalksCount(long eventId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	/**
	* Returns a list of all talks for given platform instance (company) and site (group)
	*
	* @param companyId the id of the portal instance (guarantees data sharding in multi-tenant environments)
	* @param groupId the id of the site (guarantees data sharding in multi-hosting environments)
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Talk> getGroupTalks(long companyId, long groupId);

	/**
	* Returns a subset (page) of talks for given platform instance (company) and site (group)
	*
	* @param companyId the id of the portal instance (guarantees data sharding in multi-tenant environments)
	* @param groupId the id of the site (guarantees data sharding in multi-hosting environments)
	* @param start the record to start from
	* @param end the record to end at
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Talk> getGroupTalks(long companyId, long groupId, int start,
		int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	* Returns the talk with the primary key.
	*
	* @param talkId the primary key of the talk
	* @return the talk
	* @throws PortalException if a talk with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Talk getTalk(long talkId) throws PortalException;

	/**
	* Returns the talk matching the UUID and group.
	*
	* @param uuid the talk's UUID
	* @param groupId the primary key of the group
	* @return the matching talk
	* @throws PortalException if a matching talk could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Talk getTalkByUuidAndGroupId(java.lang.String uuid, long groupId)
		throws PortalException;

	/**
	* Returns a range of all the talks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link bg.jug.workshop.liferay.cfp.model.impl.TalkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of talks
	* @param end the upper bound of the range of talks (not inclusive)
	* @return the range of talks
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Talk> getTalks(int start, int end);

	/**
	* Returns all the talks matching the UUID and company.
	*
	* @param uuid the UUID of the talks
	* @param companyId the primary key of the company
	* @return the matching talks, or an empty list if no matches were found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Talk> getTalksByUuidAndCompanyId(java.lang.String uuid,
		long companyId);

	/**
	* Returns a range of talks matching the UUID and company.
	*
	* @param uuid the UUID of the talks
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of talks
	* @param end the upper bound of the range of talks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching talks, or an empty list if no matches were found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Talk> getTalksByUuidAndCompanyId(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<Talk> orderByComparator);

	/**
	* Returns the number of talks.
	*
	* @return the number of talks
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getTalksCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasEventTalk(long eventId, long talkId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasEventTalks(long eventId);

	/**
	* This method creates a new talk or updates an existing one.
	* <p>
	* If there is {@code talkId} provided it updates the talk with that id. Otherwise it creates a new talk.
	* <p>
	* This method also creates/updates :
	* <ul>
	*     <li> respective {@link Resource} entity. This is needed to link the talk with the resource framework
	* which among other things is used to manage resources' permissions
	*  <li> respective {@link DDMStructureLink} entity. This is needed to indicate the talk uses given {@link DDMStructure}
	* to prevent the structure from being deleted when there are talks using it.
	* </ul>
	* <strong>NOTE: Important information for wrapping this method: </strong>
	* <ul>
	*     <li> it uses  {@code counterLocalService.increment(Talk.class.getName())} as opposite to {@code counterLocalService.increment()}.
	* Take that into account to avoid id collisions if you modify the talk creation process.
	* </ul>
	*
	* @param talkId the id of the talk to save. If provided the it MUST be positive value.
	* @param structureId the id of the {@code DDMStructure} that defines the structure of the data
	* @param data the talk's data in a form described by the respective {@code DDMStructure}
	* @param serviceContext the context of the service request (generated by the caller from servlet or portlet requests)
	* @throws IllegalArgumentException if {@code talkId} is provided but it is not a positive value
	* @throws NoSuchTalkException if {@code talkId} is provided but a talk with such id can not be found
	* @throws PortalException if any other error occur
	*/
	public Talk saveTalk(Optional<java.lang.Long> talkId,
		java.lang.String title, long structureId, long templateId,
		java.lang.String data, ServiceContext serviceContext)
		throws PortalException;

	public void setEventTalks(long eventId, long[] talkIds);

	/**
	* Updates the talk in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param talk the talk
	* @return the talk that was updated
	* @throws UnsupportedOperationException
	*/
	@Indexable(type = IndexableType.REINDEX)
	@java.lang.Deprecated
	public Talk updateTalk(Talk talk)
		throws java.lang.UnsupportedOperationException;
}