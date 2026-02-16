package sorokin_hibernate_dz.application.dto.patchRequest;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ProfilePatchRequest {
    @NotBlank @Size(max = 255)
    private String address;

    @NotBlank @Size(max = 255)
    private String phoneNumber;

    public boolean hasUpdates(){
        return hasAddressUpdate() || hasPhoneNumberUpdate();
    }

    public boolean hasAddressUpdate(){
        return address != null;
    }

    public boolean hasPhoneNumberUpdate(){
        return phoneNumber != null;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
