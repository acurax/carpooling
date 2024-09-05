package com.challenge.carpooling.service;

import com.challenge.carpooling.entity.Car;
import com.challenge.carpooling.repository.CarRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = CarService.class)
public class CarServiceTest {

    @Autowired
    CarService carService;

    @MockBean
    CarRepository carRepository;

    @Test
    void createCarsTest() {
        ArrayList<Car> savedCars = new ArrayList<>();
        savedCars.addAll(List.of(new Car(1,4),new Car(1,5),new Car(1,6)));
        Mockito.when(carRepository.saveAll(ArgumentMatchers.anyList())).thenReturn(savedCars);
        List<Car> cars = carService.createCars(List.of(4,5,6,7,8,3));
        Assertions.assertNotNull(cars);
        Assertions.assertEquals(3, cars.size());
    }

}
