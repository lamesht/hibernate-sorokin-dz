package com.sorokin_hibernate_dz.client;

public record ClientSimpleResponse(
        Long id,
        String name,
        String email
) {
}