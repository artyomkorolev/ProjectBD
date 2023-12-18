package com.example.projectbd.app.controler;

import com.example.projectbd.api.StaffApi;
import com.example.projectbd.api.model.StaffDto;
import com.example.projectbd.app.mapper.StaffMapper;
import com.example.projectbd.app.service.StaffService;
import com.example.projectbd.item.model.StaffItem;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequiredArgsConstructor
public class StaffController implements StaffApi {
    private final StaffService staffService;



    @Override
    public ResponseEntity<List<StaffDto>> getAllStaff() {
        List<StaffItem> allStaff = staffService.getAllStaff();
        List<StaffDto> staffDtos = StaffMapper.INSTANCE.toDto(allStaff);

        return ResponseEntity.ok(staffDtos);
    }
}
