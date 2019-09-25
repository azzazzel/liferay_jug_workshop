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

package bg.jug.workshop.liferay.cfp.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Talk}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Talk
 * @generated
 */
@ProviderType
public class TalkWrapper implements Talk, ModelWrapper<Talk> {
	public TalkWrapper(Talk talk) {
		_talk = talk;
	}

	@Override
	public Class<?> getModelClass() {
		return Talk.class;
	}

	@Override
	public String getModelClassName() {
		return Talk.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("talkId", getTalkId());
		attributes.put("title", getTitle());
		attributes.put("data", getData());
		attributes.put("structureId", getStructureId());
		attributes.put("templateId", getTemplateId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long talkId = (Long)attributes.get("talkId");

		if (talkId != null) {
			setTalkId(talkId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String data = (String)attributes.get("data");

		if (data != null) {
			setData(data);
		}

		Long structureId = (Long)attributes.get("structureId");

		if (structureId != null) {
			setStructureId(structureId);
		}

		Long templateId = (Long)attributes.get("templateId");

		if (templateId != null) {
			setTemplateId(templateId);
		}
	}

	@Override
	public java.lang.Object clone() {
		return new TalkWrapper((Talk)_talk.clone());
	}

	@Override
	public int compareTo(Talk talk) {
		return _talk.compareTo(talk);
	}

	/**
	* Returns the company ID of this talk.
	*
	* @return the company ID of this talk
	*/
	@Override
	public long getCompanyId() {
		return _talk.getCompanyId();
	}

	/**
	* Returns the create date of this talk.
	*
	* @return the create date of this talk
	*/
	@Override
	public Date getCreateDate() {
		return _talk.getCreateDate();
	}

	/**
	* Returns the data of this talk.
	*
	* @return the data of this talk
	*/
	@Override
	public java.lang.String getData() {
		return _talk.getData();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _talk.getExpandoBridge();
	}

	/**
	* Returns the group ID of this talk.
	*
	* @return the group ID of this talk
	*/
	@Override
	public long getGroupId() {
		return _talk.getGroupId();
	}

	/**
	* Returns the modified date of this talk.
	*
	* @return the modified date of this talk
	*/
	@Override
	public Date getModifiedDate() {
		return _talk.getModifiedDate();
	}

	/**
	* Returns the primary key of this talk.
	*
	* @return the primary key of this talk
	*/
	@Override
	public long getPrimaryKey() {
		return _talk.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _talk.getPrimaryKeyObj();
	}

	/**
	* Returns the structure ID of this talk.
	*
	* @return the structure ID of this talk
	*/
	@Override
	public long getStructureId() {
		return _talk.getStructureId();
	}

	/**
	* Returns the talk ID of this talk.
	*
	* @return the talk ID of this talk
	*/
	@Override
	public long getTalkId() {
		return _talk.getTalkId();
	}

	/**
	* Returns the template ID of this talk.
	*
	* @return the template ID of this talk
	*/
	@Override
	public long getTemplateId() {
		return _talk.getTemplateId();
	}

	/**
	* Returns the title of this talk.
	*
	* @return the title of this talk
	*/
	@Override
	public java.lang.String getTitle() {
		return _talk.getTitle();
	}

	/**
	* Returns the user ID of this talk.
	*
	* @return the user ID of this talk
	*/
	@Override
	public long getUserId() {
		return _talk.getUserId();
	}

	/**
	* Returns the user name of this talk.
	*
	* @return the user name of this talk
	*/
	@Override
	public java.lang.String getUserName() {
		return _talk.getUserName();
	}

	/**
	* Returns the user uuid of this talk.
	*
	* @return the user uuid of this talk
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _talk.getUserUuid();
	}

	/**
	* Returns the uuid of this talk.
	*
	* @return the uuid of this talk
	*/
	@Override
	public java.lang.String getUuid() {
		return _talk.getUuid();
	}

	@Override
	public int hashCode() {
		return _talk.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _talk.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _talk.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _talk.isNew();
	}

	@Override
	public void persist() {
		_talk.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_talk.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this talk.
	*
	* @param companyId the company ID of this talk
	*/
	@Override
	public void setCompanyId(long companyId) {
		_talk.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this talk.
	*
	* @param createDate the create date of this talk
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_talk.setCreateDate(createDate);
	}

	/**
	* Sets the data of this talk.
	*
	* @param data the data of this talk
	*/
	@Override
	public void setData(java.lang.String data) {
		_talk.setData(data);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_talk.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_talk.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_talk.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this talk.
	*
	* @param groupId the group ID of this talk
	*/
	@Override
	public void setGroupId(long groupId) {
		_talk.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this talk.
	*
	* @param modifiedDate the modified date of this talk
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_talk.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_talk.setNew(n);
	}

	/**
	* Sets the primary key of this talk.
	*
	* @param primaryKey the primary key of this talk
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_talk.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_talk.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the structure ID of this talk.
	*
	* @param structureId the structure ID of this talk
	*/
	@Override
	public void setStructureId(long structureId) {
		_talk.setStructureId(structureId);
	}

	/**
	* Sets the talk ID of this talk.
	*
	* @param talkId the talk ID of this talk
	*/
	@Override
	public void setTalkId(long talkId) {
		_talk.setTalkId(talkId);
	}

	/**
	* Sets the template ID of this talk.
	*
	* @param templateId the template ID of this talk
	*/
	@Override
	public void setTemplateId(long templateId) {
		_talk.setTemplateId(templateId);
	}

	/**
	* Sets the title of this talk.
	*
	* @param title the title of this talk
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_talk.setTitle(title);
	}

	/**
	* Sets the user ID of this talk.
	*
	* @param userId the user ID of this talk
	*/
	@Override
	public void setUserId(long userId) {
		_talk.setUserId(userId);
	}

	/**
	* Sets the user name of this talk.
	*
	* @param userName the user name of this talk
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_talk.setUserName(userName);
	}

	/**
	* Sets the user uuid of this talk.
	*
	* @param userUuid the user uuid of this talk
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_talk.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this talk.
	*
	* @param uuid the uuid of this talk
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_talk.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Talk> toCacheModel() {
		return _talk.toCacheModel();
	}

	@Override
	public Talk toEscapedModel() {
		return new TalkWrapper(_talk.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _talk.toString();
	}

	@Override
	public Talk toUnescapedModel() {
		return new TalkWrapper(_talk.toUnescapedModel());
	}

	@Override
	public java.lang.String toXmlString() {
		return _talk.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TalkWrapper)) {
			return false;
		}

		TalkWrapper talkWrapper = (TalkWrapper)obj;

		if (Objects.equals(_talk, talkWrapper._talk)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _talk.getStagedModelType();
	}

	@Override
	public Talk getWrappedModel() {
		return _talk;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _talk.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _talk.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_talk.resetOriginalValues();
	}

	private final Talk _talk;
}