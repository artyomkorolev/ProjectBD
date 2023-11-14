package com.example.projectbd.app.controler;

import com.example.projectbd.api.LivingRoomApi;

import com.example.projectbd.api.model.LivingRoomDto;

import com.example.projectbd.app.mapper.ClientMapper;
import com.example.projectbd.app.mapper.LivingRoomMapper;
import com.example.projectbd.app.service.LivingRoomService;

import com.example.projectbd.item.model.ClientItem;
import com.example.projectbd.item.model.LivingRoomItem;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LivingRoomController implements LivingRoomApi {


    private final LivingRoomService livingRoomService;


    @Override
    public ResponseEntity<List<LivingRoomDto>> getAllLivingRooms() {
        List<LivingRoomItem> allLivingRooms = livingRoomService.getAllLivingRooms();
        return ResponseEntity.ok(LivingRoomMapper.INSTANCE.toDto(allLivingRooms));
    }

    @Override
    public ResponseEntity<LivingRoomDto> getLivingRoom(Integer livingroomId) {
        LivingRoomItem livingroom = livingRoomService.getLivingRoom(livingroomId);
        return ResponseEntity.ok(LivingRoomMapper.INSTANCE.toDto(livingroom));
    }

    @Override
    public ResponseEntity<LivingRoomDto> addLivingRoom(LivingRoomDto livingroom) {
        LivingRoomItem livingRoomItem = LivingRoomMapper.INSTANCE.mapToItem(livingroom);
        //clientItem.setId(Integer.randomInteger());
        LivingRoomItem createdLivingRoom = livingRoomService.createLivingRoom(livingRoomItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(LivingRoomMapper.INSTANCE.toDto(createdLivingRoom));
    }

    @Override
    public ResponseEntity<LivingRoomDto> updateLivingRoom(Integer livingroomId, LivingRoomDto livingroom) {
        LivingRoomItem currentLivingRoom = livingRoomService.getLivingRoom(livingroomId);
        currentLivingRoom.setFloor(livingroom.getFloor());
        currentLivingRoom.setType(livingroom.getType());
        currentLivingRoom.setNumber(livingroom.getNumber());


        LivingRoomItem updatedLivingRoom = livingRoomService.saveLivingRoom(currentLivingRoom);
        return ResponseEntity.ok(LivingRoomMapper.INSTANCE.toDto(updatedLivingRoom));
    }

    @Override
    public ResponseEntity<Void> deleteLivingRoom(Integer livingroomId) {
        livingRoomService.deleteLivingRoom(livingroomId);
        return ResponseEntity.ok().build();
    }
}
