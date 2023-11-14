package com.example.projectbd.api.model;

import lombok.*;

import java.sql.Time;
import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProcedureProcedureRoomDto {
    private Integer id;
    private Time startProcedure;

    private Time endProcedure;
}
