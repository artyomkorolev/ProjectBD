package com.example.projectbd.item.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@Builder
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class RoomOccupancyPK implements Serializable {




    @ManyToOne
    @JoinColumn(name="living_room_id")
    private LivingRoomItem livingRoomItem;
    @ManyToOne
    @JoinColumn(name="client_id")
    private ClientItem clientItem;
}
