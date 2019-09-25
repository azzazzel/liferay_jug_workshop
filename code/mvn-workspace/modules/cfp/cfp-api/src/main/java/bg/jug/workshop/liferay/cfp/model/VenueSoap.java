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
 * This class is used by SOAP remote services, specifically {@link bg.jug.workshop.liferay.cfp.service.http.VenueServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see bg.jug.workshop.liferay.cfp.service.http.VenueServiceSoap
 * @generated
 */
@ProviderType
public class VenueSoap implements Serializable {
	public static VenueSoap toSoapModel(Venue model) {
		VenueSoap soapModel = new VenueSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setVenueId(model.getVenueId());
		soapModel.setName(model.getName());
		soapModel.setAddress(model.getAddress());
		soapModel.setLatitude(model.getLatitude());
		soapModel.setLongitude(model.getLongitude());

		return soapModel;
	}

	public static VenueSoap[] toSoapModels(Venue[] models) {
		VenueSoap[] soapModels = new VenueSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VenueSoap[][] toSoapModels(Venue[][] models) {
		VenueSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VenueSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VenueSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VenueSoap[] toSoapModels(List<Venue> models) {
		List<VenueSoap> soapModels = new ArrayList<VenueSoap>(models.size());

		for (Venue model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VenueSoap[soapModels.size()]);
	}

	public VenueSoap() {
	}

	public long getPrimaryKey() {
		return _venueId;
	}

	public void setPrimaryKey(long pk) {
		setVenueId(pk);
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

	public long getVenueId() {
		return _venueId;
	}

	public void setVenueId(long venueId) {
		_venueId = venueId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
	}

	public double getLatitude() {
		return _latitude;
	}

	public void setLatitude(double latitude) {
		_latitude = latitude;
	}

	public double getLongitude() {
		return _longitude;
	}

	public void setLongitude(double longitude) {
		_longitude = longitude;
	}

	private String _uuid;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _venueId;
	private String _name;
	private String _address;
	private double _latitude;
	private double _longitude;
}