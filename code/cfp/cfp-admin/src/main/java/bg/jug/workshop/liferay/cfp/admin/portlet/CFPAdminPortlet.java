package bg.jug.workshop.liferay.cfp.admin.portlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;

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
import com.liferay.portal.kernel.portlet.PortalPreferences;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import bg.jug.workshop.liferay.cfp.admin.constants.CFPAdminPortletKeys;
import bg.jug.workshop.liferay.cfp.model.Talk;
import bg.jug.workshop.liferay.cfp.service.EventLocalService;
import bg.jug.workshop.liferay.cfp.service.TalkLocalService;
import bg.jug.workshop.liferay.cfp.service.VenueLocalService;

/**
 * @author Milen Dyankov
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.hidden",
		"javax.portlet.display-name=CFP Administration",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + CFPAdminPortletKeys.CFP_ADMIN,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class CFPAdminPortlet extends MVCPortlet {

	@Reference
	EventLocalService eventLocalService;

	@Reference
	VenueLocalService venueLocalService;

	@Reference
	TalkLocalService talkLocalService;

	@Reference
	DDMFormValuesJSONDeserializer ddmFormValuesJSONDeserializer; 	
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		renderRequest.setAttribute("ddmFormValuesJSONDeserializer", ddmFormValuesJSONDeserializer);
		super.render(renderRequest, renderResponse);
	}
	
	public void changeDisplayStyle(ActionRequest actionRequest, ActionResponse actionResponse) {
		hideDefaultSuccessMessage(actionRequest);
		String displayStyle = ParamUtil.getString(actionRequest, "displayStyle");
		PortalPreferences portalPreferences = PortletPreferencesFactoryUtil.getPortalPreferences(actionRequest);
		portalPreferences.setValue(CFPAdminPortletKeys.CFP_ADMIN, "display-style", displayStyle);
	}
	

	public void saveEvent(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {

		String eventIdValue = actionRequest.getParameter("eventId");
		Optional<Long> eventId = Optional.ofNullable(Validator.isBlank(eventIdValue) ? null : Long.parseLong(eventIdValue));

		String venueIdValue = actionRequest.getParameter("venueId");
		Optional<Long> venueId = Optional.ofNullable(Validator.isBlank(venueIdValue) ? null : Long.parseLong(venueIdValue));

		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Date eventDate = ParamUtil.getDate(actionRequest, "date", sdf);

		String website = actionRequest.getParameter("website");
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
		eventLocalService.saveEvent(
				eventId, 
				ParamUtil.get(actionRequest, "name", ""), 
				eventDate,
				venueId,
				website,
				serviceContext);
	}
	
	public void updateEventSessions(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
		long[] talkIds = ParamUtil.getLongValues(actionRequest, "rowIds");
		long eventId = ParamUtil.getLong(actionRequest, "eventId");
		eventLocalService.updateTalks(eventId, Arrays.stream(talkIds).boxed().collect(Collectors.toList()));
	}
	
	public void saveVenue(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
		String venueIdValue = actionRequest.getParameter("venueId");
		Optional<Long> venueId = Optional.ofNullable(Validator.isBlank(venueIdValue) ? null : Long.parseLong(venueIdValue));
				
		ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
		venueLocalService.saveVenue(
				venueId, 
				ParamUtil.get(actionRequest, "name", ""), 
				ParamUtil.get(actionRequest, "address", ""), 
				ParamUtil.getDouble(actionRequest, "longitude"), 
				ParamUtil.getDouble(actionRequest, "latitude"), 
				serviceContext);
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

	public void deleteEvent(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
		long[] deleteEventIds = null;
		long eventId = ParamUtil.getLong(actionRequest, "eventId");

		if (eventId > 0) {
			deleteEventIds = new long[] {eventId};
		}
		else {
			deleteEventIds = ParamUtil.getLongValues(actionRequest, "rowIds");
		}

		for (long deleteVenueId : deleteEventIds) {
			eventLocalService.deleteEvent(deleteVenueId);
		}		
	}
	
	
	public void deleteVenue(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
		long[] deleteVenueIds = null;
		long venueId = ParamUtil.getLong(actionRequest, "venueId");

		if (venueId > 0) {
			deleteVenueIds = new long[] {venueId};
		}
		else {
			deleteVenueIds = ParamUtil.getLongValues(actionRequest, "rowIds");
		}

		for (long deleteVenueId : deleteVenueIds) {
			venueLocalService.deleteVenue(deleteVenueId);
		}		
	}
	
	public void deleteTalk(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
		long[] deleteTalkIds = null;
		long talkId = ParamUtil.getLong(actionRequest, "talkId");

		if (talkId > 0) {
			deleteTalkIds = new long[] {talkId};
		}
		else {
			deleteTalkIds = ParamUtil.getLongValues(actionRequest, "rowIds");
		}

		ServiceContext serviceContext = ServiceContextFactory.getInstance(Talk.class.getName(), actionRequest);

		for (long deleteTalkId : deleteTalkIds) {
			talkLocalService.deleteTalk(deleteTalkId, serviceContext);
		}		
	}
}