package sorokin_hibernate_dz.application.dto.response;

import sorokin_hibernate_dz.domain.model.OrderStatus;

import java.time.LocalDateTime;

public record OrderResponse(
    Long id,
    Double totalAmount,
    LocalDateTime orderDate,
    OrderStatus status,
    Long clientId
) {
}
