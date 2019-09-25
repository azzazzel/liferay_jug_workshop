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
 * Provides the remote service utility for Venue. This utility wraps
 * {@link bg.jug.workshop.liferay.cfp.service.impl.VenueServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see VenueService
 * @see bg.jug.workshop.liferay.cfp.service.base.VenueServiceBaseImpl
 * @see bg.jug.workshop.liferay.cfp.service.impl.VenueServiceImpl
 * @generated
 */
@ProviderType
public class VenueServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link bg.jug.workshop.liferay.cfp.service.impl.VenueServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static java.util.Map<java.lang.Long, bg.jug.workshop.liferay.cfp.model.Venue> getGroupVenues(
		long companyId, long groupId) {
		return getService().getGroupVenues(companyId, groupId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static VenueService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<VenueService, VenueService> _serviceTracker = ServiceTrackerFactory.open(VenueService.class);
}