package com.example.projectbd.app.service;

import com.example.projectbd.item.model.ProcedureItem;
import com.example.projectbd.item.model.ProcedureRoomItem;

import java.util.List;

public interface ProcedureService {
    List<ProcedureItem> getAllProcedures();

    ProcedureItem getProcedure(Integer procedureId);

    ProcedureItem createProcedure(ProcedureItem procedureItem);

    ProcedureItem saveProcedure(ProcedureItem currentProcedure);

    void deleteProcedure(Integer procedureId);

}
