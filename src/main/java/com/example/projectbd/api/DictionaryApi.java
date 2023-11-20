package com.example.projectbd.api;

import com.example.projectbd.api.model.StaffDto;
import com.example.projectbd.api.model.ProcedureRoomDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface DictionaryApi {


    @GetMapping("/staff")
    ResponseEntity<List<StaffDto>> getAllStaff();

}
