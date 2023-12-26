package com.example.projectbd.app.controler;

import com.example.projectbd.api.ProcedureRoomApi;
import com.example.projectbd.api.model.request.ProcedureRoomRequest;
import com.example.projectbd.api.model.response.ProcedureRoomResponse;
import com.example.projectbd.app.mapper.ProcedureMapper;
import com.example.projectbd.app.mapper.ProcedureRoomMapper;
import com.example.projectbd.app.service.ProcedureRoomService;
import com.example.projectbd.item.model.ProcedureRoomItem;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequiredArgsConstructor
public class ProcedureRoomController implements ProcedureRoomApi {

    private final ProcedureRoomService procedureRoomService;
    private final ProcedureRoomMapper procedureRoomMapper;

    @Override
    public ResponseEntity<List<ProcedureRoomResponse>> getAllProcedureRooms(int page, int size) {
        List<ProcedureRoomItem> allProcedureRooms = procedureRoomService.getAllProcedureRooms(PageRequest.of(page, size));
        return ResponseEntity.ok(procedureRoomMapper.mapToDto(allProcedureRooms));
    }

    @Override
    public ResponseEntity<ProcedureRoomResponse> getProcedureRoom(Integer procedureRoomId) {
        ProcedureRoomItem procedureRoom =procedureRoomService.getProcedureRoom(procedureRoomId);
        return ResponseEntity.ok(procedureRoomMapper.mapToDto(procedureRoom));
    }

    @Override
    public ResponseEntity<ProcedureRoomResponse> addProcedureRoom(ProcedureRoomRequest procedureRoom) {

        ProcedureRoomItem procedureRoomItem = procedureRoomMapper.mapRequestToItem(procedureRoom);

        ProcedureRoomItem createdProcedureRoom = procedureRoomService.createProcedureRoom(procedureRoomItem);

        return ResponseEntity.status(HttpStatus.CREATED).body(procedureRoomMapper.mapToDto(createdProcedureRoom));
    }

    @Override
    public ResponseEntity<ProcedureRoomResponse> updateProcedureRoom(Integer procedureRoomId, ProcedureRoomRequest procedureRoom) {
        ProcedureRoomItem procedureRoomItem = procedureRoomMapper.mapRequestToItem(procedureRoom);
        ProcedureRoomItem currentProcedureRoom = procedureRoomService.getProcedureRoom(procedureRoomId);
        currentProcedureRoom.setNumber(procedureRoomItem.getNumber());
        ProcedureRoomItem updatedProcedureRoom = procedureRoomService.saveProcedureRoom(currentProcedureRoom);
        return ResponseEntity.ok(procedureRoomMapper.mapToDto(updatedProcedureRoom));
    }

    @Override
    public ResponseEntity<Void> deleteProcedureRoom(Integer procedureRoomId) {
        procedureRoomService.deleteProcedureRoom(procedureRoomId);
        return ResponseEntity.ok().build();
    }
}
