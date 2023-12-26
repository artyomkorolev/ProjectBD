package com.example.projectbd.app.mapper;

import com.example.projectbd.api.model.request.ProcedureRoomRequest;
import com.example.projectbd.api.model.response.ProcedureRoomResponse;
import com.example.projectbd.item.model.ProcedureRoomItem;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public abstract class ProcedureRoomMapper {
    public abstract ProcedureRoomItem mapRequestToItem(ProcedureRoomRequest request);
    public abstract ProcedureRoomResponse mapToDto(ProcedureRoomItem item);

    public abstract List<ProcedureRoomResponse> mapToDto(List<ProcedureRoomItem> items);
    public abstract List<ProcedureRoomItem> mapToItem(List<ProcedureRoomResponse> items);
    public abstract ProcedureRoomItem mapToItem(ProcedureRoomResponse dto);
}
