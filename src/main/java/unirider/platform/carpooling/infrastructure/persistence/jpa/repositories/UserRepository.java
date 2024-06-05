package unirider.platform.carpooling.infrastructure.persistence.jpa.repositories;


import unirider.platform.carpooling.domain.model.aggregates.User;
import unirider.platform.carpooling.domain.model.valueobjects.ProfileId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unirider.platform.carpooling.domain.model.valueobjects.UniRiderUserRecordId;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByProfileId(ProfileId profileId);
    Optional<User> findByUniriderUserRecordId(UniRiderUserRecordId UserRecordId);
}
