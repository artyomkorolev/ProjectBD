package com.example.projectbd.item;

import com.example.projectbd.item.model.ClientItem;
import com.example.projectbd.item.model.ProcedureItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProcedureRepository  extends JpaRepository<ProcedureItem,Integer>, JpaSpecificationExecutor<ProcedureItem> {
}
