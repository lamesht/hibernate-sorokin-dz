package sorokin_hibernate_dz.infrastructure.persestence.adapter;

import sorokin_hibernate_dz.domain.model.OrderDomain;
import sorokin_hibernate_dz.domain.model.OrderStatus;
import sorokin_hibernate_dz.domain.repository.OrderRepository;
import sorokin_hibernate_dz.infrastructure.persestence.entity.OrderJpaEntity;
import sorokin_hibernate_dz.infrastructure.persestence.mapper.OrderJpaMapper;
import sorokin_hibernate_dz.infrastructure.persestence.repository.OrderJpaRepository;
import sorokin_hibernate_dz.shared.exception.OrderNotFoundException;

import java.time.LocalDate;
import java.util.List;

public class OrderRepositoryAdapter implements OrderRepository {
    private final OrderJpaRepository orderJpaRepository;
    private final OrderJpaMapper jpaMapper;

    public OrderRepositoryAdapter(OrderJpaRepository orderJpaRepository, OrderJpaMapper jpaMapper) {
        this.orderJpaRepository = orderJpaRepository;
        this.jpaMapper = jpaMapper;
    }

    @Override
    public OrderDomain save(OrderDomain domain) {
        var entity = jpaMapper.toEntity(domain);

        var savedEntity = orderJpaRepository.save(entity);

        return jpaMapper.toDomain(savedEntity);
    }

    @Override
    public List<OrderDomain> findOrdersByDateRange(LocalDate from, LocalDate to) {
        List<OrderJpaEntity> entities = orderJpaRepository
                .findByOrderJpaEntityDateBetween(from, to);

        return entities.stream()
                .map(jpaMapper::toDomain)
                .toList();
    }

    @Override
    public List<OrderDomain> findByStatus(OrderStatus status) {
        return orderJpaRepository.findByStatus(status)
                .stream()
                .map(jpaMapper::toDomain)
                .toList();
    }

    @Override
    public List<OrderDomain> findOrdersByTotalAmountRange(Double min, Double max) {
        return orderJpaRepository.findByTotalAmountBetween(min, max)
                .stream()
                .map(jpaMapper::toDomain)
                .toList();
    }


    private OrderJpaEntity findEntityByIdOrThrow(Long orderId){
        return orderJpaRepository.findById(orderId)
                .orElseThrow(() ->
                    new OrderNotFoundException(
                            "Order not found (ID: %d)"
                                    .formatted(orderId))
                );
    }
}
