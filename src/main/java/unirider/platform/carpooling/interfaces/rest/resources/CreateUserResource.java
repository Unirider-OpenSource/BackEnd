package unirider.platform.carpooling.interfaces.rest.resources;

public record CreateUserResource(String firstName, String lastName, String email, String street, String number, String city, String postalCode, String country) {
}
