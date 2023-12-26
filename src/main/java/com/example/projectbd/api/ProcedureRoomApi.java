package com.example.projectbd.api;

import com.example.projectbd.api.model.request.ProcedureRequest;
import com.example.projectbd.api.model.request.ProcedureRoomRequest;
import com.example.projectbd.api.model.response.ProcedureRoomResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ProcedureRoomApi {
    @GetMapping("/procedureRooms")
    ResponseEntity<List<ProcedureRoomResponse>> getAllProcedureRooms(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size
    );

    @GetMapping("/procedureRooms/{procedureRoomId}")
    ResponseEntity<ProcedureRoomResponse> getProcedureRoom(
            @PathVariable("procedureRoomId")
            Integer procedureRoomId
    );
    @PostMapping("/procedureRooms")
    ResponseEntity<ProcedureRoomResponse> addProcedureRoom(
            @RequestBody
            ProcedureRoomRequest procedureRoom
    );

    @PutMapping("/procedureRooms/{procedureRoomId}")
    ResponseEntity<ProcedureRoomResponse> updateProcedureRoom(
            @PathVariable("procedureRoomId")
            Integer procedureRoomId,

            @RequestBody
            ProcedureRoomRequest procedureRoom
    );

    @DeleteMapping("/procedureRooms/{procedureRoomId}")
    ResponseEntity<Void> deleteProcedureRoom(
            @PathVariable("procedureRoomId")
            Integer procedureRoomId
    );
}
