package com.example.projectbd.app.service;

import com.example.projectbd.item.model.ClientItem;

import java.util.List;
import java.util.UUID;

public interface ClientService {
    List<ClientItem> getAllClients();

    ClientItem getClient(Integer clientId);

    ClientItem createClient(ClientItem clientItem);

    ClientItem saveClient(ClientItem currentClient);

    void deleteClient(Integer clientId);
}
