package com.example.projectbd.api;

import com.example.projectbd.api.model.ClientDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public interface ClientApi {

    @GetMapping("/clients")
    ResponseEntity<List<ClientDto>> getAllClients();

    @GetMapping("/clients/{clientId}")
    ResponseEntity<ClientDto> getClient(
        @PathVariable("clientId")
        Integer clientId
    );
    @PostMapping("/clients")
    ResponseEntity<ClientDto> addClient(
            @RequestBody
            ClientDto client
    );

    @PutMapping("/clients/{clientId}")
    ResponseEntity<ClientDto> updateClient(
            @PathVariable("clientId")
            Integer clientId,

            @RequestBody
            ClientDto client
    );

    @DeleteMapping("/clients/{clientId}")
    ResponseEntity<Void> deleteClient(
            @PathVariable("clientId")
            Integer clientId
    );
}
