package unirider.platform.carpooling.domain.services;

import unirider.platform.carpooling.domain.model.valueobjects.UniRiderUserRecordId;
import unirider.platform.carpooling.domain.model.commands.CreateUserCommand;
import unirider.platform.carpooling.domain.model.commands.UpdateUserMetricsOnRideOfferedCommand;

public interface UserCommandService {
    UniRiderUserRecordId handle(CreateUserCommand command);
    UniRiderUserRecordId handle(UpdateUserMetricsOnRideOfferedCommand command);
}
