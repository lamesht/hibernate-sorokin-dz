package sorokin_hibernate_dz.shared.exception;

import jakarta.persistence.EntityNotFoundException;

public class CouponNotFoundException extends EntityNotFoundException {
    public CouponNotFoundException(String message) {
        super(message);
    }
}
