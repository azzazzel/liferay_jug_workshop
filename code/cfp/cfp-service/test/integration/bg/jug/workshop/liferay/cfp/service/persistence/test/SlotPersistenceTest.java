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

import bg.jug.workshop.liferay.cfp.exception.NoSuchSlotException;
import bg.jug.workshop.liferay.cfp.model.Slot;
import bg.jug.workshop.liferay.cfp.service.SlotLocalServiceUtil;
import bg.jug.workshop.liferay.cfp.service.persistence.SlotPersistence;
import bg.jug.workshop.liferay.cfp.service.persistence.SlotUtil;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
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
import java.util.Set;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class SlotPersistenceTest {
	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule = new AggregateTestRule(new LiferayIntegrationTestRule(),
			PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED,
				"bg.jug.workshop.liferay.cfp.service"));

	@Before
	public void setUp() {
		_persistence = SlotUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Slot> iterator = _slots.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Slot slot = _persistence.create(pk);

		Assert.assertNotNull(slot);

		Assert.assertEquals(slot.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Slot newSlot = addSlot();

		_persistence.remove(newSlot);

		Slot existingSlot = _persistence.fetchByPrimaryKey(newSlot.getPrimaryKey());

		Assert.assertNull(existingSlot);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addSlot();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Slot newSlot = _persistence.create(pk);

		newSlot.setGroupId(RandomTestUtil.nextLong());

		newSlot.setCompanyId(RandomTestUtil.nextLong());

		newSlot.setUserId(RandomTestUtil.nextLong());

		newSlot.setUserName(RandomTestUtil.randomString());

		newSlot.setCreateDate(RandomTestUtil.nextDate());

		newSlot.setModifiedDate(RandomTestUtil.nextDate());

		newSlot.setName(RandomTestUtil.randomString());

		newSlot.setOrder(RandomTestUtil.nextInt());

		newSlot.setEventId(RandomTestUtil.nextLong());

		newSlot.setTalkId(RandomTestUtil.nextLong());

		_slots.add(_persistence.update(newSlot));

		Slot existingSlot = _persistence.findByPrimaryKey(newSlot.getPrimaryKey());

		Assert.assertEquals(existingSlot.getSlotId(), newSlot.getSlotId());
		Assert.assertEquals(existingSlot.getGroupId(), newSlot.getGroupId());
		Assert.assertEquals(existingSlot.getCompanyId(), newSlot.getCompanyId());
		Assert.assertEquals(existingSlot.getUserId(), newSlot.getUserId());
		Assert.assertEquals(existingSlot.getUserName(), newSlot.getUserName());
		Assert.assertEquals(Time.getShortTimestamp(existingSlot.getCreateDate()),
			Time.getShortTimestamp(newSlot.getCreateDate()));
		Assert.assertEquals(Time.getShortTimestamp(
				existingSlot.getModifiedDate()),
			Time.getShortTimestamp(newSlot.getModifiedDate()));
		Assert.assertEquals(existingSlot.getName(), newSlot.getName());
		Assert.assertEquals(existingSlot.getOrder(), newSlot.getOrder());
		Assert.assertEquals(existingSlot.getEventId(), newSlot.getEventId());
		Assert.assertEquals(existingSlot.getTalkId(), newSlot.getTalkId());
	}

	@Test
	public void testCountByEvent() throws Exception {
		_persistence.countByEvent(RandomTestUtil.nextLong());

		_persistence.countByEvent(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Slot newSlot = addSlot();

		Slot existingSlot = _persistence.findByPrimaryKey(newSlot.getPrimaryKey());

		Assert.assertEquals(existingSlot, newSlot);
	}

	@Test(expected = NoSuchSlotException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			getOrderByComparator());
	}

	protected OrderByComparator<Slot> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create("CFP_Slot", "slotId", true,
			"groupId", true, "companyId", true, "userId", true, "userName",
			true, "createDate", true, "modifiedDate", true, "name", true,
			"order", true, "eventId", true, "talkId", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Slot newSlot = addSlot();

		Slot existingSlot = _persistence.fetchByPrimaryKey(newSlot.getPrimaryKey());

		Assert.assertEquals(existingSlot, newSlot);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Slot missingSlot = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingSlot);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {
		Slot newSlot1 = addSlot();
		Slot newSlot2 = addSlot();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSlot1.getPrimaryKey());
		primaryKeys.add(newSlot2.getPrimaryKey());

		Map<Serializable, Slot> slots = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, slots.size());
		Assert.assertEquals(newSlot1, slots.get(newSlot1.getPrimaryKey()));
		Assert.assertEquals(newSlot2, slots.get(newSlot2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {
		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Slot> slots = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(slots.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {
		Slot newSlot = addSlot();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSlot.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Slot> slots = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, slots.size());
		Assert.assertEquals(newSlot, slots.get(newSlot.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys()
		throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Slot> slots = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(slots.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey()
		throws Exception {
		Slot newSlot = addSlot();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSlot.getPrimaryKey());

		Map<Serializable, Slot> slots = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, slots.size());
		Assert.assertEquals(newSlot, slots.get(newSlot.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery = SlotLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<Slot>() {
				@Override
				public void performAction(Slot slot) {
					Assert.assertNotNull(slot);

					count.increment();
				}
			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		Slot newSlot = addSlot();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Slot.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("slotId",
				newSlot.getSlotId()));

		List<Slot> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Slot existingSlot = result.get(0);

		Assert.assertEquals(existingSlot, newSlot);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Slot.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("slotId",
				RandomTestUtil.nextLong()));

		List<Slot> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting()
		throws Exception {
		Slot newSlot = addSlot();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Slot.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("slotId"));

		Object newSlotId = newSlot.getSlotId();

		dynamicQuery.add(RestrictionsFactoryUtil.in("slotId",
				new Object[] { newSlotId }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingSlotId = result.get(0);

		Assert.assertEquals(existingSlotId, newSlotId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Slot.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("slotId"));

		dynamicQuery.add(RestrictionsFactoryUtil.in("slotId",
				new Object[] { RandomTestUtil.nextLong() }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Slot addSlot() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Slot slot = _persistence.create(pk);

		slot.setGroupId(RandomTestUtil.nextLong());

		slot.setCompanyId(RandomTestUtil.nextLong());

		slot.setUserId(RandomTestUtil.nextLong());

		slot.setUserName(RandomTestUtil.randomString());

		slot.setCreateDate(RandomTestUtil.nextDate());

		slot.setModifiedDate(RandomTestUtil.nextDate());

		slot.setName(RandomTestUtil.randomString());

		slot.setOrder(RandomTestUtil.nextInt());

		slot.setEventId(RandomTestUtil.nextLong());

		slot.setTalkId(RandomTestUtil.nextLong());

		_slots.add(_persistence.update(slot));

		return slot;
	}

	private List<Slot> _slots = new ArrayList<Slot>();
	private SlotPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;
}