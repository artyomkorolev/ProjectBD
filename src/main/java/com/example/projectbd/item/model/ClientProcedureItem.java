package com.example.projectbd.item.model;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "client_proc")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientProcedureItem {
    @EmbeddedId
    private ClientProcedurePK pk;
    private long count;
}
