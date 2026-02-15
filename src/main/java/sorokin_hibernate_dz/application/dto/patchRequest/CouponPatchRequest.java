package sorokin_hibernate_dz.application.dto.patchRequest;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class CouponPatchRequest {
    @Size(max = 255)
    private String code;
    @Min(1) @Max(100)
    private Double discount;

    public boolean hasUpdates() {
        return !code.isBlank() || discount != null;
    }
}
