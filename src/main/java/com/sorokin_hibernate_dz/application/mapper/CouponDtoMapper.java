package com.sorokin_hibernate_dz.application.mapper;

import com.sorokin_hibernate_dz.domain.model.CouponDomain;
import com.sorokin_hibernate_dz.application.dto.CouponCreateRequest;
import com.sorokin_hibernate_dz.application.dto.CouponResponse;
import org.springframework.stereotype.Component;

@Component
public class CouponDtoMapper {
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
