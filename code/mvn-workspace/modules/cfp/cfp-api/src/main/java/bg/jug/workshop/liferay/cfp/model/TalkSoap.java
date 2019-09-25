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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link bg.jug.workshop.liferay.cfp.service.http.TalkServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see bg.jug.workshop.liferay.cfp.service.http.TalkServiceSoap
 * @generated
 */
@ProviderType
public class TalkSoap implements Serializable {
	public static TalkSoap toSoapModel(Talk model) {
		TalkSoap soapModel = new TalkSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setTalkId(model.getTalkId());
		soapModel.setTitle(model.getTitle());
		soapModel.setData(model.getData());
		soapModel.setStructureId(model.getStructureId());
		soapModel.setTemplateId(model.getTemplateId());

		return soapModel;
	}

	public static TalkSoap[] toSoapModels(Talk[] models) {
		TalkSoap[] soapModels = new TalkSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TalkSoap[][] toSoapModels(Talk[][] models) {
		TalkSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TalkSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TalkSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TalkSoap[] toSoapModels(List<Talk> models) {
		List<TalkSoap> soapModels = new ArrayList<TalkSoap>(models.size());

		for (Talk model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TalkSoap[soapModels.size()]);
	}

	public TalkSoap() {
	}

	public long getPrimaryKey() {
		return _talkId;
	}

	public void setPrimaryKey(long pk) {
		setTalkId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getTalkId() {
		return _talkId;
	}

	public void setTalkId(long talkId) {
		_talkId = talkId;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getData() {
		return _data;
	}

	public void setData(String data) {
		_data = data;
	}

	public long getStructureId() {
		return _structureId;
	}

	public void setStructureId(long structureId) {
		_structureId = structureId;
	}

	public long getTemplateId() {
		return _templateId;
	}

	public void setTemplateId(long templateId) {
		_templateId = templateId;
	}

	private String _uuid;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _talkId;
	private String _title;
	private String _data;
	private long _structureId;
	private long _templateId;
}