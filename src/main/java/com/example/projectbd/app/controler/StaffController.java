package com.example.projectbd.app.controler;

import com.example.projectbd.api.StaffApi;
import com.example.projectbd.api.model.request.StaffRequest;
import com.example.projectbd.api.model.response.StaffResponse;
import com.example.projectbd.app.mapper.StaffMapper;
import com.example.projectbd.app.service.StaffService;
import com.example.projectbd.item.model.StaffItem;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequiredArgsConstructor
public class StaffController implements StaffApi {
    private final StaffService staffService;
    private final StaffMapper staffMapper;

    @Override
    public ResponseEntity<List<StaffResponse>> getAllStaff(int page, int size) {
        List<StaffItem> allStaff = staffService.getAllStaff(PageRequest.of(page, size));
        List<StaffResponse> staffDtos = staffMapper.mapToDto(allStaff);

        return ResponseEntity.ok(staffDtos);
    }

    @Override
    public ResponseEntity<List<StaffResponse>> getAllStaffWithFilter(String fullName, int page, int size) {
        List<StaffItem> allStaff = staffService.getAllStaff(fullName,PageRequest.of(page, size));
        return null;
    }

    @Override
    public ResponseEntity<StaffResponse> getStaff(Integer staffId) {
        StaffItem staffItem = staffService.getStaff(staffId);
        return ResponseEntity.ok(staffMapper.mapToDto(staffItem));
    }

    @Override
    public ResponseEntity<StaffResponse> addStaff(StaffRequest staff) {
        StaffItem staffItem = staffMapper.mapRequestToItem(staff);
        StaffItem createdStaff = staffService.createStaff(staffItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(staffMapper.mapToDto(createdStaff));
    }

    @Override
    public ResponseEntity<StaffResponse> updateStaff(Integer staffId, StaffRequest staff) {
        StaffItem staffItem = staffMapper.mapRequestToItem(staff);
        StaffItem currentStaff = staffService.getStaff(staffId);
        currentStaff.setFullName(staffItem.getFullName());
        currentStaff.setPhoneNumber(staffItem.getPhoneNumber());
        StaffItem updatedStaff = staffService.saveStaff(currentStaff);
        return ResponseEntity.ok(staffMapper.mapToDto(updatedStaff));
    }

    @Override
    public ResponseEntity<Void> deleteStaff(Integer staffId) {
        staffService.deleteStaff(staffId);
        return ResponseEntity.ok().build();
    }
}
