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
 * This class is a wrapper for {@link Venue}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Venue
 * @generated
 */
@ProviderType
public class VenueWrapper implements Venue, ModelWrapper<Venue> {
	public VenueWrapper(Venue venue) {
		_venue = venue;
	}

	@Override
	public Class<?> getModelClass() {
		return Venue.class;
	}

	@Override
	public String getModelClassName() {
		return Venue.class.getName();
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
		attributes.put("venueId", getVenueId());
		attributes.put("name", getName());
		attributes.put("address", getAddress());
		attributes.put("latitude", getLatitude());
		attributes.put("longitude", getLongitude());

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

		Long venueId = (Long)attributes.get("venueId");

		if (venueId != null) {
			setVenueId(venueId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		Double latitude = (Double)attributes.get("latitude");

		if (latitude != null) {
			setLatitude(latitude);
		}

		Double longitude = (Double)attributes.get("longitude");

		if (longitude != null) {
			setLongitude(longitude);
		}
	}

	@Override
	public java.lang.Object clone() {
		return new VenueWrapper((Venue)_venue.clone());
	}

	@Override
	public int compareTo(Venue venue) {
		return _venue.compareTo(venue);
	}

	/**
	* Returns the address of this venue.
	*
	* @return the address of this venue
	*/
	@Override
	public java.lang.String getAddress() {
		return _venue.getAddress();
	}

	/**
	* Returns the company ID of this venue.
	*
	* @return the company ID of this venue
	*/
	@Override
	public long getCompanyId() {
		return _venue.getCompanyId();
	}

	/**
	* Returns the create date of this venue.
	*
	* @return the create date of this venue
	*/
	@Override
	public Date getCreateDate() {
		return _venue.getCreateDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _venue.getExpandoBridge();
	}

	/**
	* Returns the group ID of this venue.
	*
	* @return the group ID of this venue
	*/
	@Override
	public long getGroupId() {
		return _venue.getGroupId();
	}

	/**
	* Returns the latitude of this venue.
	*
	* @return the latitude of this venue
	*/
	@Override
	public double getLatitude() {
		return _venue.getLatitude();
	}

	/**
	* Returns the longitude of this venue.
	*
	* @return the longitude of this venue
	*/
	@Override
	public double getLongitude() {
		return _venue.getLongitude();
	}

	/**
	* Returns the modified date of this venue.
	*
	* @return the modified date of this venue
	*/
	@Override
	public Date getModifiedDate() {
		return _venue.getModifiedDate();
	}

	/**
	* Returns the name of this venue.
	*
	* @return the name of this venue
	*/
	@Override
	public java.lang.String getName() {
		return _venue.getName();
	}

	/**
	* Returns the primary key of this venue.
	*
	* @return the primary key of this venue
	*/
	@Override
	public long getPrimaryKey() {
		return _venue.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _venue.getPrimaryKeyObj();
	}

	/**
	* Returns the user ID of this venue.
	*
	* @return the user ID of this venue
	*/
	@Override
	public long getUserId() {
		return _venue.getUserId();
	}

	/**
	* Returns the user name of this venue.
	*
	* @return the user name of this venue
	*/
	@Override
	public java.lang.String getUserName() {
		return _venue.getUserName();
	}

	/**
	* Returns the user uuid of this venue.
	*
	* @return the user uuid of this venue
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _venue.getUserUuid();
	}

	/**
	* Returns the uuid of this venue.
	*
	* @return the uuid of this venue
	*/
	@Override
	public java.lang.String getUuid() {
		return _venue.getUuid();
	}

	/**
	* Returns the venue ID of this venue.
	*
	* @return the venue ID of this venue
	*/
	@Override
	public long getVenueId() {
		return _venue.getVenueId();
	}

	@Override
	public int hashCode() {
		return _venue.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _venue.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _venue.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _venue.isNew();
	}

	@Override
	public void persist() {
		_venue.persist();
	}

	/**
	* Sets the address of this venue.
	*
	* @param address the address of this venue
	*/
	@Override
	public void setAddress(java.lang.String address) {
		_venue.setAddress(address);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_venue.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this venue.
	*
	* @param companyId the company ID of this venue
	*/
	@Override
	public void setCompanyId(long companyId) {
		_venue.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this venue.
	*
	* @param createDate the create date of this venue
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_venue.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_venue.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_venue.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_venue.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this venue.
	*
	* @param groupId the group ID of this venue
	*/
	@Override
	public void setGroupId(long groupId) {
		_venue.setGroupId(groupId);
	}

	/**
	* Sets the latitude of this venue.
	*
	* @param latitude the latitude of this venue
	*/
	@Override
	public void setLatitude(double latitude) {
		_venue.setLatitude(latitude);
	}

	/**
	* Sets the longitude of this venue.
	*
	* @param longitude the longitude of this venue
	*/
	@Override
	public void setLongitude(double longitude) {
		_venue.setLongitude(longitude);
	}

	/**
	* Sets the modified date of this venue.
	*
	* @param modifiedDate the modified date of this venue
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_venue.setModifiedDate(modifiedDate);
	}

	/**
	* Sets the name of this venue.
	*
	* @param name the name of this venue
	*/
	@Override
	public void setName(java.lang.String name) {
		_venue.setName(name);
	}

	@Override
	public void setNew(boolean n) {
		_venue.setNew(n);
	}

	/**
	* Sets the primary key of this venue.
	*
	* @param primaryKey the primary key of this venue
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_venue.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_venue.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the user ID of this venue.
	*
	* @param userId the user ID of this venue
	*/
	@Override
	public void setUserId(long userId) {
		_venue.setUserId(userId);
	}

	/**
	* Sets the user name of this venue.
	*
	* @param userName the user name of this venue
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_venue.setUserName(userName);
	}

	/**
	* Sets the user uuid of this venue.
	*
	* @param userUuid the user uuid of this venue
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_venue.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this venue.
	*
	* @param uuid the uuid of this venue
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_venue.setUuid(uuid);
	}

	/**
	* Sets the venue ID of this venue.
	*
	* @param venueId the venue ID of this venue
	*/
	@Override
	public void setVenueId(long venueId) {
		_venue.setVenueId(venueId);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Venue> toCacheModel() {
		return _venue.toCacheModel();
	}

	@Override
	public Venue toEscapedModel() {
		return new VenueWrapper(_venue.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _venue.toString();
	}

	@Override
	public Venue toUnescapedModel() {
		return new VenueWrapper(_venue.toUnescapedModel());
	}

	@Override
	public java.lang.String toXmlString() {
		return _venue.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VenueWrapper)) {
			return false;
		}

		VenueWrapper venueWrapper = (VenueWrapper)obj;

		if (Objects.equals(_venue, venueWrapper._venue)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _venue.getStagedModelType();
	}

	@Override
	public Venue getWrappedModel() {
		return _venue;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _venue.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _venue.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_venue.resetOriginalValues();
	}

	private final Venue _venue;
}