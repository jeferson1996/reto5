package com.g35.reto4.service;




import com.g35.reto4.dbo.ClientDbo;
import com.g35.reto4.model.ClientModel;
import com.g35.reto4.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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


}
