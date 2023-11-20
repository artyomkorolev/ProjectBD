package com.example.projectbd.app.controler;

import com.example.projectbd.api.ProcedureRoomApi;
import com.example.projectbd.api.model.ProcedureRoomDto;
import com.example.projectbd.app.mapper.ProcedureRoomMapper;
import com.example.projectbd.app.service.ProcedureRoomService;
import com.example.projectbd.item.model.ProcedureRoomItem;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequiredArgsConstructor
public class ProcedureRoomController implements ProcedureRoomApi {

    private  final ProcedureRoomService procedureRoomService;

    @Override
    public ResponseEntity<List<ProcedureRoomDto>> getAllProcedureRooms() {
        List<ProcedureRoomItem> allProcedureRooms = procedureRoomService.getAllProcedureRooms();
        return ResponseEntity.ok(ProcedureRoomMapper.INSTANCE.toDto(allProcedureRooms));
    }

    @Override
    public ResponseEntity<ProcedureRoomDto> getProcedureRoom(Integer procedureroomId) {
        ProcedureRoomItem procedureRoom =procedureRoomService.getProcedureRoom(procedureroomId);
        return ResponseEntity.ok(ProcedureRoomMapper.INSTANCE.toDto(procedureRoom));
    }

    @Override
    public ResponseEntity<ProcedureRoomDto> addProcedureRoom(ProcedureRoomDto procedureroom) {

        ProcedureRoomItem procedureRoomItem = ProcedureRoomMapper.INSTANCE.mapToItem(procedureroom);

        ProcedureRoomItem createdProcedureRoom = procedureRoomService.createProcedureRoom(procedureRoomItem);

        return ResponseEntity.status(HttpStatus.CREATED).body(ProcedureRoomMapper.INSTANCE.toDto(createdProcedureRoom));
    }

    @Override
    public ResponseEntity<ProcedureRoomDto> updateProcedureRoom(Integer procedureroomId, ProcedureRoomDto procedureroom) {
        ProcedureRoomItem currentProcedureRoom = procedureRoomService.getProcedureRoom(procedureroomId);
        currentProcedureRoom.setCaparity(procedureroom.getCaparity());
        currentProcedureRoom.setId(procedureroom.getId());
        currentProcedureRoom.setName(procedureroom.getName());

        ProcedureRoomItem updatedProcedureRoom = procedureRoomService.saveProcedureRoom(currentProcedureRoom);
        return ResponseEntity.ok(ProcedureRoomMapper.INSTANCE.toDto(updatedProcedureRoom));
    }

    @Override
    public ResponseEntity<Void> deleteProcedureRoom(Integer procedureroomId) {
        procedureRoomService.deleteProcedureRoom(procedureroomId);
        return ResponseEntity.ok().build();
    }
}
