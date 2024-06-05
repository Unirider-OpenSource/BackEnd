package unirider.platform.iam.interfaces.rest.transform;

import unirider.platform.iam.domain.model.aggregates.User;
import unirider.platform.iam.domain.model.entities.Role;
import unirider.platform.iam.interfaces.rest.resources.UserResource;

public class UserResourceFromEntityAssembler {
    public static UserResource toResourceFromEntity(User user) {
        var roles = user.getRoles().stream().map(Role::getStringName).toList();
        return new UserResource(user.getId(), user.getUsername(), roles);
    }
}
