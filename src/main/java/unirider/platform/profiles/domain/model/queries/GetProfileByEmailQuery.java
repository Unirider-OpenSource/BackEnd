package unirider.platform.profiles.domain.model.queries;

import unirider.platform.profiles.domain.model.valueobjects.EmailAddress;

public record GetProfileByEmailQuery(EmailAddress emailAddress) {
}
