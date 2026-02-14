package com.sorokin_hibernate_dz.infrastructure.persestence.mapper;

import com.sorokin_hibernate_dz.domain.model.CouponDomain;
import com.sorokin_hibernate_dz.infrastructure.persestence.entity.CouponJpaEntity;
import org.springframework.stereotype.Component;

@Component
public class CouponJpaMapper {
    public CouponJpaEntity toJpaEntity(CouponDomain domain){
        return CouponJpaEntity.of(
                domain.getId(),
                domain.getCode(),
                domain.getDiscount()
        );
    }

    public CouponDomain toDomain(CouponJpaEntity entity){
        return CouponDomain.of(
                entity.getId(),
                entity.getCode(),
                entity.getDiscount()
        );
    }
}
