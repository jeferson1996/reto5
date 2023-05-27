package com.g35.reto5.controller;


import com.g35.reto5.dbo.ReportClientDbo;
import com.g35.reto5.dbo.ReportDbo;
import com.g35.reto5.dbo.ReservationsDbo;

import com.g35.reto5.model.ReservationsModel;
import com.g35.reto5.service.ClientService;
import com.g35.reto5.service.ReservationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")
public class ReservationController {

    @Autowired
    ReservationsService reservationsService;

    @Autowired
    ClientService clientService;

    @GetMapping("/all")
    public List<ReservationsModel> obtener() {
        return reservationsService.obtener();
    }

    @GetMapping("/{id}")
    public Optional<ReservationsModel> obtenerPorId(@PathVariable int id) {
        return reservationsService.obtenerPorId(id);
    }


    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void crear(@RequestBody ReservationsModel reservations) {
        reservationsService.crear(reservations);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable int id) {
        reservationsService.eliminar(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void actualizar(@RequestBody ReservationsDbo reservationsDbo) {
        reservationsService.actualizar(reservationsDbo);
    }

    @GetMapping("/report-dates/{fechainicio}/{fechafin}")
    public List<ReservationsModel> reportDate(@PathVariable String fechainicio, @PathVariable String fechafin) throws ParseException {
        return reservationsService.reportDate(fechainicio,fechafin);
    }

    @GetMapping("/report-status")
    public ReportDbo reportStatus() {
        return reservationsService.reportStatus();
    }

    @GetMapping("/report-clients")
    public List<ReportClientDbo> reportClients() {
        return clientService.reportClients();
    }


    }





