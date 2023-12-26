package com.example.projectbd.app.service;

import com.example.projectbd.item.model.ProcedureRoomItem;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface ProcedureRoomService {

    List<ProcedureRoomItem> getAllProcedureRooms(PageRequest pageRequest);

    ProcedureRoomItem getProcedureRoom(Integer procedureRoomId);

    ProcedureRoomItem createProcedureRoom(ProcedureRoomItem procedureRoomItem);

    ProcedureRoomItem saveProcedureRoom(ProcedureRoomItem currentProcedureRoom);

    void deleteProcedureRoom(Integer procedureRoomId);

}
