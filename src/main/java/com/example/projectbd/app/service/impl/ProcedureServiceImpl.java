package com.example.projectbd.app.service.impl;

import com.example.projectbd.app.exception.NotFoundException;

import com.example.projectbd.app.service.ProcedureService;
import com.example.projectbd.item.ProcedureRepository;

import com.example.projectbd.item.model.ProcedureItem;

import com.example.projectbd.specifications.ProcedureSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProcedureServiceImpl implements ProcedureService {

    private final ProcedureRepository procedureRepository;

    @Override
    public List<ProcedureItem> getAllProcedures(PageRequest pageRequest) {
        return procedureRepository.findAll(pageRequest).getContent();
    }

    @Override
    public List<ProcedureItem> getAllProcedures(String name, PageRequest pageRequest) {
        return procedureRepository.findAll(Specification.where(ProcedureSpecification.hasName(name)), pageRequest).getContent();
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