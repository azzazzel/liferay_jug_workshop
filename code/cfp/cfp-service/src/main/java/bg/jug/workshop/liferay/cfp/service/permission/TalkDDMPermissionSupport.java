package bg.jug.workshop.liferay.cfp.service.permission;

import org.osgi.service.component.annotations.Component;

import com.liferay.dynamic.data.mapping.util.DDMStructurePermissionSupport;
import com.liferay.dynamic.data.mapping.util.DDMTemplatePermissionSupport;

@Component(
		immediate = true,
		property =
			{"model.class.name=bg.jug.workshop.liferay.cfp.model.Talk"}
	)
public class TalkDDMPermissionSupport implements DDMStructurePermissionSupport, DDMTemplatePermissionSupport {

	@Override
	public String getResourceName(long classNameId) {
		return "bg.jug.workshop.liferay.cfp.model";
	}

	@Override
	public String getResourceName() {
		return "bg.jug.workshop.liferay.cfp.model";
	}

}
