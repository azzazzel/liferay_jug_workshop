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

package bg.jug.workshop.liferay.cfp.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import bg.jug.workshop.liferay.cfp.exception.NoSuchTalkException;
import bg.jug.workshop.liferay.cfp.model.Talk;
import bg.jug.workshop.liferay.cfp.model.impl.TalkImpl;
import bg.jug.workshop.liferay.cfp.model.impl.TalkModelImpl;
import bg.jug.workshop.liferay.cfp.service.persistence.EventPersistence;
import bg.jug.workshop.liferay.cfp.service.persistence.TalkPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.service.persistence.impl.TableMapper;
import com.liferay.portal.kernel.service.persistence.impl.TableMapperFactory;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReflectionUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the talk service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TalkPersistence
 * @see bg.jug.workshop.liferay.cfp.service.persistence.TalkUtil
 * @generated
 */
@ProviderType
public class TalkPersistenceImpl extends BasePersistenceImpl<Talk>
	implements TalkPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TalkUtil} to access the talk persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TalkImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TalkModelImpl.ENTITY_CACHE_ENABLED,
			TalkModelImpl.FINDER_CACHE_ENABLED, TalkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TalkModelImpl.ENTITY_CACHE_ENABLED,
			TalkModelImpl.FINDER_CACHE_ENABLED, TalkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TalkModelImpl.ENTITY_CACHE_ENABLED,
			TalkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(TalkModelImpl.ENTITY_CACHE_ENABLED,
			TalkModelImpl.FINDER_CACHE_ENABLED, TalkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(TalkModelImpl.ENTITY_CACHE_ENABLED,
			TalkModelImpl.FINDER_CACHE_ENABLED, TalkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			TalkModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(TalkModelImpl.ENTITY_CACHE_ENABLED,
			TalkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the talks where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching talks
	 */
	@Override
	public List<Talk> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Talk> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<Talk> findByUuid(String uuid, int start, int end,
		OrderByComparator<Talk> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<Talk> findByUuid(String uuid, int start, int end,
		OrderByComparator<Talk> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<Talk> list = null;

		if (retrieveFromCache) {
			list = (List<Talk>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Talk talk : list) {
					if (!Objects.equals(uuid, talk.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_TALK_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TalkModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<Talk>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Talk>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first talk in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching talk
	 * @throws NoSuchTalkException if a matching talk could not be found
	 */
	@Override
	public Talk findByUuid_First(String uuid,
		OrderByComparator<Talk> orderByComparator) throws NoSuchTalkException {
		Talk talk = fetchByUuid_First(uuid, orderByComparator);

		if (talk != null) {
			return talk;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTalkException(msg.toString());
	}

	/**
	 * Returns the first talk in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching talk, or <code>null</code> if a matching talk could not be found
	 */
	@Override
	public Talk fetchByUuid_First(String uuid,
		OrderByComparator<Talk> orderByComparator) {
		List<Talk> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last talk in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching talk
	 * @throws NoSuchTalkException if a matching talk could not be found
	 */
	@Override
	public Talk findByUuid_Last(String uuid,
		OrderByComparator<Talk> orderByComparator) throws NoSuchTalkException {
		Talk talk = fetchByUuid_Last(uuid, orderByComparator);

		if (talk != null) {
			return talk;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTalkException(msg.toString());
	}

	/**
	 * Returns the last talk in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching talk, or <code>null</code> if a matching talk could not be found
	 */
	@Override
	public Talk fetchByUuid_Last(String uuid,
		OrderByComparator<Talk> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Talk> list = findByUuid(uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Talk[] findByUuid_PrevAndNext(long talkId, String uuid,
		OrderByComparator<Talk> orderByComparator) throws NoSuchTalkException {
		Talk talk = findByPrimaryKey(talkId);

		Session session = null;

		try {
			session = openSession();

			Talk[] array = new TalkImpl[3];

			array[0] = getByUuid_PrevAndNext(session, talk, uuid,
					orderByComparator, true);

			array[1] = talk;

			array[2] = getByUuid_PrevAndNext(session, talk, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Talk getByUuid_PrevAndNext(Session session, Talk talk,
		String uuid, OrderByComparator<Talk> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TALK_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(TalkModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(talk);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Talk> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the talks where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Talk talk : findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(talk);
		}
	}

	/**
	 * Returns the number of talks where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching talks
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TALK_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "talk.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "talk.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(talk.uuid IS NULL OR talk.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(TalkModelImpl.ENTITY_CACHE_ENABLED,
			TalkModelImpl.FINDER_CACHE_ENABLED, TalkImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			TalkModelImpl.UUID_COLUMN_BITMASK |
			TalkModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(TalkModelImpl.ENTITY_CACHE_ENABLED,
			TalkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the talk where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchTalkException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching talk
	 * @throws NoSuchTalkException if a matching talk could not be found
	 */
	@Override
	public Talk findByUUID_G(String uuid, long groupId)
		throws NoSuchTalkException {
		Talk talk = fetchByUUID_G(uuid, groupId);

		if (talk == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchTalkException(msg.toString());
		}

		return talk;
	}

	/**
	 * Returns the talk where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching talk, or <code>null</code> if a matching talk could not be found
	 */
	@Override
	public Talk fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the talk where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching talk, or <code>null</code> if a matching talk could not be found
	 */
	@Override
	public Talk fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof Talk) {
			Talk talk = (Talk)result;

			if (!Objects.equals(uuid, talk.getUuid()) ||
					(groupId != talk.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_TALK_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<Talk> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					Talk talk = list.get(0);

					result = talk;

					cacheResult(talk);

					if ((talk.getUuid() == null) ||
							!talk.getUuid().equals(uuid) ||
							(talk.getGroupId() != groupId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, talk);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Talk)result;
		}
	}

	/**
	 * Removes the talk where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the talk that was removed
	 */
	@Override
	public Talk removeByUUID_G(String uuid, long groupId)
		throws NoSuchTalkException {
		Talk talk = findByUUID_G(uuid, groupId);

		return remove(talk);
	}

	/**
	 * Returns the number of talks where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching talks
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TALK_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "talk.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "talk.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(talk.uuid IS NULL OR talk.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "talk.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(TalkModelImpl.ENTITY_CACHE_ENABLED,
			TalkModelImpl.FINDER_CACHE_ENABLED, TalkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(TalkModelImpl.ENTITY_CACHE_ENABLED,
			TalkModelImpl.FINDER_CACHE_ENABLED, TalkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			TalkModelImpl.UUID_COLUMN_BITMASK |
			TalkModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(TalkModelImpl.ENTITY_CACHE_ENABLED,
			TalkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the talks where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching talks
	 */
	@Override
	public List<Talk> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Talk> findByUuid_C(String uuid, long companyId, int start,
		int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<Talk> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator<Talk> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<Talk> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator<Talk> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] { uuid, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] {
					uuid, companyId,
					
					start, end, orderByComparator
				};
		}

		List<Talk> list = null;

		if (retrieveFromCache) {
			list = (List<Talk>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Talk talk : list) {
					if (!Objects.equals(uuid, talk.getUuid()) ||
							(companyId != talk.getCompanyId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_TALK_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TalkModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				if (!pagination) {
					list = (List<Talk>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Talk>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Talk findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Talk> orderByComparator) throws NoSuchTalkException {
		Talk talk = fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (talk != null) {
			return talk;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTalkException(msg.toString());
	}

	/**
	 * Returns the first talk in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching talk, or <code>null</code> if a matching talk could not be found
	 */
	@Override
	public Talk fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Talk> orderByComparator) {
		List<Talk> list = findByUuid_C(uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Talk findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Talk> orderByComparator) throws NoSuchTalkException {
		Talk talk = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (talk != null) {
			return talk;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTalkException(msg.toString());
	}

	/**
	 * Returns the last talk in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching talk, or <code>null</code> if a matching talk could not be found
	 */
	@Override
	public Talk fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Talk> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Talk> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Talk[] findByUuid_C_PrevAndNext(long talkId, String uuid,
		long companyId, OrderByComparator<Talk> orderByComparator)
		throws NoSuchTalkException {
		Talk talk = findByPrimaryKey(talkId);

		Session session = null;

		try {
			session = openSession();

			Talk[] array = new TalkImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, talk, uuid, companyId,
					orderByComparator, true);

			array[1] = talk;

			array[2] = getByUuid_C_PrevAndNext(session, talk, uuid, companyId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Talk getByUuid_C_PrevAndNext(Session session, Talk talk,
		String uuid, long companyId, OrderByComparator<Talk> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_TALK_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(TalkModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(talk);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Talk> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the talks where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Talk talk : findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(talk);
		}
	}

	/**
	 * Returns the number of talks where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching talks
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TALK_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "talk.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "talk.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(talk.uuid IS NULL OR talk.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "talk.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYANDGROUP =
		new FinderPath(TalkModelImpl.ENTITY_CACHE_ENABLED,
			TalkModelImpl.FINDER_CACHE_ENABLED, TalkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyAndGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYANDGROUP =
		new FinderPath(TalkModelImpl.ENTITY_CACHE_ENABLED,
			TalkModelImpl.FINDER_CACHE_ENABLED, TalkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyAndGroup",
			new String[] { Long.class.getName(), Long.class.getName() },
			TalkModelImpl.COMPANYID_COLUMN_BITMASK |
			TalkModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYANDGROUP = new FinderPath(TalkModelImpl.ENTITY_CACHE_ENABLED,
			TalkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCompanyAndGroup",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the talks where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching talks
	 */
	@Override
	public List<Talk> findByCompanyAndGroup(long companyId, long groupId) {
		return findByCompanyAndGroup(companyId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Talk> findByCompanyAndGroup(long companyId, long groupId,
		int start, int end) {
		return findByCompanyAndGroup(companyId, groupId, start, end, null);
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
	@Override
	public List<Talk> findByCompanyAndGroup(long companyId, long groupId,
		int start, int end, OrderByComparator<Talk> orderByComparator) {
		return findByCompanyAndGroup(companyId, groupId, start, end,
			orderByComparator, true);
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
	@Override
	public List<Talk> findByCompanyAndGroup(long companyId, long groupId,
		int start, int end, OrderByComparator<Talk> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYANDGROUP;
			finderArgs = new Object[] { companyId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYANDGROUP;
			finderArgs = new Object[] {
					companyId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<Talk> list = null;

		if (retrieveFromCache) {
			list = (List<Talk>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Talk talk : list) {
					if ((companyId != talk.getCompanyId()) ||
							(groupId != talk.getGroupId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_TALK_WHERE);

			query.append(_FINDER_COLUMN_COMPANYANDGROUP_COMPANYID_2);

			query.append(_FINDER_COLUMN_COMPANYANDGROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TalkModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Talk>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Talk>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Talk findByCompanyAndGroup_First(long companyId, long groupId,
		OrderByComparator<Talk> orderByComparator) throws NoSuchTalkException {
		Talk talk = fetchByCompanyAndGroup_First(companyId, groupId,
				orderByComparator);

		if (talk != null) {
			return talk;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTalkException(msg.toString());
	}

	/**
	 * Returns the first talk in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching talk, or <code>null</code> if a matching talk could not be found
	 */
	@Override
	public Talk fetchByCompanyAndGroup_First(long companyId, long groupId,
		OrderByComparator<Talk> orderByComparator) {
		List<Talk> list = findByCompanyAndGroup(companyId, groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Talk findByCompanyAndGroup_Last(long companyId, long groupId,
		OrderByComparator<Talk> orderByComparator) throws NoSuchTalkException {
		Talk talk = fetchByCompanyAndGroup_Last(companyId, groupId,
				orderByComparator);

		if (talk != null) {
			return talk;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTalkException(msg.toString());
	}

	/**
	 * Returns the last talk in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching talk, or <code>null</code> if a matching talk could not be found
	 */
	@Override
	public Talk fetchByCompanyAndGroup_Last(long companyId, long groupId,
		OrderByComparator<Talk> orderByComparator) {
		int count = countByCompanyAndGroup(companyId, groupId);

		if (count == 0) {
			return null;
		}

		List<Talk> list = findByCompanyAndGroup(companyId, groupId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Talk[] findByCompanyAndGroup_PrevAndNext(long talkId,
		long companyId, long groupId, OrderByComparator<Talk> orderByComparator)
		throws NoSuchTalkException {
		Talk talk = findByPrimaryKey(talkId);

		Session session = null;

		try {
			session = openSession();

			Talk[] array = new TalkImpl[3];

			array[0] = getByCompanyAndGroup_PrevAndNext(session, talk,
					companyId, groupId, orderByComparator, true);

			array[1] = talk;

			array[2] = getByCompanyAndGroup_PrevAndNext(session, talk,
					companyId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Talk getByCompanyAndGroup_PrevAndNext(Session session, Talk talk,
		long companyId, long groupId,
		OrderByComparator<Talk> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_TALK_WHERE);

		query.append(_FINDER_COLUMN_COMPANYANDGROUP_COMPANYID_2);

		query.append(_FINDER_COLUMN_COMPANYANDGROUP_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(TalkModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(talk);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Talk> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the talks that the user has permission to view where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching talks that the user has permission to view
	 */
	@Override
	public List<Talk> filterFindByCompanyAndGroup(long companyId, long groupId) {
		return filterFindByCompanyAndGroup(companyId, groupId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Talk> filterFindByCompanyAndGroup(long companyId, long groupId,
		int start, int end) {
		return filterFindByCompanyAndGroup(companyId, groupId, start, end, null);
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
	@Override
	public List<Talk> filterFindByCompanyAndGroup(long companyId, long groupId,
		int start, int end, OrderByComparator<Talk> orderByComparator) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByCompanyAndGroup(companyId, groupId, start, end,
				orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByFields().length * 2));
		}
		else {
			query = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TALK_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TALK_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_COMPANYANDGROUP_COMPANYID_2);

		query.append(_FINDER_COLUMN_COMPANYANDGROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TALK_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator, true);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(TalkModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TalkModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Talk.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, TalkImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, TalkImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

			qPos.add(groupId);

			return (List<Talk>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
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
	@Override
	public Talk[] filterFindByCompanyAndGroup_PrevAndNext(long talkId,
		long companyId, long groupId, OrderByComparator<Talk> orderByComparator)
		throws NoSuchTalkException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByCompanyAndGroup_PrevAndNext(talkId, companyId,
				groupId, orderByComparator);
		}

		Talk talk = findByPrimaryKey(talkId);

		Session session = null;

		try {
			session = openSession();

			Talk[] array = new TalkImpl[3];

			array[0] = filterGetByCompanyAndGroup_PrevAndNext(session, talk,
					companyId, groupId, orderByComparator, true);

			array[1] = talk;

			array[2] = filterGetByCompanyAndGroup_PrevAndNext(session, talk,
					companyId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Talk filterGetByCompanyAndGroup_PrevAndNext(Session session,
		Talk talk, long companyId, long groupId,
		OrderByComparator<Talk> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TALK_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TALK_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_COMPANYANDGROUP_COMPANYID_2);

		query.append(_FINDER_COLUMN_COMPANYANDGROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TALK_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(TalkModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TalkModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Talk.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		SQLQuery q = session.createSynchronizedSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, TalkImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, TalkImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(talk);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Talk> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the talks where companyId = &#63; and groupId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 */
	@Override
	public void removeByCompanyAndGroup(long companyId, long groupId) {
		for (Talk talk : findByCompanyAndGroup(companyId, groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(talk);
		}
	}

	/**
	 * Returns the number of talks where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching talks
	 */
	@Override
	public int countByCompanyAndGroup(long companyId, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPANYANDGROUP;

		Object[] finderArgs = new Object[] { companyId, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TALK_WHERE);

			query.append(_FINDER_COLUMN_COMPANYANDGROUP_COMPANYID_2);

			query.append(_FINDER_COLUMN_COMPANYANDGROUP_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of talks that the user has permission to view where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching talks that the user has permission to view
	 */
	@Override
	public int filterCountByCompanyAndGroup(long companyId, long groupId) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByCompanyAndGroup(companyId, groupId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_TALK_WHERE);

		query.append(_FINDER_COLUMN_COMPANYANDGROUP_COMPANYID_2);

		query.append(_FINDER_COLUMN_COMPANYANDGROUP_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Talk.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

			qPos.add(groupId);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_COMPANYANDGROUP_COMPANYID_2 = "talk.companyId = ? AND ";
	private static final String _FINDER_COLUMN_COMPANYANDGROUP_GROUPID_2 = "talk.groupId = ?";

	public TalkPersistenceImpl() {
		setModelClass(Talk.class);

		try {
			Field field = ReflectionUtil.getDeclaredField(BasePersistenceImpl.class,
					"_dbColumnNames");

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("uuid", "uuid_");
			dbColumnNames.put("data", "data_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the talk in the entity cache if it is enabled.
	 *
	 * @param talk the talk
	 */
	@Override
	public void cacheResult(Talk talk) {
		entityCache.putResult(TalkModelImpl.ENTITY_CACHE_ENABLED,
			TalkImpl.class, talk.getPrimaryKey(), talk);

		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { talk.getUuid(), talk.getGroupId() }, talk);

		talk.resetOriginalValues();
	}

	/**
	 * Caches the talks in the entity cache if it is enabled.
	 *
	 * @param talks the talks
	 */
	@Override
	public void cacheResult(List<Talk> talks) {
		for (Talk talk : talks) {
			if (entityCache.getResult(TalkModelImpl.ENTITY_CACHE_ENABLED,
						TalkImpl.class, talk.getPrimaryKey()) == null) {
				cacheResult(talk);
			}
			else {
				talk.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all talks.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TalkImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the talk.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Talk talk) {
		entityCache.removeResult(TalkModelImpl.ENTITY_CACHE_ENABLED,
			TalkImpl.class, talk.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((TalkModelImpl)talk, true);
	}

	@Override
	public void clearCache(List<Talk> talks) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Talk talk : talks) {
			entityCache.removeResult(TalkModelImpl.ENTITY_CACHE_ENABLED,
				TalkImpl.class, talk.getPrimaryKey());

			clearUniqueFindersCache((TalkModelImpl)talk, true);
		}
	}

	protected void cacheUniqueFindersCache(TalkModelImpl talkModelImpl) {
		Object[] args = new Object[] {
				talkModelImpl.getUuid(), talkModelImpl.getGroupId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args, talkModelImpl,
			false);
	}

	protected void clearUniqueFindersCache(TalkModelImpl talkModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					talkModelImpl.getUuid(), talkModelImpl.getGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		if ((talkModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					talkModelImpl.getOriginalUuid(),
					talkModelImpl.getOriginalGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new talk with the primary key. Does not add the talk to the database.
	 *
	 * @param talkId the primary key for the new talk
	 * @return the new talk
	 */
	@Override
	public Talk create(long talkId) {
		Talk talk = new TalkImpl();

		talk.setNew(true);
		talk.setPrimaryKey(talkId);

		String uuid = PortalUUIDUtil.generate();

		talk.setUuid(uuid);

		talk.setCompanyId(companyProvider.getCompanyId());

		return talk;
	}

	/**
	 * Removes the talk with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param talkId the primary key of the talk
	 * @return the talk that was removed
	 * @throws NoSuchTalkException if a talk with the primary key could not be found
	 */
	@Override
	public Talk remove(long talkId) throws NoSuchTalkException {
		return remove((Serializable)talkId);
	}

	/**
	 * Removes the talk with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the talk
	 * @return the talk that was removed
	 * @throws NoSuchTalkException if a talk with the primary key could not be found
	 */
	@Override
	public Talk remove(Serializable primaryKey) throws NoSuchTalkException {
		Session session = null;

		try {
			session = openSession();

			Talk talk = (Talk)session.get(TalkImpl.class, primaryKey);

			if (talk == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTalkException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(talk);
		}
		catch (NoSuchTalkException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Talk removeImpl(Talk talk) {
		talk = toUnwrappedModel(talk);

		talkToEventTableMapper.deleteLeftPrimaryKeyTableMappings(talk.getPrimaryKey());

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(talk)) {
				talk = (Talk)session.get(TalkImpl.class, talk.getPrimaryKeyObj());
			}

			if (talk != null) {
				session.delete(talk);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (talk != null) {
			clearCache(talk);
		}

		return talk;
	}

	@Override
	public Talk updateImpl(Talk talk) {
		talk = toUnwrappedModel(talk);

		boolean isNew = talk.isNew();

		TalkModelImpl talkModelImpl = (TalkModelImpl)talk;

		if (Validator.isNull(talk.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			talk.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (talk.getCreateDate() == null)) {
			if (serviceContext == null) {
				talk.setCreateDate(now);
			}
			else {
				talk.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!talkModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				talk.setModifiedDate(now);
			}
			else {
				talk.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (talk.isNew()) {
				session.save(talk);

				talk.setNew(false);
			}
			else {
				talk = (Talk)session.merge(talk);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!TalkModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { talkModelImpl.getUuid() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] {
					talkModelImpl.getUuid(), talkModelImpl.getCompanyId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
				args);

			args = new Object[] {
					talkModelImpl.getCompanyId(), talkModelImpl.getGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_COMPANYANDGROUP, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYANDGROUP,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((talkModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { talkModelImpl.getOriginalUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { talkModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((talkModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						talkModelImpl.getOriginalUuid(),
						talkModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						talkModelImpl.getUuid(), talkModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((talkModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYANDGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						talkModelImpl.getOriginalCompanyId(),
						talkModelImpl.getOriginalGroupId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_COMPANYANDGROUP,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYANDGROUP,
					args);

				args = new Object[] {
						talkModelImpl.getCompanyId(), talkModelImpl.getGroupId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_COMPANYANDGROUP,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYANDGROUP,
					args);
			}
		}

		entityCache.putResult(TalkModelImpl.ENTITY_CACHE_ENABLED,
			TalkImpl.class, talk.getPrimaryKey(), talk, false);

		clearUniqueFindersCache(talkModelImpl, false);
		cacheUniqueFindersCache(talkModelImpl);

		talk.resetOriginalValues();

		return talk;
	}

	protected Talk toUnwrappedModel(Talk talk) {
		if (talk instanceof TalkImpl) {
			return talk;
		}

		TalkImpl talkImpl = new TalkImpl();

		talkImpl.setNew(talk.isNew());
		talkImpl.setPrimaryKey(talk.getPrimaryKey());

		talkImpl.setUuid(talk.getUuid());
		talkImpl.setCompanyId(talk.getCompanyId());
		talkImpl.setGroupId(talk.getGroupId());
		talkImpl.setUserId(talk.getUserId());
		talkImpl.setUserName(talk.getUserName());
		talkImpl.setCreateDate(talk.getCreateDate());
		talkImpl.setModifiedDate(talk.getModifiedDate());
		talkImpl.setTalkId(talk.getTalkId());
		talkImpl.setTitle(talk.getTitle());
		talkImpl.setData(talk.getData());
		talkImpl.setStructureId(talk.getStructureId());
		talkImpl.setTemplateId(talk.getTemplateId());

		return talkImpl;
	}

	/**
	 * Returns the talk with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the talk
	 * @return the talk
	 * @throws NoSuchTalkException if a talk with the primary key could not be found
	 */
	@Override
	public Talk findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTalkException {
		Talk talk = fetchByPrimaryKey(primaryKey);

		if (talk == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTalkException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return talk;
	}

	/**
	 * Returns the talk with the primary key or throws a {@link NoSuchTalkException} if it could not be found.
	 *
	 * @param talkId the primary key of the talk
	 * @return the talk
	 * @throws NoSuchTalkException if a talk with the primary key could not be found
	 */
	@Override
	public Talk findByPrimaryKey(long talkId) throws NoSuchTalkException {
		return findByPrimaryKey((Serializable)talkId);
	}

	/**
	 * Returns the talk with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the talk
	 * @return the talk, or <code>null</code> if a talk with the primary key could not be found
	 */
	@Override
	public Talk fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(TalkModelImpl.ENTITY_CACHE_ENABLED,
				TalkImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Talk talk = (Talk)serializable;

		if (talk == null) {
			Session session = null;

			try {
				session = openSession();

				talk = (Talk)session.get(TalkImpl.class, primaryKey);

				if (talk != null) {
					cacheResult(talk);
				}
				else {
					entityCache.putResult(TalkModelImpl.ENTITY_CACHE_ENABLED,
						TalkImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(TalkModelImpl.ENTITY_CACHE_ENABLED,
					TalkImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return talk;
	}

	/**
	 * Returns the talk with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param talkId the primary key of the talk
	 * @return the talk, or <code>null</code> if a talk with the primary key could not be found
	 */
	@Override
	public Talk fetchByPrimaryKey(long talkId) {
		return fetchByPrimaryKey((Serializable)talkId);
	}

	@Override
	public Map<Serializable, Talk> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Talk> map = new HashMap<Serializable, Talk>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Talk talk = fetchByPrimaryKey(primaryKey);

			if (talk != null) {
				map.put(primaryKey, talk);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(TalkModelImpl.ENTITY_CACHE_ENABLED,
					TalkImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Talk)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_TALK_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (Talk talk : (List<Talk>)q.list()) {
				map.put(talk.getPrimaryKeyObj(), talk);

				cacheResult(talk);

				uncachedPrimaryKeys.remove(talk.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(TalkModelImpl.ENTITY_CACHE_ENABLED,
					TalkImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the talks.
	 *
	 * @return the talks
	 */
	@Override
	public List<Talk> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Talk> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Talk> findAll(int start, int end,
		OrderByComparator<Talk> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Talk> findAll(int start, int end,
		OrderByComparator<Talk> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Talk> list = null;

		if (retrieveFromCache) {
			list = (List<Talk>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_TALK);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TALK;

				if (pagination) {
					sql = sql.concat(TalkModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Talk>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Talk>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the talks from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Talk talk : findAll()) {
			remove(talk);
		}
	}

	/**
	 * Returns the number of talks.
	 *
	 * @return the number of talks
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TALK);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the primaryKeys of events associated with the talk.
	 *
	 * @param pk the primary key of the talk
	 * @return long[] of the primaryKeys of events associated with the talk
	 */
	@Override
	public long[] getEventPrimaryKeys(long pk) {
		long[] pks = talkToEventTableMapper.getRightPrimaryKeys(pk);

		return pks.clone();
	}

	/**
	 * Returns all the events associated with the talk.
	 *
	 * @param pk the primary key of the talk
	 * @return the events associated with the talk
	 */
	@Override
	public List<bg.jug.workshop.liferay.cfp.model.Event> getEvents(long pk) {
		return getEvents(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
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
	@Override
	public List<bg.jug.workshop.liferay.cfp.model.Event> getEvents(long pk,
		int start, int end) {
		return getEvents(pk, start, end, null);
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
	@Override
	public List<bg.jug.workshop.liferay.cfp.model.Event> getEvents(long pk,
		int start, int end,
		OrderByComparator<bg.jug.workshop.liferay.cfp.model.Event> orderByComparator) {
		return talkToEventTableMapper.getRightBaseModels(pk, start, end,
			orderByComparator);
	}

	/**
	 * Returns the number of events associated with the talk.
	 *
	 * @param pk the primary key of the talk
	 * @return the number of events associated with the talk
	 */
	@Override
	public int getEventsSize(long pk) {
		long[] pks = talkToEventTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the event is associated with the talk.
	 *
	 * @param pk the primary key of the talk
	 * @param eventPK the primary key of the event
	 * @return <code>true</code> if the event is associated with the talk; <code>false</code> otherwise
	 */
	@Override
	public boolean containsEvent(long pk, long eventPK) {
		return talkToEventTableMapper.containsTableMapping(pk, eventPK);
	}

	/**
	 * Returns <code>true</code> if the talk has any events associated with it.
	 *
	 * @param pk the primary key of the talk to check for associations with events
	 * @return <code>true</code> if the talk has any events associated with it; <code>false</code> otherwise
	 */
	@Override
	public boolean containsEvents(long pk) {
		if (getEventsSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the talk and the event. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the talk
	 * @param eventPK the primary key of the event
	 */
	@Override
	public void addEvent(long pk, long eventPK) {
		Talk talk = fetchByPrimaryKey(pk);

		if (talk == null) {
			talkToEventTableMapper.addTableMapping(companyProvider.getCompanyId(),
				pk, eventPK);
		}
		else {
			talkToEventTableMapper.addTableMapping(talk.getCompanyId(), pk,
				eventPK);
		}
	}

	/**
	 * Adds an association between the talk and the event. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the talk
	 * @param event the event
	 */
	@Override
	public void addEvent(long pk, bg.jug.workshop.liferay.cfp.model.Event event) {
		Talk talk = fetchByPrimaryKey(pk);

		if (talk == null) {
			talkToEventTableMapper.addTableMapping(companyProvider.getCompanyId(),
				pk, event.getPrimaryKey());
		}
		else {
			talkToEventTableMapper.addTableMapping(talk.getCompanyId(), pk,
				event.getPrimaryKey());
		}
	}

	/**
	 * Adds an association between the talk and the events. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the talk
	 * @param eventPKs the primary keys of the events
	 */
	@Override
	public void addEvents(long pk, long[] eventPKs) {
		long companyId = 0;

		Talk talk = fetchByPrimaryKey(pk);

		if (talk == null) {
			companyId = companyProvider.getCompanyId();
		}
		else {
			companyId = talk.getCompanyId();
		}

		talkToEventTableMapper.addTableMappings(companyId, pk, eventPKs);
	}

	/**
	 * Adds an association between the talk and the events. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the talk
	 * @param events the events
	 */
	@Override
	public void addEvents(long pk,
		List<bg.jug.workshop.liferay.cfp.model.Event> events) {
		addEvents(pk,
			ListUtil.toLongArray(events,
				bg.jug.workshop.liferay.cfp.model.Event.EVENT_ID_ACCESSOR));
	}

	/**
	 * Clears all associations between the talk and its events. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the talk to clear the associated events from
	 */
	@Override
	public void clearEvents(long pk) {
		talkToEventTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the talk and the event. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the talk
	 * @param eventPK the primary key of the event
	 */
	@Override
	public void removeEvent(long pk, long eventPK) {
		talkToEventTableMapper.deleteTableMapping(pk, eventPK);
	}

	/**
	 * Removes the association between the talk and the event. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the talk
	 * @param event the event
	 */
	@Override
	public void removeEvent(long pk,
		bg.jug.workshop.liferay.cfp.model.Event event) {
		talkToEventTableMapper.deleteTableMapping(pk, event.getPrimaryKey());
	}

	/**
	 * Removes the association between the talk and the events. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the talk
	 * @param eventPKs the primary keys of the events
	 */
	@Override
	public void removeEvents(long pk, long[] eventPKs) {
		talkToEventTableMapper.deleteTableMappings(pk, eventPKs);
	}

	/**
	 * Removes the association between the talk and the events. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the talk
	 * @param events the events
	 */
	@Override
	public void removeEvents(long pk,
		List<bg.jug.workshop.liferay.cfp.model.Event> events) {
		removeEvents(pk,
			ListUtil.toLongArray(events,
				bg.jug.workshop.liferay.cfp.model.Event.EVENT_ID_ACCESSOR));
	}

	/**
	 * Sets the events associated with the talk, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the talk
	 * @param eventPKs the primary keys of the events to be associated with the talk
	 */
	@Override
	public void setEvents(long pk, long[] eventPKs) {
		Set<Long> newEventPKsSet = SetUtil.fromArray(eventPKs);
		Set<Long> oldEventPKsSet = SetUtil.fromArray(talkToEventTableMapper.getRightPrimaryKeys(
					pk));

		Set<Long> removeEventPKsSet = new HashSet<Long>(oldEventPKsSet);

		removeEventPKsSet.removeAll(newEventPKsSet);

		talkToEventTableMapper.deleteTableMappings(pk,
			ArrayUtil.toLongArray(removeEventPKsSet));

		newEventPKsSet.removeAll(oldEventPKsSet);

		long companyId = 0;

		Talk talk = fetchByPrimaryKey(pk);

		if (talk == null) {
			companyId = companyProvider.getCompanyId();
		}
		else {
			companyId = talk.getCompanyId();
		}

		talkToEventTableMapper.addTableMappings(companyId, pk,
			ArrayUtil.toLongArray(newEventPKsSet));
	}

	/**
	 * Sets the events associated with the talk, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the talk
	 * @param events the events to be associated with the talk
	 */
	@Override
	public void setEvents(long pk,
		List<bg.jug.workshop.liferay.cfp.model.Event> events) {
		try {
			long[] eventPKs = new long[events.size()];

			for (int i = 0; i < events.size(); i++) {
				bg.jug.workshop.liferay.cfp.model.Event event = events.get(i);

				eventPKs[i] = event.getPrimaryKey();
			}

			setEvents(pk, eventPKs);
		}
		catch (Exception e) {
			throw processException(e);
		}
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TalkModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the talk persistence.
	 */
	public void afterPropertiesSet() {
		talkToEventTableMapper = TableMapperFactory.getTableMapper("CFP_Talk_Event",
				"companyId", "talkId", "eventId", this, eventPersistence);
	}

	public void destroy() {
		entityCache.removeCache(TalkImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		TableMapperFactory.removeTableMapper("CFP_Talk_Event");
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	@BeanReference(type = EventPersistence.class)
	protected EventPersistence eventPersistence;
	protected TableMapper<Talk, bg.jug.workshop.liferay.cfp.model.Event> talkToEventTableMapper;
	private static final String _SQL_SELECT_TALK = "SELECT talk FROM Talk talk";
	private static final String _SQL_SELECT_TALK_WHERE_PKS_IN = "SELECT talk FROM Talk talk WHERE talkId IN (";
	private static final String _SQL_SELECT_TALK_WHERE = "SELECT talk FROM Talk talk WHERE ";
	private static final String _SQL_COUNT_TALK = "SELECT COUNT(talk) FROM Talk talk";
	private static final String _SQL_COUNT_TALK_WHERE = "SELECT COUNT(talk) FROM Talk talk WHERE ";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "talk.talkId";
	private static final String _FILTER_SQL_SELECT_TALK_WHERE = "SELECT DISTINCT {talk.*} FROM CFP_Talk talk WHERE ";
	private static final String _FILTER_SQL_SELECT_TALK_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {CFP_Talk.*} FROM (SELECT DISTINCT talk.talkId FROM CFP_Talk talk WHERE ";
	private static final String _FILTER_SQL_SELECT_TALK_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN CFP_Talk ON TEMP_TABLE.talkId = CFP_Talk.talkId";
	private static final String _FILTER_SQL_COUNT_TALK_WHERE = "SELECT COUNT(DISTINCT talk.talkId) AS COUNT_VALUE FROM CFP_Talk talk WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "talk";
	private static final String _FILTER_ENTITY_TABLE = "CFP_Talk";
	private static final String _ORDER_BY_ENTITY_ALIAS = "talk.";
	private static final String _ORDER_BY_ENTITY_TABLE = "CFP_Talk.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Talk exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Talk exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(TalkPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "data"
			});
}