package com.example.projectbd.app.service.impl;

import com.example.projectbd.app.exception.NotFoundException;
import com.example.projectbd.app.service.ClientService;
import com.example.projectbd.app.service.LivingRoomService;
import com.example.projectbd.item.ClientRepository;
import com.example.projectbd.item.model.ClientItem;
import com.example.projectbd.item.model.LivingRoomItem;
import com.example.projectbd.specifications.ClientSpecifications;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientSeviceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final LivingRoomService livingRoomService;

    @Override
    public List<ClientItem> getAllClients(PageRequest pageRequest) {
        return clientRepository.findAll(pageRequest).getContent();
    }

    public List<ClientItem> getAllClients(String fullName, PageRequest pageRequest) {
        return clientRepository.findAll(Specification.where(ClientSpecifications.hasFullName(fullName)),pageRequest).getContent();
    }

    @Override
    public ClientItem getClient(Integer clientId) {
        return clientRepository.findById(clientId).orElseThrow(() -> new NotFoundException(("Client with this id not found")));
    }

    @Override
    public ClientItem createClient(ClientItem clientItem) {
        LivingRoomItem livingRoom = clientItem.getLivingRoom();
        livingRoom.setStatus(true);
        livingRoomService.saveLivingRoom(livingRoom);
        return saveClient(clientItem);
    }

    @Override
    public ClientItem saveClient(ClientItem client) {
        return clientRepository.saveAndFlush(client);
    }

    @Override
    public void deleteClient(Integer clientId) {
        LivingRoomItem livingRoom = getClient(clientId).getLivingRoom();
        livingRoom.setStatus(false);
        livingRoomService.saveLivingRoom(livingRoom);
        clientRepository.deleteById(clientId);
    }
}
