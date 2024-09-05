package com.challenge.carpooling.controller;

import com.challenge.carpooling.entity.Car;
import com.challenge.carpooling.service.CarService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CarController.class)
public class CarControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CarService carService;

    @Test
    void putCarsTest() throws Exception {

        Mockito.when(carService.createCars(any())).thenReturn(List.of(new Car(1,5)));

        MvcResult mvcResult = mockMvc.perform(put("/api/cars/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("[4,5,6,7]"))
                .andExpect(status().isOk())
                .andReturn();

        Assertions.assertFalse( mvcResult.getResponse().getContentAsString().isEmpty());
    }

    @Test
    void putCarsTestException() throws Exception {
       mockMvc.perform(put("/api/cars/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(""))
                .andExpect(status().is4xxClientError());
    }
}
