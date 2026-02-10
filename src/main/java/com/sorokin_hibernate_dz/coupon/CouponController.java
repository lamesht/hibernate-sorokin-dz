package com.sorokin_hibernate_dz.coupon;

import com.sorokin_hibernate_dz.client.ClientSimpleResponse;
import com.sorokin_hibernate_dz.services.ClientCouponRelationshipService;
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
    private final ClientCouponRelationshipService clientCouponRelationshipService;

    public CouponController(CouponService couponService, ClientCouponRelationshipService clientCouponRelationshipService) {
        this.couponService = couponService;
        this.clientCouponRelationshipService = clientCouponRelationshipService;
    }

    @PostMapping
    public ResponseEntity<CouponResponse> createCoupon(
            @RequestBody @Valid
            CouponCreateRequest request) {
        var simpleResponse = couponService.createCoupon(request);

        return ResponseEntity.ok(simpleResponse);
    }

    @GetMapping("/{couponId}")
    public ResponseEntity<CouponResponse> findCouponById(
            @PathVariable Long couponId
    ) {
        CouponResponse coupon = couponService.findCouponById(couponId);

        return ResponseEntity.ok(coupon);
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
        clientCouponRelationshipService.addClientsToCoupon(couponId, clientIds);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{couponId}/clients")
    public ResponseEntity<Void> removeClientsFromCoupon(
            @PathVariable Long couponId,
            @RequestBody List<Long> clientIds
    ){
        clientCouponRelationshipService.removeClientsFromCoupon(couponId, clientIds);

        return ResponseEntity.ok().build();
    }

//    @GetMapping("/{couponId}/clients")
//    public ResponseEntity<List<ClientSimpleResponse>> findCouponClients(
//            @PathVariable Long couponId
//    ){
//
//    }
}
