package com.sorokin_hibernate_dz.coupon;

public record CouponSimpleResponse(
        Long id,
        String code,
        Double discount
) {
}
