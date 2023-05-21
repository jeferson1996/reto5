package com.g35.reto4.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "client")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id")
    private int idClient;

    @Column(length = 45)
    private String email;

    @Column(length = 45)
    private String password;

    @Column(length = 250)
    private String name;

    @Column(length = 3)
    private Byte age;



    @OneToMany(cascade = CascadeType.MERGE , mappedBy = "client")
    private List <MessageModel> messages;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "client")
    private List<ReservationsModel> reservations;
}
