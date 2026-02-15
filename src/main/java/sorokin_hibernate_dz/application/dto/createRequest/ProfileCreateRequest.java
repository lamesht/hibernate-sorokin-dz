package sorokin_hibernate_dz.application.dto.createRequest;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class ProfileCreateRequest {
    @NotNull
    @NotBlank
    @Size(max = 255)
    private String address;

    @NotNull
    @NotBlank
    @Size(max = 255)
    private String phoneNumber;
}
