package com.murray.weatherstationapi.controller;

import com.murray.weatherstationapi.model.WeatherReading;
import com.murray.weatherstationapi.service.WeatherSubmissionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/submit-report")
public class WeatherSubmissionController {
    private final WeatherSubmissionService weatherSubmissionService;

    public WeatherSubmissionController(WeatherSubmissionService weatherSubmissionService) {
        this.weatherSubmissionService = weatherSubmissionService;
    }

    @PostMapping
    WeatherReading newReading(@RequestBody WeatherReading newReading){
        weatherSubmissionService.save(newReading);
        System.out.println("Reading: " + newReading.getReadingId() + " saved to DB.");
        return newReading;
    }
}
