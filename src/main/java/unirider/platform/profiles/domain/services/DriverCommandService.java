package unirider.platform.profiles.domain.services;

import unirider.platform.profiles.domain.model.commands.CreateDriverCommand;
import unirider.platform.profiles.domain.model.commands.CreateDriverImageCommand;
import unirider.platform.profiles.domain.model.commands.UpdateDriverCommand;

public interface DriverCommandService {
    Long handle(CreateDriverCommand command);
    Long handle(UpdateDriverCommand command);
    Long handle(CreateDriverImageCommand command);
}
