package unirider.platform.iam.domain.services;

import unirider.platform.iam.domain.model.aggregates.User;
import unirider.platform.iam.domain.model.commands.SignInCommand;
import unirider.platform.iam.domain.model.commands.SignUpCommand;
import java.util.Optional;
import org.apache.commons.lang3.tuple.ImmutablePair;

public interface UserCommandService {
    Optional<ImmutablePair<User, String>> handle(SignInCommand command);
    Optional<User> handle(SignUpCommand command);

}
