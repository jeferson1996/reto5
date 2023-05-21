package com.g35.reto4.controller;


import com.g35.reto4.dbo.CarDbo;
import com.g35.reto4.model.CarModel;
import com.g35.reto4.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Car")
public class CarController {


    @Autowired
    CarService carService;

    @GetMapping("/all")
    public List<CarModel> obtener() {
        return carService.obtener();
    }


    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void crear(@RequestBody CarModel car) {
        carService.crear(car);
    }


    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        carService.eliminar(id);
    }

    @PutMapping("/update")
    public void actualizar(@RequestBody CarDbo carDbo) {
        carService.actualizar(carDbo);
    }
}


