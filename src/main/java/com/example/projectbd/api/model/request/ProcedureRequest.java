package com.example.projectbd.api.model.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProcedureRequest {
    private String name;
    private long price;

    private Integer staffId;
    private Integer procedureRoomId;
}
