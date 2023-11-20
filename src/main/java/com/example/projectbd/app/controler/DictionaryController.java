package com.example.projectbd.app.controler;

import com.example.projectbd.api.DictionaryApi;
import com.example.projectbd.api.model.ProcedureRoomDto;
import com.example.projectbd.api.model.StaffDto;
import com.example.projectbd.app.mapper.StaffMapper;
import com.example.projectbd.app.service.DictionaryService;
import com.example.projectbd.item.model.StaffItem;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequiredArgsConstructor
public class DictionaryController implements DictionaryApi {
    private final DictionaryService dictionaryService;



    @Override
    public ResponseEntity<List<StaffDto>> getAllStaff() {
        List<StaffItem> allStaff = dictionaryService.getAllStaff();
        List<StaffDto> staffDtos = StaffMapper.INSTANCE.toDto(allStaff);

        return ResponseEntity.ok(staffDtos);
    }
}
