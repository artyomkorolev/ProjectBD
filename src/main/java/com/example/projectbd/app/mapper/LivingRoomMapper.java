package com.example.projectbd.app.mapper;

import com.example.projectbd.api.model.request.LivingRoomRequest;
import com.example.projectbd.api.model.response.LivingRoomResponse;
import com.example.projectbd.item.model.LivingRoomItem;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public abstract class LivingRoomMapper {

    public abstract LivingRoomItem mapRequestToItem(LivingRoomRequest request);
    public abstract LivingRoomResponse mapToDto(LivingRoomItem item);

    public abstract List<LivingRoomResponse> mapToDto(List<LivingRoomItem> items);
    public abstract List<LivingRoomItem> mapToItem(List<LivingRoomResponse> items);
    public abstract LivingRoomItem mapToItem(LivingRoomResponse dto);
}
