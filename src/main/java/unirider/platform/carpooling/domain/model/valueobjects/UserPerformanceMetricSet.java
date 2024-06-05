package unirider.platform.carpooling.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record UserPerformanceMetricSet(Integer totalRidesOffered, Integer totalRidesTaken) {
    public UserPerformanceMetricSet() {
        this(0, 0);
    }

    public UserPerformanceMetricSet {
        if (totalRidesOffered < 0) {
            throw new IllegalArgumentException("Total rides offered cannot be negative");
        }
        if (totalRidesTaken < 0) {
            throw new IllegalArgumentException("Total rides taken cannot be negative");
        }
    }

    public UserPerformanceMetricSet incrementTotalRidesOffered() {
        return new UserPerformanceMetricSet(totalRidesOffered + 1, totalRidesTaken);
    }

    public UserPerformanceMetricSet incrementTotalRidesTaken() {
        return new UserPerformanceMetricSet(totalRidesOffered, totalRidesTaken + 1);
    }
}
