package com.example.projectbd.app.service;

import com.example.projectbd.item.model.ProcedureItem;
import com.example.projectbd.item.model.RoomOccupancyItem;

import java.util.List;

public interface RoomOccupancyService {
    List<RoomOccupancyItem> getAllRoomOccupancys();

    RoomOccupancyItem createRoomOccupancy(RoomOccupancyItem roomOccupancyItem);

    RoomOccupancyItem saveRoomOccupancy(RoomOccupancyItem currentRoomOccupancy);
    void deleteRoomOccupancy(RoomOccupancyItem roomOccupancyId);
}
