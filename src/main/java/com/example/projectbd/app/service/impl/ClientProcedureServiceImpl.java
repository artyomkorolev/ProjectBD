package com.example.projectbd.app.service.impl;

import com.example.projectbd.app.exception.NotFoundException;
import com.example.projectbd.app.service.ClientProcedureService;
import com.example.projectbd.app.service.ClientService;
import com.example.projectbd.app.service.ProcedureService;
import com.example.projectbd.item.ClientProcedureRepository;
import com.example.projectbd.item.model.ClientItem;
import com.example.projectbd.item.model.ClientProcedureItem;
import com.example.projectbd.item.model.ClientProcedurePK;
import com.example.projectbd.item.model.ProcedureItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ClientProcedureServiceImpl implements ClientProcedureService {

    private final ProcedureService procedureService;
    private final ClientService clientService;
    private final ClientProcedureRepository clientProcedureRepository;
    @Override
    public ClientProcedureItem getClientProcedure(Integer clientId, Integer procedureId) {
        ClientItem client = clientService.getClient(clientId);
        ProcedureItem procedure = procedureService.getProcedure(procedureId);
        ClientProcedurePK clientProcedurePK = ClientProcedurePK.builder().client(client).procedure(procedure).build();
        return clientProcedureRepository.findById(clientProcedurePK).orElseThrow(() -> new NotFoundException("ClientProcedure with this id not found"));
    }

    @Override
    public List<ClientProcedureItem> getProcedureOfClient(Integer clientId) {
        List<ClientProcedureItem> clientProcedureItems = clientProcedureRepository.findByPkClient(clientService.getClient(clientId));
        return clientProcedureItems;
    }

    @Override
    public List<ClientProcedureItem> getClientOfProcedure(Integer procedureId) {
        List<ClientProcedureItem> clientProcedureItems = clientProcedureRepository.findByPkProcedure(procedureService.getProcedure(procedureId));
        return clientProcedureItems;
    }

    @Override
    public ClientProcedureItem createClientProcedure(ClientProcedureItem clientProcedureItem) {
        return updateClientProcedure(clientProcedureItem);
    }

    @Override
    public ClientProcedureItem updateClientProcedure(ClientProcedureItem clientProcedureItem) {
        return clientProcedureRepository.saveAndFlush(clientProcedureItem);
    }

    @Override
    public void deleteClientProcedure(Integer clientId, Integer procedureId) {
        ClientItem client = clientService.getClient(clientId);
        ProcedureItem procedure = procedureService.getProcedure(procedureId);
        ClientProcedurePK clientProcedurePK = ClientProcedurePK.builder().client(client).procedure(procedure).build();
        clientProcedureRepository.deleteById(clientProcedurePK);
    }
}
