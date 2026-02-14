package com.sorokin_hibernate_dz.application.service;

import com.sorokin_hibernate_dz.application.dto.ClientCreateRequest;
import com.sorokin_hibernate_dz.application.dto.ClientResponse;
import com.sorokin_hibernate_dz.application.mapper.ClientDtoMapper;
import com.sorokin_hibernate_dz.domain.repository.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    private final ClientDtoMapper dtoMapper;

    public ClientService(ClientRepository clientRepository, ClientDtoMapper dtoMapper) {
        this.clientRepository = clientRepository;
        this.dtoMapper = dtoMapper;
    }

    public ClientResponse createClient(ClientCreateRequest createRequest) {
        var domainWithoutId = dtoMapper.fromCreateRequest(createRequest);

        var savedDomain = clientRepository.save(domainWithoutId);

        return dtoMapper.toResponse(savedDomain);
    }

    public void deleteClient(Long clientId) {
        clientRepository.deleteClient(clientId);
    }
}
