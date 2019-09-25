package bg.jug.workshop.liferay.user.wrapper;

import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserGroup;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.UserGroupLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.UserLocalServiceWrapper;

import aQute.bnd.annotation.metatype.Configurable;

/**
 * This is a service wrapper that wraps calls to methods in UserLocalService
 * We use it here to wrap the 
 * {@link UserLocalService#addUser(long, long, boolean, String, String, boolean, String, String, long, String, Locale, String, String, String, long, long, boolean, int, int, int, String, long[], long[], long[], long[], boolean, ServiceContext)}}
 * and 
 * {@link UserLocalService#addUserWithWorkflow(long, long, boolean, String, String, boolean, String, String, long, String, Locale, String, String, String, long, long, boolean, int, int, int, String, long[], long[], long[], long[], boolean, ServiceContext)}
 * methods to create 
 * <ul>
 * 	<li> create a user group if it does not exists</li>
 * 	<li> add the user being created to that user group if his domain is in {@code jug.bg} domain</li>
 * </ul>
 * 
 * <p> NOTE: The tricky part when writing wrappers is knowing which method(s) to wrap! For example there is also 
 * {@link UserLocalService#addUser(User)} method which is automatically generated by service builder 
 * but it is not used. Unfortunately there is no easy way to figure out which methods are used and which are not! 
 * 
 * <p> NOTE: One option to make it easier for people writing wrappers and calling service builder generated APIs
 * is to deprecate unused methods in {@code *LocalServiceImpl} classes and make them throw {@code UnsupportedOperationException}
 * See {@code TalkLocalServiceImpl#addTalk(Talk)} in {@code cfp/cfp-service} project for example. Unfortunately Liferay's
 * OOTB services do not do that.
 * 
 * @author Milen Dyankov
 */

@Component(
		immediate = true, 
		service = ServiceWrapper.class,
		configurationPid = EmailBasedUserToGroupAssociationConfiguration.ID,
		configurationPolicy = ConfigurationPolicy.REQUIRE
	)
public class EmailBasedUserToGroupAssociation extends UserLocalServiceWrapper {

	private static Log log = LogFactoryUtil.getLog(EmailBasedUserToGroupAssociation.class);

	private EmailBasedUserToGroupAssociationConfiguration configuration;
	
	@Reference
	private UserGroupLocalService userGroupLocalService;

	
	public EmailBasedUserToGroupAssociation() {
		super(null);
	}

	@Activate
	@Modified
	protected void start (Map<String, Object> configuration) {
		this.configuration = Configurable.createConfigurable(EmailBasedUserToGroupAssociationConfiguration.class, configuration);
	}
	
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

		User user = super.addUserWithWorkflow(creatorUserId, companyId, autoPassword, password1, password2,
				autoScreenName, screenName, emailAddress, facebookId, openId, locale, firstName, middleName, lastName,
				prefixId, suffixId, male, birthdayMonth, birthdayDay, birthdayYear, jobTitle, groupIds, organizationIds,
				roleIds, userGroupIds, sendEmail, serviceContext);

		addUserToUserGroup(user, serviceContext);

		return user;
	}

	/**
	 * Creates user group if it does not exists and adds the user to it if the email is in {@code jig.bg} domain
	 * 
	 * @param user the user being created
	 * @param serviceContext the context of the service request (generated by the caller from servlet or portlet requests)
	 * @throws PortalException if any error occur 
	 */
	private void addUserToUserGroup(User user, ServiceContext serviceContext) throws PortalException {
		
		String email = user.getEmailAddress();
		if (email.matches(configuration.emailRegex())) {

			/*
			 * There are always 2 methods in every `*LocalService` for obtaining entities by id:
			 * - fetch*(...) - which returns `null` if the entity is not found
			 * - get*(...) - which throws an exception if the entity is not found
			 */
			UserGroup userGroup = userGroupLocalService.fetchUserGroup(user.getCompanyId(), configuration.groupName());

			if (userGroup == null && configuration.createGroup()) {
				log.info("Creating group " + configuration.groupName());
				userGroup = userGroupLocalService.addUserGroup(
					serviceContext.getUserId(), 	// the id of the user group
					serviceContext.getCompanyId(),	// the id of the instance (useful in mutli-tenant environment)
					configuration.groupName(),		// the name of the user group
					"",								// the description of the user group
					serviceContext					// the context of the service request
				);
			}

			log.info("Adding user " + user.getScreenName() + " to group " + configuration.groupName());
			userGroupLocalService.addUserUserGroup(user.getUserId(), userGroup);
		}
		
	}

}