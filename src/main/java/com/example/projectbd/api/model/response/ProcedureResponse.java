package com.example.projectbd.api.model.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProcedureResponse {
    private  Integer id;
    private String name;
    private long price;
    private StaffResponse staff;
    private ProcedureRoomResponse procedureRoom;
}
