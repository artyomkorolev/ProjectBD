package com.example.projectbd.app.service.impl;

import com.example.projectbd.app.exception.NotFoundException;

import com.example.projectbd.app.service.ProcedureService;
import com.example.projectbd.item.ProcedureRepository;

import com.example.projectbd.item.model.ProcedureItem;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProcedureImpl implements ProcedureService {

    private final ProcedureRepository procedureRepository;

    @Override
    public List<ProcedureItem> getAllProcedures() {
        return procedureRepository.findAll();
    }

    @Override
    public ProcedureItem getProcedure(Integer procedureId) {
        return procedureRepository.findById(procedureId).orElseThrow(()-> new NotFoundException(("Procedure with this id not found")));
    }

    @Override
    public ProcedureItem createProcedure(ProcedureItem procedureItem) {
        return saveProcedure(procedureItem);
    }

    @Override
    public ProcedureItem saveProcedure(ProcedureItem currentProcedure) {
        return procedureRepository.saveAndFlush(currentProcedure);
    }

    @Override
    public void deleteProcedure(Integer procedureId) {
        procedureRepository.deleteById(procedureId);
    }
}