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

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Venue. This utility wraps
 * {@link bg.jug.workshop.liferay.cfp.service.impl.VenueLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see VenueLocalService
 * @see bg.jug.workshop.liferay.cfp.service.base.VenueLocalServiceBaseImpl
 * @see bg.jug.workshop.liferay.cfp.service.impl.VenueLocalServiceImpl
 * @generated
 */
@ProviderType
public class VenueLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link bg.jug.workshop.liferay.cfp.service.impl.VenueLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the venue to the database. Also notifies the appropriate model listeners.
	*
	* @param venue the venue
	* @return the venue that was added
	*/
	public static bg.jug.workshop.liferay.cfp.model.Venue addVenue(
		bg.jug.workshop.liferay.cfp.model.Venue venue) {
		return getService().addVenue(venue);
	}

	/**
	* Creates a new venue with the primary key. Does not add the venue to the database.
	*
	* @param venueId the primary key for the new venue
	* @return the new venue
	*/
	public static bg.jug.workshop.liferay.cfp.model.Venue createVenue(
		long venueId) {
		return getService().createVenue(venueId);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the venue with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param venueId the primary key of the venue
	* @return the venue that was removed
	* @throws PortalException if a venue with the primary key could not be found
	*/
	public static bg.jug.workshop.liferay.cfp.model.Venue deleteVenue(
		long venueId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteVenue(venueId);
	}

	public static bg.jug.workshop.liferay.cfp.model.Venue deleteVenue(
		long venueId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteVenue(venueId, serviceContext);
	}

	/**
	* Deletes the venue from the database. Also notifies the appropriate model listeners.
	*
	* @param venue the venue
	* @return the venue that was removed
	*/
	public static bg.jug.workshop.liferay.cfp.model.Venue deleteVenue(
		bg.jug.workshop.liferay.cfp.model.Venue venue) {
		return getService().deleteVenue(venue);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static bg.jug.workshop.liferay.cfp.model.Venue fetchVenue(
		long venueId) {
		return getService().fetchVenue(venueId);
	}

	/**
	* Returns the venue matching the UUID and group.
	*
	* @param uuid the venue's UUID
	* @param groupId the primary key of the group
	* @return the matching venue, or <code>null</code> if a matching venue could not be found
	*/
	public static bg.jug.workshop.liferay.cfp.model.Venue fetchVenueByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return getService().fetchVenueByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static java.util.List<bg.jug.workshop.liferay.cfp.model.Venue> getGroupVenues(
		com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay, int start,
		int end) {
		return getService().getGroupVenues(themeDisplay, start, end);
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the venue with the primary key.
	*
	* @param venueId the primary key of the venue
	* @return the venue
	* @throws PortalException if a venue with the primary key could not be found
	*/
	public static bg.jug.workshop.liferay.cfp.model.Venue getVenue(long venueId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getVenue(venueId);
	}

	/**
	* Returns the venue matching the UUID and group.
	*
	* @param uuid the venue's UUID
	* @param groupId the primary key of the group
	* @return the matching venue
	* @throws PortalException if a matching venue could not be found
	*/
	public static bg.jug.workshop.liferay.cfp.model.Venue getVenueByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getVenueByUuidAndGroupId(uuid, groupId);
	}

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
	public static java.util.List<bg.jug.workshop.liferay.cfp.model.Venue> getVenues(
		int start, int end) {
		return getService().getVenues(start, end);
	}

	/**
	* Returns all the venues matching the UUID and company.
	*
	* @param uuid the UUID of the venues
	* @param companyId the primary key of the company
	* @return the matching venues, or an empty list if no matches were found
	*/
	public static java.util.List<bg.jug.workshop.liferay.cfp.model.Venue> getVenuesByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return getService().getVenuesByUuidAndCompanyId(uuid, companyId);
	}

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
	public static java.util.List<bg.jug.workshop.liferay.cfp.model.Venue> getVenuesByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<bg.jug.workshop.liferay.cfp.model.Venue> orderByComparator) {
		return getService()
				   .getVenuesByUuidAndCompanyId(uuid, companyId, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of venues.
	*
	* @return the number of venues
	*/
	public static int getVenuesCount() {
		return getService().getVenuesCount();
	}

	public static bg.jug.workshop.liferay.cfp.model.Venue saveVenue(
		java.util.Optional<java.lang.Long> venueId, java.lang.String name,
		java.lang.String address, double longitude, double latitude,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .saveVenue(venueId, name, address, longitude, latitude,
			serviceContext);
	}

	/**
	* Updates the venue in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param venue the venue
	* @return the venue that was updated
	*/
	public static bg.jug.workshop.liferay.cfp.model.Venue updateVenue(
		bg.jug.workshop.liferay.cfp.model.Venue venue) {
		return getService().updateVenue(venue);
	}

	public static VenueLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<VenueLocalService, VenueLocalService> _serviceTracker =
		ServiceTrackerFactory.open(VenueLocalService.class);
}