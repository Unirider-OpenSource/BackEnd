package unirider.platform.carpooling.application.internal.eventhandlers;


import unirider.platform.carpooling.domain.model.events.RideOfferedEvent;
import unirider.platform.carpooling.domain.model.commands.UpdateUserMetricsOnRideOfferedCommand;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import unirider.platform.carpooling.domain.services.UserCommandService;

@Service
public class RideOfferedEventHandler {
    private final UserCommandService userCommandService;

    public RideOfferedEventHandler(UserCommandService userCommandService) {
        this.userCommandService = userCommandService;
    }


}
