package unirider.platform.profiles.interfaces.rest.transform;

import unirider.platform.profiles.domain.model.entities.DriverImage;
import unirider.platform.profiles.interfaces.rest.resources.DriverImageResource;

public class DriverImageResourceFromEntityAssembler {
    public static DriverImageResource ToResourceFromEntity(DriverImage driverImage){
        return new DriverImageResource(driverImage.getId(), driverImage.getUrl());
    }
}
