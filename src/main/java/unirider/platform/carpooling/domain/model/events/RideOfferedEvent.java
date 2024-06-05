package unirider.platform.carpooling.domain.model.events;

import unirider.platform.carpooling.application.internal.eventhandlers.RideOfferedEventHandler;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public final class RideOfferedEvent extends ApplicationEvent {
    private final Long rideId;
    private final Long driverId;

    public RideOfferedEvent(Object source, Long rideId, Long driverId) {
        super(source);
        this.rideId = rideId;
        this.driverId = driverId;
    }
}
