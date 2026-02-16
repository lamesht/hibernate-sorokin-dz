package sorokin_hibernate_dz.application.dto.createRequest;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ProfileCreateRequest {
    @NotNull
    @NotBlank
    @Size(max = 255)
    private String address;

    @NotNull
    @NotBlank
    @Size(max = 255)
    private String phoneNumber;

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
