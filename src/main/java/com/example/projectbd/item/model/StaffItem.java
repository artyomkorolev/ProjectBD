package com.example.projectbd.item.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "staff")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StaffItem {
    @Id
    @Generated
    private Integer id;
    private  String phone_number;
    private String full_name;


    @ManyToOne
    private ProcedureItem procedure;
}
