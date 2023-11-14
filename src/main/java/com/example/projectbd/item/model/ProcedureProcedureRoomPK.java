package com.example.projectbd.item.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class ProcedureProcedureRoomPK implements Serializable {
    @ManyToOne
    @JoinColumn(name="procedure_id")
    private ProcedureItem procedureItem;
    @ManyToOne
    @JoinColumn(name="procedure_room_id")
    private ProcedureRoomItem procedureRoomItem;
}
