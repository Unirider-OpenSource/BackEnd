package unirider.platform.carpooling.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import java.util.UUID;

@Embeddable
public record UniRiderUserRecordId(String userRecordId) {
    public UniRiderUserRecordId() {
        this(UUID.randomUUID().toString());
    }

    public UniRiderUserRecordId {
        if (userRecordId == null || userRecordId.isBlank()) {
            throw new IllegalArgumentException("Unirider user record profileId cannot be null or blank");
        }
    }
}