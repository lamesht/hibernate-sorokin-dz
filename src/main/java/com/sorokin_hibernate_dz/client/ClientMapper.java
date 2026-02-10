package com.sorokin_hibernate_dz.client;

import org.springframework.stereotype.Component;

@Component
public class ClientMapper {
    public ClientDomain toDomain(ClientEntity entity){
        return new ClientDomain(
            entity.g
        );
    }
}
