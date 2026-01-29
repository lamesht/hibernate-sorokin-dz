package com.sorokin_hibernate_dz.repositories;

import com.sorokin_hibernate_dz.entities.Client;

import java.util.Collection;
import java.util.List;

public interface ClientFinder {
    List<Client> findAllByIdIn(Collection<Long> ids);
}
