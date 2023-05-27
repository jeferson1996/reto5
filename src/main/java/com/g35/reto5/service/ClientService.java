package com.g35.reto5.service;




import com.g35.reto5.dbo.ClientDbo;
import com.g35.reto5.dbo.ReportClientDbo;
import com.g35.reto5.model.ClientModel;
import com.g35.reto5.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;


@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public List<ClientModel> obtener() {
        return clientRepository.findAll();

    }

    public void crear(ClientModel client) {
        if (!clientRepository.existsById(client.getIdClient())) {
            clientRepository.save(client);
        }

    }

    public void eliminar(int id) {
        clientRepository.deleteById(id);
    }

    public void actualizar(ClientDbo clientDbo) {
        if (clientRepository.existsById(clientDbo.getIdClient())) {
            ClientModel client = clientRepository.findById(clientDbo.getIdClient()).get();
            client.setEmail(clientDbo.getEmail());
            client.setPassword(clientDbo.getPassword());
            client.setName(clientDbo.getName());
            client.setAge(clientDbo.getAge());
            clientRepository.save(client);
        }
    }


    public Optional<ClientModel> obtenerPorId(int id) {
        return clientRepository.findById(id);
    }

    public List<ReportClientDbo> reportClients() {
        List<ReportClientDbo> listReportClient = new LinkedList<>();
        List<ClientModel> listClient = clientRepository.findClientByStatusCompleted();
        for (ClientModel client : listClient) {
            int totalReservation = client.getReservations().size();
            listReportClient.add(new ReportClientDbo(totalReservation, client));
        }
        return listReportClient;

    }


}
