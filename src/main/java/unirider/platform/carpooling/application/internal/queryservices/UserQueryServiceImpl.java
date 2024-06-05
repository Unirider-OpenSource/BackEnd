package unirider.platform.carpooling.application.internal.queryservices;

import unirider.platform.carpooling.domain.model.aggregates.User;
import unirider.platform.carpooling.domain.model.queries.GetUserByProfileIdQuery;
import unirider.platform.carpooling.domain.model.queries.GetUserByUniRiderUserRecordIdQuery;
import unirider.platform.carpooling.domain.services.UserQueryService;
import unirider.platform.carpooling.infrastructure.persistence.jpa.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implementation of UserQueryService
 *
 * <p>
 *     This class is the implementation of the UserQueryService interface.
 *     It is used to handle queries on the User aggregate.
 * </p>
 */
@Service
public class UserQueryServiceImpl implements UserQueryService {

    private final UserRepository userRepository;

    public UserQueryServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> handle(GetUserByProfileIdQuery query) {
        return userRepository.findByProfileId(query.profileId());
    }

    @Override
    public Optional<User> handle(GetUserByUniRiderUserRecordIdQuery query) {
        return userRepository.findByUniRiderUserRecordId(query.uniRiderUserRecordId());
    }
}
