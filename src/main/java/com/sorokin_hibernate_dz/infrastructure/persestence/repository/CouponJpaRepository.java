package com.sorokin_hibernate_dz.infrastructure.persestence.repository;

import com.sorokin_hibernate_dz.infrastructure.persestence.entity.CouponJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponJpaRepository extends JpaRepository<CouponJpaEntity, Long> { }
