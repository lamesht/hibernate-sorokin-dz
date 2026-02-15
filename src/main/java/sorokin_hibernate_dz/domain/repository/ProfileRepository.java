package sorokin_hibernate_dz.domain.repository;

import sorokin_hibernate_dz.domain.model.ProfileDomain;

public interface ProfileRepository {
    ProfileDomain save(ProfileDomain domain);
    ProfileDomain findDomainByIdOrThrow(Long profileId);
}
