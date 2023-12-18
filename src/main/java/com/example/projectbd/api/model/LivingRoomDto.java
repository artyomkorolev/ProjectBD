package com.example.projectbd.api.model;

import lombok.*;

import java.util.List;
import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LivingRoomDto {
    private Integer id;
    private int number;
    private int floor;
    private String type;

    //private List<RoomOccupancyDto> roomOccupancyDtos;
}
