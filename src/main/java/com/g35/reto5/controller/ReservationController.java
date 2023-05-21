package com.g35.reto5.controller;


import com.g35.reto5.dbo.ReservationsDbo;
import com.g35.reto5.model.ReservationsModel;
import com.g35.reto5.service.ReservationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Reservation")
public class ReservationController {

    @Autowired
    ReservationsService reservationsService;

    @GetMapping("/all")
    public List<ReservationsModel> obtener() {
        return reservationsService.obtener();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void crear(@RequestBody ReservationsModel reservations) {
        reservationsService.crear(reservations);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        reservationsService.eliminar(id);
    }

    @PutMapping("/update")
    public void actualizar(@RequestBody ReservationsDbo reservationsDbo) {
        reservationsService.actualizar(reservationsDbo);
    }
}


