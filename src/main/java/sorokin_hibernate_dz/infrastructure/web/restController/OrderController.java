package sorokin_hibernate_dz.infrastructure.web.restController;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sorokin_hibernate_dz.application.dto.createRequest.OrderCreateRequest;
import sorokin_hibernate_dz.application.dto.filter.BetweenDateFilter;
import sorokin_hibernate_dz.application.dto.filter.BetweenTotalAmountFilter;
import sorokin_hibernate_dz.application.dto.response.OrderResponse;
import sorokin_hibernate_dz.application.service.OrderService;
import sorokin_hibernate_dz.domain.model.OrderStatus;

import java.util.List;

@RestController
@RequestMapping("/app")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/client/{clientId}/orders")
    public ResponseEntity<OrderResponse> createOrder(
            @PathVariable Long clientId,
            @Valid @RequestBody OrderCreateRequest createRequest
    ) {
        var response = orderService.createNewOrder(clientId, createRequest);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/orders/by-date")
    public ResponseEntity<List<OrderResponse>> findAllOrdersBetweenDate(
            @Valid @RequestBody BetweenDateFilter dateFilter
    ) {
        var responseList = orderService.findOrdersByDateRange(dateFilter);

        return ResponseEntity.ok(responseList);
    }

    @PostMapping("/orders/by-amount")
    public ResponseEntity<List<OrderResponse>> findAllOrdersBetweenTotalAmount(
            @Valid @RequestBody BetweenTotalAmountFilter totalAmountFilter
    ) {
        var responseList = orderService.findOrdersByAmountRange(totalAmountFilter);

        return ResponseEntity.ok(responseList);
    }

    @PostMapping("/orders/by-status")
    public ResponseEntity<List<OrderResponse>> findAllOrdersByStatus(
            @RequestParam(defaultValue = "CREATED") OrderStatus status
    ) {
        var responseList = orderService.findOrdersByStatus(status);

        return ResponseEntity.ok(responseList);
    }
}
