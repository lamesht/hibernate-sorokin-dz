package sorokin_hibernate_dz.infrastructure.persestence.mapper;

import sorokin_hibernate_dz.domain.model.ClientDomain;
import sorokin_hibernate_dz.infrastructure.persestence.entity.ClientJpaEntity;
import org.springframework.stereotype.Component;

@Component
public class ClientJpaMapper {
    public ClientDomain toDomain(ClientJpaEntity entity){
        return ClientDomain.of(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getRegistrationDate()
        );
    }

    public ClientJpaEntity toEntity(ClientDomain domain){
        return ClientJpaEntity.of(
                domain.getId(),
                domain.getName(),
                domain.getEmail(),
                domain.getRegistrationDate()
        );
    }
}
