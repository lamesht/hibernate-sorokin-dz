package sorokin_hibernate_dz.shared.exception;

import jakarta.persistence.EntityNotFoundException;

public class ProfileNotFoundException extends EntityNotFoundException {
    public ProfileNotFoundException(String message) {
        super(message);
    }
}
