package com.example.projectbd.api.model.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StaffRequest {
    private String fullName;
    private  String phoneNumber;
}
