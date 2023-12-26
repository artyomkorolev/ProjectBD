package com.example.projectbd.item;

import com.example.projectbd.item.model.ClientItem;
import com.example.projectbd.item.model.ClientProcedureItem;
import com.example.projectbd.item.model.ClientProcedurePK;
import com.example.projectbd.item.model.ProcedureItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientProcedureRepository extends JpaRepository<ClientProcedureItem, ClientProcedurePK> {
    List<ClientProcedureItem> findByPkClient (ClientItem client);
    List<ClientProcedureItem> findByPkProcedure (ProcedureItem procedure);
}
