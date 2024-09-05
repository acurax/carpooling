package com.challenge.carpooling.repository;

import com.challenge.carpooling.entity.Journey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JourneyRepository extends JpaRepository<Journey, Integer> {
}
