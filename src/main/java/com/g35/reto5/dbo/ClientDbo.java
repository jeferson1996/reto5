package com.g35.reto5.dbo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDbo {

    private int idClient;

    private String email;

    private String password;

    private String name;

    private Byte age;

}
