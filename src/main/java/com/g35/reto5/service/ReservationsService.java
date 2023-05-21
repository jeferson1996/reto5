package com.g35.reto5.service;


import com.g35.reto5.dbo.ReservationsDbo;
import com.g35.reto5.model.ReservationsModel;
import com.g35.reto5.repository.ReservationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReservationsService {

    @Autowired
    ReservationsRepository reservationsRepository;

    public List<ReservationsModel> obtener() {
        return reservationsRepository.findAll();

    }

    public void crear(ReservationsModel reservations) {
        if (!reservationsRepository.existsById(reservations.getIdReservation())) {
            reservationsRepository.save(reservations);
        }

    }

    public void eliminar(int id) {
        reservationsRepository.deleteById(id);
    }

    public void actualizar(ReservationsDbo reservationsDbo) {
        if (reservationsRepository.existsById(reservationsDbo.getIdReservation())) {
            ReservationsModel reservations = reservationsRepository.findById(reservationsDbo.getIdReservation()).get();
            reservations.setStartDate(reservationsDbo.getStartDate());
            reservations.setDevolutionDate(reservationsDbo.getDevolutionDate());
            reservations.setStatus("update");
            reservationsRepository.save(reservations);

        }

    }
}