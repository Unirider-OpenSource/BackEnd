package unirider.platform.profiles.application.internal.queryservices;

import unirider.platform.profiles.domain.model.entities.Review;
import unirider.platform.profiles.domain.model.queries.GetAllReviewByDriverIdQuery;
import unirider.platform.profiles.domain.services.ReviewQueryService;
import unirider.platform.profiles.infrastructure.persistence.jpa.repositories.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewQueryServiceImpl implements ReviewQueryService {
    private final ReviewRepository reviewRepository;

    public ReviewQueryServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> handle(GetAllReviewByDriverIdQuery query) {
        return reviewRepository.findReviewByDriverId(query.driverId());
    }
}
