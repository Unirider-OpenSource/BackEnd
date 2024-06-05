package unirider.platform.carpooling.domain.services;

import unirider.platform.carpooling.domain.model.aggregates.User;
import unirider.platform.carpooling.domain.model.queries.GetUserByProfileIdQuery;
import unirider.platform.carpooling.domain.model.queries.GetUserByUniRiderUserRecordIdQuery;

import java.util.Optional;

public interface UserQueryService {
    Optional<User> handle(GetUserByProfileIdQuery query);
    Optional<User> handle(GetUserByUniRiderUserRecordIdQuery query);

}
