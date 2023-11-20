package com.example.projectbd.app.service;

import com.example.projectbd.item.model.LivingRoomItem;
import com.example.projectbd.item.model.ProcedureRoomItem;

import java.util.List;

public interface ProcedureRoomService {

    List<ProcedureRoomItem> getAllProcedureRooms();

    ProcedureRoomItem getProcedureRoom(Integer procedureRoomId);

    ProcedureRoomItem createProcedureRoom(ProcedureRoomItem procedureRoomItem);

    ProcedureRoomItem saveProcedureRoom(ProcedureRoomItem currentProcedureRoom);

    void deleteProcedureRoom(Integer procedureRoomId);

}
