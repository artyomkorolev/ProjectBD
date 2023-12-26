package com.example.projectbd.app.service;

import com.example.projectbd.item.model.ClientItem;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface ClientService {
    List<ClientItem> getAllClients(PageRequest pageRequest);
    List<ClientItem> getAllClients(String fullName, PageRequest pageRequest);

    ClientItem getClient(Integer clientId);

    ClientItem createClient(ClientItem clientItem);

    ClientItem saveClient(ClientItem currentClient);

    void deleteClient(Integer clientId);
}
