package com.sorokin_hibernate_dz.services;

import com.sorokin_hibernate_dz.entities.Coupon;
import com.sorokin_hibernate_dz.entities.CouponPatchRequest;
import com.sorokin_hibernate_dz.repositories.CouponRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponService {
    private final CouponRepository couponRepository;

    public CouponService(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    @Transactional
    public Coupon applyCouponPatch(Long couponId, CouponPatchRequest patchRequest) {
        Coupon updatableCoupon = findCouponById(couponId);

        if (patchRequest.hasUpdates()) {
            String patchCode = patchRequest.getCode();
            Double patchDiscount = patchRequest.getDiscount();

            updateCouponCode(updatableCoupon, patchCode);
            updateCouponDiscount(updatableCoupon, patchDiscount);
        }

        couponRepository.save(updatableCoupon);

        return updatableCoupon;
    }

    private void updateCouponDiscount(Coupon updatableCoupon, Double updatedDiscount) {
        if (updatedDiscount != null) {
            updatableCoupon.setDiscount(updatedDiscount);
        }
    }

    private void updateCouponCode(Coupon updatableCoupon, String updateCode) {
        if (updateCode != null && !updateCode.isBlank()) {
            updatableCoupon.setCode(updateCode);
        }
    }

    public Coupon createCoupon(Coupon coupon) {
        return couponRepository.save(coupon);
    }

    public List<Coupon> findAll() {
        return couponRepository.findAll();
    }

    public Coupon findCouponById(Long couponId) {
        return couponRepository.findById(couponId)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Not found coupon with id: %s"
                                .formatted(couponId))
                );
    }

}
