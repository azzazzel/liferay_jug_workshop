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

import bg.jug.workshop.liferay.cfp.exception.NoSuchSpeakerException;
import bg.jug.workshop.liferay.cfp.model.Speaker;
import bg.jug.workshop.liferay.cfp.service.SpeakerLocalServiceUtil;
import bg.jug.workshop.liferay.cfp.service.persistence.SpeakerPersistence;
import bg.jug.workshop.liferay.cfp.service.persistence.SpeakerUtil;

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
public class SpeakerPersistenceTest {
	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule = new AggregateTestRule(new LiferayIntegrationTestRule(),
			PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED,
				"bg.jug.workshop.liferay.cfp.service"));

	@Before
	public void setUp() {
		_persistence = SpeakerUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Speaker> iterator = _speakers.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Speaker speaker = _persistence.create(pk);

		Assert.assertNotNull(speaker);

		Assert.assertEquals(speaker.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Speaker newSpeaker = addSpeaker();

		_persistence.remove(newSpeaker);

		Speaker existingSpeaker = _persistence.fetchByPrimaryKey(newSpeaker.getPrimaryKey());

		Assert.assertNull(existingSpeaker);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addSpeaker();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Speaker newSpeaker = _persistence.create(pk);

		newSpeaker.setUuid(RandomTestUtil.randomString());

		newSpeaker.setCompanyId(RandomTestUtil.nextLong());

		newSpeaker.setGroupId(RandomTestUtil.nextLong());

		newSpeaker.setUserId(RandomTestUtil.nextLong());

		newSpeaker.setUserName(RandomTestUtil.randomString());

		newSpeaker.setCreateDate(RandomTestUtil.nextDate());

		newSpeaker.setModifiedDate(RandomTestUtil.nextDate());

		newSpeaker.setName(RandomTestUtil.randomString());

		newSpeaker.setEmail(RandomTestUtil.randomString());

		newSpeaker.setBio(RandomTestUtil.randomString());

		_speakers.add(_persistence.update(newSpeaker));

		Speaker existingSpeaker = _persistence.findByPrimaryKey(newSpeaker.getPrimaryKey());

		Assert.assertEquals(existingSpeaker.getUuid(), newSpeaker.getUuid());
		Assert.assertEquals(existingSpeaker.getCompanyId(),
			newSpeaker.getCompanyId());
		Assert.assertEquals(existingSpeaker.getGroupId(),
			newSpeaker.getGroupId());
		Assert.assertEquals(existingSpeaker.getUserId(), newSpeaker.getUserId());
		Assert.assertEquals(existingSpeaker.getUserName(),
			newSpeaker.getUserName());
		Assert.assertEquals(Time.getShortTimestamp(
				existingSpeaker.getCreateDate()),
			Time.getShortTimestamp(newSpeaker.getCreateDate()));
		Assert.assertEquals(Time.getShortTimestamp(
				existingSpeaker.getModifiedDate()),
			Time.getShortTimestamp(newSpeaker.getModifiedDate()));
		Assert.assertEquals(existingSpeaker.getSpeakerId(),
			newSpeaker.getSpeakerId());
		Assert.assertEquals(existingSpeaker.getName(), newSpeaker.getName());
		Assert.assertEquals(existingSpeaker.getEmail(), newSpeaker.getEmail());
		Assert.assertEquals(existingSpeaker.getBio(), newSpeaker.getBio());
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
	public void testCountByEmail() throws Exception {
		_persistence.countByEmail(RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong(), StringPool.BLANK);

		_persistence.countByEmail(0L, 0L, StringPool.NULL);

		_persistence.countByEmail(0L, 0L, (String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Speaker newSpeaker = addSpeaker();

		Speaker existingSpeaker = _persistence.findByPrimaryKey(newSpeaker.getPrimaryKey());

		Assert.assertEquals(existingSpeaker, newSpeaker);
	}

	@Test(expected = NoSuchSpeakerException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			getOrderByComparator());
	}

	protected OrderByComparator<Speaker> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create("CFP_Speaker", "uuid", true,
			"companyId", true, "groupId", true, "userId", true, "userName",
			true, "createDate", true, "modifiedDate", true, "speakerId", true,
			"name", true, "email", true, "bio", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Speaker newSpeaker = addSpeaker();

		Speaker existingSpeaker = _persistence.fetchByPrimaryKey(newSpeaker.getPrimaryKey());

		Assert.assertEquals(existingSpeaker, newSpeaker);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Speaker missingSpeaker = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingSpeaker);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {
		Speaker newSpeaker1 = addSpeaker();
		Speaker newSpeaker2 = addSpeaker();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSpeaker1.getPrimaryKey());
		primaryKeys.add(newSpeaker2.getPrimaryKey());

		Map<Serializable, Speaker> speakers = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, speakers.size());
		Assert.assertEquals(newSpeaker1,
			speakers.get(newSpeaker1.getPrimaryKey()));
		Assert.assertEquals(newSpeaker2,
			speakers.get(newSpeaker2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {
		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Speaker> speakers = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(speakers.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {
		Speaker newSpeaker = addSpeaker();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSpeaker.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Speaker> speakers = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, speakers.size());
		Assert.assertEquals(newSpeaker, speakers.get(newSpeaker.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys()
		throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Speaker> speakers = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(speakers.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey()
		throws Exception {
		Speaker newSpeaker = addSpeaker();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSpeaker.getPrimaryKey());

		Map<Serializable, Speaker> speakers = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, speakers.size());
		Assert.assertEquals(newSpeaker, speakers.get(newSpeaker.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery = SpeakerLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<Speaker>() {
				@Override
				public void performAction(Speaker speaker) {
					Assert.assertNotNull(speaker);

					count.increment();
				}
			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		Speaker newSpeaker = addSpeaker();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Speaker.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("speakerId",
				newSpeaker.getSpeakerId()));

		List<Speaker> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Speaker existingSpeaker = result.get(0);

		Assert.assertEquals(existingSpeaker, newSpeaker);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Speaker.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("speakerId",
				RandomTestUtil.nextLong()));

		List<Speaker> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting()
		throws Exception {
		Speaker newSpeaker = addSpeaker();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Speaker.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("speakerId"));

		Object newSpeakerId = newSpeaker.getSpeakerId();

		dynamicQuery.add(RestrictionsFactoryUtil.in("speakerId",
				new Object[] { newSpeakerId }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingSpeakerId = result.get(0);

		Assert.assertEquals(existingSpeakerId, newSpeakerId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Speaker.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("speakerId"));

		dynamicQuery.add(RestrictionsFactoryUtil.in("speakerId",
				new Object[] { RandomTestUtil.nextLong() }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		Speaker newSpeaker = addSpeaker();

		_persistence.clearCache();

		Speaker existingSpeaker = _persistence.findByPrimaryKey(newSpeaker.getPrimaryKey());

		Assert.assertTrue(Objects.equals(existingSpeaker.getUuid(),
				ReflectionTestUtil.invoke(existingSpeaker, "getOriginalUuid",
					new Class<?>[0])));
		Assert.assertEquals(Long.valueOf(existingSpeaker.getGroupId()),
			ReflectionTestUtil.<Long>invoke(existingSpeaker,
				"getOriginalGroupId", new Class<?>[0]));

		Assert.assertEquals(Long.valueOf(existingSpeaker.getCompanyId()),
			ReflectionTestUtil.<Long>invoke(existingSpeaker,
				"getOriginalCompanyId", new Class<?>[0]));
		Assert.assertEquals(Long.valueOf(existingSpeaker.getGroupId()),
			ReflectionTestUtil.<Long>invoke(existingSpeaker,
				"getOriginalGroupId", new Class<?>[0]));

		Assert.assertEquals(Long.valueOf(existingSpeaker.getCompanyId()),
			ReflectionTestUtil.<Long>invoke(existingSpeaker,
				"getOriginalCompanyId", new Class<?>[0]));
		Assert.assertEquals(Long.valueOf(existingSpeaker.getGroupId()),
			ReflectionTestUtil.<Long>invoke(existingSpeaker,
				"getOriginalGroupId", new Class<?>[0]));
		Assert.assertTrue(Objects.equals(existingSpeaker.getEmail(),
				ReflectionTestUtil.invoke(existingSpeaker, "getOriginalEmail",
					new Class<?>[0])));
	}

	protected Speaker addSpeaker() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Speaker speaker = _persistence.create(pk);

		speaker.setUuid(RandomTestUtil.randomString());

		speaker.setCompanyId(RandomTestUtil.nextLong());

		speaker.setGroupId(RandomTestUtil.nextLong());

		speaker.setUserId(RandomTestUtil.nextLong());

		speaker.setUserName(RandomTestUtil.randomString());

		speaker.setCreateDate(RandomTestUtil.nextDate());

		speaker.setModifiedDate(RandomTestUtil.nextDate());

		speaker.setName(RandomTestUtil.randomString());

		speaker.setEmail(RandomTestUtil.randomString());

		speaker.setBio(RandomTestUtil.randomString());

		_speakers.add(_persistence.update(speaker));

		return speaker;
	}

	private List<Speaker> _speakers = new ArrayList<Speaker>();
	private SpeakerPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;
}