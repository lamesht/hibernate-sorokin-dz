package com.sorokin_hibernate_dz.repositories;

import com.sorokin_hibernate_dz.entities.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long> {
}
