package unirider.platform.carpooling.domain.model.commands;

import unirider.platform.carpooling.domain.model.valueobjects.UniRiderUserRecordId;

public record UpdateUserMetricsOnRideOfferedCommand(UniRiderUserRecordId userRecordId) {
}
