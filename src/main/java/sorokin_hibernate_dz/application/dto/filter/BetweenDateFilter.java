package sorokin_hibernate_dz.application.dto.filter;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record BetweenDateFilter(
        @NotNull(message = "Date for date filter cannot be null")
        @PastOrPresent(message = "Date for filter cannot be in future")
        LocalDate from,

        @NotNull(message = "Date for date filter cannot be null")
        @PastOrPresent(message = "Date for filter cannot be in future")
        LocalDate to
) {

    public BetweenDateFilter {
        if(from.isAfter(to)){
            throw new IllegalArgumentException(
                    "First date cannot be later then second (FIRST_DATE: %s; SECOND_DATE: %s)"
                            .formatted(from, to)
            );
        }
    }
}
