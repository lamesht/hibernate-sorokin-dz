package com.sorokin_hibernate_dz.services;

import com.sorokin_hibernate_dz.entities.Client;
import com.sorokin_hibernate_dz.entities.Coupon;
import com.sorokin_hibernate_dz.entities.CouponPatchRequest;
import com.sorokin_hibernate_dz.repositories.CouponRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CouponService {
    private final CouponRepository couponRepository;

    public CouponService(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    public Optional<Coupon> applyCouponPatch(Long couponId, CouponPatchRequest patchRequest) {
        Optional<Coupon> optionalCoupon = findCouponById(couponId);

        if (optionalCoupon.isEmpty()) {
            return Optional.empty();
        }

        Coupon updatableCoupon = optionalCoupon.get();

        if (patchRequest.hasUpdates()) {
            String patchCode = patchRequest.getCode();
            Double patchDiscount = patchRequest.getDiscount();
            List<Client> patchAddClients = patchRequest.getAddClients();
            List<Client> pathRemoveClients = patchRequest.getRemoveClients();

            if (patchCode != null) {
                updatableCoupon.setCode(patchCode);
            }
            if (patchDiscount != null) {
                updatableCoupon.setDiscount(patchDiscount);
            }
            if(!patchAddClients.isEmpty() || patchAddClients != null){

            }
        }


    }

    private Coupon updateCouponDiscount(Coupon updatableCoupon, Double updatedDiscount) {
        if (updatedDiscount != null) {
            updatableCoupon.setDiscount(updatedDiscount);
        }

        return updatableCoupon;
    }

    private Coupon updateCouponCode(Coupon updatableCoupon, String updatedCode) {

    }

    public Coupon createCoupon(Coupon coupon) {
        return couponRepository.save(coupon);
    }

    public List<Coupon> findAll() {
        return couponRepository.findAll();
    }

    public Optional<Coupon> findCouponById(Long couponId) {
        return couponRepository.findById(couponId);
    }

}
