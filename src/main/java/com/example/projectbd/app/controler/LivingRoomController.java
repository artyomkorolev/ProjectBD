package com.example.projectbd.app.controler;

import com.example.projectbd.api.LivingRoomApi;

import com.example.projectbd.api.model.request.LivingRoomRequest;
import com.example.projectbd.api.model.response.LivingRoomResponse;
import com.example.projectbd.app.mapper.LivingRoomMapper;
import com.example.projectbd.app.service.LivingRoomService;

import com.example.projectbd.item.model.LivingRoomItem;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LivingRoomController implements LivingRoomApi {


    private final LivingRoomService livingRoomService;
    private final LivingRoomMapper livingRoomMapper;


    @Override
    public ResponseEntity<List<LivingRoomResponse>> getAllLivingRooms(int page, int size) {
        List<LivingRoomItem> allLivingRooms = livingRoomService.getAllLivingRooms(PageRequest.of(page, size));
        return ResponseEntity.ok(
                livingRoomMapper.mapToDto(allLivingRooms));
    }

    @Override
    public ResponseEntity<List<LivingRoomResponse>> getAllLivingRoomsFilter(boolean param, int page, int size) {
        List<LivingRoomItem> allLivingRooms = livingRoomService.getAllLivingRooms(param, PageRequest.of(page, size));
        return ResponseEntity.ok(
                livingRoomMapper.mapToDto(allLivingRooms));
    }


    @Override
    public ResponseEntity<LivingRoomResponse> getLivingRoom(Integer livingRoomId) {
        LivingRoomItem livingRoom = livingRoomService.getLivingRoom(livingRoomId);
        return ResponseEntity.ok(
                livingRoomMapper.mapToDto(livingRoom));
    }

    @Override
    public ResponseEntity<LivingRoomResponse> addLivingRoom(LivingRoomRequest livingRoom) {
        LivingRoomItem livingRoomItem = livingRoomMapper.mapRequestToItem(livingRoom);
        LivingRoomItem createdLivingRoom = livingRoomService.createLivingRoom(livingRoomItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                livingRoomMapper.mapToDto(createdLivingRoom));
    }

    @Override
    public ResponseEntity<LivingRoomResponse> updateLivingRoom(Integer livingRoomId, LivingRoomRequest livingRoom) {
        LivingRoomItem livingRoomItem = livingRoomMapper.mapRequestToItem(livingRoom);
        LivingRoomItem currentLivingRoom = livingRoomService.getLivingRoom(livingRoomId);
        currentLivingRoom.setNumber(livingRoomItem.getNumber());
        currentLivingRoom.setPrice(livingRoomItem.getPrice());
        currentLivingRoom.setStatus(livingRoomItem.isStatus());

        LivingRoomItem updatedLivingRoom = livingRoomService.saveLivingRoom(currentLivingRoom);
        return ResponseEntity.ok(
                livingRoomMapper.mapToDto(updatedLivingRoom));
    }

    @Override
    public ResponseEntity<Void> deleteLivingRoom(Integer livingRoomId) {
        livingRoomService.deleteLivingRoom(livingRoomId);
        return ResponseEntity.ok().build();
    }
}
