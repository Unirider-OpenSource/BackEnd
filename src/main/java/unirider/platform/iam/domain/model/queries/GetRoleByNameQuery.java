package unirider.platform.iam.domain.model.queries;

import unirider.platform.iam.domain.model.valueobjects.Roles;

public record GetRoleByNameQuery(Roles name) {
}
