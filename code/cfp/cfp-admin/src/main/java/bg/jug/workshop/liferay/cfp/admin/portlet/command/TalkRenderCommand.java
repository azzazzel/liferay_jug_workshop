package bg.jug.workshop.liferay.cfp.admin.portlet.command;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.liferay.dynamic.data.mapping.io.DDMFormValuesJSONDeserializer;
import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.dynamic.data.mapping.model.DDMTemplate;
import com.liferay.dynamic.data.mapping.model.DDMTemplateConstants;
import com.liferay.dynamic.data.mapping.model.Value;
import com.liferay.dynamic.data.mapping.service.DDMStructureLocalService;
import com.liferay.dynamic.data.mapping.service.DDMTemplateLocalService;
import com.liferay.dynamic.data.mapping.storage.DDMFormFieldValue;
import com.liferay.dynamic.data.mapping.storage.DDMFormValues;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.io.unsync.UnsyncStringWriter;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.service.ClassNameLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.template.StringTemplateResource;
import com.liferay.portal.kernel.template.Template;
import com.liferay.portal.kernel.template.TemplateConstants;
import com.liferay.portal.kernel.template.TemplateHandler;
import com.liferay.portal.kernel.template.TemplateHandlerRegistryUtil;
import com.liferay.portal.kernel.template.TemplateManagerUtil;
import com.liferay.portal.kernel.template.TemplateVariableDefinition;
import com.liferay.portal.kernel.template.TemplateVariableGroup;
import com.liferay.portal.kernel.templateparser.TemplateNode;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;

import bg.jug.workshop.liferay.cfp.admin.constants.CFPAdminPortletKeys;
import bg.jug.workshop.liferay.cfp.model.Talk;
import bg.jug.workshop.liferay.cfp.service.TalkLocalService;

@Component(
		property = {
			"javax.portlet.name=" + CFPAdminPortletKeys.CFP_ADMIN,
			"javax.portlet.name=" + CFPAdminPortletKeys.CFP_TALK_DISPLAY,
			"mvc.command.name=preview",
		}
	)
public class TalkRenderCommand implements MVCRenderCommand  {

	@Reference
	ClassNameLocalService classNameLocalService; 	

	@Reference
	DDMStructureLocalService ddmStructureLocalService;

	@Reference
	DDMTemplateLocalService ddmTemplateLocalService;

	@Reference
	DDMFormValuesJSONDeserializer ddmFormValuesJSONDeserializer; 	

	@Reference
	TalkLocalService talkLocalService;
	
	private static final String PAGE = "/talk_preview.jsp";

	private static final Logger LOG = LoggerFactory.getLogger(TalkRenderCommand.class);
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		try {

			/*
			 * NOTE: The following can probably be done with a lot less code by using `com.liferay.portal.templateparser.Transformer`
			 * Unfortunately it is not (yet?) a service and it is `portal-impl.jar` and I as a general rule one should avoid 
			 * introducing dependencies on implementations. 
			 */
			
			
			long talkId = ParamUtil.getLong(renderRequest, "talkId");
			Talk talk = talkLocalService.getTalk(talkId);
			renderRequest.setAttribute("talk", talk);
			
			long structureId =  talk.getStructureId();
			DDMStructure structure = ddmStructureLocalService.getDDMStructure(structureId);
			renderRequest.setAttribute("structure", structure);

			ServiceContext serviceContext = ServiceContextFactory.getInstance(Talk.class.getName(), renderRequest);
			ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			Locale locale = PortalUtil.getLocale(renderRequest);
			Company company = PortalUtil.getCompany(renderRequest);
			long scopeGroupId = serviceContext.getScopeGroupId();
			long structureClassNameId = classNameLocalService.getClassNameId(DDMStructure.class.getName());

			DDMTemplate displayTemplate = ddmTemplateLocalService.getDDMTemplate(talk.getTemplateId());
			renderRequest.setAttribute("displayTemplate", displayTemplate);
			
			
			StringTemplateResource stringTemplateResource = new StringTemplateResource(String.valueOf(displayTemplate.getTemplateId()), displayTemplate.getScript());
			Template template = TemplateManagerUtil.getTemplate(displayTemplate.getLanguage(), stringTemplateResource, true);
			template.put("company", company);
			template.put("companyId", company.getCompanyId());
			template.put("device", themeDisplay.getDevice());
			template.put("permissionChecker", PermissionThreadLocal.getPermissionChecker());
			template.put("randomNamespace",StringUtil.randomId() + StringPool.UNDERLINE);
			template.put("scopeGroupId", scopeGroupId);
			template.put("siteGroupId", themeDisplay.getSiteGroup());
			template.put("groupId", scopeGroupId);
			template.put("viewMode", ParamUtil.getString(renderRequest, "viewMode", Constants.VIEW));
			template.put("templatesPath", getTemplatesPath(company.getCompanyId(), scopeGroupId, structureClassNameId));
			template.put("documentTitle", talk.getTitle());

			DDMFormValues formValues = ddmFormValuesJSONDeserializer.deserialize(structure.getDDMForm(), talk.getData());
			List<TemplateNode> templateNodes = getTemplateNodes(formValues.getDDMFormFieldValues(), locale, themeDisplay);
			for (TemplateNode templateNode : templateNodes) {
				template.put(templateNode.getName(), templateNode);
			}
			
			checkTemplateVariables(template, structureId, locale);
			
			UnsyncStringWriter writer = new UnsyncStringWriter();
			template.processTemplate(writer);
			renderRequest.setAttribute("result", writer.toString());
			
		} catch (PortalException e) {
			throw new PortletException(e);
		}
				
		return PAGE;
	}

	private void checkTemplateVariables(Template template, long structureId, Locale locale) {
		TemplateHandler templateHandler = TemplateHandlerRegistryUtil.getTemplateHandler(Talk.class.getName());
		template.putAll(templateHandler.getCustomContextObjects());
		List<String> missing = new LinkedList<>();
		Map<String, TemplateVariableGroup> groups;
		try {
			// second parameter is language but it's not used
			groups = templateHandler.getTemplateVariableGroups(structureId, null, locale);
		} catch (Exception e) {
			LOG.warn("Unable to check template variables ", e);
			return;
		}
		for (TemplateVariableGroup templateVariableGroup : groups.values()) {
			for (TemplateVariableDefinition templateVariableDefinition : templateVariableGroup.getTemplateVariableDefinitions()) {
				if (!template.containsKey(templateVariableDefinition.getName())) {
					missing.add(templateVariableDefinition.getName());
				}
			}
		}
		if (!missing.isEmpty()) {
			throw new IllegalStateException ("The following tempate variables do not have values: " + missing);
		}
	}

	
	private List<TemplateNode> getTemplateNodes (List<DDMFormFieldValue> formFieldValues, Locale locale, ThemeDisplay themeDisplay) {
		List<TemplateNode> templateNodes = new LinkedList<>();
		for (DDMFormFieldValue formFieldValue : formFieldValues) {
			Value value = formFieldValue.getValue();
			if (value == null) {
				List<DDMFormFieldValue> nestedFormFieldValues = formFieldValue.getNestedDDMFormFieldValues();
				if ( nestedFormFieldValues != null && !nestedFormFieldValues.isEmpty() ) {
					templateNodes.addAll(getTemplateNodes(formFieldValue.getNestedDDMFormFieldValues(), locale, themeDisplay));
				}
			} else {
				TemplateNode templateNode = new TemplateNode(
						themeDisplay,
						formFieldValue.getName(),
						value.getString(locale),
						formFieldValue.getType(),
						Collections.emptyMap());

				List<DDMFormFieldValue> nestedFormFieldValues = formFieldValue.getNestedDDMFormFieldValues();
				if ( nestedFormFieldValues != null && !nestedFormFieldValues.isEmpty() ) {
					templateNode.appendChildren(getTemplateNodes(formFieldValue.getNestedDDMFormFieldValues(), locale, themeDisplay));
				}
				templateNodes.add(templateNode);
			}
		}		
		return templateNodes;
	}
	
	private String getTemplatesPath(
			long companyId, long groupId, long classNameId) {

			StringBundler sb = new StringBundler(7);

			sb.append(TemplateConstants.TEMPLATE_SEPARATOR);
			sb.append(StringPool.SLASH);
			sb.append(companyId);
			sb.append(StringPool.SLASH);
			sb.append(groupId);
			sb.append(StringPool.SLASH);
			sb.append(classNameId);

			return sb.toString();
		}

}
