package unirider.platform.profiles.domain.services;

import unirider.platform.profiles.domain.model.aggregates.Passenger;
import unirider.platform.profiles.domain.model.queries.GetAllPassengersQuery;
import unirider.platform.profiles.domain.model.queries.GetPassengerByIdQuery;

import java.util.List;
import java.util.Optional;


public interface PassengerQueryService {
    Optional<Passenger> handle(GetPassengerByIdQuery query);
    List<Passenger> handle(GetAllPassengersQuery query);
}
