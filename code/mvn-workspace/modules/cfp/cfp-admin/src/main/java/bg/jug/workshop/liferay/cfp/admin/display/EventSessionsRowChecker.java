package bg.jug.workshop.liferay.cfp.admin.display;

import javax.portlet.PortletResponse;

import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;

import bg.jug.workshop.liferay.cfp.model.Talk;
import bg.jug.workshop.liferay.cfp.service.TalkLocalServiceUtil;

public class EventSessionsRowChecker extends EmptyOnClickRowChecker {

	long eventId;
	
	public EventSessionsRowChecker(PortletResponse portletResponse, long eventId) {
		super(portletResponse);
		this.eventId = eventId;
	}

	@Override
	public boolean isChecked(Object obj) {
		Talk talk = (Talk)obj;
		return TalkLocalServiceUtil.hasEventTalk(eventId, talk.getTalkId());
	}
	
}
