package com.murray.weatherstationapi.controller;

import com.murray.weatherstationapi.dto.WeatherReadingResponseDTO;
import com.murray.weatherstationapi.service.WeatherQueryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {
    private final WeatherQueryService weatherService;
    public WeatherController(WeatherQueryService weatherService){
        this.weatherService = weatherService;
    }
    /*
    @GetMapping("/current")
    public WeatherReadingResponseDTO getCurrent(){
        return weatherService.getCurrent();
    }
     */
    @GetMapping("/readings")
    public List<WeatherReadingResponseDTO> getAll() {
        return weatherService.getAll();
    }
    @GetMapping("/readings/{id}")
    public WeatherReadingResponseDTO getById(@PathVariable long id){
        return weatherService.getById(id);
    }
}
