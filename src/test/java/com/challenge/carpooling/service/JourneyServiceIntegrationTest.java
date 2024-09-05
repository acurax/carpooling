package com.challenge.carpooling.service;

import com.challenge.carpooling.IntegrationTestContainer;
import com.challenge.carpooling.bean.JourneyStatus;
import com.challenge.carpooling.repository.CarRepository;
import com.challenge.carpooling.repository.JourneyRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;


@SpringBootTest
@Testcontainers
public class JourneyServiceIntegrationTest extends IntegrationTestContainer {

    @Autowired
    CarRepository carRepository;

    @Autowired
    CarService carService;

    @Autowired
    JourneyRepository journeyRepository;

    @Autowired
    JourneyService journeyService;

    @BeforeEach
    void cleanDb() {

        carRepository.deleteAll();
        journeyRepository.deleteAll();
    }

    @Test
    void testAvailableJourney() {
        JourneyStatus journeyStatus = journeyService.requestNewJourney(123, 4);
        Assertions.assertEquals(JourneyStatus.ON_RIDE, journeyStatus);
    }



}
