package com.example.projectbd.item.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;

@Entity
@Table(name = "procedure_procedure_room")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProcedureProcedureRoomItem {
    @EmbeddedId
    private ProcedureProcedureRoomPK procedureProcedureRoomPK;

    private Time startProcedure;

    private Time endProcedure;
}
