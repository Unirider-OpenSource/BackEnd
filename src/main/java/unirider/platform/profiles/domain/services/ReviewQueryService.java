package unirider.platform.profiles.domain.services;

import unirider.platform.profiles.domain.model.entities.Review;
import unirider.platform.profiles.domain.model.queries.GetAllReviewByDriverIdQuery;

import java.util.List;

public interface ReviewQueryService {
    List<Review> handle(GetAllReviewByDriverIdQuery query);
}
