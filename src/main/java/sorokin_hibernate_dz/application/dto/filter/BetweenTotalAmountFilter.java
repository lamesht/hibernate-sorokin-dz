package sorokin_hibernate_dz.application.dto.filter;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record BetweenTotalAmountFilter(
        @NotNull(message = "Min amount cannot be null")
        @Min(value = 1, message = "Min amount must be at least 1")
        Double min,

        @NotNull(message = "Max amount cannot be null")
        @Min(value = 1, message = "Max amount must be at least 1")
        Double max
) {

    public BetweenTotalAmountFilter {
        if (Double.compare(min, max) > 0) {
            throw new IllegalArgumentException(
                    "Min amount cannot be more than max (MIN: %.2f; MAX: %.2f)"
                            .formatted(min, max)
            );
        }
    }
}
