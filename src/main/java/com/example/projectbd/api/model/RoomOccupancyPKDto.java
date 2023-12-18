package com.example.projectbd.api.model;

import lombok.*;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoomOccupancyPKDto {
    private ClientDto client;

    private  LivingRoomDto livingRoom;
}
