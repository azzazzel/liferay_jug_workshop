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

import bg.jug.workshop.liferay.cfp.exception.NoSuchTalkException;
import bg.jug.workshop.liferay.cfp.model.Talk;
import bg.jug.workshop.liferay.cfp.service.TalkLocalServiceUtil;
import bg.jug.workshop.liferay.cfp.service.persistence.TalkPersistence;
import bg.jug.workshop.liferay.cfp.service.persistence.TalkUtil;

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
public class TalkPersistenceTest {
	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule = new AggregateTestRule(new LiferayIntegrationTestRule(),
			PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED,
				"bg.jug.workshop.liferay.cfp.service"));

	@Before
	public void setUp() {
		_persistence = TalkUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Talk> iterator = _talks.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Talk talk = _persistence.create(pk);

		Assert.assertNotNull(talk);

		Assert.assertEquals(talk.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Talk newTalk = addTalk();

		_persistence.remove(newTalk);

		Talk existingTalk = _persistence.fetchByPrimaryKey(newTalk.getPrimaryKey());

		Assert.assertNull(existingTalk);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addTalk();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Talk newTalk = _persistence.create(pk);

		newTalk.setUuid(RandomTestUtil.randomString());

		newTalk.setCompanyId(RandomTestUtil.nextLong());

		newTalk.setGroupId(RandomTestUtil.nextLong());

		newTalk.setUserId(RandomTestUtil.nextLong());

		newTalk.setUserName(RandomTestUtil.randomString());

		newTalk.setCreateDate(RandomTestUtil.nextDate());

		newTalk.setModifiedDate(RandomTestUtil.nextDate());

		newTalk.setTitle(RandomTestUtil.randomString());

		newTalk.setData(RandomTestUtil.randomString());

		newTalk.setStructureId(RandomTestUtil.nextLong());

		newTalk.setTemplateId(RandomTestUtil.nextLong());

		_talks.add(_persistence.update(newTalk));

		Talk existingTalk = _persistence.findByPrimaryKey(newTalk.getPrimaryKey());

		Assert.assertEquals(existingTalk.getUuid(), newTalk.getUuid());
		Assert.assertEquals(existingTalk.getCompanyId(), newTalk.getCompanyId());
		Assert.assertEquals(existingTalk.getGroupId(), newTalk.getGroupId());
		Assert.assertEquals(existingTalk.getUserId(), newTalk.getUserId());
		Assert.assertEquals(existingTalk.getUserName(), newTalk.getUserName());
		Assert.assertEquals(Time.getShortTimestamp(existingTalk.getCreateDate()),
			Time.getShortTimestamp(newTalk.getCreateDate()));
		Assert.assertEquals(Time.getShortTimestamp(
				existingTalk.getModifiedDate()),
			Time.getShortTimestamp(newTalk.getModifiedDate()));
		Assert.assertEquals(existingTalk.getTalkId(), newTalk.getTalkId());
		Assert.assertEquals(existingTalk.getTitle(), newTalk.getTitle());
		Assert.assertEquals(existingTalk.getData(), newTalk.getData());
		Assert.assertEquals(existingTalk.getStructureId(),
			newTalk.getStructureId());
		Assert.assertEquals(existingTalk.getTemplateId(),
			newTalk.getTemplateId());
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
		Talk newTalk = addTalk();

		Talk existingTalk = _persistence.findByPrimaryKey(newTalk.getPrimaryKey());

		Assert.assertEquals(existingTalk, newTalk);
	}

	@Test(expected = NoSuchTalkException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			getOrderByComparator());
	}

	protected OrderByComparator<Talk> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create("CFP_Talk", "uuid", true,
			"companyId", true, "groupId", true, "userId", true, "userName",
			true, "createDate", true, "modifiedDate", true, "talkId", true,
			"title", true, "structureId", true, "templateId", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Talk newTalk = addTalk();

		Talk existingTalk = _persistence.fetchByPrimaryKey(newTalk.getPrimaryKey());

		Assert.assertEquals(existingTalk, newTalk);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Talk missingTalk = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingTalk);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {
		Talk newTalk1 = addTalk();
		Talk newTalk2 = addTalk();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newTalk1.getPrimaryKey());
		primaryKeys.add(newTalk2.getPrimaryKey());

		Map<Serializable, Talk> talks = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, talks.size());
		Assert.assertEquals(newTalk1, talks.get(newTalk1.getPrimaryKey()));
		Assert.assertEquals(newTalk2, talks.get(newTalk2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {
		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Talk> talks = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(talks.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {
		Talk newTalk = addTalk();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newTalk.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Talk> talks = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, talks.size());
		Assert.assertEquals(newTalk, talks.get(newTalk.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys()
		throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Talk> talks = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(talks.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey()
		throws Exception {
		Talk newTalk = addTalk();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newTalk.getPrimaryKey());

		Map<Serializable, Talk> talks = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, talks.size());
		Assert.assertEquals(newTalk, talks.get(newTalk.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery = TalkLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<Talk>() {
				@Override
				public void performAction(Talk talk) {
					Assert.assertNotNull(talk);

					count.increment();
				}
			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		Talk newTalk = addTalk();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Talk.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("talkId",
				newTalk.getTalkId()));

		List<Talk> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Talk existingTalk = result.get(0);

		Assert.assertEquals(existingTalk, newTalk);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Talk.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("talkId",
				RandomTestUtil.nextLong()));

		List<Talk> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting()
		throws Exception {
		Talk newTalk = addTalk();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Talk.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("talkId"));

		Object newTalkId = newTalk.getTalkId();

		dynamicQuery.add(RestrictionsFactoryUtil.in("talkId",
				new Object[] { newTalkId }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingTalkId = result.get(0);

		Assert.assertEquals(existingTalkId, newTalkId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Talk.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("talkId"));

		dynamicQuery.add(RestrictionsFactoryUtil.in("talkId",
				new Object[] { RandomTestUtil.nextLong() }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		Talk newTalk = addTalk();

		_persistence.clearCache();

		Talk existingTalk = _persistence.findByPrimaryKey(newTalk.getPrimaryKey());

		Assert.assertTrue(Objects.equals(existingTalk.getUuid(),
				ReflectionTestUtil.invoke(existingTalk, "getOriginalUuid",
					new Class<?>[0])));
		Assert.assertEquals(Long.valueOf(existingTalk.getGroupId()),
			ReflectionTestUtil.<Long>invoke(existingTalk, "getOriginalGroupId",
				new Class<?>[0]));
	}

	protected Talk addTalk() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Talk talk = _persistence.create(pk);

		talk.setUuid(RandomTestUtil.randomString());

		talk.setCompanyId(RandomTestUtil.nextLong());

		talk.setGroupId(RandomTestUtil.nextLong());

		talk.setUserId(RandomTestUtil.nextLong());

		talk.setUserName(RandomTestUtil.randomString());

		talk.setCreateDate(RandomTestUtil.nextDate());

		talk.setModifiedDate(RandomTestUtil.nextDate());

		talk.setTitle(RandomTestUtil.randomString());

		talk.setData(RandomTestUtil.randomString());

		talk.setStructureId(RandomTestUtil.nextLong());

		talk.setTemplateId(RandomTestUtil.nextLong());

		_talks.add(_persistence.update(talk));

		return talk;
	}

	private List<Talk> _talks = new ArrayList<Talk>();
	private TalkPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;
}