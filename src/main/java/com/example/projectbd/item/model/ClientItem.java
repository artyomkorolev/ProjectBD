package com.example.projectbd.item.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.Generated;

import java.util.Date;
import java.util.List;
import java.util.UUID;
@Entity
@Table(name = "client")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientItem {
    @Id
    @Generated
    private Integer id;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String address;

    @Formula("(SELECT COALESCE(SUM(p.price * cp.count), 0) " +
            "FROM client_proc cp " +
            "JOIN proc p ON cp.proc_id = p.id " +
            "WHERE cp.client_id = id)")
    private long summa;

    @ManyToOne(fetch = FetchType.LAZY)
    private LivingRoomItem livingRoom;

    @OneToMany(mappedBy = "pk.client",fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<ClientProcedureItem> clientProcedure;
}
