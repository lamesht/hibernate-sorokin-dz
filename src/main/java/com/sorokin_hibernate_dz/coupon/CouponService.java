package com.sorokin_hibernate_dz.coupon;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CouponService {
    private final CouponRepository couponRepository;
    private final CouponMapper mapper;

    public CouponService(CouponRepository couponRepository, CouponMapper mapper) {
        this.couponRepository = couponRepository;
        this.mapper = mapper;
    }

    @Transactional
    public CouponDomain applyCouponPatch(Long couponId, CouponPatchRequest patchRequest) {
        var entity = findEntityById(couponId);

        CouponDomain updatableCoupon = mapper.toDomain(entity);

        String patchCode = patchRequest.getCode();
        Double patchDiscount = patchRequest.getDiscount();

        updateCouponCode(updatableCoupon, patchCode);
        updateCouponDiscount(updatableCoupon, patchDiscount);

        return updatableCoupon;
    }

    public CouponSimpleResponse createCoupon(CouponCreateRequest request) {
        CouponDomain domain = mapper.fromCreateRequest(request);

        var savedEntity = couponRepository.save(mapper.toEntity(domain));

        domain.setId(savedEntity.getId());

        return mapper.toSimpleResponse(domain);
    }

    public CouponResponse findCouponById(Long couponId) {
        var entity = couponRepository.findById(couponId)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Not found coupon with id: %s"
                                .formatted(couponId))
                );

        var domain = mapper.toDomain(entity);

        return mapper.toResponse(domain);
    }

    private CouponEntity findEntityById(Long couponId){
        return couponRepository.findById(couponId)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Entity with id %d not found"
                                .formatted(couponId)
                ));
    }

    private void updateCouponDiscount(CouponDomain updatableCoupon, Double updatedDiscount) {
        if (updatedDiscount != null) {
            updatableCoupon.changeDiscount(updatedDiscount);
        }
    }

    private void updateCouponCode(CouponDomain updatableCoupon, String updateCode) {
        if (updateCode != null && !updateCode.isBlank()) {
            updatableCoupon.changeCode(updateCode);
        }
    }

}
