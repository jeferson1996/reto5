package com.g35.reto4.dbo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class ReservationsDbo {

    private int idReservation;

    private Date startDate;

    private Date devolutionDate;

    private String status;

}
