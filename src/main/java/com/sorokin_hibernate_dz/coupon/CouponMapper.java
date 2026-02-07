package com.sorokin_hibernate_dz.coupon;

import com.sorokin_hibernate_dz.client.Client;
import com.sorokin_hibernate_dz.client.ClientSimpleResponse;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class CouponMapper {
    public CouponEntity toEntity(CouponDomain domain){
        return new CouponEntity(
                domain.getId(),
                domain.getCode(),
                domain.getDiscount(),
                domain.getClients()
        );
    }

    public CouponDomain toDomain(CouponEntity entity){
        return new CouponDomain(
                entity.getId(),
                entity.getCode(),
                entity.getDiscount(),
                entity.getClients()
        );
    }

    public CouponDomain fromCreateRequest(CouponCreateRequest request){
        return new CouponDomain(
                request.code(),
                request.discount()
        );
    }

    public CouponSimpleResponse toSimpleResponse(CouponDomain coupon){
        return new CouponSimpleResponse(
                coupon.getId(),
                coupon.getCode(),
                coupon.getDiscount()
        );
    }

    public CouponResponse toResponse(CouponDomain coupon){
        return new CouponResponse(
                coupon.getId(),
                coupon.getCode(),
                coupon.getDiscount(),
                toClientSimpleResponse(coupon.getClients())
        );
    }

    private Set<ClientSimpleResponse> toClientSimpleResponse(Set<Client> clients){
        Set<ClientSimpleResponse> result = new HashSet<>();

        for(var client : clients){
            result.add(new ClientSimpleResponse(
                    client.getId(),
                    client.getName(),
                    client.getEmail()
            ));
        }

        return result;
    }
}
