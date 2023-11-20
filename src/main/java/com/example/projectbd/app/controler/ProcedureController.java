package com.example.projectbd.app.controler;

import com.example.projectbd.api.ProcedureApi;
import com.example.projectbd.api.model.ProcedureDto;
import com.example.projectbd.app.mapper.ProcedureMapper;
import com.example.projectbd.app.service.ProcedureService;
import com.example.projectbd.item.model.ProcedureItem;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequiredArgsConstructor
public class ProcedureController implements ProcedureApi {

    private  final ProcedureService procedureService;

    @Override
    public ResponseEntity<List<ProcedureDto>> getAllProcedures() {
        List<ProcedureItem> allProcedures = procedureService.getAllProcedures();
        return ResponseEntity.ok(ProcedureMapper.INSTANCE.toDto(allProcedures));
    }

    @Override
    public ResponseEntity<ProcedureDto> getProcedure(Integer procedureId) {
        ProcedureItem procedure =procedureService.getProcedure(procedureId);
        return ResponseEntity.ok(ProcedureMapper.INSTANCE.toDto(procedure));
    }

    @Override
    public ResponseEntity<ProcedureDto> addProcedure(ProcedureDto procedure) {

        ProcedureItem procedureItem = ProcedureMapper.INSTANCE.mapToItem(procedure);

        ProcedureItem createdProcedure = procedureService.createProcedure(procedureItem);

        return ResponseEntity.status(HttpStatus.CREATED).body(ProcedureMapper.INSTANCE.toDto(createdProcedure));
    }

    @Override
    public ResponseEntity<ProcedureDto> updateProcedure(Integer procedureId, ProcedureDto procedure) {
        ProcedureItem currentProcedure = procedureService.getProcedure(procedureId);
        currentProcedure.setDuration(procedure.getDuration());
        currentProcedure.setId(procedure.getId());
        currentProcedure.setName(procedure.getName());

        ProcedureItem updatedProcedure = procedureService.saveProcedure(currentProcedure);
        return ResponseEntity.ok(ProcedureMapper.INSTANCE.toDto(updatedProcedure));
    }

    @Override
    public ResponseEntity<Void> deleteProcedure(Integer procedureId) {
        procedureService.deleteProcedure(procedureId);
        return ResponseEntity.ok().build();
    }
}
