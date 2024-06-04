package unirider.platform.profiles.infrastructure.persistence.jpa.repositories;


import unirider.platform.profiles.domain.model.aggregates.Profile;
import unirider.platform.profiles.domain.model.valueobjects.EmailAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Optional<Profile> findByEmail(EmailAddress emailAddress);
}