package com.example.projectbd.app.service;

import com.example.projectbd.item.model.ProcedureItem;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface ProcedureService {
    List<ProcedureItem> getAllProcedures(PageRequest pageRequest);
    List<ProcedureItem> getAllProcedures(String name,PageRequest pageRequest);

    ProcedureItem getProcedure(Integer procedureId);

    ProcedureItem createProcedure(ProcedureItem procedureItem);

    ProcedureItem saveProcedure(ProcedureItem currentProcedure);

    void deleteProcedure(Integer procedureId);

}
