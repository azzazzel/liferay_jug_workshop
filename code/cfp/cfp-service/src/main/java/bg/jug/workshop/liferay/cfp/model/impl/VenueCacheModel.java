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

import bg.jug.workshop.liferay.cfp.model.Venue;

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
 * The cache model class for representing Venue in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Venue
 * @generated
 */
@ProviderType
public class VenueCacheModel implements CacheModel<Venue>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VenueCacheModel)) {
			return false;
		}

		VenueCacheModel venueCacheModel = (VenueCacheModel)obj;

		if (venueId == venueCacheModel.venueId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, venueId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

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
		sb.append(", venueId=");
		sb.append(venueId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", address=");
		sb.append(address);
		sb.append(", latitude=");
		sb.append(latitude);
		sb.append(", longitude=");
		sb.append(longitude);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Venue toEntityModel() {
		VenueImpl venueImpl = new VenueImpl();

		if (uuid == null) {
			venueImpl.setUuid(StringPool.BLANK);
		}
		else {
			venueImpl.setUuid(uuid);
		}

		venueImpl.setCompanyId(companyId);
		venueImpl.setGroupId(groupId);
		venueImpl.setUserId(userId);

		if (userName == null) {
			venueImpl.setUserName(StringPool.BLANK);
		}
		else {
			venueImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			venueImpl.setCreateDate(null);
		}
		else {
			venueImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			venueImpl.setModifiedDate(null);
		}
		else {
			venueImpl.setModifiedDate(new Date(modifiedDate));
		}

		venueImpl.setVenueId(venueId);

		if (name == null) {
			venueImpl.setName(StringPool.BLANK);
		}
		else {
			venueImpl.setName(name);
		}

		if (address == null) {
			venueImpl.setAddress(StringPool.BLANK);
		}
		else {
			venueImpl.setAddress(address);
		}

		venueImpl.setLatitude(latitude);
		venueImpl.setLongitude(longitude);

		venueImpl.resetOriginalValues();

		return venueImpl;
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

		venueId = objectInput.readLong();
		name = objectInput.readUTF();
		address = objectInput.readUTF();

		latitude = objectInput.readDouble();

		longitude = objectInput.readDouble();
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

		objectOutput.writeLong(venueId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (address == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(address);
		}

		objectOutput.writeDouble(latitude);

		objectOutput.writeDouble(longitude);
	}

	public String uuid;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long venueId;
	public String name;
	public String address;
	public double latitude;
	public double longitude;
}