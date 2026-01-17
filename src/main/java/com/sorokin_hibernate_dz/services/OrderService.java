package com.sorokin_hibernate_dz.services;

import com.sorokin_hibernate_dz.entities.Client;
import com.sorokin_hibernate_dz.entities.Order;
import com.sorokin_hibernate_dz.entities.OrderStatus;
import com.sorokin_hibernate_dz.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
        return orderRepository.findByOrderDateBetween(startDate, endDate);
    }

    public List<Order> findOrdersByAmountRange(Long minAmount, Long maxAmount) {
        return orderRepository.findByTotalAmountBetween(minAmount, maxAmount);
    }

    public List<Order> findOrdersByStatus(OrderStatus status) {
        return orderRepository.findByStatus(status);
    }
}
