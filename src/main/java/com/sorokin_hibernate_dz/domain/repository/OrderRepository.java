package com.sorokin_hibernate_dz.domain.repository;

import com.sorokin_hibernate_dz.order.Order;
import com.sorokin_hibernate_dz.order.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByOrderDateBetween(
            LocalDateTime startDate,
            LocalDateTime endDate
    );

    List<Order> findByTotalAmountBetween(
            Long minTotalAmount,
            Long maxTotalAmount
    );

    List<Order> findByStatus(OrderStatus status);
}
