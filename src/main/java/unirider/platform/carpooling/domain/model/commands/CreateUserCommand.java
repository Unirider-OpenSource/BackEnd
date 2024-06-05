package unirider.platform.carpooling.domain.model.commands;

public record CreateUserCommand(String firstName, String lastName, String email, String street, String number, String city, String postalCode, String country) {
}
