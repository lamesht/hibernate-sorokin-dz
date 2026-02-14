package com.sorokin_hibernate_dz.infrastructure.persestence.repository;

import com.sorokin_hibernate_dz.infrastructure.persestence.entity.ClientJpaEntity;

public interface ClientJpaReferenceRepository {
    ClientJpaEntity getReferenceById(Long clientId);
}
