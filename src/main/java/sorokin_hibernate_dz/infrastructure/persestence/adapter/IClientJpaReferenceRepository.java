package sorokin_hibernate_dz.infrastructure.persestence.adapter;

import org.springframework.stereotype.Component;
import sorokin_hibernate_dz.infrastructure.persestence.entity.ClientJpaEntity;
import sorokin_hibernate_dz.infrastructure.persestence.repository.ClientJpaReferenceRepository;
import sorokin_hibernate_dz.infrastructure.persestence.repository.ClientJpaRepository;
import org.springframework.stereotype.Repository;

@Component
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
