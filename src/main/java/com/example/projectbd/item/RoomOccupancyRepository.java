package com.example.projectbd.item;

import com.example.projectbd.item.model.ClientProcedureItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomOccupancyRepository  extends JpaRepository<ClientProcedureItem,Integer> {

}
