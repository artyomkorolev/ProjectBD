package com.example.projectbd.item;

import com.example.projectbd.item.model.RoomOccupancyItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomOccupancyRepository  extends JpaRepository<RoomOccupancyItem,Integer> {

}
