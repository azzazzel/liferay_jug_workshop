package bg.jug.workshop.liferay.rest.application;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import com.google.gson.Gson;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserGroup;
import com.liferay.portal.kernel.model.Website;
import com.liferay.portal.kernel.service.ListTypeLocalService;
import com.liferay.portal.kernel.service.UserGroupLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.DigesterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.URLCodec;

/**
 * This is a standard Java JAX-RS application that uses internal OSGi services 
 * to get the people who are members of the {@code BGJUG team} user group
 * and return JSON formatted information about them
 * 
 * @author Milen Dyankov
 */
@Component(
	immediate = true, 
	service = Application.class,
	property = {
			JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/jug-leaders",
			JaxrsWhiteboardConstants.JAX_RS_NAME + "=jug.leaders.rest.api"
		}
)
public class JugLeadersApplication extends Application {

	private static Log log = LogFactoryUtil.getLog(JugLeadersApplication.class);
	
	@Reference
	private UserLocalService userLocalService;

	@Reference
	private UserGroupLocalService userGroupLocalService;
	
	@Reference
	private ListTypeLocalService listTypeLocalService;

	
	@Override
	public Set<Object> getSingletons() {
		return Collections.singleton((Object)this);
	}
	

	@GET
	@Path("/{groupName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@Context HttpServletRequest request, @PathParam("groupName") String group) {
		
		if (log.isDebugEnabled()) {
			log.debug("REST request for group " + group);
		}
		
		long companyId = PortalUtil.getCompanyId(request);

		UserGroup userGroup = userGroupLocalService.fetchUserGroup(companyId, group);
		if (userGroup != null) {
			List<User> users = userLocalService.getUserGroupUsers(userGroup.getUserGroupId());
			List<UserDTO> usersDTO = new LinkedList<>();
			for (User u : users) {
				UserDTO dto = new UserDTO();
				dto.name = u.getFullName(); 
				dto.description = u.getComments();
				dto.imageId = u.getPortraitId(); 
				dto.imageUUID = URLCodec.encodeURL(DigesterUtil.digest(u.getUserUuid())); 
				dto.websites = new LinkedList<>();
				for (Website website : u.getWebsites()) {
					WebsiteDTO websiteDTO = new WebsiteDTO();
					websiteDTO.url = website.getUrl();
					try {
						websiteDTO.type = listTypeLocalService.getListType(website.getTypeId()).getName();
					} catch (PortalException e) {
					}
					dto.websites.add(websiteDTO);
				}
				usersDTO.add(dto);
			}
			Gson gson = new Gson();
			return Response.ok(gson.toJson(usersDTO)).build();
		}
		return Response.status(404).build();		
	}

	/**
	 * Data transfer object representing the user 
	 */
	class UserDTO {
		String name;
		String description;
		long imageId;
		String imageUUID;
		List<WebsiteDTO> websites;
	}

	/**
	 * Data transfer object representing website
	 */
	class WebsiteDTO {
		String url;
		String type;
	}

}