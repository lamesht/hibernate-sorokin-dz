package com.sorokin_hibernate_dz.services;

import com.sorokin_hibernate_dz.client.ClientMapper;
import com.sorokin_hibernate_dz.client.ClientRepository;
import com.sorokin_hibernate_dz.coupon.CouponEntity;
import com.sorokin_hibernate_dz.coupon.CouponMapper;
import com.sorokin_hibernate_dz.coupon.CouponRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientCouponRelationshipService {
    private final ClientRepository clientRepository;
    private final CouponRepository couponRepository;
    private final CouponMapper couponMapper;
    private final ClientMapper clientMapper;

    public ClientCouponRelationshipService(
            ClientRepository clientRepository,
            CouponRepository couponRepository,
            CouponMapper couponMapper,
            ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.couponRepository = couponRepository;
        this.couponMapper = couponMapper;
        this.clientMapper = clientMapper;
    }

    @Transactional
    public void addClientsToCoupon(Long couponId, List<Long> clientIds){

    }

    @Transactional
    public void removeClientsFromCoupon(Long couponId, List<Long> clientIds){

    }

    @Transactional
    public void addCouponsToClient(Long clientId, List<Long> couponIds){

    }

    @Transactional
    public void removeCouponsFromClient(Long clientId, List<Long> couponIds){

    }

    private CouponEntity findCouponByIdOrThrow(Long couponId){
        return couponRepository.findById(couponId)
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "Not find coupon (ID: %d)".formatted(couponId))
                );
    }
}
