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

package bg.jug.workshop.liferay.cfp.model.impl;

import aQute.bnd.annotation.ProviderType;

import bg.jug.workshop.liferay.cfp.model.Event;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Event in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Event
 * @generated
 */
@ProviderType
public class EventCacheModel implements CacheModel<Event>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EventCacheModel)) {
			return false;
		}

		EventCacheModel eventCacheModel = (EventCacheModel)obj;

		if (eventId == eventCacheModel.eventId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, eventId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", eventId=");
		sb.append(eventId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", date=");
		sb.append(date);
		sb.append(", website=");
		sb.append(website);
		sb.append(", venueId=");
		sb.append(venueId);
		sb.append(", calendarBookingId=");
		sb.append(calendarBookingId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Event toEntityModel() {
		EventImpl eventImpl = new EventImpl();

		if (uuid == null) {
			eventImpl.setUuid(StringPool.BLANK);
		}
		else {
			eventImpl.setUuid(uuid);
		}

		eventImpl.setCompanyId(companyId);
		eventImpl.setGroupId(groupId);
		eventImpl.setUserId(userId);

		if (userName == null) {
			eventImpl.setUserName(StringPool.BLANK);
		}
		else {
			eventImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			eventImpl.setCreateDate(null);
		}
		else {
			eventImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			eventImpl.setModifiedDate(null);
		}
		else {
			eventImpl.setModifiedDate(new Date(modifiedDate));
		}

		eventImpl.setEventId(eventId);

		if (name == null) {
			eventImpl.setName(StringPool.BLANK);
		}
		else {
			eventImpl.setName(name);
		}

		if (date == Long.MIN_VALUE) {
			eventImpl.setDate(null);
		}
		else {
			eventImpl.setDate(new Date(date));
		}

		if (website == null) {
			eventImpl.setWebsite(StringPool.BLANK);
		}
		else {
			eventImpl.setWebsite(website);
		}

		eventImpl.setVenueId(venueId);
		eventImpl.setCalendarBookingId(calendarBookingId);

		eventImpl.resetOriginalValues();

		return eventImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		eventId = objectInput.readLong();
		name = objectInput.readUTF();
		date = objectInput.readLong();
		website = objectInput.readUTF();

		venueId = objectInput.readLong();

		calendarBookingId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(eventId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeLong(date);

		if (website == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(website);
		}

		objectOutput.writeLong(venueId);

		objectOutput.writeLong(calendarBookingId);
	}

	public String uuid;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long eventId;
	public String name;
	public long date;
	public String website;
	public long venueId;
	public long calendarBookingId;
}