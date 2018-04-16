/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package bg.jug.workshop.liferay.cfp.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.liferay.calendar.exception.NoSuchResourceException;
import com.liferay.dynamic.data.mapping.exception.NoSuchStructureLinkException;
import com.liferay.dynamic.data.mapping.kernel.DDMStructureLink;
import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.dynamic.data.mapping.model.DDMTemplateLink;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Resource;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.PortalUtil;

import bg.jug.workshop.liferay.cfp.exception.NoSuchTalkException;
import bg.jug.workshop.liferay.cfp.model.Talk;
import bg.jug.workshop.liferay.cfp.service.TalkLocalService;
import bg.jug.workshop.liferay.cfp.service.base.TalkLocalServiceBaseImpl;

/**
 * The implementation of the talk local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link bg.jug.workshop.liferay.cfp.service.TalkLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TalkLocalServiceBaseImpl
 * @see bg.jug.workshop.liferay.cfp.service.TalkLocalServiceUtil
 */
public class TalkLocalServiceImpl extends TalkLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link bg.jug.workshop.liferay.cfp.service.TalkLocalServiceUtil} to access the talk local service.
	 */

	private static Logger logger = LoggerFactory.getLogger(TalkLocalServiceImpl.class);
	
	
	/**
	 * Returns a list of all talks for given platform instance (company) and site (group)
	 * 
	 * @param companyId the id of the portal instance (guarantees data sharding in multi-tenant environments)
	 * @param groupId the id of the site (guarantees data sharding in multi-hosting environments)
	 */
	public List<Talk> getGroupTalks(long companyId, long groupId) {
		/*
		 * since we have a finder already generated in the persistence layer,
		 * let's just delegate to it 
		 */
		return talkPersistence.findByCompanyAndGroup(companyId, groupId);
	}

	/**
	 * Returns a subset (page) of talks for given platform instance (company) and site (group)
	 * 
	 * @param companyId the id of the portal instance (guarantees data sharding in multi-tenant environments)
	 * @param groupId the id of the site (guarantees data sharding in multi-hosting environments)
	 * @param start the record to start from
	 * @param end the record to end at
	 */
	public List<Talk> getGroupTalks(long companyId, long groupId, int start, int end) {
		/*
		 * since we have a finder already generated in the persistence layer,
		 * let's just delegate to it 
		 */
		return talkPersistence.findByCompanyAndGroup(companyId, groupId, start, end);
	}

	public int countGroupTalks(long companyId, long groupId) {
		/*
		 * since we have a finder already generated in the persistence layer,
		 * let's just delegate to it 
		 */
		return talkPersistence.countByCompanyAndGroup(companyId, groupId);
	}

	
	/** 
	 * This method creates a new talk or updates an existing one. 
	 * <p>
	 * If there is {@code talkId} provided it updates the talk with that id. Otherwise it creates a new talk.
	 * <p>
	 * This method also creates/updates :
	 * <ul>
	 * 	<li> respective {@link Resource} entity. This is needed to link the talk with the resource framework 
	 * which among other things is used to manage resources' permissions 
	 *  <li> respective {@link DDMStructureLink} entity. This is needed to indicate the talk uses given {@link DDMStructure} 
	 * to prevent the structure from being deleted when there are talks using it. 
	 * </ul>
	 * <strong>Important information for wrapping this method: </strong>
	 * <ul>
	 * 	<li> it uses  {@code counterLocalService.increment(Talk.class.getName())} as opposite to {@code counterLocalService.increment()}.
	 * Take that into account to avoid id collisions if you modify the talk creation process. 
	 * </ul>
	 *  
	 * 	@param talkId the id of the talk to save. If provided the id MUST be positive value.
	 *  @param structureId the id of the {@code DDMStructure} that defines the structure of the data
	 *  @param data the talk's data in a form described by the respective {@code DDMStructure}
	 * 	@param serviceContext the context of the service request (generated by the caller from servlet or portlet requests)
	 * 
	 * 	@throws IllegalArgumentException if {@code talkId} is provided but it is not a positive value
	 * 	@throws NoSuchTalkException if {@code talkId} is provided but a talk with such id can not be found
	 * 	@throws PortalException if any other error occur 
	 */
	public Talk saveTalk(
			Optional<Long> talkId, 
			String title, 
			long structureId, 
			long templateId, 
			String data,
			ServiceContext serviceContext) throws PortalException {

		/*
		 * First, things first - we need to figure out if we are creating a new talk
		 * or updating existing one.
		 */
		Talk talk;
		if (talkId.isPresent()) {
			/*
			 * The caller's intention was to update a talk. We need to check if the id is correct.
			 */
			long tId = talkId.get();
			if (tId > 0) { 	
				/*
				 * The id is correct, so lets try to load the talk.
				 * There are 2 methods generated by service builder that can do that 
				 *  - getTalk() throws NoSuchTalkException if no talk is found with given Id
				 *  - fetchTalk() returns null if no talk is found with given Id
				 */
				talk = getTalk(tId);
			} else {
				/*
				 * The id is incorrect. Let's inform the caller by throwing IllegalArgumentException
				 */
				throw new IllegalArgumentException("Talk id must be positive value!");
			}
		} else {
			/*
			 * The caller's intention was to create a talk.
			 * To create a talk we need to generate an id. For that we use'll use the 
			 * counterLocalService reference to which is conveniently provided by the base model.
			 */
			talk = createTalk(counterLocalService.increment(Talk.class.getName()));	
		}

		/*
		 * Lets get and keep some data handy in local variables as we'll need it later.
		 */
		long userId = serviceContext.getUserId();			// the user who invoked the service
		long companyId = serviceContext.getCompanyId();		// the id of the instance (tennant)
		long groupId = serviceContext.getScopeGroupId();	// the id of the site
		long oldStructureId = talk.getStructureId();		// the id of the structure from the existing talk
		long oldTemplateId = talk.getTemplateId();			// the id of the template from the existing talk
		Date date = new Date();								

		/*
		 * Now we are ready to build a talk model
		 */
		talk.setCompanyId(companyId);
		talk.setGroupId(groupId);
		talk.setUserId(userId);
		talk.setUserName(PortalUtil.getUserName(userId, "unknown"));
		if (talk.isNew()) {
			talk.setCreateDate(date); 						// we must not *update* creation date
		}
		talk.setModifiedDate(date);
		talk.setTitle(title);
		talk.setStructureId(structureId);
		talk.setTemplateId(templateId);
		talk.setData(data);

		
		/*
		 * Time to take care of the related entities
		 */
		if (talk.isNew()) {
			/*
			 * For new talks we need to create a link to the DDM structure that describes 
			 * how our data looks like. We need to do that to prevent the structure from being 
			 * deleted while still used by some other entities. 
			 */
			ddmStructureLinkLocalService.addStructureLink(
					classNameLocalService.getClassNameId(Talk.class.getName()), 
					talk.getTalkId(), 
					talk.getStructureId());

			
			/*
			 * For new talks we need to also create a link to the DDM template that describes 
			 * how our data will be rendered. We need to do that to prevent the template from being 
			 * deleted while still used by some other entities. 
			 */
			ddmTemplateLinkLocalService.addTemplateLink(
					classNameLocalService.getClassNameId(Talk.class.getName()), 
					talk.getTalkId(), 
					talk.getTemplateId());

			/*
			 * For new talks we need to create a resource. Think of it an one-to-one relation between
			 * talks and resources. Some generic Liferay frameworks (like permission checking) are designed 
			 * to work with resources. By "making our entities resources" we can leverage those frameworks.
			 */
			resourceLocalService.addResources(
					companyId,					// the id of the instance (useful in mutli-tenant environment)
					groupId,					// the id of the site
					userId,						// the id of the currently logged in user
				    Talk.class.getName(), 		// the type of the model to add resource for
				    talk.getTalkId(), 			// the id of the model entity to add resource for
				    false, 						// is this a portlet resource (if it is not then it is a model resource)
				    true, 						// should the default permissions for the site be used 
				    true						// should the default permissions for the guest user be used
				    );
		} else {
			/*
			 * For existing talks we need to check if the DDM structure was changed. 
			 * If it was, we need to update the link  
			 */
			if (talk.getStructureId() != oldStructureId) {
				/*
				 * Unfortunately ddmStructureLinkLocalService does not provide
				 * update method where the id of the link itself is not needed.
				 * 
				 */
				ddmStructureLinkLocalService.deleteStructureLink(
						classNameLocalService.getClassNameId(Talk.class.getName()), 
						talk.getTalkId(), 
						talk.getStructureId());
				ddmStructureLinkLocalService.addStructureLink(
						classNameLocalService.getClassNameId(Talk.class.getName()), 
						talk.getTalkId(), 
						talk.getStructureId());
			}

			/*
			 * For existing talks we need to check if the DDM template was changed. 
			 * If it was, we need to update the link  
			 */
			if (talk.getTemplateId() != oldTemplateId) {
				/*
				 * NOTE: It is unclear to me why ddmTemplateLinkLocalService
				 * only allows 1 to 1 relationship with given class 
				 * but it seams to be the case. It will work in this case as
				 * we only link to display templates and we only need one of those 
				 */
				ddmTemplateLinkLocalService.updateTemplateLink(
						classNameLocalService.getClassNameId(Talk.class.getName()), 
						talk.getTalkId(), 
						talk.getTemplateId());
			}
			
			/*
			 * For existing talks we need to update the resource to update possible permissions
			 * changes coming from the front-end and passed in the service context
			 */
			resourceLocalService.updateResources(
					companyId,								// the id of the instance (useful in mutli-tenant environment)
					groupId,								// the id of the site
					Talk.class.getName(), 					// the type of the model to add resource for
					talk.getTalkId(), 						// the id of the model entity to add resource for
				    serviceContext.getGroupPermissions(), 	// the new group permissions 
				    serviceContext.getGuestPermissions()	// the new guest permissions
				    );
		}
		
		/*
		 * Finally we can update out talk.
		 * Calling update works 
		 */
		return super.updateTalk(talk);
	}
	
	/** 
	 * Deletes given talk, it's respective resource entity (if present) and structure link (if present). 
	 *  
	 * 	@param talkId the id of the talk to delete
	 * 	@param serviceContext the context of the service request (generated by the caller from servlet or portlet requests)
	 * 
	 * 	@throws PortalException if any error occur 
	 */
	public Talk deleteTalk(long talkId, ServiceContext serviceContext) throws PortalException {

		/*
		 * Get the talk model.
		 * We need it in order to find the structure link below.
		 */
		Talk talk = fetchTalk(talkId);
		
		/*
		 * Throw exception if we can't find the talk. We can't remove what does not exists.
		 */
		if (talk == null) {
			throw new NoSuchTalkException();
		}
		
		/*
		 * Delete the link to the structure.
		 */
		try {
			ddmStructureLinkLocalService.deleteStructureLink(
					classNameLocalService.getClassNameId(Talk.class.getName()), 
					talk.getTalkId(), 
					talk.getStructureId());
		} catch (NoSuchStructureLinkException e) {
			/*
			 *  oh well, if there is no structure linked we'll just delete the talk.
			 *  But that means there is likely inconsistent data in our database, 
			 *  so let's be a good citizen and print a warning.
			 */
			logger.warn("Missing structure link for talk id {}. Please check for data inconsistency!", talk.getTalkId());
		}
		
		/*
		 * Delete the link to the template.
		 *
		 * NOTE: Seems like template link API is pretty silent
		 * Perhaps this should be handled differently. 
		 * But we work with what we have 
		 */
		ddmTemplateLinkLocalService.deleteTemplateLink(
				classNameLocalService.getClassNameId(Talk.class.getName()), 
				talk.getTalkId());

		/*
		 * Delete the link to the resource.
		 */
		try {
			resourceLocalService.deleteResource(
					serviceContext.getCompanyId(),			// the id of the instance (useful in mutli-tenant environment)
					Talk.class.getName(), 					// the type of the model to add resource for
	                ResourceConstants.SCOPE_INDIVIDUAL,
	                talkId);
		} catch (NoSuchResourceException e) {
			/*
			 *  oh well, if there is no resource linked we'll just delete the talk.
			 *  But that means there is likely inconsistent data in our database, 
			 *  so let's be a good citizen and print a warning.
			 */
			logger.warn("Missing resource link for talk id {}. Please check for data inconsistency!", talk.getTalkId());
		}

		/*
		 *  Now let's delete the talk itself
		 */
		return super.deleteTalk(talkId);
	}
	
	
	/* 
	 * ==================================================
	 * While service builder generates many convenient methods, once we've changed 
	 * the basic CRUD logic, those must not be used. To not confuse callers and wrappers 
	 * we should deprecate and override those automatically generated methods that appear
	 * to be useful but collide with the changed CRUD logic.
	 * ==================================================  
	 */
	
	/**
	 * This automatically generated method must not be used and was overridden to throw {@link UnsupportedOperationException}.  
	 * Please use {@link TalkLocalService#saveTalk(Optional, String, long, String, ServiceContext)} instead.
	 * 
	 *  @throws IllegalArgumentException
	 */
	@Override
	@Deprecated
	public Talk updateTalk(Talk talk) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	/**
	 * This automatically generated method must not be used and was overridden to throw {@link UnsupportedOperationException}.  
	 * Please use {@link TalkLocalService#saveTalk(Optional, String, long, String, ServiceContext)} instead.
	 * 
	 *  @throws IllegalArgumentException
	 */
	@Override
	@Deprecated
	public Talk addTalk(Talk talk) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * This automatically generated method must not be used and was overridden to throw {@link UnsupportedOperationException}.  
	 * Please use {@link TalkLocalService#deleteTalk(long, ServiceContext)} instead.
	 * 
	 *  @throws IllegalArgumentException
	 */
	@Override
	@Deprecated
	public Talk deleteTalk(long talkId) throws PortalException {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * This automatically generated method must not be used and was overridden to throw {@link UnsupportedOperationException}.  
	 * Please use {@link TalkLocalService#deleteTalk(long, ServiceContext)} instead.
	 * 
	 *  @throws IllegalArgumentException
	 */
	@Override
	@Deprecated
	public Talk deleteTalk(Talk talk) {
		throw new UnsupportedOperationException();
	}

	/**
	 * This automatically generated method should not be used as it does not take multi-tenancy and multi-hosting into account.
	 */
	@Override
	public List<Talk> getTalks(int start, int end) {
		logger.warn("This method does not take multi-tenancy and multi-hosting into account. Most likely this is not what you want!");
		return super.getTalks(start, end);
	}

	/**
	 * This automatically generated method should not be used as it does not take multi-tenancy and multi-hosting into account.
	 */
	@Override
	public int getTalksCount() {
		logger.warn("This method does not take multi-tenancy and multi-hosting into account. Most likely this is not what you want!");
		return super.getTalksCount();
	}
}