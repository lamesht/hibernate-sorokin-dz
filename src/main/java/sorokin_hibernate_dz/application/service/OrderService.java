package sorokin_hibernate_dz.application.service;

import sorokin_hibernate_dz.order.Order;
import sorokin_hibernate_dz.infrastructure.persestence.repository.OrderJpaRepository;
import sorokin_hibernate_dz.domain.model.OrderStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
public class OrderService {
    private final OrderJpaRepository orderJpaRepository;

    public OrderService(OrderJpaRepository orderJpaRepository) {
        this.orderJpaRepository = orderJpaRepository;
    }

    public Order createNewOrder(Client client, Long totalAmount){
        return orderJpaRepository.save(new Order(client, totalAmount));
    }

    public void addNewOrderForClient(Client client, Long totalAmount){
        Order order = createNewOrder(client, totalAmount);

        client.addOrder(order);
    }

    public List<Order> findOrdersByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        List<Order> requiredOrders = orderJpaRepository.findByOrderDateBetween(startDate, endDate);
        return Collections.unmodifiableList(requiredOrders);
    }

    public List<Order> findOrdersByAmountRange(Long minAmount, Long maxAmount) {
        List<Order> requiredOrders = orderJpaRepository.findByTotalAmountBetween(minAmount, maxAmount);
        return Collections.unmodifiableList(requiredOrders);
    }

    public List<Order> findOrdersByStatus(OrderStatus status) {
        List<Order> requiredOrders = orderJpaRepository.findByStatus(status);
        return Collections.unmodifiableList(requiredOrders);
    }
}
