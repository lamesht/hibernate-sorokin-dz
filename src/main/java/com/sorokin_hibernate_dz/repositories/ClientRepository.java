package com.sorokin_hibernate_dz.repositories;

import com.sorokin_hibernate_dz.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> { }
