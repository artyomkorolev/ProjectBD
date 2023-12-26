package com.example.projectbd.api;

import com.example.projectbd.api.model.request.LivingRoomRequest;
import com.example.projectbd.api.model.response.LivingRoomResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface LivingRoomApi {
    @GetMapping("/livingRooms")
    ResponseEntity<List<LivingRoomResponse>> getAllLivingRooms(
        @RequestParam(required = false, defaultValue = "0") int page,
        @RequestParam(required = false, defaultValue = "10") int size
    );

    @GetMapping("/livingRoom/find")
    ResponseEntity<List<LivingRoomResponse>> getAllLivingRoomsFilter(
            @RequestParam(required = false) boolean param,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size
    );

    @GetMapping("/livingRooms/{livingRoomId}")
    ResponseEntity<LivingRoomResponse> getLivingRoom(
            @PathVariable("livingRoomId")
            Integer livingRoomId
    );

    @PostMapping("/livingRooms")
    ResponseEntity<LivingRoomResponse> addLivingRoom(
            @RequestBody
            LivingRoomRequest livingRoom
    );

    @PutMapping("/livingRooms/{livingRoomId}")
    ResponseEntity<LivingRoomResponse> updateLivingRoom(
            @PathVariable("livingRoomId")
            Integer livingRoomId,

            @RequestBody
            LivingRoomRequest livingRoom
    );

    @DeleteMapping("/livingRooms/{livingRoomId}")
    ResponseEntity<Void> deleteLivingRoom(
            @PathVariable("livingRoomId")
            Integer livingRoomId
    );
}
