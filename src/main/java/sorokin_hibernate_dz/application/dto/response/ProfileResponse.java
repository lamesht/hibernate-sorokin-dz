package sorokin_hibernate_dz.application.dto.response;

public record ProfileResponse(
    Long id,
    String address,
    String phoneNumber,
    Long clientId
) {
}
