package unirider.platform.profiles.application.internal.queryservices;


import unirider.platform.profiles.domain.model.aggregates.Passenger;
import unirider.platform.profiles.domain.model.queries.GetAllPassengersQuery;
import unirider.platform.profiles.domain.model.queries.GetPassengerByIdQuery;
import unirider.platform.profiles.domain.services.PassengerQueryService;
import unirider.platform.profiles.infrastructure.persistence.jpa.repositories.PassengerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerQueryServiceImpl  implements  PassengerQueryService {

    private final PassengerRepository passengerRepository;

    public PassengerQueryServiceImpl(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    @Override
    public List<Passenger> handle(GetAllPassengersQuery query) {
        return passengerRepository.findAll();
    }

    @Override
    public Optional<Passenger> handle(GetPassengerByIdQuery query) {
        return passengerRepository.findById(query.id());
    }
}
