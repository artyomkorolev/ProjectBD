package com.example.projectbd.api;

import com.example.projectbd.api.model.ProcedureRoomDto;
import com.example.projectbd.api.model.RoomOccupancyDto;
import com.example.projectbd.api.model.RoomOccupancyPKDto;
import com.example.projectbd.item.model.RoomOccupancyItem;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface RoomOccupancyApi {
    @GetMapping("/roomoccupancys")
    ResponseEntity<List<RoomOccupancyDto>> getAllRoomOccupancys();


    @PostMapping("/roomoccupancys")
    ResponseEntity<RoomOccupancyDto> addRoomOccupancys(
            @RequestBody
            RoomOccupancyDto roomOccupancy
    );

    @DeleteMapping("/roomoccupancys/{roomoccupancyId}")
    ResponseEntity<Void> deleteRoomOccupancy(
            @PathVariable("roomoccupancyId")
            RoomOccupancyItem roomoccupancyId
    );
}
