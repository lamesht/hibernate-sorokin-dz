package sorokin_hibernate_dz.application.dto.response;

public record ClientResponse(
        Long id,
        String name,
        String email
) {
}
