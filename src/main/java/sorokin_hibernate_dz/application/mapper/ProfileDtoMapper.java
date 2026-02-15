package sorokin_hibernate_dz.application.mapper;

import sorokin_hibernate_dz.application.dto.createRequest.ProfileCreateRequest;
import sorokin_hibernate_dz.application.dto.response.ProfileResponse;
import sorokin_hibernate_dz.domain.model.ProfileDomain;

public class ProfileDtoMapper {

    public ProfileDomain fromCreateRequest(
            Long clientId,
            ProfileCreateRequest createRequest
    ){
        return ProfileDomain.create(
                createRequest.getAddress(),
                createRequest.getPhoneNumber(),
                clientId
        );
    }

    public ProfileResponse toResponse(ProfileDomain domain){
        return new ProfileResponse(
                domain.getId(),
                domain.getAddress(),
                domain.getPhoneNumber(),
                domain.getClientId()
        );

    }
}
