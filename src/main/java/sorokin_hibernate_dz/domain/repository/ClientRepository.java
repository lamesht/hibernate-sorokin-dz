package sorokin_hibernate_dz.domain.repository;

import sorokin_hibernate_dz.domain.model.ClientDomain;

public interface ClientRepository {
    ClientDomain save(ClientDomain domain);
    ClientDomain findByIdOrThrow(Long clientId);
    void deleteClient(Long clientId);
}
