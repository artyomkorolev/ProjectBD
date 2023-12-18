package com.example.projectbd.api.model;

import com.example.projectbd.item.model.StaffItem;
import lombok.*;

import java.util.List;
import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProcedureDto {
    private Integer id;
    private String name;
    private StaffDto staffDto;
    //private int duration;
}
