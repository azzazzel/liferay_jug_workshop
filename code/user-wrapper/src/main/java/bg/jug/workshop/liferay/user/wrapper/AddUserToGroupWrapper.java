package bg.jug.workshop.liferay.user.wrapper;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserGroup;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.UserGroupLocalService;
import com.liferay.portal.kernel.service.UserLocalServiceWrapper;

/**
 * @author Milen Dyankov
 */
@Component(immediate = true, property = {}, service = ServiceWrapper.class)
public class AddUserToGroupWrapper extends UserLocalServiceWrapper {

	public AddUserToGroupWrapper() {
		super(null);
	}

	@Reference
	private UserGroupLocalService userGroupLocalService;

	@Override
	public User addUser(long creatorUserId, long companyId, boolean autoPassword, String password1, String password2,
			boolean autoScreenName, String screenName, String emailAddress, long facebookId, String openId,
			Locale locale, String firstName, String middleName, String lastName, long prefixId, long suffixId,
			boolean male, int birthdayMonth, int birthdayDay, int birthdayYear, String jobTitle, long[] groupIds,
			long[] organizationIds, long[] roleIds, long[] userGroupIds, boolean sendEmail,
			ServiceContext serviceContext) throws PortalException {

		User user = super.addUser(creatorUserId, companyId, autoPassword, password1, password2, autoScreenName,
				screenName, emailAddress, facebookId, openId, locale, firstName, middleName, lastName, prefixId,
				suffixId, male, birthdayMonth, birthdayDay, birthdayYear, jobTitle, groupIds, organizationIds, roleIds,
				userGroupIds, sendEmail, serviceContext);

		addUserToUserGroup(user, serviceContext);

		return user;
	}

	@Override
	public User addUserWithWorkflow(long creatorUserId, long companyId, boolean autoPassword, String password1,
			String password2, boolean autoScreenName, String screenName, String emailAddress, long facebookId,
			String openId, Locale locale, String firstName, String middleName, String lastName, long prefixId,
			long suffixId, boolean male, int birthdayMonth, int birthdayDay, int birthdayYear, String jobTitle,
			long[] groupIds, long[] organizationIds, long[] roleIds, long[] userGroupIds, boolean sendEmail,
			ServiceContext serviceContext) throws PortalException {

		System.out.println("ADD WITH WORKFLOW");

		User user = super.addUserWithWorkflow(creatorUserId, companyId, autoPassword, password1, password2,
				autoScreenName, screenName, emailAddress, facebookId, openId, locale, firstName, middleName, lastName,
				prefixId, suffixId, male, birthdayMonth, birthdayDay, birthdayYear, jobTitle, groupIds, organizationIds,
				roleIds, userGroupIds, sendEmail, serviceContext);

		addUserToUserGroup(user, serviceContext);

		return user;
	}

	private void addUserToUserGroup(User user, ServiceContext serviceContext) throws PortalException {
		UserGroup userGroup = userGroupLocalService.fetchUserGroup(user.getCompanyId(), "BGJUG team");
		if (userGroup == null) {
			userGroup = userGroupLocalService.addUserGroup(serviceContext.getUserId(), serviceContext.getCompanyId(),
					"BGJUG team", "", serviceContext);
		}
		
		String email = user.getEmailAddress();
		if (email.endsWith("jug.bg"))  {
			userGroupLocalService.addUserUserGroup(user.getUserId(), userGroup);
		}
		
	}

}