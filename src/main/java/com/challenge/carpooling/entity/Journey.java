package com.challenge.carpooling.entity;

import com.challenge.carpooling.bean.JourneyStatus;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Journey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Nonnull
    int userId;

    @Nonnull
    int carId;

    int passengers;

    JourneyStatus status;
}
