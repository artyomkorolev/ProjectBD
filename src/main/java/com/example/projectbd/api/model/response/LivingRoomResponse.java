package com.example.projectbd.api.model.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LivingRoomResponse {
    private  Integer id;
    private int number;
    private int price;
    private boolean status;
}
