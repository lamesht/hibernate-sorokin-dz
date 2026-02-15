package sorokin_hibernate_dz.infrastructure.persestence.adapter;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;
import sorokin_hibernate_dz.domain.model.ProfileDomain;
import sorokin_hibernate_dz.domain.repository.ProfileRepository;
import sorokin_hibernate_dz.infrastructure.persestence.entity.ProfileJpaEntity;
import sorokin_hibernate_dz.infrastructure.persestence.mapper.ProfileJpaMapper;
import sorokin_hibernate_dz.infrastructure.persestence.repository.ProfileJpaRepository;
import sorokin_hibernate_dz.shared.exception.ProfileNotFoundException;

@Component
@Transactional
public class ProfileRepositoryAdapter implements ProfileRepository {
    private final ProfileJpaRepository profileJpaRepository;
    private final ProfileJpaMapper jpaMapper;

    public ProfileRepositoryAdapter(
            ProfileJpaRepository profileJpaRepository,
            ProfileJpaMapper jpaMapper) {
        this.profileJpaRepository = profileJpaRepository;
        this.jpaMapper = jpaMapper;
    }


    @Override
    public ProfileDomain save(ProfileDomain domain) {
        var entity = jpaMapper.toEntity(domain);

        var savedEntity = profileJpaRepository.save(entity);

        return jpaMapper.toDomain(savedEntity);
    }

    @Override
    public ProfileDomain findDomainByIdOrThrow(Long profileId) {
        var entity = findEntityByIdOrThrow(profileId);

        return jpaMapper.toDomain(entity);
    }

    private ProfileJpaEntity findEntityByIdOrThrow(Long profileId){
        return profileJpaRepository.findById(profileId)
                .orElseThrow(() ->
                    new ProfileNotFoundException(
                            "Profile not found (ID: %d)"
                                    .formatted(profileId)
                    )
                );
    }
}
