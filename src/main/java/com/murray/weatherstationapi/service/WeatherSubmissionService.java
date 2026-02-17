package com.murray.weatherstationapi.service;

import com.murray.weatherstationapi.model.WeatherReading;
import com.murray.weatherstationapi.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherSubmissionService {
    @Autowired
    private final WeatherRepository repository;
    public WeatherSubmissionService(WeatherRepository repository){ this.repository = repository; };

    public void save(WeatherReading weatherReading){
        repository.save(weatherReading);
    }
}
