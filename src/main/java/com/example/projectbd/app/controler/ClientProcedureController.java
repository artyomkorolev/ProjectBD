package com.example.projectbd.app.controler;

import com.example.projectbd.api.ClientProcedureApi;
import com.example.projectbd.api.model.request.ClientProcedureRequest;
import com.example.projectbd.api.model.response.ClientProcedureResponse;
import com.example.projectbd.app.mapper.ClientProcedureMapper;
import com.example.projectbd.app.service.ClientProcedureService;
import com.example.projectbd.item.model.ClientProcedureItem;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ClientProcedureController implements ClientProcedureApi {

    private final ClientProcedureService clientProcedureService;
    private final ClientProcedureMapper clientProcedureMapper;
    @Override
    public ResponseEntity<List<ClientProcedureResponse>> getProcedureOfClient(Integer clientId) {
        List<ClientProcedureItem> clientProcedureItems = clientProcedureService.getProcedureOfClient(clientId);
        List<ClientProcedureResponse> dtos = clientProcedureMapper.mapClientProcedureItemToDto(clientProcedureItems);
        return ResponseEntity.ok(dtos);
    }

    @Override
    public ResponseEntity<List<ClientProcedureResponse>> getClientOfProcedure(Integer procedureId) {
        List<ClientProcedureItem> clientProcedureItems = clientProcedureService.getClientOfProcedure(procedureId);
        List<ClientProcedureResponse> dtos = clientProcedureMapper.mapClientProcedureItemToDto(clientProcedureItems);
        return ResponseEntity.ok(dtos);
    }

    @Override
    public ResponseEntity<ClientProcedureResponse> createClientProcedure(ClientProcedureRequest clientProcedure) {
        ClientProcedureItem clientProcedureItem = clientProcedureMapper.mapRequestToItem(clientProcedure);
        ClientProcedureItem createdProcedureItem = clientProcedureService.createClientProcedure(clientProcedureItem);
        ClientProcedureResponse clientProcedureResponse = clientProcedureMapper.mapClientProcedureItemToDto(createdProcedureItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientProcedureResponse);
    }

    @Override
    public ResponseEntity<ClientProcedureResponse> updateClientProcedure(Integer clientId, Integer procedureId, ClientProcedureRequest clientProcedure) {
        ClientProcedureItem currentClientProcedureItem = clientProcedureService.getClientProcedure(clientId, procedureId);
        ClientProcedureItem newClientProcedureItem = clientProcedureMapper.mapRequestToItem(clientProcedure);
        currentClientProcedureItem.setCount(newClientProcedureItem.getCount());
        ClientProcedureItem updatedClientProcedureItem = clientProcedureService.updateClientProcedure(currentClientProcedureItem);
        return ResponseEntity.ok(clientProcedureMapper.mapClientProcedureItemToDto(updatedClientProcedureItem));
    }

    @Override
    public ResponseEntity<ClientProcedureResponse> deleteClientProcedure(Integer clientId, Integer procedureId) {
        clientProcedureService.deleteClientProcedure(clientId, procedureId);
        return ResponseEntity.ok().build();
    }
}
