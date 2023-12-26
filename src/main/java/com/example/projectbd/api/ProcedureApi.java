package com.example.projectbd.api;

import com.example.projectbd.api.model.request.ProcedureRequest;
import com.example.projectbd.api.model.response.ProcedureResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ProcedureApi {
    @GetMapping("/procedures")
    ResponseEntity<List<ProcedureResponse>> getAllProcedures(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size
    );

    @GetMapping("/procedure/find")
    ResponseEntity<List<ProcedureResponse>> getAllProceduresWithFilter(
            @RequestParam(required = false) String name,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size
    );

    @GetMapping("/procedures/{procedureId}")
    ResponseEntity<ProcedureResponse> getProcedure(
            @PathVariable("procedureId")
            Integer procedureId
    );
    @PostMapping("/procedures")
    ResponseEntity<ProcedureResponse> addProcedure(
            @RequestBody
            ProcedureRequest procedure
    );

    @PutMapping("/procedures/{procedureId}")
    ResponseEntity<ProcedureResponse> updateProcedure(
            @PathVariable("procedureId")
            Integer proceduremId,

            @RequestBody
            ProcedureRequest procedure
    );

    @DeleteMapping("/procedures/{procedureId}")
    ResponseEntity<Void> deleteProcedure(
            @PathVariable("procedureId")
            Integer procedureId
    );
}
