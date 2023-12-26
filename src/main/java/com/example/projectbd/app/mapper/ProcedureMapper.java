package com.example.projectbd.app.mapper;

import com.example.projectbd.api.model.request.ProcedureRequest;
import com.example.projectbd.api.model.response.ProcedureResponse;
import com.example.projectbd.app.service.ProcedureRoomService;
import com.example.projectbd.app.service.ProcedureService;
import com.example.projectbd.app.service.StaffService;
import com.example.projectbd.item.model.ProcedureItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Mapper(componentModel = "spring")
public abstract class ProcedureMapper {
    @Autowired
    protected StaffService staffService;
    @Autowired
    protected ProcedureRoomService procedureRoomService;
    public abstract ProcedureResponse mapToDto(ProcedureItem item);

    public abstract List<ProcedureResponse> mapToDto(List<ProcedureItem> items);
    public abstract List<ProcedureItem> mapToItem(List<ProcedureResponse> items);
    public abstract ProcedureItem mapToItem(ProcedureResponse dto);

    @Mappings({
            @Mapping(target = "staff", expression = "java(staffService.getStaff(request.getStaffId()))"),
            @Mapping(target = "procedureRoom", expression = "java(procedureRoomService.getProcedureRoom(request.getProcedureRoomId()))")
    })
    public abstract ProcedureItem mapRequestToItem(ProcedureRequest request);

}
