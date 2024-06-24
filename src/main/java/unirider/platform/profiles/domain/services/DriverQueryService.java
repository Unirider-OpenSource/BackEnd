package unirider.platform.profiles.domain.services;

import unirider.platform.profiles.domain.model.aggregates.Driver;
import unirider.platform.profiles.domain.model.entities.DriverImage;
import unirider.platform.profiles.domain.model.queries.GetAllDriverImagesByDriverIdQuery;
import unirider.platform.profiles.domain.model.queries.GetAllDriversQuery;
import unirider.platform.profiles.domain.model.queries.GetDriverByIdQuery;
import unirider.platform.profiles.domain.model.queries.GetDriverByNameQuery;

import java.util.List;
import java.util.Optional;


public interface DriverQueryService {
    Optional<Driver> handle(GetDriverByIdQuery query);
    Optional<Driver> handle(GetDriverByNameQuery query);
    List<Driver> handle(GetAllDriversQuery query);
    List<DriverImage> handle(GetAllDriverImagesByDriverIdQuery query);
}
