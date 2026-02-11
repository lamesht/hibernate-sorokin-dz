package com.sorokin_hibernate_dz.client;

import java.util.Collection;
import java.util.List;

public interface CustomClientRepository {
    List<ClientEntity> existsByIds(Collection<Long> ids);
}
