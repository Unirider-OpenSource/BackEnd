package unirider.platform.profiles.domain.services;

import unirider.platform.profiles.domain.model.commands.CreateReviewCommand;
import unirider.platform.profiles.domain.model.entities.Review;

public interface ReviewCommandService {
    Review handle(CreateReviewCommand command);
}
