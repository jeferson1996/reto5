package com.g35.reto5.service;


import com.g35.reto5.dbo.CarDbo;
import com.g35.reto5.model.CarModel;
import com.g35.reto5.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CarService {

    @Autowired
    CarRepository carRepository;

    public List<CarModel> obtener() {
        return carRepository.findAll();

    }

    public void crear(CarModel car) {
        if (!carRepository.existsById(car.getIdCar())) {
            carRepository.save(car);
        }

    }

    public void eliminar(int id) {
        carRepository.deleteById(id);
    }


    public void actualizar(CarDbo carDbo) {
        if (carRepository.existsById(carDbo.getIdCar())) {
            CarModel car = carRepository.findById(carDbo.getIdCar()).get();
            car.setName(carDbo.getName());
            car.setBrand(carDbo.getBrand());
            car.setYear(carDbo.getYear());
            car.setDescription(carDbo.getDescription());
            carRepository.save(car);
        }

    }


    public Optional<CarModel> obtenerPorId(int id) {
        return carRepository.findById(id);
    }
}