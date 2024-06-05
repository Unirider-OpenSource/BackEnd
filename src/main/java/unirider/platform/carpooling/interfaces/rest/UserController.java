package unirider.platform.carpooling.interfaces.rest;

import unirider.platform.carpooling.domain.model.queries.GetUserByUniRiderUserRecordIdQuery;
import unirider.platform.carpooling.domain.model.valueobjects.UniRiderUserRecordId;
import unirider.platform.carpooling.domain.services.UserCommandService;
import unirider.platform.carpooling.domain.services.UserQueryService;
import unirider.platform.carpooling.interfaces.rest.resources.CreateUserResource;
import unirider.platform.carpooling.interfaces.rest.resources.UserResource;
import unirider.platform.carpooling.interfaces.rest.transform.CreateUserCommandFromResourceAssembler;
import unirider.platform.carpooling.interfaces.rest.transform.UserResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/users", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Users", description = "User Management Endpoints")
public class UserController {
    private final UserCommandService userCommandService;
    private final UserQueryService userQueryService;


    public UsersController(UserCommandService userCommandService, UserQueryService userQueryService) {
        this.userCommandService = userCommandService;
        this.userQueryService = userQueryService;
    }

    @PostMapping
    public ResponseEntity<UserResource> createUser(@RequestBody CreateUserResource resource) {
        var createUserCommand = CreateUserCommandFromResourceAssembler.toCommandFromResource(resource);
        var userId = userCommandService.handle(createUserCommand);
        if (userId.userRecordId().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var getUserByUniRiderUserRecordIdQuery = new GetUserByUniRiderUserRecordIdQuery(userId);
        var user = userQueryService.handle(getUserByUniRiderUserRecordIdQuery);
        if (user.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var userResource = UserResourceFromEntityAssembler.toResourceFromEntity(user.get());
        return new ResponseEntity<>(userResource, HttpStatus.CREATED);

    }





}

