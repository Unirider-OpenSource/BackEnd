package unirider.platform.iam.domain.services;

import unirider.platform.iam.domain.model.entities.Role;
import unirider.platform.iam.domain.model.queries.GetAllRolesQuery;
import unirider.platform.iam.domain.model.queries.GetRoleByNameQuery;

import java.util.List;
import java.util.Optional;

public interface RoleQueryService {
    List<Role>handle(GetAllRolesQuery query);
    Optional<Role>handle(GetRoleByNameQuery query);
}
