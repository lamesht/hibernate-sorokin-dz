package sorokin_hibernate_dz.infrastructure.web.restController;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sorokin_hibernate_dz.application.dto.createRequest.ProfileCreateRequest;
import sorokin_hibernate_dz.application.dto.patchRequest.ProfilePatchRequest;
import sorokin_hibernate_dz.application.dto.response.ProfileResponse;
import sorokin_hibernate_dz.application.service.ProfileService;

@RestController
@RequestMapping("/app/client/{clientId}/profile")
public class ProfileController {
    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping
    public ResponseEntity<ProfileResponse> createProfile(
            @PathVariable Long clientId,
            @Valid @RequestBody ProfileCreateRequest createRequest
    ){
        var response = profileService.createProfile(clientId, createRequest);

        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{profileId}")
    public ResponseEntity<ProfileResponse> patchProfile(
            @PathVariable Long profileId,
            @Valid @RequestBody ProfilePatchRequest patchRequest
    ){
        var response = profileService.applyProfilePatch(profileId, patchRequest);

        return ResponseEntity.ok(response);
    }
}
