package com.example.projectbd.item;

import com.example.projectbd.item.model.ProcedureItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcedureRepository  extends JpaRepository<ProcedureItem,Integer> {
}
