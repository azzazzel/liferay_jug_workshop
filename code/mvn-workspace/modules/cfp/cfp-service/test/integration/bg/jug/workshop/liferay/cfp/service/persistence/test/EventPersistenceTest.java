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

package bg.jug.workshop.liferay.cfp.service.persistence.test;

import bg.jug.workshop.liferay.cfp.exception.NoSuchEventException;
import bg.jug.workshop.liferay.cfp.model.Event;
import bg.jug.workshop.liferay.cfp.service.EventLocalServiceUtil;
import bg.jug.workshop.liferay.cfp.service.persistence.EventPersistence;
import bg.jug.workshop.liferay.cfp.service.persistence.EventUtil;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.ReflectionTestUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import org.junit.runner.RunWith;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class EventPersistenceTest {
	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule = new AggregateTestRule(new LiferayIntegrationTestRule(),
			PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED,
				"bg.jug.workshop.liferay.cfp.service"));

	@Before
	public void setUp() {
		_persistence = EventUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Event> iterator = _events.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Event event = _persistence.create(pk);

		Assert.assertNotNull(event);

		Assert.assertEquals(event.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Event newEvent = addEvent();

		_persistence.remove(newEvent);

		Event existingEvent = _persistence.fetchByPrimaryKey(newEvent.getPrimaryKey());

		Assert.assertNull(existingEvent);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addEvent();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Event newEvent = _persistence.create(pk);

		newEvent.setUuid(RandomTestUtil.randomString());

		newEvent.setCompanyId(RandomTestUtil.nextLong());

		newEvent.setGroupId(RandomTestUtil.nextLong());

		newEvent.setUserId(RandomTestUtil.nextLong());

		newEvent.setUserName(RandomTestUtil.randomString());

		newEvent.setCreateDate(RandomTestUtil.nextDate());

		newEvent.setModifiedDate(RandomTestUtil.nextDate());

		newEvent.setName(RandomTestUtil.randomString());

		newEvent.setDate(RandomTestUtil.nextDate());

		newEvent.setWebsite(RandomTestUtil.randomString());

		newEvent.setVenueId(RandomTestUtil.nextLong());

		newEvent.setCalendarBookingId(RandomTestUtil.nextLong());

		_events.add(_persistence.update(newEvent));

		Event existingEvent = _persistence.findByPrimaryKey(newEvent.getPrimaryKey());

		Assert.assertEquals(existingEvent.getUuid(), newEvent.getUuid());
		Assert.assertEquals(existingEvent.getCompanyId(),
			newEvent.getCompanyId());
		Assert.assertEquals(existingEvent.getGroupId(), newEvent.getGroupId());
		Assert.assertEquals(existingEvent.getUserId(), newEvent.getUserId());
		Assert.assertEquals(existingEvent.getUserName(), newEvent.getUserName());
		Assert.assertEquals(Time.getShortTimestamp(
				existingEvent.getCreateDate()),
			Time.getShortTimestamp(newEvent.getCreateDate()));
		Assert.assertEquals(Time.getShortTimestamp(
				existingEvent.getModifiedDate()),
			Time.getShortTimestamp(newEvent.getModifiedDate()));
		Assert.assertEquals(existingEvent.getEventId(), newEvent.getEventId());
		Assert.assertEquals(existingEvent.getName(), newEvent.getName());
		Assert.assertEquals(Time.getShortTimestamp(existingEvent.getDate()),
			Time.getShortTimestamp(newEvent.getDate()));
		Assert.assertEquals(existingEvent.getWebsite(), newEvent.getWebsite());
		Assert.assertEquals(existingEvent.getVenueId(), newEvent.getVenueId());
		Assert.assertEquals(existingEvent.getCalendarBookingId(),
			newEvent.getCalendarBookingId());
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid(StringPool.BLANK);

		_persistence.countByUuid(StringPool.NULL);

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountByUUID_G() throws Exception {
		_persistence.countByUUID_G(StringPool.BLANK, RandomTestUtil.nextLong());

		_persistence.countByUUID_G(StringPool.NULL, 0L);

		_persistence.countByUUID_G((String)null, 0L);
	}

	@Test
	public void testCountByUuid_C() throws Exception {
		_persistence.countByUuid_C(StringPool.BLANK, RandomTestUtil.nextLong());

		_persistence.countByUuid_C(StringPool.NULL, 0L);

		_persistence.countByUuid_C((String)null, 0L);
	}

	@Test
	public void testCountByCompanyAndGroup() throws Exception {
		_persistence.countByCompanyAndGroup(RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong());

		_persistence.countByCompanyAndGroup(0L, 0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Event newEvent = addEvent();

		Event existingEvent = _persistence.findByPrimaryKey(newEvent.getPrimaryKey());

		Assert.assertEquals(existingEvent, newEvent);
	}

	@Test(expected = NoSuchEventException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			getOrderByComparator());
	}

	protected OrderByComparator<Event> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create("CFP_Event", "uuid", true,
			"companyId", true, "groupId", true, "userId", true, "userName",
			true, "createDate", true, "modifiedDate", true, "eventId", true,
			"name", true, "date", true, "website", true, "venueId", true,
			"calendarBookingId", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Event newEvent = addEvent();

		Event existingEvent = _persistence.fetchByPrimaryKey(newEvent.getPrimaryKey());

		Assert.assertEquals(existingEvent, newEvent);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Event missingEvent = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingEvent);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {
		Event newEvent1 = addEvent();
		Event newEvent2 = addEvent();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEvent1.getPrimaryKey());
		primaryKeys.add(newEvent2.getPrimaryKey());

		Map<Serializable, Event> events = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, events.size());
		Assert.assertEquals(newEvent1, events.get(newEvent1.getPrimaryKey()));
		Assert.assertEquals(newEvent2, events.get(newEvent2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {
		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Event> events = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(events.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {
		Event newEvent = addEvent();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEvent.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Event> events = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, events.size());
		Assert.assertEquals(newEvent, events.get(newEvent.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys()
		throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Event> events = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(events.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey()
		throws Exception {
		Event newEvent = addEvent();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEvent.getPrimaryKey());

		Map<Serializable, Event> events = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, events.size());
		Assert.assertEquals(newEvent, events.get(newEvent.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery = EventLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<Event>() {
				@Override
				public void performAction(Event event) {
					Assert.assertNotNull(event);

					count.increment();
				}
			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		Event newEvent = addEvent();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Event.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("eventId",
				newEvent.getEventId()));

		List<Event> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Event existingEvent = result.get(0);

		Assert.assertEquals(existingEvent, newEvent);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Event.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("eventId",
				RandomTestUtil.nextLong()));

		List<Event> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting()
		throws Exception {
		Event newEvent = addEvent();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Event.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("eventId"));

		Object newEventId = newEvent.getEventId();

		dynamicQuery.add(RestrictionsFactoryUtil.in("eventId",
				new Object[] { newEventId }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingEventId = result.get(0);

		Assert.assertEquals(existingEventId, newEventId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Event.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("eventId"));

		dynamicQuery.add(RestrictionsFactoryUtil.in("eventId",
				new Object[] { RandomTestUtil.nextLong() }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		Event newEvent = addEvent();

		_persistence.clearCache();

		Event existingEvent = _persistence.findByPrimaryKey(newEvent.getPrimaryKey());

		Assert.assertTrue(Objects.equals(existingEvent.getUuid(),
				ReflectionTestUtil.invoke(existingEvent, "getOriginalUuid",
					new Class<?>[0])));
		Assert.assertEquals(Long.valueOf(existingEvent.getGroupId()),
			ReflectionTestUtil.<Long>invoke(existingEvent,
				"getOriginalGroupId", new Class<?>[0]));
	}

	protected Event addEvent() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Event event = _persistence.create(pk);

		event.setUuid(RandomTestUtil.randomString());

		event.setCompanyId(RandomTestUtil.nextLong());

		event.setGroupId(RandomTestUtil.nextLong());

		event.setUserId(RandomTestUtil.nextLong());

		event.setUserName(RandomTestUtil.randomString());

		event.setCreateDate(RandomTestUtil.nextDate());

		event.setModifiedDate(RandomTestUtil.nextDate());

		event.setName(RandomTestUtil.randomString());

		event.setDate(RandomTestUtil.nextDate());

		event.setWebsite(RandomTestUtil.randomString());

		event.setVenueId(RandomTestUtil.nextLong());

		event.setCalendarBookingId(RandomTestUtil.nextLong());

		_events.add(_persistence.update(event));

		return event;
	}

	private List<Event> _events = new ArrayList<Event>();
	private EventPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;
}