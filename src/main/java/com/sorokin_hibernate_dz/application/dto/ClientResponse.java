package com.sorokin_hibernate_dz.application.dto;

public record ClientResponse(
        Long id,
        String name,
        String email
) {
}
