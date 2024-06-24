package unirider.platform.profiles.interfaces.rest.transform;

import unirider.platform.profiles.domain.model.commands.UpdatePassengerCommand;
import unirider.platform.profiles.interfaces.rest.resources.CreatePassengerResource;


public class UpdatePassengerCommandFromResourceAssembler {

    public static UpdatePassengerCommand toCommandFromResource(CreatePassengerResource resource, Long passengerId) {
        UpdatePassengerCommand command = new UpdatePassengerCommand(
                passengerId,
                resource.name(),
                resource.email(),
                resource.dni(),
                resource.phone(),
                resource.photo()
        );
        return command;
    }

}
