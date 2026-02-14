package com.sorokin_hibernate_dz.domain.repository;

import com.sorokin_hibernate_dz.domain.model.ClientDomain;

public interface ClientRepository {
    ClientDomain save(ClientDomain domain);
    ClientDomain findByIdOrThrow(Long clientId);
    void deleteClient(Long clientId);
}
