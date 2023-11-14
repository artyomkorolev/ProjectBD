package com.example.projectbd.api.model;

import lombok.*;

import java.util.Date;
import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoomOccupancyDto {
    private Integer id;

    private Date startOccupancy;

    private  Date endOccupancy;

    private ClientDto clientDto;

    private  LivingRoomDto livingRoomDto;
}
