package com.challenge.carpooling.service;

import com.challenge.carpooling.IntegrationTestContainer;
import com.challenge.carpooling.repository.CarRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;


@SpringBootTest
@Testcontainers
public class CarServiceIntegrationTest extends IntegrationTestContainer {

    @Autowired
    CarRepository carRepository;

    @Autowired
    CarService carService;

    @BeforeEach
    void cleanDb() {
        carRepository.deleteAll();
    }

    @Test
    void testValidListOfSeats() {
        carService.createCars(List.of(4,5,6));
        Assertions.assertEquals(3,carRepository.findAll().size());
    }

    @Test
    void testValidAndInvalidListOfSeats() {
        carService.createCars(List.of(4,5,6,3,2,1));
        Assertions.assertEquals(3,carRepository.findAll().size());
    }

    @Test
    void testInvalidListOfSeats() {
        carService.createCars(List.of(2,1));
        Assertions.assertEquals(0,carRepository.findAll().size());
    }


}
