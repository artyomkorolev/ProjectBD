package com.example.projectbd.app.mapper;

import com.example.projectbd.api.model.ClientDto;
import com.example.projectbd.api.model.ProcedureRoomDto;
import com.example.projectbd.item.model.ClientItem;
import com.example.projectbd.item.model.ProcedureRoomItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProcedureRoomMapper {
    ProcedureRoomMapper INSTANCE = Mappers.getMapper(ProcedureRoomMapper.class);
    ProcedureRoomDto toDto (ProcedureRoomItem item);
    List<ProcedureRoomDto> toDto(List<ProcedureRoomItem> items);
    ProcedureRoomItem mapToItem(ProcedureRoomDto dto);
    List<ProcedureRoomItem> mapToItem(List<ProcedureRoomDto> dtos);
}

