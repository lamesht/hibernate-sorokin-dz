package sorokin_hibernate_dz.infrastructure.web.restController;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sorokin_hibernate_dz.application.dto.createRequest.ClientCreateRequest;
import sorokin_hibernate_dz.application.dto.response.ClientResponse;
import sorokin_hibernate_dz.application.service.ClientService;

@RestController
@RequestMapping("/app/client")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<ClientResponse> createClient(
            @Valid @RequestBody ClientCreateRequest createRequest
    ){
        var response = clientService.createClient(createRequest);


        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<Void> deleteClient(
            @PathVariable Long clientId
    ){
        clientService.deleteClient(clientId);
        return ResponseEntity.noContent().build();
    }
}
