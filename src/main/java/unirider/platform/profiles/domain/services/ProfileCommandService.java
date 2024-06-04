package unirider.platform.profiles.domain.services;


import unirider.platform.profiles.domain.model.aggregates.Profile;
import unirider.platform.profiles.domain.model.commands.CreateProfileCommand;

import java.util.Optional;

public interface ProfileCommandService {
    Optional<Profile> handle(CreateProfileCommand command);
}