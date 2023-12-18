package com.example.projectbd.app.service.impl;

import com.example.projectbd.app.service.RoomOccupancyService;
import com.example.projectbd.item.RoomOccupancyRepository;
import com.example.projectbd.item.model.RoomOccupancyItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class RoomOccupancyServiceImpl implements RoomOccupancyService {

    private final RoomOccupancyRepository roomOccupancyRepository;

    @Override
    public List<RoomOccupancyItem> getAllRoomOccupancys() {
        return roomOccupancyRepository.findAll();
    }

    @Override
    public RoomOccupancyItem createRoomOccupancy(RoomOccupancyItem roomOccupancyItem) {
        return saveRoomOccupancy(roomOccupancyItem);
    }

    @Override
    public RoomOccupancyItem saveRoomOccupancy(RoomOccupancyItem currentRoomOccupancy) {
        return roomOccupancyRepository.saveAndFlush(currentRoomOccupancy);
    }

    @Override
    public void deleteRoomOccupancy(RoomOccupancyItem roomOccupancyId) {
        roomOccupancyRepository.delete(roomOccupancyId);
    }
}
