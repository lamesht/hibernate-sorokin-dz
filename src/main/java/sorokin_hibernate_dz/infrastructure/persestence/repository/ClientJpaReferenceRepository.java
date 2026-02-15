package sorokin_hibernate_dz.infrastructure.persestence.repository;

import sorokin_hibernate_dz.infrastructure.persestence.entity.ClientJpaEntity;

public interface ClientJpaReferenceRepository {
    ClientJpaEntity getReferenceById(Long clientId);
}
