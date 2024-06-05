package unirider.platform.iam.domain.services;

import unirider.platform.iam.domain.model.aggregates.User;
import unirider.platform.iam.domain.model.queries.GetAllUsersQuery;
import unirider.platform.iam.domain.model.queries.GetUserByIdQuery;
import unirider.platform.iam.domain.model.queries.GetUserByUsernameQuery;
import java.util.List;
import java.util.Optional;

public interface UserQueryService {
    List<User> handle(GetAllUsersQuery query);
    Optional<User> handle(GetUserByIdQuery query);
    Optional<User> handle(GetUserByUsernameQuery query);

}
