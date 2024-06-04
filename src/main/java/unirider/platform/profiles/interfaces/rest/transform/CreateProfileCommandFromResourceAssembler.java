package unirider.platform.profiles.interfaces.rest.transform;

import unirider.platform.profiles.domain.model.commands.CreateProfileCommand;
import unirider.platform.profiles.interfaces.rest.resources.CreateProfileResource;

public class CreateProfileCommandFromResourceAssembler {
    public static CreateProfileCommand toCommandFromResource(CreateProfileResource resource) {
        return new CreateProfileCommand(resource.firstName(), resource.lastName(), resource.email(), resource.street(), resource.number(), resource.city(), resource.postalCode(), resource.country());
    }
}
