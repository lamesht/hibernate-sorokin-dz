package sorokin_hibernate_dz.infrastructure.persestence.repository;

import sorokin_hibernate_dz.infrastructure.persestence.entity.ProfileJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileJpaRepository extends JpaRepository<ProfileJpaEntity, Long> {}
