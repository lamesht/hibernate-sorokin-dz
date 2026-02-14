package com.sorokin_hibernate_dz.infrastructure.persestence.repository;

import com.sorokin_hibernate_dz.infrastructure.persestence.entity.ClientJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface ClientJpaRepository extends JpaRepository<ClientJpaEntity, Long> {
    @Query("SELECT DISTINCT c FROM ClientJpaEntity c LEFT JOIN FETCH c.coupons WHERE c.id IN :ids")
    List<ClientJpaEntity> findAllByIdsWithCoupons(@Param("ids") Collection<Long> ids);

    @Query("SELECT c FROM ClientJpaEntity c LEFT JOIN FETCH c.coupons WHERE c.id = :id")
    Optional<ClientJpaEntity> findByIdWithCoupons(@Param("id") Long id);
}
