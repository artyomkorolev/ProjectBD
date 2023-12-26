package com.example.projectbd.api.model.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LivingRoomRequest {
    private int number;
    private int price;
    private boolean status;
}
