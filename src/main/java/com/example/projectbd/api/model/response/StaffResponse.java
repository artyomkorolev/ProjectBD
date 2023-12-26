package com.example.projectbd.api.model.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StaffResponse {
    private Integer id;
    private String fullName;
    private  String phoneNumber;
    private long summa;
}
