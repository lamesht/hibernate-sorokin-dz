package com.sorokin_hibernate_dz.controllers;

import com.sorokin_hibernate_dz.entities.Coupon;
import com.sorokin_hibernate_dz.entities.CouponPatchRequest;
import com.sorokin_hibernate_dz.services.ClientCouponRelationshipService;
import com.sorokin_hibernate_dz.services.CouponService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/app/coupons")
public class CouponController {
    private final CouponService couponService;
    private final ClientCouponRelationshipService clientCouponRelationshipService;

    public CouponController(CouponService couponService, ClientCouponRelationshipService clientCouponRelationshipService) {
        this.couponService = couponService;
        this.clientCouponRelationshipService = clientCouponRelationshipService;
    }

    @GetMapping
    public List<Coupon> findAll() {
        return couponService.findAll();
    }

    @PostMapping
    public Coupon createCoupon(
            @RequestBody Coupon coupon) {
        return couponService.createCoupon(coupon);
    }

    @GetMapping("/{couponId}")
    public ResponseEntity<Coupon> findCouponById(
            @PathVariable Long couponId
    ) {
        Coupon coupon = couponService.findCouponById(couponId);

        return ResponseEntity.ok(coupon);
    }

    @PatchMapping("/{couponId}")
    public ResponseEntity<Coupon> changeCoupon(
            @PathVariable Long couponId,
            @RequestBody CouponPatchRequest patchRequest
    ) {
        if (!patchRequest.hasUpdates()) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .build();
        }

        Coupon coupon = couponService.applyCouponPatch(couponId, patchRequest);

        return ResponseEntity.ok(coupon);
    }
}
