package com.example.projectbd.api.model.response;

import com.example.projectbd.item.model.LivingRoomItem;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientResponse {
    private Integer id;
    private String fullName;
    private String phoneNumber;
    private String address;
    private long summa;
    private LivingRoomResponse livingRoom;
}
