package com.sorokin_hibernate_dz.infrastructure.persestence.adapter;

import com.sorokin_hibernate_dz.infrastructure.persestence.mapper.ClientJpaMapper;
import com.sorokin_hibernate_dz.domain.model.ClientDomain;
import com.sorokin_hibernate_dz.domain.repository.ClientRepository;
import com.sorokin_hibernate_dz.shared.exception.ClientNotFoundException;
import com.sorokin_hibernate_dz.infrastructure.persestence.repository.ClientJpaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class ClientRepositoryAdapter implements ClientRepository {
    private final ClientJpaRepository clientJpaRepository;
    private final ClientJpaMapper clientMapper;

    public ClientRepositoryAdapter(
            ClientJpaRepository clientJpaRepository,
            ClientJpaMapper clientMapper) {
        this.clientJpaRepository = clientJpaRepository;
        this.clientMapper = clientMapper;
    }

    @Override
    public ClientDomain save(ClientDomain domain) {
        var mappedEntity = clientMapper.toEntity(domain);

        var savedEntity = clientJpaRepository.save(mappedEntity);

        return clientMapper.toDomain(savedEntity);
    }

    @Override
    public ClientDomain findByIdOrThrow(Long clientId) {
        var entity = clientJpaRepository.findById(clientId)
                .orElseThrow(() ->
                    new ClientNotFoundException("Client not found (ID: %d)"
                            .formatted(clientId))
                );

        return clientMapper.toDomain(entity);
    }

    @Override
    public void deleteClient(Long clientId) {
        clientJpaRepository.deleteById(clientId);
    }
}
