package com.example.projectbd.item.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Generated;
import java.util.UUID;
import java.util.List;

@Entity
@Table(name = "proc")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProcedureItem {
    @Id
    @Generated
    private  Integer id;
    private String name;
    private long price;

   @OneToOne
   private StaffItem staff;

   @ManyToOne
   @JoinColumn(name="proc_room_id")
   private ProcedureRoomItem procedureRoom;

    @OneToMany(mappedBy = "pk.procedure",fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<ClientProcedureItem> clientProcedure;

}
