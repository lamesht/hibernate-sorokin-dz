package com.sorokin_hibernate_dz.entities;

import com.sorokin_hibernate_dz.client.Client;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Table(name = "orders")
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @Getter
    private LocalDateTime orderDate;
    @Getter
    private Long totalAmount;

    @Enumerated(EnumType.STRING)
    @Getter @Setter
    private OrderStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    public Order(Client client, Long totalAmount) {
        this.totalAmount = totalAmount;
        this.client = client;

        this.orderDate = LocalDateTime.now();
        this.status = OrderStatus.CREATE;
    }

    public Client getClient() {
        return client;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderDate=" + orderDate +
                ", totalAmount=" + totalAmount +
                ", status=" + status +
                '}';
    }
}
