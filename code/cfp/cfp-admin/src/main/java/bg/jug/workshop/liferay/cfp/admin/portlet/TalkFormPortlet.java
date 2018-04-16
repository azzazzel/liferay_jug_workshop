package bg.jug.workshop.liferay.cfp.admin.portlet;

import java.io.IOException;
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
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.ParamUtil;
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
	DDMFormValuesJSONDeserializer ddmFormValuesJSONDeserializer; 	
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		renderRequest.setAttribute("ddmFormValuesJSONDeserializer", ddmFormValuesJSONDeserializer);
		super.render(renderRequest, renderResponse);
	}
	
	

	public void saveTalk(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
		String talkIdValue = actionRequest.getParameter("talkId");
		Optional<Long> talkId = Optional.ofNullable(Validator.isBlank(talkIdValue) ? null : Long.parseLong(talkIdValue));

		ServiceContext serviceContext = ServiceContextFactory.getInstance(Talk.class.getName(), actionRequest);
		talkLocalService.saveTalk(
				talkId, 
				ParamUtil.get(actionRequest, "title", ""), 
				ParamUtil.getLong(actionRequest, "structureId", 0), 
				ParamUtil.getLong(actionRequest, "templateId", 0), 
				ParamUtil.getString(actionRequest, "ddmFormValues"),
				serviceContext);
	}

}