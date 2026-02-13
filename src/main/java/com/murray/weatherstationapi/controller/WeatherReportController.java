package com.murray.weatherstationapi.controller;

import com.murray.weatherstationapi.dto.WeatherReadingResponseDTO;
import com.murray.weatherstationapi.model.WeatherReading;
import com.murray.weatherstationapi.service.WeatherQueryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/weather")
public class WeatherReportController {
    private final WeatherQueryService weatherService;
    public WeatherReportController(WeatherQueryService weatherService){
        this.weatherService = weatherService;
    }

    @GetMapping("/latest")
    public WeatherReadingResponseDTO getLatest(){
        /*
        This endpoint returns the latest single reading from the sensors
         */
        return weatherService.getLatest();
    }

    @GetMapping("/current")
    public List<WeatherReadingResponseDTO> getCurrent(){
        return weatherService.getCurrent();
    }

    @GetMapping("/readings")
    public List<WeatherReadingResponseDTO> getAll() {
        return weatherService.getAll();
    }

    @PostMapping("/submit-reading")
    WeatherReading newReading(@RequestBody WeatherReading newReading){
        weatherService.save(newReading);
        System.out.println("Reading: " + newReading.getReadingId() + " saved to DB.");
        return newReading;
    }
}
