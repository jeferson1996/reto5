package com.g35.reto5.repository;



import com.g35.reto5.model.ReservationsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationsRepository extends JpaRepository<ReservationsModel,Integer> {


}
