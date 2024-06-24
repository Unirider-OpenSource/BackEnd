package unirider.platform.profiles.interfaces.rest.transform;

import unirider.platform.profiles.domain.model.commands.CreatePassengerCommand;
import unirider.platform.profiles.interfaces.rest.resources.CreatePassengerResource;


public class CreatePassengerCommandFromResourceAssembler {

    public static CreatePassengerCommand toCommandFromResource(CreatePassengerResource resource) {
        return new CreatePassengerCommand(
                resource.name(),
                resource.email(),
                resource.dni(),
                resource.phone(),
                resource.photo()
        );
    }
}
