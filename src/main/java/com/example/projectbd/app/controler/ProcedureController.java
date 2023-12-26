package com.example.projectbd.app.controler;

import com.example.projectbd.api.ProcedureApi;
import com.example.projectbd.api.model.request.ProcedureRequest;
import com.example.projectbd.api.model.response.ProcedureResponse;
import com.example.projectbd.app.mapper.ProcedureMapper;
import com.example.projectbd.app.service.ProcedureService;
import com.example.projectbd.item.model.ProcedureItem;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequiredArgsConstructor
public class ProcedureController implements ProcedureApi {

    private  final ProcedureService procedureService;
    private final ProcedureMapper procedureMapper;

    @Override
    public ResponseEntity<List<ProcedureResponse>> getAllProcedures(int page, int size) {
        List<ProcedureItem> allProcedures = procedureService.getAllProcedures(PageRequest.of(page, size));
        return ResponseEntity.ok(procedureMapper.mapToDto(allProcedures));
    }

    @Override
    public ResponseEntity<List<ProcedureResponse>> getAllProceduresWithFilter(String name, int page, int size) {
        List<ProcedureItem> allProcedures = procedureService.getAllProcedures(name, PageRequest.of(page, size));
        return ResponseEntity.ok(procedureMapper.mapToDto(allProcedures));
    }

    @Override
    public ResponseEntity<ProcedureResponse> getProcedure(Integer procedureId) {
        ProcedureItem procedure =procedureService.getProcedure(procedureId);
        return ResponseEntity.ok(procedureMapper.mapToDto(procedure));
    }

    @Override
    public ResponseEntity<ProcedureResponse> addProcedure(ProcedureRequest procedure) {

        ProcedureItem procedureItem = procedureMapper.mapRequestToItem(procedure);

        ProcedureItem createdProcedure = procedureService.createProcedure(procedureItem);

        return ResponseEntity.status(HttpStatus.CREATED).body(procedureMapper.mapToDto(createdProcedure));
    }

    @Override
    public ResponseEntity<ProcedureResponse> updateProcedure(Integer procedureId, ProcedureRequest procedure) {
        ProcedureItem procedureItem = procedureMapper.mapRequestToItem(procedure);
        ProcedureItem currentProcedure = procedureService.getProcedure(procedureId);
        currentProcedure.setName(procedureItem.getName());
        currentProcedure.setPrice(procedureItem.getPrice());
        currentProcedure.setStaff(procedureItem.getStaff());
        currentProcedure.setProcedureRoom(procedureItem.getProcedureRoom());
        ProcedureItem updatedProcedure = procedureService.saveProcedure(currentProcedure);
        return ResponseEntity.ok(procedureMapper.mapToDto(updatedProcedure));
    }

    @Override
    public ResponseEntity<Void> deleteProcedure(Integer procedureId) {
        procedureService.deleteProcedure(procedureId);
        return ResponseEntity.ok().build();
    }
}
