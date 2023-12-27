package com.example.projectbd.api;

import com.example.projectbd.api.model.request.StaffRequest;
import com.example.projectbd.api.model.response.StaffResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface StaffApi {

    @GetMapping("/staffs")
    ResponseEntity<List<StaffResponse>> getAllStaff(
        @RequestParam(required = false, defaultValue = "0") int page,
        @RequestParam(required = false, defaultValue = "10") int size
    );

    @GetMapping("/staffs/find")
    ResponseEntity<List<StaffResponse>> getAllStaffWithFilter(
            @RequestParam(required = false) String fullName,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size
    );

    @GetMapping("/staffs/{staffId}")
    ResponseEntity<StaffResponse> getStaff(
            @PathVariable("staffId")
            Integer staffId
    );
    @PostMapping("/staffs")
    ResponseEntity<StaffResponse> addStaff(
            @RequestBody
            StaffRequest staff
    );

    @PutMapping("/staffs/{staffId}")
    ResponseEntity<StaffResponse> updateStaff(
            @PathVariable("staffId")
            Integer staffId,

            @RequestBody
            StaffRequest staff
    );

    @DeleteMapping("/staffs/{staffId}")
    ResponseEntity<Void> deleteStaff(
            @PathVariable("staffId")
            Integer staffId
    );

}
