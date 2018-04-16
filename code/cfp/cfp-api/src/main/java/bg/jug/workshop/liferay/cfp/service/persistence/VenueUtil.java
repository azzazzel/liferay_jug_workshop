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

package bg.jug.workshop.liferay.cfp.service.persistence;

import aQute.bnd.annotation.ProviderType;

import bg.jug.workshop.liferay.cfp.model.Venue;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the venue service. This utility wraps {@link bg.jug.workshop.liferay.cfp.service.persistence.impl.VenuePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VenuePersistence
 * @see bg.jug.workshop.liferay.cfp.service.persistence.impl.VenuePersistenceImpl
 * @generated
 */
@ProviderType
public class VenueUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Venue venue) {
		getPersistence().clearCache(venue);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Venue> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Venue> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Venue> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator<Venue> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Venue update(Venue venue) {
		return getPersistence().update(venue);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Venue update(Venue venue, ServiceContext serviceContext) {
		return getPersistence().update(venue, serviceContext);
	}

	/**
	* Returns all the venues where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching venues
	*/
	public static List<Venue> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the venues where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VenueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of venues
	* @param end the upper bound of the range of venues (not inclusive)
	* @return the range of matching venues
	*/
	public static List<Venue> findByUuid(java.lang.String uuid, int start,
		int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the venues where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VenueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of venues
	* @param end the upper bound of the range of venues (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching venues
	*/
	public static List<Venue> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<Venue> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the venues where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VenueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of venues
	* @param end the upper bound of the range of venues (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching venues
	*/
	public static List<Venue> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<Venue> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first venue in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching venue
	* @throws NoSuchVenueException if a matching venue could not be found
	*/
	public static Venue findByUuid_First(java.lang.String uuid,
		OrderByComparator<Venue> orderByComparator)
		throws bg.jug.workshop.liferay.cfp.exception.NoSuchVenueException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first venue in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching venue, or <code>null</code> if a matching venue could not be found
	*/
	public static Venue fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<Venue> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last venue in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching venue
	* @throws NoSuchVenueException if a matching venue could not be found
	*/
	public static Venue findByUuid_Last(java.lang.String uuid,
		OrderByComparator<Venue> orderByComparator)
		throws bg.jug.workshop.liferay.cfp.exception.NoSuchVenueException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last venue in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching venue, or <code>null</code> if a matching venue could not be found
	*/
	public static Venue fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<Venue> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the venues before and after the current venue in the ordered set where uuid = &#63;.
	*
	* @param venueId the primary key of the current venue
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next venue
	* @throws NoSuchVenueException if a venue with the primary key could not be found
	*/
	public static Venue[] findByUuid_PrevAndNext(long venueId,
		java.lang.String uuid, OrderByComparator<Venue> orderByComparator)
		throws bg.jug.workshop.liferay.cfp.exception.NoSuchVenueException {
		return getPersistence()
				   .findByUuid_PrevAndNext(venueId, uuid, orderByComparator);
	}

	/**
	* Removes all the venues where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of venues where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching venues
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the venue where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchVenueException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching venue
	* @throws NoSuchVenueException if a matching venue could not be found
	*/
	public static Venue findByUUID_G(java.lang.String uuid, long groupId)
		throws bg.jug.workshop.liferay.cfp.exception.NoSuchVenueException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the venue where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching venue, or <code>null</code> if a matching venue could not be found
	*/
	public static Venue fetchByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the venue where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching venue, or <code>null</code> if a matching venue could not be found
	*/
	public static Venue fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the venue where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the venue that was removed
	*/
	public static Venue removeByUUID_G(java.lang.String uuid, long groupId)
		throws bg.jug.workshop.liferay.cfp.exception.NoSuchVenueException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of venues where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching venues
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the venues where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching venues
	*/
	public static List<Venue> findByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the venues where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VenueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of venues
	* @param end the upper bound of the range of venues (not inclusive)
	* @return the range of matching venues
	*/
	public static List<Venue> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the venues where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VenueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of venues
	* @param end the upper bound of the range of venues (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching venues
	*/
	public static List<Venue> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<Venue> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the venues where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VenueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of venues
	* @param end the upper bound of the range of venues (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching venues
	*/
	public static List<Venue> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<Venue> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first venue in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching venue
	* @throws NoSuchVenueException if a matching venue could not be found
	*/
	public static Venue findByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<Venue> orderByComparator)
		throws bg.jug.workshop.liferay.cfp.exception.NoSuchVenueException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first venue in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching venue, or <code>null</code> if a matching venue could not be found
	*/
	public static Venue fetchByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<Venue> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last venue in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching venue
	* @throws NoSuchVenueException if a matching venue could not be found
	*/
	public static Venue findByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<Venue> orderByComparator)
		throws bg.jug.workshop.liferay.cfp.exception.NoSuchVenueException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last venue in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching venue, or <code>null</code> if a matching venue could not be found
	*/
	public static Venue fetchByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<Venue> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the venues before and after the current venue in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param venueId the primary key of the current venue
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next venue
	* @throws NoSuchVenueException if a venue with the primary key could not be found
	*/
	public static Venue[] findByUuid_C_PrevAndNext(long venueId,
		java.lang.String uuid, long companyId,
		OrderByComparator<Venue> orderByComparator)
		throws bg.jug.workshop.liferay.cfp.exception.NoSuchVenueException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(venueId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the venues where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of venues where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching venues
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the venues where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching venues
	*/
	public static List<Venue> findByCompanyAndGroup(long companyId, long groupId) {
		return getPersistence().findByCompanyAndGroup(companyId, groupId);
	}

	/**
	* Returns a range of all the venues where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VenueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of venues
	* @param end the upper bound of the range of venues (not inclusive)
	* @return the range of matching venues
	*/
	public static List<Venue> findByCompanyAndGroup(long companyId,
		long groupId, int start, int end) {
		return getPersistence()
				   .findByCompanyAndGroup(companyId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the venues where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VenueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of venues
	* @param end the upper bound of the range of venues (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching venues
	*/
	public static List<Venue> findByCompanyAndGroup(long companyId,
		long groupId, int start, int end,
		OrderByComparator<Venue> orderByComparator) {
		return getPersistence()
				   .findByCompanyAndGroup(companyId, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the venues where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VenueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of venues
	* @param end the upper bound of the range of venues (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching venues
	*/
	public static List<Venue> findByCompanyAndGroup(long companyId,
		long groupId, int start, int end,
		OrderByComparator<Venue> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByCompanyAndGroup(companyId, groupId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first venue in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching venue
	* @throws NoSuchVenueException if a matching venue could not be found
	*/
	public static Venue findByCompanyAndGroup_First(long companyId,
		long groupId, OrderByComparator<Venue> orderByComparator)
		throws bg.jug.workshop.liferay.cfp.exception.NoSuchVenueException {
		return getPersistence()
				   .findByCompanyAndGroup_First(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the first venue in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching venue, or <code>null</code> if a matching venue could not be found
	*/
	public static Venue fetchByCompanyAndGroup_First(long companyId,
		long groupId, OrderByComparator<Venue> orderByComparator) {
		return getPersistence()
				   .fetchByCompanyAndGroup_First(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last venue in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching venue
	* @throws NoSuchVenueException if a matching venue could not be found
	*/
	public static Venue findByCompanyAndGroup_Last(long companyId,
		long groupId, OrderByComparator<Venue> orderByComparator)
		throws bg.jug.workshop.liferay.cfp.exception.NoSuchVenueException {
		return getPersistence()
				   .findByCompanyAndGroup_Last(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last venue in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching venue, or <code>null</code> if a matching venue could not be found
	*/
	public static Venue fetchByCompanyAndGroup_Last(long companyId,
		long groupId, OrderByComparator<Venue> orderByComparator) {
		return getPersistence()
				   .fetchByCompanyAndGroup_Last(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the venues before and after the current venue in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param venueId the primary key of the current venue
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next venue
	* @throws NoSuchVenueException if a venue with the primary key could not be found
	*/
	public static Venue[] findByCompanyAndGroup_PrevAndNext(long venueId,
		long companyId, long groupId, OrderByComparator<Venue> orderByComparator)
		throws bg.jug.workshop.liferay.cfp.exception.NoSuchVenueException {
		return getPersistence()
				   .findByCompanyAndGroup_PrevAndNext(venueId, companyId,
			groupId, orderByComparator);
	}

	/**
	* Returns all the venues that the user has permission to view where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching venues that the user has permission to view
	*/
	public static List<Venue> filterFindByCompanyAndGroup(long companyId,
		long groupId) {
		return getPersistence().filterFindByCompanyAndGroup(companyId, groupId);
	}

	/**
	* Returns a range of all the venues that the user has permission to view where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VenueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of venues
	* @param end the upper bound of the range of venues (not inclusive)
	* @return the range of matching venues that the user has permission to view
	*/
	public static List<Venue> filterFindByCompanyAndGroup(long companyId,
		long groupId, int start, int end) {
		return getPersistence()
				   .filterFindByCompanyAndGroup(companyId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the venues that the user has permissions to view where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VenueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of venues
	* @param end the upper bound of the range of venues (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching venues that the user has permission to view
	*/
	public static List<Venue> filterFindByCompanyAndGroup(long companyId,
		long groupId, int start, int end,
		OrderByComparator<Venue> orderByComparator) {
		return getPersistence()
				   .filterFindByCompanyAndGroup(companyId, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the venues before and after the current venue in the ordered set of venues that the user has permission to view where companyId = &#63; and groupId = &#63;.
	*
	* @param venueId the primary key of the current venue
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next venue
	* @throws NoSuchVenueException if a venue with the primary key could not be found
	*/
	public static Venue[] filterFindByCompanyAndGroup_PrevAndNext(
		long venueId, long companyId, long groupId,
		OrderByComparator<Venue> orderByComparator)
		throws bg.jug.workshop.liferay.cfp.exception.NoSuchVenueException {
		return getPersistence()
				   .filterFindByCompanyAndGroup_PrevAndNext(venueId, companyId,
			groupId, orderByComparator);
	}

	/**
	* Removes all the venues where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	*/
	public static void removeByCompanyAndGroup(long companyId, long groupId) {
		getPersistence().removeByCompanyAndGroup(companyId, groupId);
	}

	/**
	* Returns the number of venues where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching venues
	*/
	public static int countByCompanyAndGroup(long companyId, long groupId) {
		return getPersistence().countByCompanyAndGroup(companyId, groupId);
	}

	/**
	* Returns the number of venues that the user has permission to view where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching venues that the user has permission to view
	*/
	public static int filterCountByCompanyAndGroup(long companyId, long groupId) {
		return getPersistence().filterCountByCompanyAndGroup(companyId, groupId);
	}

	/**
	* Caches the venue in the entity cache if it is enabled.
	*
	* @param venue the venue
	*/
	public static void cacheResult(Venue venue) {
		getPersistence().cacheResult(venue);
	}

	/**
	* Caches the venues in the entity cache if it is enabled.
	*
	* @param venues the venues
	*/
	public static void cacheResult(List<Venue> venues) {
		getPersistence().cacheResult(venues);
	}

	/**
	* Creates a new venue with the primary key. Does not add the venue to the database.
	*
	* @param venueId the primary key for the new venue
	* @return the new venue
	*/
	public static Venue create(long venueId) {
		return getPersistence().create(venueId);
	}

	/**
	* Removes the venue with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param venueId the primary key of the venue
	* @return the venue that was removed
	* @throws NoSuchVenueException if a venue with the primary key could not be found
	*/
	public static Venue remove(long venueId)
		throws bg.jug.workshop.liferay.cfp.exception.NoSuchVenueException {
		return getPersistence().remove(venueId);
	}

	public static Venue updateImpl(Venue venue) {
		return getPersistence().updateImpl(venue);
	}

	/**
	* Returns the venue with the primary key or throws a {@link NoSuchVenueException} if it could not be found.
	*
	* @param venueId the primary key of the venue
	* @return the venue
	* @throws NoSuchVenueException if a venue with the primary key could not be found
	*/
	public static Venue findByPrimaryKey(long venueId)
		throws bg.jug.workshop.liferay.cfp.exception.NoSuchVenueException {
		return getPersistence().findByPrimaryKey(venueId);
	}

	/**
	* Returns the venue with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param venueId the primary key of the venue
	* @return the venue, or <code>null</code> if a venue with the primary key could not be found
	*/
	public static Venue fetchByPrimaryKey(long venueId) {
		return getPersistence().fetchByPrimaryKey(venueId);
	}

	public static java.util.Map<java.io.Serializable, Venue> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the venues.
	*
	* @return the venues
	*/
	public static List<Venue> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the venues.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VenueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of venues
	* @param end the upper bound of the range of venues (not inclusive)
	* @return the range of venues
	*/
	public static List<Venue> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the venues.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VenueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of venues
	* @param end the upper bound of the range of venues (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of venues
	*/
	public static List<Venue> findAll(int start, int end,
		OrderByComparator<Venue> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the venues.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VenueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of venues
	* @param end the upper bound of the range of venues (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of venues
	*/
	public static List<Venue> findAll(int start, int end,
		OrderByComparator<Venue> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the venues from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of venues.
	*
	* @return the number of venues
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static VenuePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<VenuePersistence, VenuePersistence> _serviceTracker =
		ServiceTrackerFactory.open(VenuePersistence.class);
}