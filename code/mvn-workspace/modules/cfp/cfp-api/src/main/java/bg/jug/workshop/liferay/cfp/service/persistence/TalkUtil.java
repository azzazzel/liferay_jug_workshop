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

import bg.jug.workshop.liferay.cfp.model.Talk;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the talk service. This utility wraps {@link bg.jug.workshop.liferay.cfp.service.persistence.impl.TalkPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TalkPersistence
 * @see bg.jug.workshop.liferay.cfp.service.persistence.impl.TalkPersistenceImpl
 * @generated
 */
@ProviderType
public class TalkUtil {
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
	public static void clearCache(Talk talk) {
		getPersistence().clearCache(talk);
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
	public static List<Talk> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Talk> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Talk> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator<Talk> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Talk update(Talk talk) {
		return getPersistence().update(talk);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Talk update(Talk talk, ServiceContext serviceContext) {
		return getPersistence().update(talk, serviceContext);
	}

	/**
	* Returns all the talks where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching talks
	*/
	public static List<Talk> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the talks where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TalkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of talks
	* @param end the upper bound of the range of talks (not inclusive)
	* @return the range of matching talks
	*/
	public static List<Talk> findByUuid(java.lang.String uuid, int start,
		int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the talks where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TalkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of talks
	* @param end the upper bound of the range of talks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching talks
	*/
	public static List<Talk> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<Talk> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the talks where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TalkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of talks
	* @param end the upper bound of the range of talks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching talks
	*/
	public static List<Talk> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<Talk> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first talk in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching talk
	* @throws NoSuchTalkException if a matching talk could not be found
	*/
	public static Talk findByUuid_First(java.lang.String uuid,
		OrderByComparator<Talk> orderByComparator)
		throws bg.jug.workshop.liferay.cfp.exception.NoSuchTalkException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first talk in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching talk, or <code>null</code> if a matching talk could not be found
	*/
	public static Talk fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<Talk> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last talk in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching talk
	* @throws NoSuchTalkException if a matching talk could not be found
	*/
	public static Talk findByUuid_Last(java.lang.String uuid,
		OrderByComparator<Talk> orderByComparator)
		throws bg.jug.workshop.liferay.cfp.exception.NoSuchTalkException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last talk in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching talk, or <code>null</code> if a matching talk could not be found
	*/
	public static Talk fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<Talk> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the talks before and after the current talk in the ordered set where uuid = &#63;.
	*
	* @param talkId the primary key of the current talk
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next talk
	* @throws NoSuchTalkException if a talk with the primary key could not be found
	*/
	public static Talk[] findByUuid_PrevAndNext(long talkId,
		java.lang.String uuid, OrderByComparator<Talk> orderByComparator)
		throws bg.jug.workshop.liferay.cfp.exception.NoSuchTalkException {
		return getPersistence()
				   .findByUuid_PrevAndNext(talkId, uuid, orderByComparator);
	}

	/**
	* Removes all the talks where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of talks where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching talks
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the talk where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchTalkException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching talk
	* @throws NoSuchTalkException if a matching talk could not be found
	*/
	public static Talk findByUUID_G(java.lang.String uuid, long groupId)
		throws bg.jug.workshop.liferay.cfp.exception.NoSuchTalkException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the talk where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching talk, or <code>null</code> if a matching talk could not be found
	*/
	public static Talk fetchByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the talk where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching talk, or <code>null</code> if a matching talk could not be found
	*/
	public static Talk fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the talk where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the talk that was removed
	*/
	public static Talk removeByUUID_G(java.lang.String uuid, long groupId)
		throws bg.jug.workshop.liferay.cfp.exception.NoSuchTalkException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of talks where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching talks
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the talks where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching talks
	*/
	public static List<Talk> findByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the talks where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TalkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of talks
	* @param end the upper bound of the range of talks (not inclusive)
	* @return the range of matching talks
	*/
	public static List<Talk> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the talks where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TalkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of talks
	* @param end the upper bound of the range of talks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching talks
	*/
	public static List<Talk> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<Talk> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the talks where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TalkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of talks
	* @param end the upper bound of the range of talks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching talks
	*/
	public static List<Talk> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<Talk> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first talk in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching talk
	* @throws NoSuchTalkException if a matching talk could not be found
	*/
	public static Talk findByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<Talk> orderByComparator)
		throws bg.jug.workshop.liferay.cfp.exception.NoSuchTalkException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first talk in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching talk, or <code>null</code> if a matching talk could not be found
	*/
	public static Talk fetchByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<Talk> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last talk in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching talk
	* @throws NoSuchTalkException if a matching talk could not be found
	*/
	public static Talk findByUuid_C_Last(java.lang.String uuid, long companyId,
		OrderByComparator<Talk> orderByComparator)
		throws bg.jug.workshop.liferay.cfp.exception.NoSuchTalkException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last talk in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching talk, or <code>null</code> if a matching talk could not be found
	*/
	public static Talk fetchByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<Talk> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the talks before and after the current talk in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param talkId the primary key of the current talk
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next talk
	* @throws NoSuchTalkException if a talk with the primary key could not be found
	*/
	public static Talk[] findByUuid_C_PrevAndNext(long talkId,
		java.lang.String uuid, long companyId,
		OrderByComparator<Talk> orderByComparator)
		throws bg.jug.workshop.liferay.cfp.exception.NoSuchTalkException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(talkId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the talks where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of talks where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching talks
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the talks where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching talks
	*/
	public static List<Talk> findByCompanyAndGroup(long companyId, long groupId) {
		return getPersistence().findByCompanyAndGroup(companyId, groupId);
	}

	/**
	* Returns a range of all the talks where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TalkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of talks
	* @param end the upper bound of the range of talks (not inclusive)
	* @return the range of matching talks
	*/
	public static List<Talk> findByCompanyAndGroup(long companyId,
		long groupId, int start, int end) {
		return getPersistence()
				   .findByCompanyAndGroup(companyId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the talks where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TalkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of talks
	* @param end the upper bound of the range of talks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching talks
	*/
	public static List<Talk> findByCompanyAndGroup(long companyId,
		long groupId, int start, int end,
		OrderByComparator<Talk> orderByComparator) {
		return getPersistence()
				   .findByCompanyAndGroup(companyId, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the talks where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TalkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of talks
	* @param end the upper bound of the range of talks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching talks
	*/
	public static List<Talk> findByCompanyAndGroup(long companyId,
		long groupId, int start, int end,
		OrderByComparator<Talk> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByCompanyAndGroup(companyId, groupId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first talk in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching talk
	* @throws NoSuchTalkException if a matching talk could not be found
	*/
	public static Talk findByCompanyAndGroup_First(long companyId,
		long groupId, OrderByComparator<Talk> orderByComparator)
		throws bg.jug.workshop.liferay.cfp.exception.NoSuchTalkException {
		return getPersistence()
				   .findByCompanyAndGroup_First(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the first talk in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching talk, or <code>null</code> if a matching talk could not be found
	*/
	public static Talk fetchByCompanyAndGroup_First(long companyId,
		long groupId, OrderByComparator<Talk> orderByComparator) {
		return getPersistence()
				   .fetchByCompanyAndGroup_First(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last talk in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching talk
	* @throws NoSuchTalkException if a matching talk could not be found
	*/
	public static Talk findByCompanyAndGroup_Last(long companyId, long groupId,
		OrderByComparator<Talk> orderByComparator)
		throws bg.jug.workshop.liferay.cfp.exception.NoSuchTalkException {
		return getPersistence()
				   .findByCompanyAndGroup_Last(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last talk in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching talk, or <code>null</code> if a matching talk could not be found
	*/
	public static Talk fetchByCompanyAndGroup_Last(long companyId,
		long groupId, OrderByComparator<Talk> orderByComparator) {
		return getPersistence()
				   .fetchByCompanyAndGroup_Last(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the talks before and after the current talk in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param talkId the primary key of the current talk
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next talk
	* @throws NoSuchTalkException if a talk with the primary key could not be found
	*/
	public static Talk[] findByCompanyAndGroup_PrevAndNext(long talkId,
		long companyId, long groupId, OrderByComparator<Talk> orderByComparator)
		throws bg.jug.workshop.liferay.cfp.exception.NoSuchTalkException {
		return getPersistence()
				   .findByCompanyAndGroup_PrevAndNext(talkId, companyId,
			groupId, orderByComparator);
	}

	/**
	* Returns all the talks that the user has permission to view where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching talks that the user has permission to view
	*/
	public static List<Talk> filterFindByCompanyAndGroup(long companyId,
		long groupId) {
		return getPersistence().filterFindByCompanyAndGroup(companyId, groupId);
	}

	/**
	* Returns a range of all the talks that the user has permission to view where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TalkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of talks
	* @param end the upper bound of the range of talks (not inclusive)
	* @return the range of matching talks that the user has permission to view
	*/
	public static List<Talk> filterFindByCompanyAndGroup(long companyId,
		long groupId, int start, int end) {
		return getPersistence()
				   .filterFindByCompanyAndGroup(companyId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the talks that the user has permissions to view where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TalkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of talks
	* @param end the upper bound of the range of talks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching talks that the user has permission to view
	*/
	public static List<Talk> filterFindByCompanyAndGroup(long companyId,
		long groupId, int start, int end,
		OrderByComparator<Talk> orderByComparator) {
		return getPersistence()
				   .filterFindByCompanyAndGroup(companyId, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the talks before and after the current talk in the ordered set of talks that the user has permission to view where companyId = &#63; and groupId = &#63;.
	*
	* @param talkId the primary key of the current talk
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next talk
	* @throws NoSuchTalkException if a talk with the primary key could not be found
	*/
	public static Talk[] filterFindByCompanyAndGroup_PrevAndNext(long talkId,
		long companyId, long groupId, OrderByComparator<Talk> orderByComparator)
		throws bg.jug.workshop.liferay.cfp.exception.NoSuchTalkException {
		return getPersistence()
				   .filterFindByCompanyAndGroup_PrevAndNext(talkId, companyId,
			groupId, orderByComparator);
	}

	/**
	* Removes all the talks where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	*/
	public static void removeByCompanyAndGroup(long companyId, long groupId) {
		getPersistence().removeByCompanyAndGroup(companyId, groupId);
	}

	/**
	* Returns the number of talks where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching talks
	*/
	public static int countByCompanyAndGroup(long companyId, long groupId) {
		return getPersistence().countByCompanyAndGroup(companyId, groupId);
	}

	/**
	* Returns the number of talks that the user has permission to view where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching talks that the user has permission to view
	*/
	public static int filterCountByCompanyAndGroup(long companyId, long groupId) {
		return getPersistence().filterCountByCompanyAndGroup(companyId, groupId);
	}

	/**
	* Caches the talk in the entity cache if it is enabled.
	*
	* @param talk the talk
	*/
	public static void cacheResult(Talk talk) {
		getPersistence().cacheResult(talk);
	}

	/**
	* Caches the talks in the entity cache if it is enabled.
	*
	* @param talks the talks
	*/
	public static void cacheResult(List<Talk> talks) {
		getPersistence().cacheResult(talks);
	}

	/**
	* Creates a new talk with the primary key. Does not add the talk to the database.
	*
	* @param talkId the primary key for the new talk
	* @return the new talk
	*/
	public static Talk create(long talkId) {
		return getPersistence().create(talkId);
	}

	/**
	* Removes the talk with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param talkId the primary key of the talk
	* @return the talk that was removed
	* @throws NoSuchTalkException if a talk with the primary key could not be found
	*/
	public static Talk remove(long talkId)
		throws bg.jug.workshop.liferay.cfp.exception.NoSuchTalkException {
		return getPersistence().remove(talkId);
	}

	public static Talk updateImpl(Talk talk) {
		return getPersistence().updateImpl(talk);
	}

	/**
	* Returns the talk with the primary key or throws a {@link NoSuchTalkException} if it could not be found.
	*
	* @param talkId the primary key of the talk
	* @return the talk
	* @throws NoSuchTalkException if a talk with the primary key could not be found
	*/
	public static Talk findByPrimaryKey(long talkId)
		throws bg.jug.workshop.liferay.cfp.exception.NoSuchTalkException {
		return getPersistence().findByPrimaryKey(talkId);
	}

	/**
	* Returns the talk with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param talkId the primary key of the talk
	* @return the talk, or <code>null</code> if a talk with the primary key could not be found
	*/
	public static Talk fetchByPrimaryKey(long talkId) {
		return getPersistence().fetchByPrimaryKey(talkId);
	}

	public static java.util.Map<java.io.Serializable, Talk> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the talks.
	*
	* @return the talks
	*/
	public static List<Talk> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the talks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TalkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of talks
	* @param end the upper bound of the range of talks (not inclusive)
	* @return the range of talks
	*/
	public static List<Talk> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the talks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TalkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of talks
	* @param end the upper bound of the range of talks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of talks
	*/
	public static List<Talk> findAll(int start, int end,
		OrderByComparator<Talk> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the talks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TalkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of talks
	* @param end the upper bound of the range of talks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of talks
	*/
	public static List<Talk> findAll(int start, int end,
		OrderByComparator<Talk> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the talks from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of talks.
	*
	* @return the number of talks
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	/**
	* Returns the primaryKeys of events associated with the talk.
	*
	* @param pk the primary key of the talk
	* @return long[] of the primaryKeys of events associated with the talk
	*/
	public static long[] getEventPrimaryKeys(long pk) {
		return getPersistence().getEventPrimaryKeys(pk);
	}

	/**
	* Returns all the events associated with the talk.
	*
	* @param pk the primary key of the talk
	* @return the events associated with the talk
	*/
	public static List<bg.jug.workshop.liferay.cfp.model.Event> getEvents(
		long pk) {
		return getPersistence().getEvents(pk);
	}

	/**
	* Returns a range of all the events associated with the talk.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TalkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the talk
	* @param start the lower bound of the range of talks
	* @param end the upper bound of the range of talks (not inclusive)
	* @return the range of events associated with the talk
	*/
	public static List<bg.jug.workshop.liferay.cfp.model.Event> getEvents(
		long pk, int start, int end) {
		return getPersistence().getEvents(pk, start, end);
	}

	/**
	* Returns an ordered range of all the events associated with the talk.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TalkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the talk
	* @param start the lower bound of the range of talks
	* @param end the upper bound of the range of talks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of events associated with the talk
	*/
	public static List<bg.jug.workshop.liferay.cfp.model.Event> getEvents(
		long pk, int start, int end,
		OrderByComparator<bg.jug.workshop.liferay.cfp.model.Event> orderByComparator) {
		return getPersistence().getEvents(pk, start, end, orderByComparator);
	}

	/**
	* Returns the number of events associated with the talk.
	*
	* @param pk the primary key of the talk
	* @return the number of events associated with the talk
	*/
	public static int getEventsSize(long pk) {
		return getPersistence().getEventsSize(pk);
	}

	/**
	* Returns <code>true</code> if the event is associated with the talk.
	*
	* @param pk the primary key of the talk
	* @param eventPK the primary key of the event
	* @return <code>true</code> if the event is associated with the talk; <code>false</code> otherwise
	*/
	public static boolean containsEvent(long pk, long eventPK) {
		return getPersistence().containsEvent(pk, eventPK);
	}

	/**
	* Returns <code>true</code> if the talk has any events associated with it.
	*
	* @param pk the primary key of the talk to check for associations with events
	* @return <code>true</code> if the talk has any events associated with it; <code>false</code> otherwise
	*/
	public static boolean containsEvents(long pk) {
		return getPersistence().containsEvents(pk);
	}

	/**
	* Adds an association between the talk and the event. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the talk
	* @param eventPK the primary key of the event
	*/
	public static void addEvent(long pk, long eventPK) {
		getPersistence().addEvent(pk, eventPK);
	}

	/**
	* Adds an association between the talk and the event. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the talk
	* @param event the event
	*/
	public static void addEvent(long pk,
		bg.jug.workshop.liferay.cfp.model.Event event) {
		getPersistence().addEvent(pk, event);
	}

	/**
	* Adds an association between the talk and the events. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the talk
	* @param eventPKs the primary keys of the events
	*/
	public static void addEvents(long pk, long[] eventPKs) {
		getPersistence().addEvents(pk, eventPKs);
	}

	/**
	* Adds an association between the talk and the events. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the talk
	* @param events the events
	*/
	public static void addEvents(long pk,
		List<bg.jug.workshop.liferay.cfp.model.Event> events) {
		getPersistence().addEvents(pk, events);
	}

	/**
	* Clears all associations between the talk and its events. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the talk to clear the associated events from
	*/
	public static void clearEvents(long pk) {
		getPersistence().clearEvents(pk);
	}

	/**
	* Removes the association between the talk and the event. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the talk
	* @param eventPK the primary key of the event
	*/
	public static void removeEvent(long pk, long eventPK) {
		getPersistence().removeEvent(pk, eventPK);
	}

	/**
	* Removes the association between the talk and the event. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the talk
	* @param event the event
	*/
	public static void removeEvent(long pk,
		bg.jug.workshop.liferay.cfp.model.Event event) {
		getPersistence().removeEvent(pk, event);
	}

	/**
	* Removes the association between the talk and the events. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the talk
	* @param eventPKs the primary keys of the events
	*/
	public static void removeEvents(long pk, long[] eventPKs) {
		getPersistence().removeEvents(pk, eventPKs);
	}

	/**
	* Removes the association between the talk and the events. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the talk
	* @param events the events
	*/
	public static void removeEvents(long pk,
		List<bg.jug.workshop.liferay.cfp.model.Event> events) {
		getPersistence().removeEvents(pk, events);
	}

	/**
	* Sets the events associated with the talk, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the talk
	* @param eventPKs the primary keys of the events to be associated with the talk
	*/
	public static void setEvents(long pk, long[] eventPKs) {
		getPersistence().setEvents(pk, eventPKs);
	}

	/**
	* Sets the events associated with the talk, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the talk
	* @param events the events to be associated with the talk
	*/
	public static void setEvents(long pk,
		List<bg.jug.workshop.liferay.cfp.model.Event> events) {
		getPersistence().setEvents(pk, events);
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static TalkPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TalkPersistence, TalkPersistence> _serviceTracker =
		ServiceTrackerFactory.open(TalkPersistence.class);
}