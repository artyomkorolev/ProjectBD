package com.example.projectbd.api;

import com.example.projectbd.api.model.request.ClientProcedureRequest;
import com.example.projectbd.api.model.response.ClientProcedureResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ClientProcedureApi {
    @GetMapping("/client/procedure/{clientId}")
    ResponseEntity<List<ClientProcedureResponse>> getProcedureOfClient(
            @PathVariable Integer clientId
    );

    @GetMapping("/procedure/client/{procedureId}")
    ResponseEntity<List<ClientProcedureResponse>> getClientOfProcedure(
            @PathVariable Integer procedureId
    );

    @PostMapping("/procedure/client")
    ResponseEntity<ClientProcedureResponse> createClientProcedure(
            @RequestBody
            ClientProcedureRequest clientProcedure
    );

    @PutMapping("procedure/client/{clientId}/{procedureId}")
    ResponseEntity<ClientProcedureResponse> updateClientProcedure(
            @PathVariable("clientId")
            Integer clientId,

            @PathVariable("procedureId")
            Integer procedureId,

            @RequestBody
            ClientProcedureRequest clientProcedure
    );

    @DeleteMapping("procedure/client/{clientId}/{procedureId}")
    ResponseEntity<ClientProcedureResponse> deleteClientProcedure(
            @PathVariable("clientId")
            Integer clientId,

            @PathVariable("procedureId")
            Integer procedureId
    );
}
