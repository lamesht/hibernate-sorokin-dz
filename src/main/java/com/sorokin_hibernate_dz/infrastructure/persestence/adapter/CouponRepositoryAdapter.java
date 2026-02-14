package com.sorokin_hibernate_dz.infrastructure.persestence.adapter;

import com.sorokin_hibernate_dz.infrastructure.persestence.repository.ClientJpaReferenceRepository;
import com.sorokin_hibernate_dz.domain.model.CouponDomain;
import com.sorokin_hibernate_dz.domain.repository.CouponRepository;
import com.sorokin_hibernate_dz.infrastructure.persestence.entity.CouponJpaEntity;
import com.sorokin_hibernate_dz.infrastructure.persestence.mapper.CouponJpaMapper;
import com.sorokin_hibernate_dz.infrastructure.persestence.repository.CouponJpaRepository;
import com.sorokin_hibernate_dz.shared.exception.CouponNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CouponRepositoryAdapter implements CouponRepository {
    private final CouponJpaRepository couponJpaRepository;
    private final ClientJpaReferenceRepository clientJpaReferenceRepository;
    private final CouponJpaMapper couponJpaMapper;

    public CouponRepositoryAdapter(
            CouponJpaRepository couponJpaRepository,
            ClientJpaReferenceRepository clientJpaReferenceRepository,
            CouponJpaMapper couponJpaMapper
    ) {
        this.couponJpaRepository = couponJpaRepository;
        this.clientJpaReferenceRepository = clientJpaReferenceRepository;
        this.couponJpaMapper = couponJpaMapper;
    }


    @Override
    public CouponDomain save(CouponDomain domain) {
        var mappedEntity = couponJpaMapper.toJpaEntity(domain);

        var savedEntity = couponJpaRepository.save(mappedEntity);

        return couponJpaMapper.toDomain(savedEntity);
    }

    @Override
    public CouponDomain findDomainByIdOrThrow(Long couponId) {
        var entity = findEntityByIdOrThrow(couponId);

        return couponJpaMapper.toDomain(entity);
    }

    @Override
    @Transactional
    public void addClients(Long couponId, List<Long> clientIds) {
        var entity = findEntityByIdOrThrow(couponId);

        for(var clientId : clientIds){
            var client = clientJpaReferenceRepository.getReferenceById(clientId);
            entity.addClient(client);
        }
    }

    @Override
    @Transactional
    public void removeClients(Long couponId, List<Long> clientIds) {
        var entity = findEntityByIdOrThrow(couponId);

        for(var clientId : clientIds){
            var client = clientJpaReferenceRepository.getReferenceById(clientId);
            entity.removeClient(client);
        }
    }

    private CouponJpaEntity findEntityByIdOrThrow(Long couponId){
        return couponJpaRepository.findById(couponId)
                .orElseThrow(() ->
                        new CouponNotFoundException(
                                "Coupon not found (ID: %d)"
                                        .formatted(couponId)
                        )
                );
    }
}
