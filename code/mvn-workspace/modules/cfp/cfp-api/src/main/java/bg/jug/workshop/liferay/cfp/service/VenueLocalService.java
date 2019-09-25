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

import bg.jug.workshop.liferay.cfp.model.Venue;

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
 * Provides the local service interface for Venue. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see VenueLocalServiceUtil
 * @see bg.jug.workshop.liferay.cfp.service.base.VenueLocalServiceBaseImpl
 * @see bg.jug.workshop.liferay.cfp.service.impl.VenueLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface VenueLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VenueLocalServiceUtil} to access the venue local service. Add custom service methods to {@link bg.jug.workshop.liferay.cfp.service.impl.VenueLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the venue to the database. Also notifies the appropriate model listeners.
	*
	* @param venue the venue
	* @return the venue that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	@java.lang.Deprecated
	public Venue addVenue(Venue venue);

	public int countGroupVenues(long companyId, long groupId);

	/**
	* Creates a new venue with the primary key. Does not add the venue to the database.
	*
	* @param venueId the primary key for the new venue
	* @return the new venue
	*/
	public Venue createVenue(long venueId);

	/**
	* @throws PortalException
	*/
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	* Deletes the venue with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param venueId the primary key of the venue
	* @return the venue that was removed
	* @throws PortalException if a venue with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	@java.lang.Deprecated
	public Venue deleteVenue(long venueId) throws PortalException;

	public Venue deleteVenue(long venueId, ServiceContext serviceContext)
		throws PortalException;

	/**
	* Deletes the venue from the database. Also notifies the appropriate model listeners.
	*
	* @param venue the venue
	* @return the venue that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	@java.lang.Deprecated
	public Venue deleteVenue(Venue venue);

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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link bg.jug.workshop.liferay.cfp.model.impl.VenueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link bg.jug.workshop.liferay.cfp.model.impl.VenueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public Venue fetchVenue(long venueId);

	/**
	* Returns the venue matching the UUID and group.
	*
	* @param uuid the venue's UUID
	* @param groupId the primary key of the group
	* @return the matching venue, or <code>null</code> if a matching venue could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Venue fetchVenueByUuidAndGroupId(java.lang.String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	/**
	* Returns a list of all venues for given platform instance (company) and site (group)
	*
	* @param companyId the id of the portal instance (guarantees data sharding in multi-tenant environments)
	* @param groupId the id of the site (guarantees data sharding in multi-hosting environments)
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Venue> getGroupVenues(long companyId, long groupId);

	/**
	* Returns a subset (page) of venues for given platform instance (company) and site (group)
	*
	* @param companyId the id of the portal instance (guarantees data sharding in multi-tenant environments)
	* @param groupId the id of the site (guarantees data sharding in multi-hosting environments)
	* @param start the record to start from
	* @param end the record to end at
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Venue> getGroupVenues(long companyId, long groupId, int start,
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
	* Returns the venue with the primary key.
	*
	* @param venueId the primary key of the venue
	* @return the venue
	* @throws PortalException if a venue with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Venue getVenue(long venueId) throws PortalException;

	/**
	* Returns the venue matching the UUID and group.
	*
	* @param uuid the venue's UUID
	* @param groupId the primary key of the group
	* @return the matching venue
	* @throws PortalException if a matching venue could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Venue getVenueByUuidAndGroupId(java.lang.String uuid, long groupId)
		throws PortalException;

	/**
	* Returns a range of all the venues.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link bg.jug.workshop.liferay.cfp.model.impl.VenueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of venues
	* @param end the upper bound of the range of venues (not inclusive)
	* @return the range of venues
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Venue> getVenues(int start, int end);

	/**
	* Returns all the venues matching the UUID and company.
	*
	* @param uuid the UUID of the venues
	* @param companyId the primary key of the company
	* @return the matching venues, or an empty list if no matches were found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Venue> getVenuesByUuidAndCompanyId(java.lang.String uuid,
		long companyId);

	/**
	* Returns a range of venues matching the UUID and company.
	*
	* @param uuid the UUID of the venues
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of venues
	* @param end the upper bound of the range of venues (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching venues, or an empty list if no matches were found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Venue> getVenuesByUuidAndCompanyId(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<Venue> orderByComparator);

	/**
	* Returns the number of venues.
	*
	* @return the number of venues
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getVenuesCount();

	/**
	* This method creates a new venue or updates an existing one.
	* <p>
	* If there is {@code venueId} provided it updates the venue with that id. Otherwise it creates a new venue.
	* <p>
	* This method also creates/updates :
	* <ul>
	*     <li> respective {@link Resource} entity. This is needed to link the venue with the resource framework
	* which among other things is used to manage resources' permissions
	* </ul>
	* <strong>NOTE: Important information for wrapping this method: </strong>
	* <ul>
	*     <li> it uses  {@code counterLocalService.increment(Venue.class.getName())} as opposite to {@code counterLocalService.increment()}.
	* Take that into account to avoid id collisions if you modify the venue creation process.
	* </ul>
	*
	* @param venueId the id of the venue to save. If provided the it MUST be positive value.
	* @param name the venue's name
	* @param address the venue's address
	* @param longitude the venue's longitude
	* @param latitude the venue's latitude
	* @param serviceContext the context of the service request (generated by the caller from servlet or portlet requests)
	* @throws IllegalArgumentException if {@code venueId} is provided but it is not a positive value
	* @throws NoSuchVenueException if {@code venueId} is provided but a venue with such id can not be found
	* @throws PortalException if any other error occur
	*/
	public Venue saveVenue(Optional<java.lang.Long> venueId,
		java.lang.String name, java.lang.String address, double longitude,
		double latitude, ServiceContext serviceContext)
		throws PortalException;

	/**
	* Updates the venue in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param venue the venue
	* @return the venue that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	@java.lang.Deprecated
	public Venue updateVenue(Venue venue);
}