package com.example.projectbd.api;

import com.example.projectbd.api.model.ClientDto;
import com.example.projectbd.api.model.LivingRoomDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public interface LivingRoomApi {
    @GetMapping("/livingrooms")
    ResponseEntity<List<LivingRoomDto>> getAllLivingRooms();

    @GetMapping("/livingrooms/{livingroomId}")
    ResponseEntity<LivingRoomDto> getLivingRoom(
            @PathVariable("livingroomId")
            Integer livingroomId
    );

    @PostMapping("/livingrooms")
    ResponseEntity<LivingRoomDto> addLivingRoom(
            @RequestBody
            LivingRoomDto livingroom
    );

    @PutMapping("/livingrooms/{livingroomId}")
    ResponseEntity<LivingRoomDto> updateLivingRoom(
            @PathVariable("livingroomId")
            Integer livingroomId,

            @RequestBody
            LivingRoomDto livingroom
    );

    @DeleteMapping("/livingrooms/{livingroomId}")
    ResponseEntity<Void> deleteLivingRoom(
            @PathVariable("livingroomId")
            Integer livingroomId
    );
}
