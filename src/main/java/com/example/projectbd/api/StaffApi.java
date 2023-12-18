package com.example.projectbd.api;

import com.example.projectbd.api.model.StaffDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface StaffApi {


    @GetMapping("/staff")
    ResponseEntity<List<StaffDto>> getAllStaff();

}
