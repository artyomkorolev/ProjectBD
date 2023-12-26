package com.example.projectbd.api;

import com.example.projectbd.api.model.request.ClientRequest;
import com.example.projectbd.api.model.response.ClientResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ClientApi {

    @GetMapping("/clients")
    ResponseEntity<List<ClientResponse>> getAllClients(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size,
            @RequestParam(required = false, defaultValue = "id") String sortParam
    );

    @GetMapping("/clients/find")
    ResponseEntity<List<ClientResponse>> getClientsWithFilter(
            @RequestParam(required = false) String fullName,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size
    );
    @GetMapping("/clients/{clientId}")
    ResponseEntity<ClientResponse> getClient(
        @PathVariable("clientId")
        Integer clientId
    );
    @PostMapping("/clients")
    ResponseEntity<ClientResponse> addClient(
            @RequestBody
            ClientRequest client
    );

    @PutMapping("/clients/{clientId}")
    ResponseEntity<ClientResponse> updateClient(
            @PathVariable("clientId")
            Integer clientId,

            @RequestBody
            ClientRequest client
    );

    @DeleteMapping("/clients/{clientId}")
    ResponseEntity<Void> deleteClient(
            @PathVariable("clientId")
            Integer clientId
    );
}
