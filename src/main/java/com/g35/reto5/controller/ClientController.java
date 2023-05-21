package com.g35.reto5.controller;


import com.g35.reto5.dbo.ClientDbo;
import com.g35.reto5.model.ClientModel;
import com.g35.reto5.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Client")
public class ClientController {


    @Autowired
    ClientService clientService;


    @GetMapping("/all")
    public List<ClientModel> obtener() {
        return clientService.obtener();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void crear(@RequestBody ClientModel client) {
        clientService.crear(client);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        clientService.eliminar(id);
    }

    @PutMapping("/update")
    public void actualizar(@RequestBody ClientDbo clientDbo) {
        clientService.actualizar(clientDbo);

    }
}

