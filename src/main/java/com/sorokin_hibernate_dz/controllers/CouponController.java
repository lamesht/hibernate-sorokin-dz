package com.sorokin_hibernate_dz.controllers;

import com.sorokin_hibernate_dz.entities.Coupon;
import com.sorokin_hibernate_dz.entities.CouponPatchRequest;
import com.sorokin_hibernate_dz.services.CouponService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/app/coupons")
public class CouponController {
    private final CouponService couponService;

    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }

    @GetMapping
    public List<Coupon> findAll(){
        return couponService.findAll();
    }

    @PostMapping
    public Coupon createCoupon(
            @RequestBody Coupon coupon) {
        return couponService.createCoupon(coupon);
    }

    @GetMapping("/{couponId}")
    public Coupon findCouponById(
            @PathVariable Long couponId
    ){
        return couponService.findCouponById(couponId);
    }



    @PatchMapping("/{couponId}/code")
    public Coupon changeCouponCode(
            @PathVariable Long couponId,
            @RequestParam String updatedCode) {
        return couponService.changeCouponCode(couponId, updatedCode);
    }

    @PatchMapping("/{couponId}/discount")
    public Coupon changeCouponDiscount(
            @PathVariable Long couponId,
            @RequestParam Double discount) {
        return couponService.changeCouponDiscount(couponId, discount);
    }
}
