package com.example.projectbd.app.mapper;

import com.example.projectbd.api.model.ClientDto;
import com.example.projectbd.api.model.LivingRoomDto;
import com.example.projectbd.item.model.ClientItem;
import com.example.projectbd.item.model.LivingRoomItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface LivingRoomMapper {
    LivingRoomMapper INSTANCE = Mappers.getMapper(LivingRoomMapper.class);
    LivingRoomDto toDto (LivingRoomItem item);
    List<LivingRoomDto> toDto(List<LivingRoomItem> items);
    LivingRoomItem mapToItem(LivingRoomDto dto);
}
