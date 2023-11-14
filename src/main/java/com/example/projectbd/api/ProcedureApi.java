package com.example.projectbd.api;

import com.example.projectbd.api.model.ProcedureDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

public interface ProcedureApi {
    @GetMapping("/procedures")
    ResponseEntity<List<ProcedureDto>> getAllLProcedures();

    @GetMapping("/procedures/{procedureId}")
    ResponseEntity<ProcedureDto> getProcedure(
            @PathVariable("procedureId")
            Integer procedureId
    );
}
