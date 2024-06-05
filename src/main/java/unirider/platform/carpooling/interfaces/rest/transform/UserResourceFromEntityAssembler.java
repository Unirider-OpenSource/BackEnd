package unirider.platform.carpooling.interfaces.rest.transform;

import unirider.platform.carpooling.domain.model.aggregates.User;
import unirider.platform.carpooling.interfaces.rest.resources.UserResource;

public class UserResourceFromEntityAssembler {
    public static UserResource toResourceFromEntity(User user) {
        return new UserResource(
                user.getUserRecordId(),
                user.getProfileId()
        );
    }
}
