package com.example.projectbd.app.mapper;

import com.example.projectbd.api.model.ClientDto;
import com.example.projectbd.item.model.ClientItem;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);
    ClientDto toDto (ClientItem item);
    List<ClientDto> toDto(List<ClientItem> items);
    ClientItem mapToItem(ClientDto dto);
    List<ClientItem> mapToItem(List<ClientDto> dtos);
}
