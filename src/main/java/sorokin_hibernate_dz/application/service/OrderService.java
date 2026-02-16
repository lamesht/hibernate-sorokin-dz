package sorokin_hibernate_dz.application.service;

import org.springframework.stereotype.Service;
import sorokin_hibernate_dz.application.dto.createRequest.OrderCreateRequest;
import sorokin_hibernate_dz.application.dto.filter.BetweenDateFilter;
import sorokin_hibernate_dz.application.dto.filter.BetweenTotalAmountFilter;
import sorokin_hibernate_dz.application.dto.response.OrderResponse;
import sorokin_hibernate_dz.application.mapper.OrderDtoMapper;
import sorokin_hibernate_dz.domain.model.OrderStatus;
import sorokin_hibernate_dz.domain.repository.OrderRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderDtoMapper dtoMapper;

    public OrderService(OrderRepository orderRepository, OrderDtoMapper dtoMapper) {
        this.orderRepository = orderRepository;
        this.dtoMapper = dtoMapper;
    }

    public OrderResponse createNewOrder(Long clientId, OrderCreateRequest createRequest){
        var domainWithoutId = dtoMapper.fromCreateRequest(clientId, createRequest);

        var savedDomain = orderRepository.save(domainWithoutId);

        return dtoMapper.toResponse(savedDomain);
    }

    public List<OrderResponse> findOrdersByDateRange(BetweenDateFilter dateFilter) {
        var from = dateFilter.from();
        var to = dateFilter.to();

        return orderRepository.findOrdersByDateRange(from, to)
                .stream()
                .map(dtoMapper::toResponse)
                .toList();
    }

    public List<OrderResponse> findOrdersByAmountRange(BetweenTotalAmountFilter totalAmountFilter) {
        var min = totalAmountFilter.min();
        var max = totalAmountFilter.max();

        return orderRepository.findOrdersByTotalAmountRange(min, max)
                .stream()
                .map(dtoMapper::toResponse)
                .toList();
    }

    public List<OrderResponse> findOrdersByStatus(OrderStatus status) {
        return orderRepository.findByStatus(status)
                .stream()
                .map(dtoMapper::toResponse)
                .toList();
    }
}
