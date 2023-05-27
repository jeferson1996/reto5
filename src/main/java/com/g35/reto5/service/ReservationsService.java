package com.g35.reto5.service;


import com.g35.reto5.dbo.ReportDbo;
import com.g35.reto5.dbo.ReservationsDbo;
import com.g35.reto5.model.ReservationsModel;
import com.g35.reto5.repository.ReservationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;


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

    public Optional<ReservationsModel> obtenerPorId(int id) {
        return reservationsRepository.findById(id);
    }

    public List<ReservationsModel> reportDate(String fechainicio, String fechafin) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd");
        Date fechainicioDate = format.parse(fechainicio);
        Date fechafinDate = format.parse(fechafin);
        if(fechafinDate.after(fechainicioDate)){
            System.out.println(fechainicioDate + "-----" + fechafinDate);
            return reservationsRepository.findByStartDateBetween(fechainicioDate,fechafinDate);
        }
        return null;

    }
    public ReportDbo reportStatus() {
        Integer cantidadCompletados =  reservationsRepository.countByStatus("completed");
        Integer cantidadCancelados =  reservationsRepository.countByStatus("cancelled");
        ReportDbo rta = new ReportDbo(cantidadCompletados,cantidadCancelados);
        return rta;

    }



}
