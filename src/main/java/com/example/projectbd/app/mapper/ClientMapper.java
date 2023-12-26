package com.example.projectbd.app.mapper;

import com.example.projectbd.api.model.request.ClientRequest;
import com.example.projectbd.api.model.response.ClientResponse;
import com.example.projectbd.app.service.LivingRoomService;
import com.example.projectbd.item.model.ClientItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ClientMapper {
    @Autowired
    protected LivingRoomService livingRoomService;
    public abstract ClientResponse mapToDto(ClientItem item);
    public abstract List<ClientResponse> mapToDto(List<ClientItem> items);
    public abstract List<ClientItem> mapToItem(List<ClientResponse> items);
    public abstract ClientItem mapToItem(ClientResponse dto);

    @Mapping(target = "livingRoom", expression = "java(livingRoomService.getLivingRoom(request.getLivingRoomId()))")
    public abstract ClientItem mapRequestToItem(ClientRequest request);

}
