package com.g35.reto5.dbo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class MessageDbo {

    private int idMessage;

    private String messageText;
}
