package com.example.projectbd.item.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Generated;

import java.util.List;
import java.util.UUID;
@Entity
@Table(name = "proc_room")
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProcedureRoomItem {
    @Id
    @Generated
    private  Integer id;
    private Integer number;

//    @OneToMany
//    private List<ProcedureItem> procedures;
}
