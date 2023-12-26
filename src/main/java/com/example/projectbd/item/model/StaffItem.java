package com.example.projectbd.item.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Generated;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "staff")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StaffItem {
    @Id
    @Generated
    private Integer id;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "phone_number")
    private  String phoneNumber;

}
