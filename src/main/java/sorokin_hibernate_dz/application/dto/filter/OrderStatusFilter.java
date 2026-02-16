package sorokin_hibernate_dz.application.dto.filter;

import sorokin_hibernate_dz.domain.model.OrderStatus;

public record OrderStatusFilter(
        OrderStatus status
) {
}
