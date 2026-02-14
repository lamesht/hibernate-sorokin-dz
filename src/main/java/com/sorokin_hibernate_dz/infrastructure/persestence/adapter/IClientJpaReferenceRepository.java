package com.sorokin_hibernate_dz.infrastructure.persestence.adapter;

import com.sorokin_hibernate_dz.infrastructure.persestence.entity.ClientJpaEntity;
import com.sorokin_hibernate_dz.infrastructure.persestence.repository.ClientJpaReferenceRepository;
import com.sorokin_hibernate_dz.infrastructure.persestence.repository.ClientJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class IClientJpaReferenceRepository implements ClientJpaReferenceRepository {
    private final ClientJpaRepository clientJpaRepository;

    public IClientJpaReferenceRepository(ClientJpaRepository clientJpaRepository) {
        this.clientJpaRepository = clientJpaRepository;
    }

    @Override
    public ClientJpaEntity getReferenceById(Long clientId) {
        return clientJpaRepository.getReferenceById(clientId);
    }
}
