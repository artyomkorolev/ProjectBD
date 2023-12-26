package com.example.projectbd.app.service.impl;

import com.example.projectbd.app.exception.NotFoundException;
import com.example.projectbd.app.service.LivingRoomService;
import com.example.projectbd.item.LivingRoomReposiry;
import com.example.projectbd.item.model.LivingRoomItem;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class LivingRoomServiceImpl implements LivingRoomService {

    private final LivingRoomReposiry livingRoomRepository;

    @Override
    public List<LivingRoomItem> getAllLivingRooms(PageRequest pageRequest) {
        return livingRoomRepository.findAll(pageRequest).getContent();
    }

    @Override
    public LivingRoomItem getLivingRoom(Integer livingRoomId) {
        return livingRoomRepository.findById(livingRoomId).orElseThrow(() -> new NotFoundException(("LivingRoom with this id not found")));
    }

    @Override
    public LivingRoomItem createLivingRoom(LivingRoomItem livingRoomItem) {
        return saveLivingRoom(livingRoomItem);
    }

    @Override
    public LivingRoomItem saveLivingRoom(LivingRoomItem currentLivingRoom) {
        return livingRoomRepository.saveAndFlush(currentLivingRoom);
    }

    @Override
    public void deleteLivingRoom(Integer livingRoomId) {
        livingRoomRepository.deleteById(livingRoomId);
    }
}
