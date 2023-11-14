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
@Table(name = "procedure_room")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProcedureRoomItem {
    @Id
    @Generated
    private  Integer id;
    private String name;
    private int caparity;

    @OneToMany(mappedBy = "procedureProcedureRoomPK.procedureRoomItem",fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    List<ProcedureProcedureRoomItem> procedureProcedureRoomItems;
}
