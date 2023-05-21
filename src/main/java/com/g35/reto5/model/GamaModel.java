package com.g35.reto5.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "gama")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GamaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idGama;
    @Column(length = 45)
    private String name;
    @Column(length = 250)
    private String description;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "gama")
    private List<CarModel> cars;

}
