package com.example.projectbd.app.controler;

import com.example.projectbd.api.ClientApi;
import com.example.projectbd.api.model.ClientDto;
import com.example.projectbd.app.mapper.ClientMapper;

import com.example.projectbd.app.service.ClientService;
import com.example.projectbd.item.model.ClientItem;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ClientController implements ClientApi {

    private final ClientService clientService;

    @Override
    public ResponseEntity<List<ClientDto>> getAllClients() {
        List<ClientItem> allClients = clientService.getAllClients();
        return ResponseEntity.ok(ClientMapper.INSTANCE.toDto(allClients));
    }

    @Override
    public ResponseEntity<ClientDto> getClient(Integer clientId) {
        ClientItem client = clientService.getClient(clientId);
        return ResponseEntity.ok(ClientMapper.INSTANCE.toDto(client));
    }

    @Override
    public ResponseEntity<ClientDto> addClient(ClientDto client) {
        ClientItem clientItem = ClientMapper.INSTANCE.mapToItem(client);
        //clientItem.setId(Integer.randomInteger());
        ClientItem createdClient = clientService.createClient(clientItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(ClientMapper.INSTANCE.toDto(createdClient));



    }

    @Override
    public ResponseEntity<ClientDto> updateClient(Integer clientId, ClientDto newClient) {
        ClientItem currentClient = clientService.getClient(clientId);
        currentClient.setFull_name(newClient.getFull_name());
        currentClient.setGender(newClient.getGender());
        currentClient.setDate_of_birth(newClient.getDate_of_birth());
        currentClient.setAdress(newClient.getAdress());
        currentClient.setPhone_number(newClient.getPhone_number());


        ClientItem updatedClient = clientService.saveClient(currentClient);
        return ResponseEntity.ok(ClientMapper.INSTANCE.toDto(updatedClient));
    }

    @Override
    public ResponseEntity<Void> deleteClient(Integer clientId) {
        clientService.deleteClient(clientId);
        return ResponseEntity.ok().build();
    }
}
