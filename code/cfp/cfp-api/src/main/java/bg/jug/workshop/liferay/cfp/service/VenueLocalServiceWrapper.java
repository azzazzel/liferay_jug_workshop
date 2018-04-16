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
 * Provides a wrapper for {@link VenueLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see VenueLocalService
 * @generated
 */
@ProviderType
public class VenueLocalServiceWrapper implements VenueLocalService,
	ServiceWrapper<VenueLocalService> {
	public VenueLocalServiceWrapper(VenueLocalService venueLocalService) {
		_venueLocalService = venueLocalService;
	}

	/**
	* Adds the venue to the database. Also notifies the appropriate model listeners.
	*
	* @param venue the venue
	* @return the venue that was added
	*/
	@Override
	public bg.jug.workshop.liferay.cfp.model.Venue addVenue(
		bg.jug.workshop.liferay.cfp.model.Venue venue) {
		return _venueLocalService.addVenue(venue);
	}

	/**
	* Creates a new venue with the primary key. Does not add the venue to the database.
	*
	* @param venueId the primary key for the new venue
	* @return the new venue
	*/
	@Override
	public bg.jug.workshop.liferay.cfp.model.Venue createVenue(long venueId) {
		return _venueLocalService.createVenue(venueId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _venueLocalService.deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the venue with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param venueId the primary key of the venue
	* @return the venue that was removed
	* @throws PortalException if a venue with the primary key could not be found
	*/
	@Override
	public bg.jug.workshop.liferay.cfp.model.Venue deleteVenue(long venueId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _venueLocalService.deleteVenue(venueId);
	}

	@Override
	public bg.jug.workshop.liferay.cfp.model.Venue deleteVenue(long venueId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _venueLocalService.deleteVenue(venueId, serviceContext);
	}

	/**
	* Deletes the venue from the database. Also notifies the appropriate model listeners.
	*
	* @param venue the venue
	* @return the venue that was removed
	*/
	@Override
	public bg.jug.workshop.liferay.cfp.model.Venue deleteVenue(
		bg.jug.workshop.liferay.cfp.model.Venue venue) {
		return _venueLocalService.deleteVenue(venue);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _venueLocalService.dynamicQuery();
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
		return _venueLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _venueLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _venueLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _venueLocalService.dynamicQueryCount(dynamicQuery);
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
		return _venueLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public bg.jug.workshop.liferay.cfp.model.Venue fetchVenue(long venueId) {
		return _venueLocalService.fetchVenue(venueId);
	}

	/**
	* Returns the venue matching the UUID and group.
	*
	* @param uuid the venue's UUID
	* @param groupId the primary key of the group
	* @return the matching venue, or <code>null</code> if a matching venue could not be found
	*/
	@Override
	public bg.jug.workshop.liferay.cfp.model.Venue fetchVenueByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return _venueLocalService.fetchVenueByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _venueLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return _venueLocalService.getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public java.util.List<bg.jug.workshop.liferay.cfp.model.Venue> getGroupVenues(
		com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay, int start,
		int end) {
		return _venueLocalService.getGroupVenues(themeDisplay, start, end);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _venueLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _venueLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _venueLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the venue with the primary key.
	*
	* @param venueId the primary key of the venue
	* @return the venue
	* @throws PortalException if a venue with the primary key could not be found
	*/
	@Override
	public bg.jug.workshop.liferay.cfp.model.Venue getVenue(long venueId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _venueLocalService.getVenue(venueId);
	}

	/**
	* Returns the venue matching the UUID and group.
	*
	* @param uuid the venue's UUID
	* @param groupId the primary key of the group
	* @return the matching venue
	* @throws PortalException if a matching venue could not be found
	*/
	@Override
	public bg.jug.workshop.liferay.cfp.model.Venue getVenueByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _venueLocalService.getVenueByUuidAndGroupId(uuid, groupId);
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
	@Override
	public java.util.List<bg.jug.workshop.liferay.cfp.model.Venue> getVenues(
		int start, int end) {
		return _venueLocalService.getVenues(start, end);
	}

	/**
	* Returns all the venues matching the UUID and company.
	*
	* @param uuid the UUID of the venues
	* @param companyId the primary key of the company
	* @return the matching venues, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<bg.jug.workshop.liferay.cfp.model.Venue> getVenuesByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return _venueLocalService.getVenuesByUuidAndCompanyId(uuid, companyId);
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
	@Override
	public java.util.List<bg.jug.workshop.liferay.cfp.model.Venue> getVenuesByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<bg.jug.workshop.liferay.cfp.model.Venue> orderByComparator) {
		return _venueLocalService.getVenuesByUuidAndCompanyId(uuid, companyId,
			start, end, orderByComparator);
	}

	/**
	* Returns the number of venues.
	*
	* @return the number of venues
	*/
	@Override
	public int getVenuesCount() {
		return _venueLocalService.getVenuesCount();
	}

	@Override
	public bg.jug.workshop.liferay.cfp.model.Venue saveVenue(
		java.util.Optional<java.lang.Long> venueId, java.lang.String name,
		java.lang.String address, double longitude, double latitude,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _venueLocalService.saveVenue(venueId, name, address, longitude,
			latitude, serviceContext);
	}

	/**
	* Updates the venue in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param venue the venue
	* @return the venue that was updated
	*/
	@Override
	public bg.jug.workshop.liferay.cfp.model.Venue updateVenue(
		bg.jug.workshop.liferay.cfp.model.Venue venue) {
		return _venueLocalService.updateVenue(venue);
	}

	@Override
	public VenueLocalService getWrappedService() {
		return _venueLocalService;
	}

	@Override
	public void setWrappedService(VenueLocalService venueLocalService) {
		_venueLocalService = venueLocalService;
	}

	private VenueLocalService _venueLocalService;
}