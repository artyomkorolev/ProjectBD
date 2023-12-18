package com.example.projectbd.api.model;

import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientDto {
    private Integer id;
    private String full_name;
    private String gender;
    private Date date_of_birth;
    private  String adress;
    private  String phone_number;

    private List<ProcedureDto> procedures;
    //private  List<RoomOccupancyDto> RoomOccupancyDto;
}
