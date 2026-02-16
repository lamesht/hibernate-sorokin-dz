package sorokin_hibernate_dz.domain.model;

import java.time.LocalDateTime;

public class OrderDomain {
    private Long id;
    private Double totalAmount;
    private LocalDateTime orderDate;
    private OrderStatus status;
    private Long clientId;

    public static OrderDomain create(
            Double totalAmount,
            Long clientId
    ) {
        return new OrderDomain(totalAmount, clientId);
    }

    public static OrderDomain of(
            Long id,
            Double totalAmount,
            LocalDateTime orderDate,
            OrderStatus status,
            Long clientId
    ) {
        return new OrderDomain(id, totalAmount, orderDate, status, clientId);
    }

    private OrderDomain(
            Long id,
            Double totalAmount,
            LocalDateTime orderDate,
            OrderStatus status,
            Long clientId) {
        this.id = id;
        this.totalAmount = totalAmount;
        this.orderDate = orderDate;
        this.status = status;
        this.clientId = clientId;
    }

    private OrderDomain(
            Double totalAmount,
            Long clientId) {
        this.totalAmount = totalAmount;
        this.clientId = clientId;

        this.orderDate = LocalDateTime.now();
        this.status = OrderStatus.CREATE;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public Long getClientId() {
        return clientId;
    }
}