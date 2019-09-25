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

package bg.jug.workshop.liferay.cfp.admin.ddm;

import java.util.Locale;
import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.dynamic.data.mapping.model.DDMTemplate;
import com.liferay.dynamic.data.mapping.storage.StorageType;
import com.liferay.dynamic.data.mapping.util.BaseDDMDisplay;
import com.liferay.dynamic.data.mapping.util.DDMDisplay;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.service.ClassNameLocalService;

import bg.jug.workshop.liferay.cfp.admin.constants.CFPAdminPortletKeys;
import bg.jug.workshop.liferay.cfp.model.Talk;

/**
 * @author Milen Dyankov
 */
@Component(
	property = {"javax.portlet.name=" + CFPAdminPortletKeys.CFP_ADMIN},
	service = DDMDisplay.class
)
public class TalkDDMDisplay extends BaseDDMDisplay {

	@Reference
	ClassNameLocalService classNameLocalService;
	
	@Override
	public String getPortletId() {
		return CFPAdminPortletKeys.CFP_ADMIN;
	}

	@Override
	public String getStorageType() {
		return StorageType.JSON.getValue();
	}

	@Override
	public String getStructureName(Locale locale) {
		ResourceBundle resourceBundle = getResourceBundle(locale);
		return LanguageUtil.get(resourceBundle, "talk-structure");
	}

	@Override
	public String getStructureType() {
		return Talk.class.getName();
	}

	@Override
	public long getTemplateHandlerClassNameId(DDMTemplate template, long classNameId) {
		return classNameLocalService.getClassNameId(Talk.class);
	}

	@Override
	public String getTitle(Locale locale) {
		ResourceBundle resourceBundle = getResourceBundle(locale);
		return LanguageUtil.get(resourceBundle, "talk-structures");
	}

	@Override
	public boolean isShowBackURLInTitleBar() {
		return true;
	}

}