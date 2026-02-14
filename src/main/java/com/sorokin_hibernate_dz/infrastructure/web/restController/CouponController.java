package com.sorokin_hibernate_dz.infrastructure.web.restController;

import com.sorokin_hibernate_dz.application.dto.CouponCreateRequest;
import com.sorokin_hibernate_dz.application.dto.CouponPatchRequest;
import com.sorokin_hibernate_dz.application.dto.CouponResponse;
import com.sorokin_hibernate_dz.application.service.CouponService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/app/coupons")
public class CouponController {
    private final CouponService couponService;

    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }

    @PostMapping
    public ResponseEntity<CouponResponse> createCoupon(
            @RequestBody @Valid
            CouponCreateRequest request) {
        var response = couponService.createCoupon(request);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{couponId}")
    public ResponseEntity<CouponResponse> findCouponById(
            @PathVariable Long couponId
    ) {
        var response = couponService.findCouponById(couponId);

        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{couponId}")
    public ResponseEntity<CouponResponse> changeCoupon(
            @PathVariable Long couponId,
            @RequestBody @Valid CouponPatchRequest patchRequest
    ) {
        if (!patchRequest.hasUpdates()) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .build();
        }

        var response = couponService.applyCouponPatch(couponId, patchRequest);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/{couponId}/clients")
    public ResponseEntity<Void> addClientsToCoupon(
            @PathVariable Long couponId,
            @RequestBody List<Long> clientIds
    ){
        couponService.addClientsToCoupon(couponId, clientIds);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{couponId}/clients")
    public ResponseEntity<Void> removeClientsFromCoupon(
            @PathVariable Long couponId,
            @RequestBody List<Long> clientIds
    ){
        couponService.removeClientsFromCoupon(couponId, clientIds);

        return ResponseEntity.ok().build();
    }

}
