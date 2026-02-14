package com.sorokin_hibernate_dz.application.dto;

import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class ClientPatchRequest {
    @Size(max = 255)
    private String name;
    @Size(max = 255)
    private String email;

    public boolean hasUpdates() {
        return !name.isBlank() || !email.isBlank();
    }
}
