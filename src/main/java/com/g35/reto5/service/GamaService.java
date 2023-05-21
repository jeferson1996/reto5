package com.g35.reto5.service;



import com.g35.reto5.dbo.GamaDbo;
import com.g35.reto5.model.GamaModel;
import com.g35.reto5.repository.GamaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GamaService {

    @Autowired
    GamaRepository gamaRepository;

    public List<GamaModel> obtener() {
        return gamaRepository.findAll();

    }

    public void crear(GamaModel gama) {
        if (!gamaRepository.existsById(gama.getIdGama())) {
            gamaRepository.save(gama);
        }

    }

    public void eliminar(int id) {
        gamaRepository.deleteById(id);
    }


    public void actualizar(GamaDbo gamaDbo) {
        if (gamaRepository.existsById(gamaDbo.getIdGama())) {
            GamaModel gama = gamaRepository.findById(gamaDbo.getIdGama()).get();
            gama.setName(gamaDbo.getName());
            gama.setDescription(gamaDbo.getDescription());
            gamaRepository.save(gama);

        }

    }
}