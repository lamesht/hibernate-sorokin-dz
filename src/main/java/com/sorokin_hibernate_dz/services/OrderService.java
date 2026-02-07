package com.sorokin_hibernate_dz.services;

import com.sorokin_hibernate_dz.client.Client;
import com.sorokin_hibernate_dz.entities.Order;
import com.sorokin_hibernate_dz.entities.OrderStatus;
import com.sorokin_hibernate_dz.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createNewOrder(Client client, Long totalAmount){
        return orderRepository.save(new Order(client, totalAmount));
    }

    public void addNewOrderForClient(Client client, Long totalAmount){
        Order order = createNewOrder(client, totalAmount);

        client.addOrder(order);
    }

    public List<Order> findOrdersByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        List<Order> requiredOrders = orderRepository.findByOrderDateBetween(startDate, endDate);
        return Collections.unmodifiableList(requiredOrders);
    }

    public List<Order> findOrdersByAmountRange(Long minAmount, Long maxAmount) {
        List<Order> requiredOrders = orderRepository.findByTotalAmountBetween(minAmount, maxAmount);
        return Collections.unmodifiableList(requiredOrders);
    }

    public List<Order> findOrdersByStatus(OrderStatus status) {
        List<Order> requiredOrders = orderRepository.findByStatus(status);
        return Collections.unmodifiableList(requiredOrders);
    }
}
