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

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;

import bg.jug.workshop.liferay.cfp.model.Venue;
import bg.jug.workshop.liferay.cfp.service.base.VenueLocalServiceBaseImpl;

/**
 * The implementation of the venue local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link bg.jug.workshop.liferay.cfp.service.VenueLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VenueLocalServiceBaseImpl
 * @see bg.jug.workshop.liferay.cfp.service.VenueLocalServiceUtil
 */
public class VenueLocalServiceImpl extends VenueLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link bg.jug.workshop.liferay.cfp.service.VenueLocalServiceUtil} to access the venue local service.
	 */
	
	public List<Venue> getGroupVenues(ThemeDisplay themeDisplay, int start, int end) {
		return venuePersistence.findByCompanyAndGroup(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), start, end);
	}

	public Venue saveVenue(
			Optional<Long> venueId, 
			String name, 
			String address, 
			double longitude, 
			double latitude, 
			ServiceContext serviceContext) throws PortalException {

		Venue venue;
		if (venueId.isPresent()) {
			venue = getVenue(venueId.get());
		} else {
			venue = createVenue(counterLocalService.increment(Venue.class.getName()));	
		}

		long userId = serviceContext.getUserId();
		long companyId = serviceContext.getCompanyId();
		long groupId = serviceContext.getScopeGroupId();
		Date date = new Date();

		venue.setCompanyId(companyId);
		venue.setGroupId(groupId);
		venue.setUserId(userId);
		venue.setUserName(PortalUtil.getUserName(userId, "unknown"));
		if (venue.isNew()) {
			venue.setCreateDate(date);
		}
		venue.setModifiedDate(date);
		venue.setName(name);
		venue.setAddress(address);
		venue.setLongitude(longitude);
		venue.setLatitude(latitude);
	
		if (venue.isNew()) {
			resourceLocalService.addResources(
					companyId,					// the id of the instance (useful in mutli-tenant environment)
					groupId,					// the id of the site
					userId,						// the id of the currently logged in user
				    Venue.class.getName(), 		// the type of the model to add resource for
				    venue.getVenueId(), 		// the id of the model entity to add resource for
				    false, 						// is this a portlet resource (if it is not then it is a model resource)
				    true, 						// should the default permissions for the site be used 
				    true						// should the default permissions for the guest user be used
				    );
		} else {
			resourceLocalService.updateResources(
					companyId,								// the id of the instance (useful in mutli-tenant environment)
					groupId,								// the id of the site
					Venue.class.getName(), 					// the type of the model to add resource for
					venue.getVenueId(), 					// the id of the model entity to add resource for
				    serviceContext.getGroupPermissions(), 	// the new group permissions 
				    serviceContext.getGuestPermissions()	// the new guest permissions
				    );
		}
		
		return updateVenue(venue);
	}
	
	public Venue deleteVenue(long venueId, ServiceContext serviceContext) throws PortalException {
		resourceLocalService.deleteResource(
				serviceContext.getCompanyId(),			// the id of the instance (useful in mutli-tenant environment)
				Venue.class.getName(), 					// the type of the model to add resource for
                ResourceConstants.SCOPE_INDIVIDUAL,
                venueId);
		return super.deleteVenue(venueId);
	}
	
}