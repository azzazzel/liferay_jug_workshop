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

import bg.jug.workshop.liferay.cfp.exception.NoSuchVenueException;
import bg.jug.workshop.liferay.cfp.model.Venue;
import bg.jug.workshop.liferay.cfp.service.VenueLocalServiceUtil;
import bg.jug.workshop.liferay.cfp.service.persistence.VenuePersistence;
import bg.jug.workshop.liferay.cfp.service.persistence.VenueUtil;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.AssertUtils;
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
public class VenuePersistenceTest {
	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule = new AggregateTestRule(new LiferayIntegrationTestRule(),
			PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED,
				"bg.jug.workshop.liferay.cfp.service"));

	@Before
	public void setUp() {
		_persistence = VenueUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Venue> iterator = _venues.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Venue venue = _persistence.create(pk);

		Assert.assertNotNull(venue);

		Assert.assertEquals(venue.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Venue newVenue = addVenue();

		_persistence.remove(newVenue);

		Venue existingVenue = _persistence.fetchByPrimaryKey(newVenue.getPrimaryKey());

		Assert.assertNull(existingVenue);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addVenue();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Venue newVenue = _persistence.create(pk);

		newVenue.setUuid(RandomTestUtil.randomString());

		newVenue.setCompanyId(RandomTestUtil.nextLong());

		newVenue.setGroupId(RandomTestUtil.nextLong());

		newVenue.setUserId(RandomTestUtil.nextLong());

		newVenue.setUserName(RandomTestUtil.randomString());

		newVenue.setCreateDate(RandomTestUtil.nextDate());

		newVenue.setModifiedDate(RandomTestUtil.nextDate());

		newVenue.setName(RandomTestUtil.randomString());

		newVenue.setAddress(RandomTestUtil.randomString());

		newVenue.setLatitude(RandomTestUtil.nextDouble());

		newVenue.setLongitude(RandomTestUtil.nextDouble());

		_venues.add(_persistence.update(newVenue));

		Venue existingVenue = _persistence.findByPrimaryKey(newVenue.getPrimaryKey());

		Assert.assertEquals(existingVenue.getUuid(), newVenue.getUuid());
		Assert.assertEquals(existingVenue.getCompanyId(),
			newVenue.getCompanyId());
		Assert.assertEquals(existingVenue.getGroupId(), newVenue.getGroupId());
		Assert.assertEquals(existingVenue.getUserId(), newVenue.getUserId());
		Assert.assertEquals(existingVenue.getUserName(), newVenue.getUserName());
		Assert.assertEquals(Time.getShortTimestamp(
				existingVenue.getCreateDate()),
			Time.getShortTimestamp(newVenue.getCreateDate()));
		Assert.assertEquals(Time.getShortTimestamp(
				existingVenue.getModifiedDate()),
			Time.getShortTimestamp(newVenue.getModifiedDate()));
		Assert.assertEquals(existingVenue.getVenueId(), newVenue.getVenueId());
		Assert.assertEquals(existingVenue.getName(), newVenue.getName());
		Assert.assertEquals(existingVenue.getAddress(), newVenue.getAddress());
		AssertUtils.assertEquals(existingVenue.getLatitude(),
			newVenue.getLatitude());
		AssertUtils.assertEquals(existingVenue.getLongitude(),
			newVenue.getLongitude());
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
		Venue newVenue = addVenue();

		Venue existingVenue = _persistence.findByPrimaryKey(newVenue.getPrimaryKey());

		Assert.assertEquals(existingVenue, newVenue);
	}

	@Test(expected = NoSuchVenueException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			getOrderByComparator());
	}

	protected OrderByComparator<Venue> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create("CFP_Venue", "uuid", true,
			"companyId", true, "groupId", true, "userId", true, "userName",
			true, "createDate", true, "modifiedDate", true, "venueId", true,
			"name", true, "address", true, "latitude", true, "longitude", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Venue newVenue = addVenue();

		Venue existingVenue = _persistence.fetchByPrimaryKey(newVenue.getPrimaryKey());

		Assert.assertEquals(existingVenue, newVenue);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Venue missingVenue = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingVenue);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {
		Venue newVenue1 = addVenue();
		Venue newVenue2 = addVenue();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newVenue1.getPrimaryKey());
		primaryKeys.add(newVenue2.getPrimaryKey());

		Map<Serializable, Venue> venues = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, venues.size());
		Assert.assertEquals(newVenue1, venues.get(newVenue1.getPrimaryKey()));
		Assert.assertEquals(newVenue2, venues.get(newVenue2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {
		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Venue> venues = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(venues.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {
		Venue newVenue = addVenue();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newVenue.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Venue> venues = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, venues.size());
		Assert.assertEquals(newVenue, venues.get(newVenue.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys()
		throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Venue> venues = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(venues.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey()
		throws Exception {
		Venue newVenue = addVenue();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newVenue.getPrimaryKey());

		Map<Serializable, Venue> venues = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, venues.size());
		Assert.assertEquals(newVenue, venues.get(newVenue.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery = VenueLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<Venue>() {
				@Override
				public void performAction(Venue venue) {
					Assert.assertNotNull(venue);

					count.increment();
				}
			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		Venue newVenue = addVenue();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Venue.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("venueId",
				newVenue.getVenueId()));

		List<Venue> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Venue existingVenue = result.get(0);

		Assert.assertEquals(existingVenue, newVenue);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Venue.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("venueId",
				RandomTestUtil.nextLong()));

		List<Venue> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting()
		throws Exception {
		Venue newVenue = addVenue();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Venue.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("venueId"));

		Object newVenueId = newVenue.getVenueId();

		dynamicQuery.add(RestrictionsFactoryUtil.in("venueId",
				new Object[] { newVenueId }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingVenueId = result.get(0);

		Assert.assertEquals(existingVenueId, newVenueId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Venue.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("venueId"));

		dynamicQuery.add(RestrictionsFactoryUtil.in("venueId",
				new Object[] { RandomTestUtil.nextLong() }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		Venue newVenue = addVenue();

		_persistence.clearCache();

		Venue existingVenue = _persistence.findByPrimaryKey(newVenue.getPrimaryKey());

		Assert.assertTrue(Objects.equals(existingVenue.getUuid(),
				ReflectionTestUtil.invoke(existingVenue, "getOriginalUuid",
					new Class<?>[0])));
		Assert.assertEquals(Long.valueOf(existingVenue.getGroupId()),
			ReflectionTestUtil.<Long>invoke(existingVenue,
				"getOriginalGroupId", new Class<?>[0]));
	}

	protected Venue addVenue() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Venue venue = _persistence.create(pk);

		venue.setUuid(RandomTestUtil.randomString());

		venue.setCompanyId(RandomTestUtil.nextLong());

		venue.setGroupId(RandomTestUtil.nextLong());

		venue.setUserId(RandomTestUtil.nextLong());

		venue.setUserName(RandomTestUtil.randomString());

		venue.setCreateDate(RandomTestUtil.nextDate());

		venue.setModifiedDate(RandomTestUtil.nextDate());

		venue.setName(RandomTestUtil.randomString());

		venue.setAddress(RandomTestUtil.randomString());

		venue.setLatitude(RandomTestUtil.nextDouble());

		venue.setLongitude(RandomTestUtil.nextDouble());

		_venues.add(_persistence.update(venue));

		return venue;
	}

	private List<Venue> _venues = new ArrayList<Venue>();
	private VenuePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;
}