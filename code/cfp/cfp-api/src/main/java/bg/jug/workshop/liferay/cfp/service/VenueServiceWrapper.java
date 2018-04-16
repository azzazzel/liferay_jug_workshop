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
 * Provides a wrapper for {@link VenueService}.
 *
 * @author Brian Wing Shun Chan
 * @see VenueService
 * @generated
 */
@ProviderType
public class VenueServiceWrapper implements VenueService,
	ServiceWrapper<VenueService> {
	public VenueServiceWrapper(VenueService venueService) {
		_venueService = venueService;
	}

	@Override
	public java.util.Map<java.lang.Long, bg.jug.workshop.liferay.cfp.model.Venue> getGroupVenues(
		long companyId, long groupId) {
		return _venueService.getGroupVenues(companyId, groupId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _venueService.getOSGiServiceIdentifier();
	}

	@Override
	public VenueService getWrappedService() {
		return _venueService;
	}

	@Override
	public void setWrappedService(VenueService venueService) {
		_venueService = venueService;
	}

	private VenueService _venueService;
}