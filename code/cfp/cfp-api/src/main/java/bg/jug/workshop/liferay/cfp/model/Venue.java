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
 * The extended model interface for the Venue service. Represents a row in the &quot;CFP_Venue&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see VenueModel
 * @see bg.jug.workshop.liferay.cfp.model.impl.VenueImpl
 * @see bg.jug.workshop.liferay.cfp.model.impl.VenueModelImpl
 * @generated
 */
@ImplementationClassName("bg.jug.workshop.liferay.cfp.model.impl.VenueImpl")
@ProviderType
public interface Venue extends VenueModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link bg.jug.workshop.liferay.cfp.model.impl.VenueImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Venue, Long> VENUE_ID_ACCESSOR = new Accessor<Venue, Long>() {
			@Override
			public Long get(Venue venue) {
				return venue.getVenueId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Venue> getTypeClass() {
				return Venue.class;
			}
		};
}