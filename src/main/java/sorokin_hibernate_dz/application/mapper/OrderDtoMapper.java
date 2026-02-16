package sorokin_hibernate_dz.application.mapper;

import sorokin_hibernate_dz.application.dto.createRequest.OrderCreateRequest;
import sorokin_hibernate_dz.application.dto.response.OrderResponse;
import sorokin_hibernate_dz.domain.model.OrderDomain;

public class OrderDtoMapper {
    public OrderDomain fromCreateRequest(Long clientId, OrderCreateRequest createRequest) {
        return OrderDomain.create(
            createRequest.totalAmount(),
            clientId
        );
    }

    public OrderResponse toResponse(OrderDomain domain) {
        return new OrderResponse(
                domain.getId(),
                domain.getTotalAmount(),
                domain.getOrderDate(),
                domain.getStatus(),
                domain.getClientId()
        );
    }
}
