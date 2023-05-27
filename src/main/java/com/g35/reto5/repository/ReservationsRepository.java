package com.g35.reto5.repository;



import com.g35.reto5.model.ReservationsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservationsRepository extends JpaRepository<ReservationsModel,Integer> {


    //@Query(value = "SELECT * FROM reto5.reservation where start_date BETWEEN ? AND ?",nativeQuery = true)
    List<ReservationsModel> findByStartDateBetween(Date fechaInicio, Date fechaFinal);

    Integer countByStatus(String status);




}
