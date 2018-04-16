package bg.jug.workshop.liferay.cfp.admin.portlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import bg.jug.workshop.liferay.cfp.admin.constants.CFPAdminPortletKeys;

/**
 * @author Milen Dyankov
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=CFP",
		"javax.portlet.display-name=Display a talk",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/talk_preview.jsp",
		"javax.portlet.name=" + CFPAdminPortletKeys.CFP_TALK_DISPLAY,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class TalkDisplayPortlet extends MVCPortlet {
}
