package com.example.projectbd.api;

import com.example.projectbd.api.model.ProcedureDto;
import com.example.projectbd.api.model.ProcedureRoomDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public interface ProcedureApi {
    @GetMapping("/procedures")
    ResponseEntity<List<ProcedureDto>> getAllProcedures();

    @GetMapping("/procedures/{procedureId}")
    ResponseEntity<ProcedureDto> getProcedure(
            @PathVariable("procedureId")
            Integer procedureId
    );
    @PostMapping("/procedures")
    ResponseEntity<ProcedureDto> addProcedure(
            @RequestBody
            ProcedureDto procedure
    );

    @PutMapping("/procedures/{procedureId}")
    ResponseEntity<ProcedureDto> updateProcedure(
            @PathVariable("procedureId")
            Integer proceduremId,

            @RequestBody
            ProcedureDto procedure
    );

    @DeleteMapping("/procedures/{procedureId}")
    ResponseEntity<Void> deleteProcedure(
            @PathVariable("procedureId")
            Integer procedureId
    );
}
