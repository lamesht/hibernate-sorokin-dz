package com.sorokin_hibernate_dz.client;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.Collection;
import java.util.List;

public class ICustomClientRepository implements CustomClientRepository{
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<ClientEntity> existsByIds(Collection<Long> ids) {

    }
}
