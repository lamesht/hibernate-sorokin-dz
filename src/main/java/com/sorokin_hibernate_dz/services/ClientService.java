package com.sorokin_hibernate_dz.services;

import com.sorokin_hibernate_dz.entities.Client;
import com.sorokin_hibernate_dz.entities.Coupon;
import com.sorokin_hibernate_dz.repositories.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client createClient(String name, String email) {
        Client client = new Client(name, email);

        return clientRepository.save(client);
    }

    public void deleteClient(Long clientId) {
        Client client = clientRepository
                .findById(clientId)
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "Client with %d not found".formatted(clientId))
                );

        List<Coupon> clientCoupons = client.getCoupons();

        for (Coupon coupon : client.getCoupons()) {
            coupon.getClients().remove(client);
        }

        client.getCoupons().clear();

        clientRepository.delete(client);
    }
}
