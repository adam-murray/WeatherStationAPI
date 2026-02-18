package com.murray.weatherstationapi.dto;

import com.murray.weatherstationapi.model.WeatherReading;

import java.time.Instant;

public record WeatherReadingResponseDTO (
            String readingId,
            String sensorId,
            String type,
            double value,
            String unit,
            Instant timestamp
    ) {
    public static WeatherReadingResponseDTO from (WeatherReading entity) {
        return new WeatherReadingResponseDTO(
                entity.getReadingId(),
                entity.getSensorId(),
                entity.getSensorType(),
                entity.getValue(),
                entity.getSensorUnit(),
                entity.getTimestamp()
        );
    }
}
