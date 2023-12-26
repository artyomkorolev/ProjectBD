package com.example.projectbd.app.mapper;

import com.example.projectbd.api.model.request.StaffRequest;
import com.example.projectbd.api.model.response.StaffResponse;
import com.example.projectbd.item.model.StaffItem;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public abstract class StaffMapper {
    public abstract StaffItem mapRequestToItem(StaffRequest request);
    public abstract StaffResponse mapToDto(StaffItem item);
    public abstract List<StaffResponse> mapToDto(List<StaffItem> items);
    public abstract List<StaffItem> mapToItem(List<StaffResponse> items);
    public abstract StaffItem mapToItem(StaffResponse dto);
}
