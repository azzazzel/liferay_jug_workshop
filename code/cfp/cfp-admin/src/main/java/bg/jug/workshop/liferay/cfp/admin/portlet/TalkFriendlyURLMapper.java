package bg.jug.workshop.liferay.cfp.admin.portlet;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.DefaultFriendlyURLMapper;
import com.liferay.portal.kernel.portlet.FriendlyURLMapper;

import bg.jug.workshop.liferay.cfp.admin.constants.CFPAdminPortletKeys;

@Component(
	    property = {
	        "com.liferay.portlet.friendly-url-routes=META-INF/friendly-url-routes/routes.xml",
	        "javax.portlet.name=" + CFPAdminPortletKeys.CFP_TALK_DISPLAY
	    },
	    service = FriendlyURLMapper.class
	)
public class TalkFriendlyURLMapper extends DefaultFriendlyURLMapper {

	@Override
	public String getMapping() {
		return "talk";
	}
}
