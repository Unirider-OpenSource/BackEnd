package unirider.platform.profiles.domain.services;

import unirider.platform.profiles.domain.model.aggregates.Profile;
import unirider.platform.profiles.domain.model.queries.GetAllProfilesQuery;
import unirider.platform.profiles.domain.model.queries.GetProfileByEmailQuery;
import unirider.platform.profiles.domain.model.queries.GetProfileByIdQuery;

import java.util.List;
import java.util.Optional;

public interface ProfileQueryService {
    Optional<Profile> handle(GetProfileByEmailQuery query);

    Optional<Profile> handle(GetProfileByIdQuery query);

    List<Profile> handle(GetAllProfilesQuery query);
}