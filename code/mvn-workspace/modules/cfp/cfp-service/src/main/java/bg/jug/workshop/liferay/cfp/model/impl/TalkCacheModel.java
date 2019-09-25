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

import bg.jug.workshop.liferay.cfp.model.Talk;

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
 * The cache model class for representing Talk in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Talk
 * @generated
 */
@ProviderType
public class TalkCacheModel implements CacheModel<Talk>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TalkCacheModel)) {
			return false;
		}

		TalkCacheModel talkCacheModel = (TalkCacheModel)obj;

		if (talkId == talkCacheModel.talkId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, talkId);
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
		sb.append(", talkId=");
		sb.append(talkId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", data=");
		sb.append(data);
		sb.append(", structureId=");
		sb.append(structureId);
		sb.append(", templateId=");
		sb.append(templateId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Talk toEntityModel() {
		TalkImpl talkImpl = new TalkImpl();

		if (uuid == null) {
			talkImpl.setUuid(StringPool.BLANK);
		}
		else {
			talkImpl.setUuid(uuid);
		}

		talkImpl.setCompanyId(companyId);
		talkImpl.setGroupId(groupId);
		talkImpl.setUserId(userId);

		if (userName == null) {
			talkImpl.setUserName(StringPool.BLANK);
		}
		else {
			talkImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			talkImpl.setCreateDate(null);
		}
		else {
			talkImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			talkImpl.setModifiedDate(null);
		}
		else {
			talkImpl.setModifiedDate(new Date(modifiedDate));
		}

		talkImpl.setTalkId(talkId);

		if (title == null) {
			talkImpl.setTitle(StringPool.BLANK);
		}
		else {
			talkImpl.setTitle(title);
		}

		if (data == null) {
			talkImpl.setData(StringPool.BLANK);
		}
		else {
			talkImpl.setData(data);
		}

		talkImpl.setStructureId(structureId);
		talkImpl.setTemplateId(templateId);

		talkImpl.resetOriginalValues();

		return talkImpl;
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

		talkId = objectInput.readLong();
		title = objectInput.readUTF();
		data = objectInput.readUTF();

		structureId = objectInput.readLong();

		templateId = objectInput.readLong();
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

		objectOutput.writeLong(talkId);

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (data == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(data);
		}

		objectOutput.writeLong(structureId);

		objectOutput.writeLong(templateId);
	}

	public String uuid;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long talkId;
	public String title;
	public String data;
	public long structureId;
	public long templateId;
}