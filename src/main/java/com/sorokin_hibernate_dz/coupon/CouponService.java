package com.sorokin_hibernate_dz.coupon;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CouponService {
    private final CouponRepository couponRepository;
    private final CouponMapper mapper;

    public CouponService(
            CouponRepository couponRepository,
            CouponMapper mapper) {
        this.couponRepository = couponRepository;
        this.mapper = mapper;
    }

    @Transactional
    public CouponResponse applyCouponPatch(
            Long couponId,
            CouponPatchRequest patchRequest
    ) {
        var entity = findEntityByIdOrThrow(couponId);

        var domain = mapper.toDomain(entity);

        String patchCode = patchRequest.getCode();
        Double patchDiscount = patchRequest.getDiscount();

        domain.changeCode(patchCode);
        entity.setCode(patchCode);

        domain.changeDiscount(patchDiscount);
        entity.setDiscount(patchDiscount);

        return mapper.toResponse(domain);
    }

    @Transactional
    public CouponResponse createCoupon(CouponCreateRequest request) {
        var domainWithoutId = mapper.fromCreateRequest(request);

        var entity = mapper.toEntity(domainWithoutId);
        var savedEntity = couponRepository.save(entity);

        var domain = mapper.toDomain(savedEntity);

        return mapper.toResponse(domain);
    }

    public CouponResponse findCouponById(Long couponId) {
        var entity = findEntityByIdOrThrow(couponId);

        var domain = mapper.toDomain(entity);

        return mapper.toResponse(domain);
    }

    private CouponEntity findEntityByIdOrThrow(Long couponId){
        return couponRepository.findById(couponId)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Not found coupon (ID: %d)"
                                .formatted(couponId)
                ));
    }
}
