package sorokin_hibernate_dz.domain.repository;

import sorokin_hibernate_dz.domain.model.CouponDomain;

import java.util.List;

public interface CouponRepository {
    CouponDomain save(CouponDomain coupon);
    CouponDomain findDomainByIdOrThrow(Long couponId);
    void addClients(Long couponId, List<Long> clientIds);
    void removeClients(Long couponId, List<Long> clientIds);
}
