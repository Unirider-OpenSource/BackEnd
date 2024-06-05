package unirider.platform.carpooling.application.internal.commandservices;

import unirider.platform.carpooling.application.internal.outboundservices.acl.ExternalProfileService;
import unirider.platform.carpooling.domain.model.aggregates.User;
import unirider.platform.carpooling.domain.model.commands.CreateUserCommand;
import unirider.platform.carpooling.domain.model.commands.UpdateUserMetricsOnRideOfferedCommand;
import unirider.platform.carpooling.domain.model.valueobjects.UniRiderUserRecordId;
import unirider.platform.carpooling.domain.services.UserCommandService;
import unirider.platform.carpooling.infrastructure.persistence.jpa.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserCommandServiceImpl implements UserCommandService{
    private final UserRepository userRepository;
    private final ExternalProfileService externalProfileService;

    public UserCommandServiceImpl(UserRepository userRepository, ExternalProfileService externalProfileService) {
        this.userRepository = userRepository;
        this.externalProfileService = externalProfileService;
    }

    @Override
    public UniRiderUserRecordId handle(CreateUserCommand command) {
        var profileId = externalProfileService.fetchProfileIdByEmail(command.email());
        if (profileId.isEmpty()) {
            profileId = externalProfileService.createProfile(command.firstName(), command.lastName(), command.email(), command.street(), command.number(), command.city(), command.postalCode(), command.country());
        } else {
            userRepository.findByProfileId(profileId.get()).ifPresent(user -> {
                throw new IllegalArgumentException("User already exists");
            });
        }
        if (profileId.isEmpty()) throw new IllegalArgumentException("Unable to create profile");
        var user = new User(profileId.get());
        userRepository.save(user);
        return user.getUniRiderUserRecordId();
    }

    @Override
    public UniRiderUserRecordId handle(UpdateUserMetricsOnRideOfferedCommand command) {
        userRepository.findByUniRiderUserRecordId(command.uniRiderUserRecordId()).map(user -> {
            user.updateMetricsOnRideOffered(command.rideOffered());
            userRepository.save(user);
            return user.getUniRiderUserRecordId();
        }).orElseThrow(() -> new IllegalArgumentException("User not found"));
        return null;
    }
}
