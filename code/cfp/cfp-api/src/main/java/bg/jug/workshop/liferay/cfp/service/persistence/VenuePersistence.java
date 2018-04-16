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

import bg.jug.workshop.liferay.cfp.exception.NoSuchVenueException;
import bg.jug.workshop.liferay.cfp.model.Venue;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the venue service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see bg.jug.workshop.liferay.cfp.service.persistence.impl.VenuePersistenceImpl
 * @see VenueUtil
 * @generated
 */
@ProviderType
public interface VenuePersistence extends BasePersistence<Venue> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VenueUtil} to access the venue persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the venues where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching venues
	*/
	public java.util.List<Venue> findByUuid(java.lang.String uuid);

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
	public java.util.List<Venue> findByUuid(java.lang.String uuid, int start,
		int end);

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
	public java.util.List<Venue> findByUuid(java.lang.String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Venue> orderByComparator);

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
	public java.util.List<Venue> findByUuid(java.lang.String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Venue> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first venue in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching venue
	* @throws NoSuchVenueException if a matching venue could not be found
	*/
	public Venue findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Venue> orderByComparator)
		throws NoSuchVenueException;

	/**
	* Returns the first venue in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching venue, or <code>null</code> if a matching venue could not be found
	*/
	public Venue fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Venue> orderByComparator);

	/**
	* Returns the last venue in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching venue
	* @throws NoSuchVenueException if a matching venue could not be found
	*/
	public Venue findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Venue> orderByComparator)
		throws NoSuchVenueException;

	/**
	* Returns the last venue in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching venue, or <code>null</code> if a matching venue could not be found
	*/
	public Venue fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Venue> orderByComparator);

	/**
	* Returns the venues before and after the current venue in the ordered set where uuid = &#63;.
	*
	* @param venueId the primary key of the current venue
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next venue
	* @throws NoSuchVenueException if a venue with the primary key could not be found
	*/
	public Venue[] findByUuid_PrevAndNext(long venueId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Venue> orderByComparator)
		throws NoSuchVenueException;

	/**
	* Removes all the venues where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of venues where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching venues
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns the venue where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchVenueException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching venue
	* @throws NoSuchVenueException if a matching venue could not be found
	*/
	public Venue findByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchVenueException;

	/**
	* Returns the venue where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching venue, or <code>null</code> if a matching venue could not be found
	*/
	public Venue fetchByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns the venue where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching venue, or <code>null</code> if a matching venue could not be found
	*/
	public Venue fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the venue where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the venue that was removed
	*/
	public Venue removeByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchVenueException;

	/**
	* Returns the number of venues where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching venues
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns all the venues where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching venues
	*/
	public java.util.List<Venue> findByUuid_C(java.lang.String uuid,
		long companyId);

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
	public java.util.List<Venue> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

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
	public java.util.List<Venue> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Venue> orderByComparator);

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
	public java.util.List<Venue> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Venue> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first venue in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching venue
	* @throws NoSuchVenueException if a matching venue could not be found
	*/
	public Venue findByUuid_C_First(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Venue> orderByComparator)
		throws NoSuchVenueException;

	/**
	* Returns the first venue in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching venue, or <code>null</code> if a matching venue could not be found
	*/
	public Venue fetchByUuid_C_First(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Venue> orderByComparator);

	/**
	* Returns the last venue in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching venue
	* @throws NoSuchVenueException if a matching venue could not be found
	*/
	public Venue findByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Venue> orderByComparator)
		throws NoSuchVenueException;

	/**
	* Returns the last venue in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching venue, or <code>null</code> if a matching venue could not be found
	*/
	public Venue fetchByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Venue> orderByComparator);

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
	public Venue[] findByUuid_C_PrevAndNext(long venueId,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Venue> orderByComparator)
		throws NoSuchVenueException;

	/**
	* Removes all the venues where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of venues where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching venues
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns all the venues where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching venues
	*/
	public java.util.List<Venue> findByCompanyAndGroup(long companyId,
		long groupId);

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
	public java.util.List<Venue> findByCompanyAndGroup(long companyId,
		long groupId, int start, int end);

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
	public java.util.List<Venue> findByCompanyAndGroup(long companyId,
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Venue> orderByComparator);

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
	public java.util.List<Venue> findByCompanyAndGroup(long companyId,
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Venue> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first venue in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching venue
	* @throws NoSuchVenueException if a matching venue could not be found
	*/
	public Venue findByCompanyAndGroup_First(long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Venue> orderByComparator)
		throws NoSuchVenueException;

	/**
	* Returns the first venue in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching venue, or <code>null</code> if a matching venue could not be found
	*/
	public Venue fetchByCompanyAndGroup_First(long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Venue> orderByComparator);

	/**
	* Returns the last venue in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching venue
	* @throws NoSuchVenueException if a matching venue could not be found
	*/
	public Venue findByCompanyAndGroup_Last(long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Venue> orderByComparator)
		throws NoSuchVenueException;

	/**
	* Returns the last venue in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching venue, or <code>null</code> if a matching venue could not be found
	*/
	public Venue fetchByCompanyAndGroup_Last(long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Venue> orderByComparator);

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
	public Venue[] findByCompanyAndGroup_PrevAndNext(long venueId,
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Venue> orderByComparator)
		throws NoSuchVenueException;

	/**
	* Returns all the venues that the user has permission to view where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching venues that the user has permission to view
	*/
	public java.util.List<Venue> filterFindByCompanyAndGroup(long companyId,
		long groupId);

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
	public java.util.List<Venue> filterFindByCompanyAndGroup(long companyId,
		long groupId, int start, int end);

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
	public java.util.List<Venue> filterFindByCompanyAndGroup(long companyId,
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Venue> orderByComparator);

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
	public Venue[] filterFindByCompanyAndGroup_PrevAndNext(long venueId,
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Venue> orderByComparator)
		throws NoSuchVenueException;

	/**
	* Removes all the venues where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	*/
	public void removeByCompanyAndGroup(long companyId, long groupId);

	/**
	* Returns the number of venues where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching venues
	*/
	public int countByCompanyAndGroup(long companyId, long groupId);

	/**
	* Returns the number of venues that the user has permission to view where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching venues that the user has permission to view
	*/
	public int filterCountByCompanyAndGroup(long companyId, long groupId);

	/**
	* Caches the venue in the entity cache if it is enabled.
	*
	* @param venue the venue
	*/
	public void cacheResult(Venue venue);

	/**
	* Caches the venues in the entity cache if it is enabled.
	*
	* @param venues the venues
	*/
	public void cacheResult(java.util.List<Venue> venues);

	/**
	* Creates a new venue with the primary key. Does not add the venue to the database.
	*
	* @param venueId the primary key for the new venue
	* @return the new venue
	*/
	public Venue create(long venueId);

	/**
	* Removes the venue with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param venueId the primary key of the venue
	* @return the venue that was removed
	* @throws NoSuchVenueException if a venue with the primary key could not be found
	*/
	public Venue remove(long venueId) throws NoSuchVenueException;

	public Venue updateImpl(Venue venue);

	/**
	* Returns the venue with the primary key or throws a {@link NoSuchVenueException} if it could not be found.
	*
	* @param venueId the primary key of the venue
	* @return the venue
	* @throws NoSuchVenueException if a venue with the primary key could not be found
	*/
	public Venue findByPrimaryKey(long venueId) throws NoSuchVenueException;

	/**
	* Returns the venue with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param venueId the primary key of the venue
	* @return the venue, or <code>null</code> if a venue with the primary key could not be found
	*/
	public Venue fetchByPrimaryKey(long venueId);

	@Override
	public java.util.Map<java.io.Serializable, Venue> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the venues.
	*
	* @return the venues
	*/
	public java.util.List<Venue> findAll();

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
	public java.util.List<Venue> findAll(int start, int end);

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
	public java.util.List<Venue> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Venue> orderByComparator);

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
	public java.util.List<Venue> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Venue> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the venues from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of venues.
	*
	* @return the number of venues
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}