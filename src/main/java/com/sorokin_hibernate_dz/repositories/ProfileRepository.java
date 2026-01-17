package com.sorokin_hibernate_dz.repositories;

import com.sorokin_hibernate_dz.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {}
