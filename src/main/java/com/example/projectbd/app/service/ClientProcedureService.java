package com.example.projectbd.app.service;

import com.example.projectbd.item.model.ClientProcedureItem;

import java.util.List;

public interface ClientProcedureService {
    ClientProcedureItem getClientProcedure(Integer clientId, Integer procedureId);
    List<ClientProcedureItem> getProcedureOfClient(Integer clientId);

    List<ClientProcedureItem> getClientOfProcedure(Integer procedureId);

    ClientProcedureItem createClientProcedure(ClientProcedureItem clientProcedureItem);

    ClientProcedureItem updateClientProcedure(ClientProcedureItem clientProcedureItem);

    void deleteClientProcedure(Integer clientId, Integer procedureId);
}
