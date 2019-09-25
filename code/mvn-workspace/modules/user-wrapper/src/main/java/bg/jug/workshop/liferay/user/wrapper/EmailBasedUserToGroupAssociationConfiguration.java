package bg.jug.workshop.liferay.user.wrapper;


import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition.Scope;

import aQute.bnd.annotation.metatype.Meta;


@ExtendedObjectClassDefinition(
	    category = "users",
	    scope = Scope.COMPANY,
	    factoryInstanceLabelAttribute = "configurationName"
	)
@Meta.OCD(
	    id = EmailBasedUserToGroupAssociationConfiguration.ID,
	    localization = "content/Language", 
	    name = "email-based-user-to-group-association-configuration",
	    factory = true
	)
public interface EmailBasedUserToGroupAssociationConfiguration {
	
	/*
	 * MUST BE the FQCN 
	 */
	static final String ID = "bg.jug.workshop.liferay.user.wrapper.EmailBasedUserToGroupAssociationConfiguration";

    @Meta.AD(
            name = "configuration-name",
			required = true
        )
    public String configurationName();

	
    @Meta.AD(
            name = "group-name",
			required = true
        )
    public String groupName();

    @Meta.AD(
            name = "create-group-if-not-exists",
			required = true
        )
    public boolean createGroup();

    
    @Meta.AD(
            name = "email-regex",
			required = true
        )
    public String emailRegex();
}
