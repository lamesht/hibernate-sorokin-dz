package sorokin_hibernate_dz.application.mapper;

import sorokin_hibernate_dz.application.dto.createRequest.ClientCreateRequest;
import sorokin_hibernate_dz.application.dto.response.ClientResponse;
import sorokin_hibernate_dz.domain.model.ClientDomain;
import org.springframework.stereotype.Component;

@Component
public class ClientDtoMapper {

    public ClientDomain fromCreateRequest(ClientCreateRequest createRequest){
        return ClientDomain.create(
                createRequest.name(),
                createRequest.email()
        );
    }

    public ClientResponse toResponse(ClientDomain domain){
        return new ClientResponse(
                domain.getId(),
                domain.getName(),
                domain.getEmail()
        );
    }
}
