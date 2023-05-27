package com.g35.reto5.dbo;

import com.g35.reto5.model.ClientModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportClientDbo {
    public Integer total;
    private ClientModel client;
}
