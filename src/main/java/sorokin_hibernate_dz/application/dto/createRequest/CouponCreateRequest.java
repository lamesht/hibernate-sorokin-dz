package sorokin_hibernate_dz.application.dto.createRequest;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CouponCreateRequest(
        @NotBlank @Size(max = 255)
        String code,

        @NotNull
        @Min(1) @Max(100)
        Double discount
) {
}
