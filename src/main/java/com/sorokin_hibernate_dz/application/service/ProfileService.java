package com.sorokin_hibernate_dz.application.service;

import com.sorokin_hibernate_dz.profile.Profile;
import com.sorokin_hibernate_dz.domain.repository.ProfileRepository;

public class ProfileService {
    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public Profile editPhoneNumber(Profile profile, String editedPhoneNumber){
        profile.setPhoneNumber(editedPhoneNumber);

        return profileRepository.save(profile);
    }

    public Profile editAddress(Profile profile, String editedAddress){
        profile.setAddress(editedAddress);

        return profileRepository.save(profile);
    }
}
