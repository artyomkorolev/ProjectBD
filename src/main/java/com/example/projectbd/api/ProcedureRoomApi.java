package com.example.projectbd.api;

import com.example.projectbd.api.model.ClientDto;
import com.example.projectbd.api.model.ProcedureRoomDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ProcedureRoomApi {
    @GetMapping("/procedurerooms")
    ResponseEntity<List<ProcedureRoomDto>> getAllProcedureRooms();

    @GetMapping("/procedurerooms/{procedureroomId}")
    ResponseEntity<ProcedureRoomDto> getProcedureRoom(
            @PathVariable("procedureroomId")
            Integer procedureroomId
    );
    @PostMapping("/procedurerooms")
    ResponseEntity<ProcedureRoomDto> addProcedureRoom(
            @RequestBody
            ProcedureRoomDto procedureroom
    );

    @PutMapping("/procedurerooms/{procedureroomId}")
    ResponseEntity<ProcedureRoomDto> updateProcedureRoom(
            @PathVariable("procedureroomId")
            Integer procedureroomId,

            @RequestBody
            ProcedureRoomDto procedureroom
    );

    @DeleteMapping("/procedurerooms/{procedureroomId}")
    ResponseEntity<Void> deleteProcedureRoom(
            @PathVariable("procedureroomId")
            Integer procedureroomId
    );
}
