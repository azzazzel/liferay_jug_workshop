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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the Talk service. Represents a row in the &quot;CFP_Talk&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see TalkModel
 * @see bg.jug.workshop.liferay.cfp.model.impl.TalkImpl
 * @see bg.jug.workshop.liferay.cfp.model.impl.TalkModelImpl
 * @generated
 */
@ImplementationClassName("bg.jug.workshop.liferay.cfp.model.impl.TalkImpl")
@ProviderType
public interface Talk extends TalkModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link bg.jug.workshop.liferay.cfp.model.impl.TalkImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Talk, Long> TALK_ID_ACCESSOR = new Accessor<Talk, Long>() {
			@Override
			public Long get(Talk talk) {
				return talk.getTalkId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Talk> getTypeClass() {
				return Talk.class;
			}
		};
}