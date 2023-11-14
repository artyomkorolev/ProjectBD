package com.example.projectbd.app.service.impl;

import com.example.projectbd.app.exception.NotFoundException;
import com.example.projectbd.app.service.ClientService;
import com.example.projectbd.item.ClientRepository;
import com.example.projectbd.item.model.ClientItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class ClientSeviceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    public List<ClientItem> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public ClientItem getClient(Integer clientId) {
        return clientRepository.findById(clientId).orElseThrow(() -> new NotFoundException(("Client with this id not found")));
    }

    @Override
    public ClientItem createClient(ClientItem clientItem) {
        return saveClient(clientItem);
    }

    @Override
    public ClientItem saveClient(ClientItem client) {
        return clientRepository.saveAndFlush(client);
    }

    @Override
    public void deleteClient(Integer clientId) {
        clientRepository.deleteById(clientId);
    }
}
