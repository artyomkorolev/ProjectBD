package com.example.projectbd.app.mapper;

import com.example.projectbd.api.model.StaffDto;
import com.example.projectbd.item.model.StaffItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StaffMapper {
    StaffMapper INSTANCE = Mappers.getMapper(StaffMapper.class);

    StaffDto toDto (StaffItem item);
    List<StaffDto> toDto(List<StaffItem> items);
}
