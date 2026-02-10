package com.sorokin_hibernate_dz.client;

import com.sorokin_hibernate_dz.coupon.CouponResponse;
import com.sorokin_hibernate_dz.entities.Profile;

import java.util.Set;

public record ClientResponse(
        Long id,
        String name,
        String email,
        Profile profile,
        Set<CouponResponse> coupons
) {
}
