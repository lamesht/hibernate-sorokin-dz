package com.sorokin_hibernate_dz.coupon;

public record CouponResponse(
        Long id,
        String code,
        Double discount
) {
}
