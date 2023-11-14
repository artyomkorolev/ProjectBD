package com.example.projectbd.api.model;

import lombok.*;
import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProcedureRoomDto {
    private Integer id;
    private String name;
    private int caparity;
}
