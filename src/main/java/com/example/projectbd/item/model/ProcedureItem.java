package com.example.projectbd.item.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;
import java.util.UUID;
import java.util.List;

@Entity
@Table(name = "procedure")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProcedureItem {
    @Id
    @Generated
    private  Integer id;
    private String name;
    private int duration;


    @OneToMany(mappedBy = "procedure")
    private List<StaffItem> staffItems;

    @ManyToMany
    @JoinTable(name = "client_procedure",
        joinColumns = { @JoinColumn(name = "procedure_id") },
        inverseJoinColumns = { @JoinColumn(name = "client_id")} )
    private List<ClientItem> clientItems;

    @OneToMany(mappedBy = "procedureProcedureRoomPK.procedureItem",fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    List<ProcedureProcedureRoomItem> procedureProcedureRoomItems;

}
