package com.challenge.carpooling.controller;

import com.challenge.carpooling.entity.Car;
import com.challenge.carpooling.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    @Autowired
    CarService carService;

    @PutMapping("/")
    public List<Car> createCars(@RequestBody List<Integer> seats) {

        return carService.createCars(seats);
    }

}
