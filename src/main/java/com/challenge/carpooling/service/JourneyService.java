package com.challenge.carpooling.service;

import com.challenge.carpooling.bean.JourneyStatus;
import com.challenge.carpooling.repository.CarRepository;
import com.challenge.carpooling.repository.JourneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JourneyService {

    @Autowired
    CarRepository carRepository;

    @Autowired
    JourneyRepository journeyRepository;

    public JourneyStatus requestNewJourney(int userId, int passengers) {

        // Existe el User ID?

        // Existe un ride de ese USER ID?

        // Existe un car disponible para el raid? asientos suficientes, disponibilidadd de coche, etc

        // Si existe todo, asignas car al user, y creas el journey y le pones on ride

        // Si no existe coche lo pones en wait

        return JourneyStatus.WAITING;
    }
}
