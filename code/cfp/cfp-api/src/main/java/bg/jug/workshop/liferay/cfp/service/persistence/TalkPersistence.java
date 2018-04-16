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

import bg.jug.workshop.liferay.cfp.exception.NoSuchTalkException;
import bg.jug.workshop.liferay.cfp.model.Talk;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the talk service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see bg.jug.workshop.liferay.cfp.service.persistence.impl.TalkPersistenceImpl
 * @see TalkUtil
 * @generated
 */
@ProviderType
public interface TalkPersistence extends BasePersistence<Talk> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TalkUtil} to access the talk persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the talks where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching talks
	*/
	public java.util.List<Talk> findByUuid(java.lang.String uuid);

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
	public java.util.List<Talk> findByUuid(java.lang.String uuid, int start,
		int end);

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
	public java.util.List<Talk> findByUuid(java.lang.String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Talk> orderByComparator);

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
	public java.util.List<Talk> findByUuid(java.lang.String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Talk> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first talk in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching talk
	* @throws NoSuchTalkException if a matching talk could not be found
	*/
	public Talk findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Talk> orderByComparator)
		throws NoSuchTalkException;

	/**
	* Returns the first talk in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching talk, or <code>null</code> if a matching talk could not be found
	*/
	public Talk fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Talk> orderByComparator);

	/**
	* Returns the last talk in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching talk
	* @throws NoSuchTalkException if a matching talk could not be found
	*/
	public Talk findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Talk> orderByComparator)
		throws NoSuchTalkException;

	/**
	* Returns the last talk in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching talk, or <code>null</code> if a matching talk could not be found
	*/
	public Talk fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Talk> orderByComparator);

	/**
	* Returns the talks before and after the current talk in the ordered set where uuid = &#63;.
	*
	* @param talkId the primary key of the current talk
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next talk
	* @throws NoSuchTalkException if a talk with the primary key could not be found
	*/
	public Talk[] findByUuid_PrevAndNext(long talkId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Talk> orderByComparator)
		throws NoSuchTalkException;

	/**
	* Removes all the talks where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of talks where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching talks
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns the talk where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchTalkException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching talk
	* @throws NoSuchTalkException if a matching talk could not be found
	*/
	public Talk findByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchTalkException;

	/**
	* Returns the talk where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching talk, or <code>null</code> if a matching talk could not be found
	*/
	public Talk fetchByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns the talk where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching talk, or <code>null</code> if a matching talk could not be found
	*/
	public Talk fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the talk where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the talk that was removed
	*/
	public Talk removeByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchTalkException;

	/**
	* Returns the number of talks where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching talks
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns all the talks where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching talks
	*/
	public java.util.List<Talk> findByUuid_C(java.lang.String uuid,
		long companyId);

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
	public java.util.List<Talk> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

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
	public java.util.List<Talk> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Talk> orderByComparator);

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
	public java.util.List<Talk> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Talk> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first talk in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching talk
	* @throws NoSuchTalkException if a matching talk could not be found
	*/
	public Talk findByUuid_C_First(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Talk> orderByComparator)
		throws NoSuchTalkException;

	/**
	* Returns the first talk in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching talk, or <code>null</code> if a matching talk could not be found
	*/
	public Talk fetchByUuid_C_First(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Talk> orderByComparator);

	/**
	* Returns the last talk in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching talk
	* @throws NoSuchTalkException if a matching talk could not be found
	*/
	public Talk findByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Talk> orderByComparator)
		throws NoSuchTalkException;

	/**
	* Returns the last talk in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching talk, or <code>null</code> if a matching talk could not be found
	*/
	public Talk fetchByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Talk> orderByComparator);

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
	public Talk[] findByUuid_C_PrevAndNext(long talkId, java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Talk> orderByComparator)
		throws NoSuchTalkException;

	/**
	* Removes all the talks where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of talks where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching talks
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns all the talks where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching talks
	*/
	public java.util.List<Talk> findByCompanyAndGroup(long companyId,
		long groupId);

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
	public java.util.List<Talk> findByCompanyAndGroup(long companyId,
		long groupId, int start, int end);

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
	public java.util.List<Talk> findByCompanyAndGroup(long companyId,
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Talk> orderByComparator);

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
	public java.util.List<Talk> findByCompanyAndGroup(long companyId,
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Talk> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first talk in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching talk
	* @throws NoSuchTalkException if a matching talk could not be found
	*/
	public Talk findByCompanyAndGroup_First(long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Talk> orderByComparator)
		throws NoSuchTalkException;

	/**
	* Returns the first talk in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching talk, or <code>null</code> if a matching talk could not be found
	*/
	public Talk fetchByCompanyAndGroup_First(long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Talk> orderByComparator);

	/**
	* Returns the last talk in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching talk
	* @throws NoSuchTalkException if a matching talk could not be found
	*/
	public Talk findByCompanyAndGroup_Last(long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Talk> orderByComparator)
		throws NoSuchTalkException;

	/**
	* Returns the last talk in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching talk, or <code>null</code> if a matching talk could not be found
	*/
	public Talk fetchByCompanyAndGroup_Last(long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Talk> orderByComparator);

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
	public Talk[] findByCompanyAndGroup_PrevAndNext(long talkId,
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Talk> orderByComparator)
		throws NoSuchTalkException;

	/**
	* Returns all the talks that the user has permission to view where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching talks that the user has permission to view
	*/
	public java.util.List<Talk> filterFindByCompanyAndGroup(long companyId,
		long groupId);

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
	public java.util.List<Talk> filterFindByCompanyAndGroup(long companyId,
		long groupId, int start, int end);

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
	public java.util.List<Talk> filterFindByCompanyAndGroup(long companyId,
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Talk> orderByComparator);

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
	public Talk[] filterFindByCompanyAndGroup_PrevAndNext(long talkId,
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Talk> orderByComparator)
		throws NoSuchTalkException;

	/**
	* Removes all the talks where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	*/
	public void removeByCompanyAndGroup(long companyId, long groupId);

	/**
	* Returns the number of talks where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching talks
	*/
	public int countByCompanyAndGroup(long companyId, long groupId);

	/**
	* Returns the number of talks that the user has permission to view where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching talks that the user has permission to view
	*/
	public int filterCountByCompanyAndGroup(long companyId, long groupId);

	/**
	* Caches the talk in the entity cache if it is enabled.
	*
	* @param talk the talk
	*/
	public void cacheResult(Talk talk);

	/**
	* Caches the talks in the entity cache if it is enabled.
	*
	* @param talks the talks
	*/
	public void cacheResult(java.util.List<Talk> talks);

	/**
	* Creates a new talk with the primary key. Does not add the talk to the database.
	*
	* @param talkId the primary key for the new talk
	* @return the new talk
	*/
	public Talk create(long talkId);

	/**
	* Removes the talk with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param talkId the primary key of the talk
	* @return the talk that was removed
	* @throws NoSuchTalkException if a talk with the primary key could not be found
	*/
	public Talk remove(long talkId) throws NoSuchTalkException;

	public Talk updateImpl(Talk talk);

	/**
	* Returns the talk with the primary key or throws a {@link NoSuchTalkException} if it could not be found.
	*
	* @param talkId the primary key of the talk
	* @return the talk
	* @throws NoSuchTalkException if a talk with the primary key could not be found
	*/
	public Talk findByPrimaryKey(long talkId) throws NoSuchTalkException;

	/**
	* Returns the talk with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param talkId the primary key of the talk
	* @return the talk, or <code>null</code> if a talk with the primary key could not be found
	*/
	public Talk fetchByPrimaryKey(long talkId);

	@Override
	public java.util.Map<java.io.Serializable, Talk> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the talks.
	*
	* @return the talks
	*/
	public java.util.List<Talk> findAll();

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
	public java.util.List<Talk> findAll(int start, int end);

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
	public java.util.List<Talk> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Talk> orderByComparator);

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
	public java.util.List<Talk> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Talk> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the talks from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of talks.
	*
	* @return the number of talks
	*/
	public int countAll();

	/**
	* Returns the primaryKeys of events associated with the talk.
	*
	* @param pk the primary key of the talk
	* @return long[] of the primaryKeys of events associated with the talk
	*/
	public long[] getEventPrimaryKeys(long pk);

	/**
	* Returns all the events associated with the talk.
	*
	* @param pk the primary key of the talk
	* @return the events associated with the talk
	*/
	public java.util.List<bg.jug.workshop.liferay.cfp.model.Event> getEvents(
		long pk);

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
	public java.util.List<bg.jug.workshop.liferay.cfp.model.Event> getEvents(
		long pk, int start, int end);

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
	public java.util.List<bg.jug.workshop.liferay.cfp.model.Event> getEvents(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<bg.jug.workshop.liferay.cfp.model.Event> orderByComparator);

	/**
	* Returns the number of events associated with the talk.
	*
	* @param pk the primary key of the talk
	* @return the number of events associated with the talk
	*/
	public int getEventsSize(long pk);

	/**
	* Returns <code>true</code> if the event is associated with the talk.
	*
	* @param pk the primary key of the talk
	* @param eventPK the primary key of the event
	* @return <code>true</code> if the event is associated with the talk; <code>false</code> otherwise
	*/
	public boolean containsEvent(long pk, long eventPK);

	/**
	* Returns <code>true</code> if the talk has any events associated with it.
	*
	* @param pk the primary key of the talk to check for associations with events
	* @return <code>true</code> if the talk has any events associated with it; <code>false</code> otherwise
	*/
	public boolean containsEvents(long pk);

	/**
	* Adds an association between the talk and the event. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the talk
	* @param eventPK the primary key of the event
	*/
	public void addEvent(long pk, long eventPK);

	/**
	* Adds an association between the talk and the event. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the talk
	* @param event the event
	*/
	public void addEvent(long pk, bg.jug.workshop.liferay.cfp.model.Event event);

	/**
	* Adds an association between the talk and the events. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the talk
	* @param eventPKs the primary keys of the events
	*/
	public void addEvents(long pk, long[] eventPKs);

	/**
	* Adds an association between the talk and the events. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the talk
	* @param events the events
	*/
	public void addEvents(long pk,
		java.util.List<bg.jug.workshop.liferay.cfp.model.Event> events);

	/**
	* Clears all associations between the talk and its events. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the talk to clear the associated events from
	*/
	public void clearEvents(long pk);

	/**
	* Removes the association between the talk and the event. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the talk
	* @param eventPK the primary key of the event
	*/
	public void removeEvent(long pk, long eventPK);

	/**
	* Removes the association between the talk and the event. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the talk
	* @param event the event
	*/
	public void removeEvent(long pk,
		bg.jug.workshop.liferay.cfp.model.Event event);

	/**
	* Removes the association between the talk and the events. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the talk
	* @param eventPKs the primary keys of the events
	*/
	public void removeEvents(long pk, long[] eventPKs);

	/**
	* Removes the association between the talk and the events. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the talk
	* @param events the events
	*/
	public void removeEvents(long pk,
		java.util.List<bg.jug.workshop.liferay.cfp.model.Event> events);

	/**
	* Sets the events associated with the talk, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the talk
	* @param eventPKs the primary keys of the events to be associated with the talk
	*/
	public void setEvents(long pk, long[] eventPKs);

	/**
	* Sets the events associated with the talk, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the talk
	* @param events the events to be associated with the talk
	*/
	public void setEvents(long pk,
		java.util.List<bg.jug.workshop.liferay.cfp.model.Event> events);

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}