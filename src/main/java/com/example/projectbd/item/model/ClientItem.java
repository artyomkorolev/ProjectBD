package com.example.projectbd.item.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Generated;

import java.util.Date;
import java.util.List;
import java.util.UUID;
@Entity
@Table(name = "client")
@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientItem {
    @Id
    @Generated
    private  Integer id;
    private String full_name;
    private String gender;
    private Date date_of_birth;
    private  String adress;
    private  String phone_number;

    @OneToMany(mappedBy = "roomOccupancyPK.clientItem",fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    List<RoomOccupancyItem> roomOccupancyItems;
}
