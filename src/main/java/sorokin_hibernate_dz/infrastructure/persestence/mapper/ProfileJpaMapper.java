package sorokin_hibernate_dz.infrastructure.persestence.mapper;

import org.springframework.stereotype.Component;
import sorokin_hibernate_dz.domain.model.ProfileDomain;
import sorokin_hibernate_dz.infrastructure.persestence.entity.ProfileJpaEntity;
import sorokin_hibernate_dz.infrastructure.persestence.repository.ClientJpaReferenceRepository;

@Component
public class ProfileJpaMapper {
    private final ClientJpaReferenceRepository clientJpaReferenceRepository;

    public ProfileJpaMapper(ClientJpaReferenceRepository clientJpaReferenceRepository) {
        this.clientJpaReferenceRepository = clientJpaReferenceRepository;
    }

    public ProfileDomain toDomain(ProfileJpaEntity entity){
        return ProfileDomain.of(
                entity.getId(),
                entity.getAddress(),
                entity.getPhoneNumber(),
                entity.getClientId()
        );
    }

    public ProfileJpaEntity toEntity(ProfileDomain domain){
        var clientId = domain.getClientId();

        return ProfileJpaEntity.of(
                domain.getId(),
                domain.getAddress(),
                domain.getPhoneNumber(),
                clientJpaReferenceRepository.getReferenceById(clientId)
        );
    }
}
