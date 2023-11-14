package com.example.projectbd.app.mapper;

import com.example.projectbd.api.model.ClientDto;
import com.example.projectbd.api.model.RoomOccupancyDto;
import com.example.projectbd.item.model.ClientItem;
import com.example.projectbd.item.model.RoomOccupancyItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RoomOccupancyMapper {
    RoomOccupancyMapper INSTANCE = Mappers.getMapper(RoomOccupancyMapper.class);
    RoomOccupancyDto toDto (RoomOccupancyItem item);
    List<RoomOccupancyDto> toDto(List<RoomOccupancyItem> items);
    List<RoomOccupancyItem> mapToItem(List<RoomOccupancyDto> dtos);
}
