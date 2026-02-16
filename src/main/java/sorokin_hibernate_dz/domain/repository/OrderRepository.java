package sorokin_hibernate_dz.domain.repository;

import sorokin_hibernate_dz.domain.model.OrderDomain;
import sorokin_hibernate_dz.domain.model.OrderStatus;

import java.time.LocalDate;
import java.util.List;

public interface OrderRepository {
    OrderDomain save(OrderDomain domain);
    List<OrderDomain> findOrdersByDateRange(LocalDate from, LocalDate to);
    List<OrderDomain> findByStatus(OrderStatus status);
    List<OrderDomain> findOrdersByTotalAmountRange(Double min, Double max);
}
