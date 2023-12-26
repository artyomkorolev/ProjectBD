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
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LivingRoomItem {
    @Id
    @Generated
    private  Integer id;
    private int number;
    private int price;
    private boolean status;

    @OneToMany(mappedBy = "livingRoom")
    private List<ClientItem> clients;
}
