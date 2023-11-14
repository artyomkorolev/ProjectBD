package com.example.projectbd.item.model;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "room_occupancy")
@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoomOccupancyItem {
    @EmbeddedId
    private RoomOccupancyPK roomOccupancyPK;

    private Date startOccupancy;

    private  Date endOccupancy;


}
