package sorokin_hibernate_dz.application.mapper;

import sorokin_hibernate_dz.domain.model.CouponDomain;
import sorokin_hibernate_dz.application.dto.createRequest.CouponCreateRequest;
import sorokin_hibernate_dz.application.dto.response.CouponResponse;
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
