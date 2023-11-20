package com.example.projectbd.item;

import com.example.projectbd.item.model.ProcedureRoomItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcedureRoomRepository extends JpaRepository<ProcedureRoomItem,Integer> {

}
