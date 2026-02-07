package com.sorokin_hibernate_dz.client;

import com.sorokin_hibernate_dz.coupon.CouponSimpleResponse;

import java.util.Set;

public record ClientResponse(
        Long id,
        String name,
        String email,
        Set<CouponSimpleResponse> coupons
) {
}
