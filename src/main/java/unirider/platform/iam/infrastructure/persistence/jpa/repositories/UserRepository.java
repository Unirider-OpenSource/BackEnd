package unirider.platform.iam.infrastructure.persistence.jpa.repositories;

import unirider.platform.iam.domain.model.aggregates.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository("iamUserRepository")
public interface UserRepository extends JpaRepository<User, Long>
{

    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);

}

