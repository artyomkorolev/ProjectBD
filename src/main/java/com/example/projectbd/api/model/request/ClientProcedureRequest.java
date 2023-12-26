package com.example.projectbd.api.model.request;
import com.example.projectbd.api.model.response.ClientResponse;
import com.example.projectbd.api.model.response.ProcedureResponse;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientProcedureRequest {
    private int clientId;
    private int procedureId;
    private long count;
}
