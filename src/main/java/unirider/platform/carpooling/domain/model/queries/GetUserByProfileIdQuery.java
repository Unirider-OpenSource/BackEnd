package unirider.platform.carpooling.domain.model.queries;

import unirider.platform.carpooling.domain.model.valueobjects.ProfileId;

public record GetUserByProfileIdQuery(ProfileId profileId) {
}
