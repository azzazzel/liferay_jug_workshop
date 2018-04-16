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

package bg.jug.workshop.liferay.cfp.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TalkService}.
 *
 * @author Brian Wing Shun Chan
 * @see TalkService
 * @generated
 */
@ProviderType
public class TalkServiceWrapper implements TalkService,
	ServiceWrapper<TalkService> {
	public TalkServiceWrapper(TalkService talkService) {
		_talkService = talkService;
	}

	@Override
	public java.util.List<bg.jug.workshop.liferay.cfp.model.Talk> getEventTalks(
		long eventId) {
		return _talkService.getEventTalks(eventId);
	}

	@Override
	public java.util.List<bg.jug.workshop.liferay.cfp.model.Talk> getGroupTalks(
		long companyId, long groupId) {
		return _talkService.getGroupTalks(companyId, groupId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _talkService.getOSGiServiceIdentifier();
	}

	@Override
	public TalkService getWrappedService() {
		return _talkService;
	}

	@Override
	public void setWrappedService(TalkService talkService) {
		_talkService = talkService;
	}

	private TalkService _talkService;
}