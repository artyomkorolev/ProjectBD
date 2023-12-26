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
public class ClientProcedurePK implements Serializable {
    @ManyToOne
    @JoinColumn(name="proc_id")
    private ProcedureItem procedure;
    @ManyToOne
    @JoinColumn(name="client_id")
    private ClientItem client;
}
