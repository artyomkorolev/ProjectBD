package com.example.projectbd.api;

import com.example.projectbd.api.model.LivingRoomDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

public interface LivingRoomApi {
    @GetMapping("/livingrooms")
    ResponseEntity<List<LivingRoomDto>> getAllLivingRooms();

    @GetMapping("/livingrooms/{livingroomId}")
    ResponseEntity<LivingRoomDto> getLivingRoom(
            @PathVariable("livingroomId")
            Integer clientId
    );
}
