package unirider.platform.profiles.interfaces.rest.resources;

public record CreateDriverResource(String name,
                                   String email,
                                   Long license,
                                   Long phone,
                                   String imageProfile,
                                   String description) {
}
