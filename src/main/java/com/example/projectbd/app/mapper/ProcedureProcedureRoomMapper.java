package com.example.projectbd.app.mapper;

import com.example.projectbd.api.model.ProcedureProcedureRoomDto;
import com.example.projectbd.item.model.ProcedureProcedureRoomItem;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface ProcedureProcedureRoomMapper {
    ProcedureProcedureRoomMapper INSTANCE = Mappers.getMapper(ProcedureProcedureRoomMapper.class);
    ProcedureProcedureRoomDto toDto (ProcedureProcedureRoomItem item);
    List<ProcedureProcedureRoomDto> toDto(List<ProcedureProcedureRoomItem> items);
}
