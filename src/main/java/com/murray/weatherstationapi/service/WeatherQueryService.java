package com.murray.weatherstationapi.service;

import com.murray.weatherstationapi.dto.WeatherReadingResponseDTO;
import com.murray.weatherstationapi.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class WeatherQueryService {
    @Autowired
    private final WeatherRepository repository;

    public WeatherQueryService(WeatherRepository repository) {
        this.repository = repository;
    }
    /*
    @Transactional(readOnly = true)
    public WeatherReadingResponseDTO getCurrent() {
        return repository.findTopByOrderByTimestampDesc()
                .map(WeatherReadingResponseDTO::from)
                .orElseThrow(() -> new NoSuchElementException("No readings found"));
    }
    */
    @Transactional(readOnly = true)
    public List<WeatherReadingResponseDTO> getAll() {
        return repository.findAll().stream()
                .map(WeatherReadingResponseDTO::from)
                .toList();
    }
    @Transactional(readOnly = true)
    public WeatherReadingResponseDTO getById(long id){
        return repository.findById(id)
                .map(WeatherReadingResponseDTO::from)
                .orElseThrow(() -> new NoSuchElementException("Reading not found"));
    }
}
