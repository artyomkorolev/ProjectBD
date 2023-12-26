package com.example.projectbd.api.model.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientProcedureResponse {
    private ClientResponse client;
    private ProcedureResponse procedure;
    private long count;
}
