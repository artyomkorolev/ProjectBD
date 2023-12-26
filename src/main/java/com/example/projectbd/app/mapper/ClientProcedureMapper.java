package com.example.projectbd.app.mapper;

import com.example.projectbd.api.model.request.ClientProcedureRequest;
import com.example.projectbd.api.model.response.ClientProcedureResponse;
import com.example.projectbd.api.model.response.ClientResponse;
import com.example.projectbd.api.model.response.ProcedureResponse;
import com.example.projectbd.app.service.ClientService;
import com.example.projectbd.app.service.ProcedureService;
import com.example.projectbd.item.model.ClientItem;
import com.example.projectbd.item.model.ClientProcedureItem;
import com.example.projectbd.item.model.ClientProcedurePK;
import com.example.projectbd.item.model.ProcedureItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class ClientProcedureMapper {
    @Autowired
    protected ClientService clientService;
    @Autowired
    protected ProcedureService procedureService;

    abstract ClientItem mapClientDtoToClientItem(ClientResponse clientResponse);
    abstract ClientResponse mapClientItemToClientDto(ClientItem clientItem);
    abstract ProcedureItem mapProcedureDtoToProcedureItem(ProcedureResponse procedureResponse);
    abstract ProcedureResponse mapProcedureItemToProcedureDto(ProcedureItem procedureItem);
    public ClientProcedureItem mapDtoToClientProcedureItem(ClientProcedureResponse clientProcedureResponse) {
        ClientProcedurePK clientProcedurePK = ClientProcedurePK.builder()
                .client(mapClientDtoToClientItem(clientProcedureResponse.getClient()))
                .procedure(mapProcedureDtoToProcedureItem(clientProcedureResponse.getProcedure()))
                .build();
        return ClientProcedureItem.builder().pk(clientProcedurePK).count(clientProcedureResponse.getCount()).build();
    };

    public ClientProcedureResponse mapClientProcedureItemToDto(ClientProcedureItem clientProcedureItem) {
        return ClientProcedureResponse.builder()
                .client(mapClientItemToClientDto(clientProcedureItem.getPk().getClient()))
                .procedure(mapProcedureItemToProcedureDto(clientProcedureItem.getPk().getProcedure()))
                .count(clientProcedureItem.getCount()).build();

    }

    public List<ClientProcedureResponse> mapClientProcedureItemToDto(List<ClientProcedureItem> clientProcedureItems) {
        return clientProcedureItems.stream()
                .map(this::mapClientProcedureItemToDto)
                .collect(Collectors.toList());
    }

    public  ClientProcedureItem mapRequestToItem(ClientProcedureRequest request) {
        ClientProcedurePK clientProcedurePK = ClientProcedurePK.builder()
                .client(clientService.getClient(request.getClientId()))
                .procedure(procedureService.getProcedure(request.getProcedureId())).build();
        return ClientProcedureItem.builder().pk(clientProcedurePK).count(request.getCount()).build();
    };
}
