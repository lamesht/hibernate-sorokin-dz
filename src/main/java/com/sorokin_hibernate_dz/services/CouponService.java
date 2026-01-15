package com.sorokin_hibernate_dz.services;

import com.sorokin_hibernate_dz.entities.Coupon;
import com.sorokin_hibernate_dz.repositories.CouponRepository;
import jakarta.persistence.EntityNotFoundException;

public class CouponService {
    private final CouponRepository couponRepository;

    public CouponService(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    public void editDiscountCoupon(Long couponId, Long updatedDiscount) {
        Coupon coupon = findCouponById(couponId);

        coupon.setDiscount(updatedDiscount);
    }

    public void editCodeCoupon(Long couponId, String updatedCode) {
        Coupon coupon = findCouponById(couponId);

        coupon.setCode(updatedCode);
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
