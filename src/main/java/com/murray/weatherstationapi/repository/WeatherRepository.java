package com.murray.weatherstationapi.repository;

import com.murray.weatherstationapi.model.WeatherReading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WeatherRepository
        extends JpaRepository<WeatherReading, Long> {
    Optional<WeatherReading> findTopByOrderByTimestampDesc();
}
