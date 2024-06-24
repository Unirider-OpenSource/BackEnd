package unirider.platform.profiles.infrastructure.persistence.jpa.repositories;

import unirider.platform.profiles.domain.model.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findReviewByDriverId(Long driverId);
    List<Review> findReviewByPassengerId(Long passengerId);
}
