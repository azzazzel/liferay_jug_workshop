package bg.jug.workshop.liferay.cfp.admin.portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.portal.kernel.model.Portlet;

import bg.jug.workshop.liferay.cfp.admin.constants.CFPAdminPortletKeys;

@Component(
		immediate = true,
		property = {
			"panel.app.order:Integer=400",
			"panel.category.key=" + PanelCategoryKeys.SITE_ADMINISTRATION_CONTENT
		},
		service = PanelApp.class
	)
public class CFPAdminPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return CFPAdminPortletKeys.CFP_ADMIN;
	}

	@Override
    @Reference(
            target = "(javax.portlet.name=" + CFPAdminPortletKeys.CFP_ADMIN + ")",
            unbind = "-"
        )
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}
}
