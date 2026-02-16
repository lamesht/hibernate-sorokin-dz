package sorokin_hibernate_dz.application.dto.patchRequest;

import jakarta.validation.constraints.Size;

public class ClientPatchRequest {
    @Size(max = 255)
    private String name;
    @Size(max = 255)
    private String email;

    public boolean hasUpdates() {
        return !name.isBlank() || !email.isBlank();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
