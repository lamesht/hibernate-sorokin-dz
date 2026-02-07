package com.sorokin_hibernate_dz.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query("SELECT DISTINCT c FROM Client c LEFT JOIN FETCH c.coupons WHERE c.id IN :ids")
    List<Client> findAllByIdsWithCoupons(@Param("ids") Collection<Long> ids);

    @Query("SELECT c FROM Client c LEFT JOIN FETCH c.coupons WHERE c.id = :id")
    Optional<Client> findByIdWithCoupons(@Param("id") Long id);
}
