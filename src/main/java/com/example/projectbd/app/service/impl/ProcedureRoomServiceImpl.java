package com.example.projectbd.app.service.impl;

import com.example.projectbd.app.exception.NotFoundException;
import com.example.projectbd.app.service.ProcedureRoomService;
import com.example.projectbd.item.ProcedureRoomRepository;
import com.example.projectbd.item.model.ProcedureRoomItem;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProcedureRoomServiceImpl implements ProcedureRoomService {

    private final ProcedureRoomRepository procedureRoomRepository;

    @Override
    public List<ProcedureRoomItem> getAllProcedureRooms(PageRequest pageRequest) {
        return procedureRoomRepository.findAll(pageRequest).getContent();
    }

    @Override
    public ProcedureRoomItem getProcedureRoom(Integer procedureRoomId) {
        return procedureRoomRepository.findById(procedureRoomId).orElseThrow(()-> new NotFoundException(("ProcedureRoom with this id not found")));
    }

    @Override
    public ProcedureRoomItem createProcedureRoom(ProcedureRoomItem procedureRoomItem) {
        return saveProcedureRoom(procedureRoomItem);
    }

    @Override
    public ProcedureRoomItem saveProcedureRoom(ProcedureRoomItem currentProcedureRoom) {
        return procedureRoomRepository.saveAndFlush(currentProcedureRoom);
    }

    @Override
    public void deleteProcedureRoom(Integer procedureRoomId) {
        procedureRoomRepository.deleteById(procedureRoomId);
    }
}
