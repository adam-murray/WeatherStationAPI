package com.murray.weatherstationapi.model;

import com.murray.weatherstationapi.model.datatypes.SensorType;
import com.murray.weatherstationapi.model.datatypes.SensorUnit;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.Instant;

@Entity
public class WeatherReading {
    @Id
    @GeneratedValue
    private String sensorId;
    private SensorType sensorType;
    private double value;
    private SensorUnit unit;
    Instant timestamp;

    public String getSensorId() {
        return this.sensorId;
    }
    public SensorType getSensorType() {
        return this.sensorType;
    }
    public double getValue() {
        return this.value;
    }

    public SensorUnit getSensorUnit() {
        return this.unit;
    }
    public Instant getTimestamp() {
        return this.timestamp;
    }
}
