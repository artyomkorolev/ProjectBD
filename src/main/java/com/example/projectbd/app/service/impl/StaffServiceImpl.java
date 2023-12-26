package com.example.projectbd.app.service.impl;

import com.example.projectbd.app.exception.NotFoundException;
import com.example.projectbd.app.service.StaffService;
import com.example.projectbd.item.StaffRepository;
import com.example.projectbd.item.model.StaffItem;
import com.example.projectbd.specifications.ClientSpecifications;
import com.example.projectbd.specifications.StaffSpecifications;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class StaffServiceImpl implements StaffService {

    private final StaffRepository staffRepository;


    @Override
    public List<StaffItem> getAllStaff(PageRequest pageRequest) {
        return staffRepository.findAll(pageRequest).getContent();
    }

    @Override
    public List<StaffItem> getAllStaff(String fullName, PageRequest pageRequest) {
        return staffRepository.findAll(Specification.where(StaffSpecifications.hasFullName(fullName)), pageRequest).getContent();
    }

    @Override
    public StaffItem getStaff(Integer staffId) {
        return staffRepository.findById(staffId).orElseThrow(()-> new NotFoundException(("Staff with this id not found")));
    }

    @Override
    public StaffItem createStaff(StaffItem staffItem) {
        return saveStaff(staffItem);
    }

    @Override
    public StaffItem saveStaff(StaffItem currentStaff) {
        return staffRepository.saveAndFlush(currentStaff);
    }

    @Override
    public void deleteStaff(Integer staffId) {
        staffRepository.deleteById(staffId);
    }
}
