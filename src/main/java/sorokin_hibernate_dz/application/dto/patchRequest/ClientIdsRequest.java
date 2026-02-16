package sorokin_hibernate_dz.application.dto.patchRequest;

import java.util.List;

public record ClientIdsRequest(
        List<Long> clientIds
) {
}
