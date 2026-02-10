package com.sorokin_hibernate_dz.coupon;

import org.springframework.stereotype.Component;

@Component
public class CouponMapper {
    public CouponEntity toEntity(CouponDomain domain){
        return CouponEntity.of(
                domain.getId(),
                domain.getCode(),
                domain.getDiscount()
        );
    }

    public CouponDomain toDomain(CouponEntity entity){
        return CouponDomain.of(
                entity.getId(),
                entity.getCode(),
                entity.getDiscount()
        );
    }

    public CouponDomain fromCreateRequest(CouponCreateRequest request){
        return CouponDomain.create(
                request.code(),
                request.discount()
        );
    }

    public CouponResponse toResponse(CouponDomain coupon){
        return new CouponResponse(
                coupon.getId(),
                coupon.getCode(),
                coupon.getDiscount()
        );
    }
}
