package com.g35.reto5.repository;


import com.g35.reto5.model.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<ClientModel,Integer> {

    @Query(value = "SELECT client.*,count(*) AS count_status FROM client\n" +
            "INNER JOIN reservations ON client.id = reservations.client_id\n" +
            "WHERE reservations.status = 'completed'\n" +
            "GROUP BY client.id\n" +
            "ORDER BY count_status DESC", nativeQuery = true)
    List<ClientModel> findClientByStatusCompleted();

}
