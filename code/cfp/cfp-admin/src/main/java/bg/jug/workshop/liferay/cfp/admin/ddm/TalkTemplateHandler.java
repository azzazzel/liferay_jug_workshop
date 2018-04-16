package bg.jug.workshop.liferay.cfp.admin.ddm;

import java.util.Locale;
import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.dynamic.data.mapping.template.BaseDDMTemplateHandler;
import com.liferay.dynamic.data.mapping.template.DDMTemplateVariableCodeHandler;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.service.ClassNameLocalService;
import com.liferay.portal.kernel.template.TemplateHandler;
import com.liferay.portal.kernel.template.TemplateVariableCodeHandler;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.liferay.portal.kernel.util.SetUtil;

import bg.jug.workshop.liferay.cfp.admin.constants.CFPAdminPortletKeys;
import bg.jug.workshop.liferay.cfp.model.Talk;

@Component(
		immediate = true,
		property = {"javax.portlet.name=" + CFPAdminPortletKeys.CFP_ADMIN},
		service = TemplateHandler.class
	)
public class TalkTemplateHandler extends BaseDDMTemplateHandler {

	@Reference
	ClassNameLocalService classNameLocalService;
	
	
	@Override
	public String getClassName() {
		return Talk.class.getName();
	}

	@Override
	public String getName(Locale locale) {
		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle("content.Language", locale, getClass());
		return LanguageUtil.get(resourceBundle, "talk-template");
	}

	@Override
	public String getResourceName() {
		return "bg.jug.workshop.liferay.cfp.model.template";
	}
	
	@Override
	protected TemplateVariableCodeHandler getTemplateVariableCodeHandler() {
		return _templateVariableCodeHandler;
	}
	
	private final TemplateVariableCodeHandler _templateVariableCodeHandler =
			new DDMTemplateVariableCodeHandler(
				TalkTemplateHandler.class.getClassLoader(),
				"bg/jug/workshop/liferay/cfp/admin/ddm/templates/",
				SetUtil.fromArray(
						new String[] {"boolean", "date", "document-library", "geolocation",
								"image", "link-to-page"}));

}
