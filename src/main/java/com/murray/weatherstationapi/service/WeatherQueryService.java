package com.murray.weatherstationapi.service;

import com.murray.weatherstationapi.dto.WeatherReadingResponseDTO;
import com.murray.weatherstationapi.model.WeatherReading;
import com.murray.weatherstationapi.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class WeatherQueryService {
    @Autowired
    private final WeatherRepository repository;

    public WeatherQueryService(WeatherRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public WeatherReadingResponseDTO getLatest() {
        return repository.findTopByOrderByTimestampDesc()
                .map(WeatherReadingResponseDTO::from)
                .orElseThrow(() -> new NoSuchElementException("No readings found"));
    }

    @Transactional(readOnly = true)
    public List<WeatherReadingResponseDTO> getCurrent(){
        Set<String> previousSensorReports = new HashSet<>();
        List<WeatherReading> reversedReadings = new ArrayList<>(repository.findAll());
        Collections.reverse(reversedReadings);
        return reversedReadings.stream()
                .filter(report -> previousSensorReports.add(report.getSensorType()))
                .map(WeatherReadingResponseDTO::from)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<WeatherReadingResponseDTO> getAll() {
        return repository.findAll().stream()
                .map(WeatherReadingResponseDTO::from)
                .toList();
    }
    public void save(WeatherReading weatherReading){
        repository.save(weatherReading);
    }
}
