package com.challenge.carpooling.service;

import com.challenge.carpooling.entity.Car;
import com.challenge.carpooling.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {

    @Autowired
    CarRepository carRepository;

    public List<Car> createCars(List<Integer> seats) {
        List<Car> validSeatsCar = seats.stream()
                .filter(seat -> (seat > 3 && seat < 7))
                .map(seat -> new Car(0, seat))
                .collect(Collectors.toList());

        List<Car> cars = carRepository.saveAll(validSeatsCar);
        return cars;
    }

}
