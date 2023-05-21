package com.g35.reto5.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "car")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column ( name = "id")
    private int idCar;
    @Column(length = 45)
    private String name;
    @Column(length = 45)
    private String brand;
    @Column(name = "yyear" , length = 5)
    private int year;
    @Column(length = 250)
    private String description;

    @ManyToOne
    @JoinColumn(name = "gama_id", nullable = false)
    @JsonIgnoreProperties ({"cars"})
    private GamaModel gama;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "car")
    @JsonIgnoreProperties({"client", "car"})
    private List <MessageModel> messages;


    @OneToMany(cascade = CascadeType.PERSIST,  mappedBy = "car")
    private List<ReservationsModel> reservations;
}
