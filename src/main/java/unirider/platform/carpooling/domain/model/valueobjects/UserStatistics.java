package unirider.platform.carpooling.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record UserStatistics(Integer totalRidesOffered, Integer totalRidesTaken) {

    public UserStatistics {
        if (totalRidesOffered == null || totalRidesTaken == null) {
            totalRidesOffered = 0;
            totalRidesTaken = 0;
        }
    }

    public UserStatistics incrementTotalRidesOffered() {
        return new UserStatistics(this.totalRidesOffered + 1, this.totalRidesTaken);
    }

    public UserStatistics incrementTotalRidesTaken() {
        return new UserStatistics(this.totalRidesOffered, this.totalRidesTaken + 1);
    }
}