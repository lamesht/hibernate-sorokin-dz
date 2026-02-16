package sorokin_hibernate_dz.infrastructure.persestence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import sorokin_hibernate_dz.domain.model.OrderStatus;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class OrderJpaEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "total_amount")
    private Double totalAmount;
    @Column(name = "order_date")
    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private OrderStatus status;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private ClientJpaEntity client;

    public static OrderJpaEntity of(
            Long id,
            Double totalAmount,
            LocalDateTime orderDate,
            OrderStatus status,
            ClientJpaEntity client
    ){
        return new OrderJpaEntity(id, orderDate, totalAmount, status, client);
    }

    private OrderJpaEntity(
            Long id,
            LocalDateTime orderDate,
            Double totalAmount,
            OrderStatus status,
            ClientJpaEntity client) {
        this.id = id;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.status = status;
        this.client = client;
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
        return client.getId();
    }

    private OrderJpaEntity() {}
}
