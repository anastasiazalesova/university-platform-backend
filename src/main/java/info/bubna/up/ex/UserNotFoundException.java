package info.bubna.up.ex;

import java.util.UUID;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(UUID id) {
        super("User not found with id " + id);
    }
}
