package com.example.projectbd.app.controler;

import com.example.projectbd.api.ClientApi;

import com.example.projectbd.api.model.request.ClientRequest;
import com.example.projectbd.api.model.response.ClientResponse;
import com.example.projectbd.app.mapper.ClientMapper;
import com.example.projectbd.app.service.ClientService;
import com.example.projectbd.item.model.ClientItem;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ClientController implements ClientApi {

    private final ClientService clientService;
    private final ClientMapper clientMapper;

    @Override
    public ResponseEntity<List<ClientResponse>> getAllClients(int page, int size, String sortParam) {
        List<ClientItem> allClients = clientService.getAllClients(PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, sortParam)));
        return ResponseEntity.ok(clientMapper.mapToDto(allClients));
    }

    @Override
    public ResponseEntity<List<ClientResponse>> getClientsWithFilter(String fullName, int page, int size) {
        List<ClientItem> allPatients = clientService.getAllClients(fullName, PageRequest.of(page, size));
        return ResponseEntity.ok(clientMapper.mapToDto(allPatients));
    }

    @Override
    public ResponseEntity<ClientResponse> getClient(Integer clientId) {
        ClientItem client = clientService.getClient(clientId);
        return ResponseEntity.ok(clientMapper.mapToDto(client));
    }

    @Override
    public ResponseEntity<ClientResponse> addClient(ClientRequest client) {
        ClientItem clientItem = clientMapper.mapRequestToItem(client);
        //clientItem.setId(Integer.randomInteger());
        ClientItem createdClient = clientService.createClient(clientItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientMapper.mapToDto(createdClient));



    }

    @Override
    public ResponseEntity<ClientResponse> updateClient(Integer clientId, ClientRequest newClient) {
        ClientItem clientItem = clientMapper.mapRequestToItem(newClient);
        ClientItem currentClient = clientService.getClient(clientId);
        currentClient.setFullName(clientItem.getFullName());
        currentClient.setPhoneNumber(clientItem.getPhoneNumber());
        currentClient.setAddress(clientItem.getAddress());
        currentClient.setLivingRoom(clientItem.getLivingRoom());
        ClientItem updatedClient = clientService.saveClient(currentClient);
        return ResponseEntity.ok(clientMapper.mapToDto(updatedClient));
    }

    @Override
    public ResponseEntity<Void> deleteClient(Integer clientId) {
        clientService.deleteClient(clientId);
        return ResponseEntity.ok().build();
    }
}
