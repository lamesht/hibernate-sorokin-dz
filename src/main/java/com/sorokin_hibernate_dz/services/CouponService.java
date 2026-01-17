package com.sorokin_hibernate_dz.services;

import com.sorokin_hibernate_dz.entities.Coupon;
import com.sorokin_hibernate_dz.repositories.CouponRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CouponService {
    private final CouponRepository couponRepository;

    public CouponService(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    public Coupon editDiscountCoupon(Long couponId, Long updatedDiscount) {
        Coupon coupon = findCouponById(couponId);

        coupon.setDiscount(updatedDiscount);

        return couponRepository.save(coupon);
    }

    public Coupon editCodeCoupon(Long couponId, String updatedCode) {
        Coupon coupon = findCouponById(couponId);

        coupon.setCode(updatedCode);

        return couponRepository.save(coupon);
    }

    private Coupon findCouponById(Long couponId){
        return couponRepository
                .findById(couponId)
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "Coupon with %d id not found".formatted(couponId))
                );
    }
}
