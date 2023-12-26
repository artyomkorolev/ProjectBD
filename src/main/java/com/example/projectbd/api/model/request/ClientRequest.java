package com.example.projectbd.api.model.request;

import com.example.projectbd.api.model.response.LivingRoomResponse;
import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientRequest {
    private String fullName;
    private String phoneNumber;
    private String address;

    private Integer livingRoomId;

}
