package sorokin_hibernate_dz.infrastructure.persestence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sorokin_hibernate_dz.domain.model.OrderStatus;
import sorokin_hibernate_dz.infrastructure.persestence.entity.OrderJpaEntity;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrderJpaRepository extends JpaRepository<OrderJpaEntity, Long> {
    @Query("SELECT o FROM OrderJpaEntity o WHERE DATE(o.orderDate) BETWEEN :from AND :to")
    List<OrderJpaEntity> findByOrderJpaEntityDateBetween(
            @Param("from") LocalDate from,
            @Param("to") LocalDate to
    );

    @Query("SELECT o FROM OrderJpaEntity o WHERE o.totalAmount BETWEEN :min AND :max")
    List<OrderJpaEntity> findByTotalAmountBetween(
            @Param("min") Double min,
            @Param("max") Double max
    );

    List<OrderJpaEntity> findByStatus(OrderStatus status);
}
