package unirider.platform.carpooling.domain.model.aggregates;

import unirider.platform.carpooling.domain.model.valueobjects.UniRiderUserRecordId;
import unirider.platform.carpooling.domain.model.valueobjects.ProfileId;
import unirider.platform.carpooling.domain.model.valueobjects.UserPerformanceMetricSet;
import unirider.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;

/**
 * Represents a student.
 * The student is an aggregate root.
 */
@Entity
public class User extends AuditableAbstractAggregateRoot<User> {

    @Getter
    @Embedded
    @Column(name = "unirider_user_id")
    private final UniRiderUserRecordId uniRiderUserRecordId;

    @Embedded
    private ProfileId profileId;

    @Embedded
    private UserPerformanceMetricSet performanceMetricSet;

    public User() {
        this.uniRiderUserRecordId = new UniRiderUserRecordId();
        this.performanceMetricSet = new UserPerformanceMetricSet();
    }

    public User(Long profileId) {
        this();
        this.profileId = new ProfileId(profileId);
    }

    public User(ProfileId profileId) {
        this();
        this.profileId = profileId;
    }

    public void updateMetricsOnRideOffered() {
        this.performanceMetricSet = this.performanceMetricSet.incrementTotalRidesOffered();
    }

    public void updateUserMetricsOnRideOffered() {
        this.performanceMetricSet = this.performanceMetricSet.incrementTotalRidesTaken();
    }

    public String getUserRecordId() {
        return this.uniRiderUserRecordId.userRecordId();
    }

    public Long getProfileId() {
        return this.profileId.profileId();
    }

}