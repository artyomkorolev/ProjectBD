package com.example.projectbd.app.service;

import com.example.projectbd.item.model.StaffItem;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface StaffService {
    List<StaffItem> getAllStaff(PageRequest pageRequest);
    List<StaffItem> getAllStaff(String fullName, PageRequest pageRequest);

    StaffItem getStaff(Integer staffId);

    StaffItem createStaff(StaffItem staffItem);

    StaffItem saveStaff(StaffItem currentStaff);

    void deleteStaff(Integer staffId);


}
