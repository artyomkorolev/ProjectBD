package com.example.projectbd.item.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Generated;

import java.util.List;
import java.util.UUID;
@Entity
@Table(name = "living_room")
@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LivingRoomItem {
    @Id
    @Generated
    private  Integer id;
    private int number;
    private int floor;
    private String type;

    @OneToMany(mappedBy = "roomOccupancyPK.livingRoomItem",fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    List<RoomOccupancyItem> roomOccupancyItems;
}
