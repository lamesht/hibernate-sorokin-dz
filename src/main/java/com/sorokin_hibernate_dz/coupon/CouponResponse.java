package com.sorokin_hibernate_dz.coupon;

import com.sorokin_hibernate_dz.client.ClientSimpleResponse;

import java.util.Set;

public record CouponResponse(
        Long id,
        String code,
        Double discount,
        Set<ClientSimpleResponse> clients
) {
}
