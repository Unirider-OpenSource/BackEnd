package unirider.platform.profiles.application.internal.commandservices;

import unirider.platform.profiles.domain.model.aggregates.Passenger;
import unirider.platform.profiles.domain.model.commands.CreatePassengerCommand;
import unirider.platform.profiles.domain.model.commands.UpdatePassengerCommand;
import unirider.platform.profiles.domain.model.valueobjects.PassengerDNI;
import unirider.platform.profiles.domain.model.valueobjects.PassengerEmail;
import unirider.platform.profiles.domain.model.valueobjects.PassengerName;
import unirider.platform.profiles.domain.model.valueobjects.PassengerPhone;
import unirider.platform.profiles.domain.services.PassengerCommandService;
import unirider.platform.profiles.infrastructure.persistence.jpa.repositories.PassengerRepository;
import org.springframework.stereotype.Service;

@Service
public class PassengerCommandServiceImpl implements PassengerCommandService {

    private final PassengerRepository passengerRepository;

    public PassengerCommandServiceImpl(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    @Override
    public Long handle(CreatePassengerCommand command) {
        // validate that the passenger has a unique email
        var email = new PassengerEmail(command.email());

        passengerRepository.findPassengerByPassengerEmail(email)
                .map(passenger -> {
                    throw new IllegalArgumentException("Passenger already exists with email "
                            + email.email() + "");
                });

        // validate that the passenger has a unique dni
        var dni = new PassengerDNI(command.dni());

        passengerRepository.findPassengerByPassengerDNI(dni)
                .map(passenger -> {
                    throw new IllegalArgumentException("Passenger already exists with dni "
                            + dni.passengerDNI() + "");
                });

        // create a new passenger and save it
        var passenger = new Passenger(
                command.name(),
                command.email(),
                command.dni(),
                command.phone(),
                command.photo()
        );

        passengerRepository.save(passenger);
        return passenger.getId();
    }

    @Override
    public Long handle(UpdatePassengerCommand command) {
        var passenger = passengerRepository.findById(command.id()).orElseThrow(() -> new IllegalArgumentException("Passenger with id " + command.id() + " does not exist"));

        // si el nombre es diferente de null, de "string" y no esta vacio, actualiza el nombre
        if (command.name() != null && !command.name().equals("string") && !command.name().isEmpty()) {
            passenger.setPassengerName(new PassengerName(command.name()));
        }

        // si el email es diferente de null, de "string" y no esta vacio, actualiza el email
        if (command.email() != null && !command.email().equals("string") && !command.email().isEmpty()) {
            passenger.setPassengerEmail(new PassengerEmail(command.email()));
        }
        // si el phone es diferente de null, de 0 y no esta vacio, actualiza el phone
        if (command.phone() != null && command.phone() != 0 ) {
            passenger.setPassengerPhone(new PassengerPhone(command.phone()));
        }


        // si el photo es diferente de null, de "string" y no esta vacio, actualiza el photo
        if (command.photo() != null && !command.photo().equals("string") && !command.photo().isEmpty()) {
            passenger.setPhoto(command.photo());
        }

        passengerRepository.save(passenger);
        return passenger.getId();
    }
}
