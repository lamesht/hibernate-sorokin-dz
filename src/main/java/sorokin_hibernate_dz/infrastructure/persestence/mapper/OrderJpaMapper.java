package sorokin_hibernate_dz.infrastructure.persestence.mapper;

import org.springframework.stereotype.Component;
import sorokin_hibernate_dz.domain.model.OrderDomain;
import sorokin_hibernate_dz.infrastructure.persestence.entity.OrderJpaEntity;
import sorokin_hibernate_dz.infrastructure.persestence.repository.ClientJpaReferenceRepository;

@Component
public class OrderJpaMapper {
    private final ClientJpaReferenceRepository clientJpaReferenceRepository;

    public OrderJpaMapper(ClientJpaReferenceRepository clientJpaReferenceRepository) {
        this.clientJpaReferenceRepository = clientJpaReferenceRepository;
    }

    public OrderJpaEntity toEntity(OrderDomain domain) {
        var clientReference = clientJpaReferenceRepository.getReferenceById(domain.getClientId());

        return OrderJpaEntity.of(
                domain.getId(),
                domain.getTotalAmount(),
                domain.getOrderDate(),
                domain.getStatus(),
                clientReference
        );
    }

    public OrderDomain toDomain(OrderJpaEntity entity){
        return OrderDomain.of(
                entity.getId(),
                entity.getTotalAmount(),
                entity.getOrderDate(),
                entity.getStatus(),
                entity.getClientId()
        );
    }
}
