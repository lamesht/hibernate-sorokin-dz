package sorokin_hibernate_dz.application.service;

import org.springframework.stereotype.Service;
import sorokin_hibernate_dz.application.dto.createRequest.ProfileCreateRequest;
import sorokin_hibernate_dz.application.dto.patchRequest.ProfilePatchRequest;
import sorokin_hibernate_dz.application.dto.response.ProfileResponse;
import sorokin_hibernate_dz.application.mapper.ProfileDtoMapper;
import sorokin_hibernate_dz.domain.model.ProfileDomain;
import sorokin_hibernate_dz.domain.repository.ProfileRepository;

@Service
public class ProfileService {
    private final ProfileRepository profileRepository;
    private final ProfileDtoMapper dtoMapper;

    public ProfileService(ProfileRepository profileRepository, ProfileDtoMapper dtoMapper) {
        this.profileRepository = profileRepository;
        this.dtoMapper = dtoMapper;
    }

    public ProfileResponse createProfile(
            Long clientId,
            ProfileCreateRequest createRequest
    ) {
        var domainWithoutId = dtoMapper.fromCreateRequest(clientId, createRequest);

        var savedDomain = profileRepository.save(domainWithoutId);

        return dtoMapper.toResponse(savedDomain);
    }

    public ProfileResponse applyProfilePatch(
            Long profileId,
            ProfilePatchRequest patchRequest
    ){
        var domain = profileRepository.findDomainByIdOrThrow(profileId);

        usePatch(domain, patchRequest);

        var savedDomain = profileRepository.save(domain);

        return dtoMapper.toResponse(savedDomain);
    }

    private void usePatch(ProfileDomain domain, ProfilePatchRequest patchRequest) {
        if(patchRequest.hasAddressUpdate()){
            var address = patchRequest.getAddress();
            domain.updateAddress(address);
        }
        if(patchRequest.hasPhoneNumberUpdate()){
            var phoneNumber = patchRequest.getPhoneNumber();
            domain.updatePhoneNumber(phoneNumber);
        }
    }
}
