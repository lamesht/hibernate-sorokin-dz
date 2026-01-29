package com.sorokin_hibernate_dz.repositories;

import com.sorokin_hibernate_dz.entities.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Repository
public class ClientFinderImpl implements ClientFinder {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Client> findAllByIdIn(Collection<Long> ids) {
        if (ids == null || ids.isEmpty()) {
            return Collections.emptyList();
        }

        return entityManager.createQuery(
                "FROM Client WHERE id IN :ids", Client.class)
                .setParameter("ids", ids)
                .getResultList();
    }
}
