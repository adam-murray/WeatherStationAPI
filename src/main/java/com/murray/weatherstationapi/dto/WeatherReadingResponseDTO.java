package com.murray.weatherstationapi.dto;

import com.murray.weatherstationapi.model.WeatherReading;
import com.murray.weatherstationapi.model.datatypes.SensorType;
import com.murray.weatherstationapi.model.datatypes.SensorUnit;

import java.time.Instant;

public record WeatherReadingResponseDTO (
            String sensorId,
            SensorType type,
            double value,
            SensorUnit unit,
            Instant timestamp
    ) {
    public static WeatherReadingResponseDTO from (WeatherReading entity) {
        return new WeatherReadingResponseDTO(
                entity.getSensorId(),
                entity.getSensorType(),
                entity.getValue(),
                entity.getSensorUnit(),
                entity.getTimestamp()
        );
    }
}
