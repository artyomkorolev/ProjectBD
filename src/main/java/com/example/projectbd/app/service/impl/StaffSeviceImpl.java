package com.example.projectbd.app.service.impl;

import com.example.projectbd.app.service.StaffService;
import com.example.projectbd.item.StaffRepository;
import com.example.projectbd.item.model.StaffItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class StaffSeviceImpl implements StaffService {

    private final StaffRepository staffRepository;


    @Override
    public List<StaffItem> getAllStaff() {
        return staffRepository.findAll();
    }
}
