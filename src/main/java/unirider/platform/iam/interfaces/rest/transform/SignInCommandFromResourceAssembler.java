package unirider.platform.iam.interfaces.rest.transform;

import unirider.platform.iam.domain.model.commands.SignInCommand;
import unirider.platform.iam.interfaces.rest.resources.SignInResource;

public class SignInCommandFromResourceAssembler {
    public static SignInCommand toCommandFromResource(SignInResource signInResource) {
        return new SignInCommand(signInResource.username(), signInResource.password());
    }
}

