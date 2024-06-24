package unirider.platform.profiles.domain.services;

import unirider.platform.profiles.domain.model.commands.CreatePassengerCommand;
import unirider.platform.profiles.domain.model.commands.UpdatePassengerCommand;


public interface PassengerCommandService {
    Long handle(CreatePassengerCommand command);
    Long handle(UpdatePassengerCommand command);
}
