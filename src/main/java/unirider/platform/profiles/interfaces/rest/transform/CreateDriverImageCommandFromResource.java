package unirider.platform.profiles.interfaces.rest.transform;

import unirider.platform.profiles.domain.model.commands.CreateDriverImageCommand;
import unirider.platform.profiles.interfaces.rest.resources.CreateDriverImageResource;
import unirider.platform.profiles.interfaces.rest.resources.CreateDriverResource;
import org.springframework.stereotype.Component;

@Component
public class CreateDriverImageCommandFromResource {
    public static CreateDriverImageCommand ToCommandFromResource(Long driverId,CreateDriverImageResource resource){
        return new CreateDriverImageCommand( driverId,resource.imageUrl());
    }
}
