package bg.jug.workshop.liferay.cfp.admin.portlet;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.dynamic.data.mapping.io.DDMFormValuesJSONDeserializer;
import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.dynamic.data.mapping.model.DDMTemplate;
import com.liferay.dynamic.data.mapping.model.DDMTemplateConstants;
import com.liferay.dynamic.data.mapping.service.DDMTemplateLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ClassNameLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import bg.jug.workshop.liferay.cfp.admin.constants.CFPAdminPortletKeys;
import bg.jug.workshop.liferay.cfp.model.Talk;
import bg.jug.workshop.liferay.cfp.service.TalkLocalService;

/**
 * @author Milen Dyankov
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=CFP",
		"javax.portlet.display-name=Submit a talk",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/talk_form/view.jsp",
		"javax.portlet.name=" + CFPAdminPortletKeys.CFP_TALK_FORM,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class TalkFormPortlet extends MVCPortlet {


	@Reference
	TalkLocalService talkLocalService;

	@Reference
	DDMTemplateLocalService ddmTemplateLocalService;

	@Reference
	DDMFormValuesJSONDeserializer ddmFormValuesJSONDeserializer; 	
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		renderRequest.setAttribute("ddmFormValuesJSONDeserializer", ddmFormValuesJSONDeserializer);
		super.render(renderRequest, renderResponse);
	}
	
	

	public void saveTalk(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
		String talkIdValue = actionRequest.getParameter("talkId");
		Optional<Long> talkId = Optional.ofNullable(Validator.isBlank(talkIdValue) ? null : Long.parseLong(talkIdValue));

		long structureId = ParamUtil.getLong(actionRequest, "structureId", 0);
		long templateId = ParamUtil.getLong(actionRequest, "templateId", 0);
		
		if (templateId == 0) {
			List<DDMTemplate> displayTemplates = ddmTemplateLocalService.getTemplates(
					PortalUtil.getScopeGroupId(actionRequest), 
					ClassNameLocalServiceUtil.getClassNameId(DDMStructure.class.getName()), 
					structureId, 
					DDMTemplateConstants.TEMPLATE_TYPE_DISPLAY);
			
			if (displayTemplates != null && !displayTemplates.isEmpty()) {
				templateId = displayTemplates.get(0).getTemplateId();
			}
		}
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Talk.class.getName(), actionRequest);
		talkLocalService.saveTalk(
				talkId, 
				ParamUtil.get(actionRequest, "title", ""), 
				structureId, 
				templateId, 
				ParamUtil.getString(actionRequest, "ddmFormValues"),
				serviceContext);
	}

}