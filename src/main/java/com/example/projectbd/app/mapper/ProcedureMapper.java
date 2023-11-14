package com.example.projectbd.app.mapper;

import com.example.projectbd.api.model.ClientDto;
import com.example.projectbd.api.model.LivingRoomDto;
import com.example.projectbd.api.model.ProcedureDto;
import com.example.projectbd.item.model.ClientItem;
import com.example.projectbd.item.model.LivingRoomItem;
import com.example.projectbd.item.model.ProcedureItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface ProcedureMapper {
    ProcedureMapper INSTANCE = Mappers.getMapper(ProcedureMapper.class);
    ProcedureDto toDto (ProcedureItem item);
    List<ProcedureDto> toDto(List<ProcedureItem> items);
    ProcedureItem mapToItem(ProcedureDto dto);
    List<ProcedureItem> mapToItem(List<ProcedureDto> dtos);
}
