package com.example.projectbd.app.service;



import com.example.projectbd.item.model.LivingRoomItem;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface LivingRoomService {

    List<LivingRoomItem> getAllLivingRooms(PageRequest pageRequest);

    LivingRoomItem getLivingRoom(Integer livingRoomId);

    LivingRoomItem createLivingRoom(LivingRoomItem livingRoomItem);

    LivingRoomItem saveLivingRoom(LivingRoomItem currentLivingRoom);

    void deleteLivingRoom(Integer livingRoomId);
}
