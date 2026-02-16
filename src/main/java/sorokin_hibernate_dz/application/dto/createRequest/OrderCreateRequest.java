package sorokin_hibernate_dz.application.dto.createRequest;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record OrderCreateRequest(
        @NotNull @Min(1)
        Double totalAmount
) {
}
