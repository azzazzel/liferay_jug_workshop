package bg.jug.workshop.liferay.cfp.admin.portlet.configuration.icon;

import java.util.ResourceBundle;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.Portlet;
import com.liferay.portal.kernel.portlet.PortletProvider;
import com.liferay.portal.kernel.portlet.PortletProviderUtil;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.configuration.icon.BasePortletConfigurationIcon;
import com.liferay.portal.kernel.portlet.configuration.icon.PortletConfigurationIcon;
import com.liferay.portal.kernel.service.PortletLocalService;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.webdav.WebDAVUtil;

import bg.jug.workshop.liferay.cfp.admin.constants.CFPAdminPortletKeys;

@Component(
		immediate = true,
		property = {"javax.portlet.name=" + CFPAdminPortletKeys.CFP_ADMIN},
		service = PortletConfigurationIcon.class
	)
public class TalkStructureConfigurationIcon extends BasePortletConfigurationIcon {

	@Reference
	PortletLocalService portletLocalService;
	
	@Override
	public boolean isShow(PortletRequest portletRequest) {
		return true;
	}


	@Override
	public String getMessage(PortletRequest portletRequest) {
		
		ResourceBundle portletResourceBundle = ResourceBundle.getBundle("content/Language", portletRequest.getLocale());
		return LanguageUtil.get(portletResourceBundle, "manage-talk-definitions");
	}

	@Override
	public String getURL(PortletRequest portletRequest, PortletResponse portletResponse) {

		ThemeDisplay themeDisplay = (ThemeDisplay)portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();
		Portlet portlet = portletLocalService.getPortletById(portletDisplay.getId());

		PortletURL portletURL = PortletURLFactoryUtil.create(
			portletRequest,
			PortletProviderUtil.getPortletId(
				DDMStructure.class.getName(), PortletProvider.Action.VIEW),
			PortletRequest.RENDER_PHASE);

		portletURL.setParameter("mvcPath", "/view.jsp");
		portletURL.setParameter("backURL", themeDisplay.getURLCurrent());
		portletURL.setParameter("groupId", String.valueOf(themeDisplay.getScopeGroupId()));
		portletURL.setParameter("refererPortletName", CFPAdminPortletKeys.CFP_ADMIN);
		portletURL.setParameter("refererWebDAVToken", WebDAVUtil.getStorageToken(portlet));
		portletURL.setParameter("showAncestorScopes", Boolean.TRUE.toString());
		
		return portletURL.toString();
	}
	
	@Override
	public double getWeight() {
		return 102;
	}

	@Override
	public boolean isToolTip() {
		return false;
	}
}
