package com.g35.reto5.controller;


import com.g35.reto5.dbo.ClientDbo;

import com.g35.reto5.model.ClientModel;
import com.g35.reto5.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Client")
@CrossOrigin(value = "*")
public class ClientController {


    @Autowired
    ClientService clientService;


    @GetMapping("/all")
    public List<ClientModel> obtener() {
        return clientService.obtener();
    }

    @GetMapping("/{id}")
    public Optional<ClientModel> obtenerPorId(@PathVariable int id) {
        return clientService.obtenerPorId(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void crear(@RequestBody ClientModel client) {
        clientService.crear(client);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable int id) {
        clientService.eliminar(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void actualizar(@RequestBody ClientDbo clientDbo) {
        clientService.actualizar(clientDbo);

    }
}

