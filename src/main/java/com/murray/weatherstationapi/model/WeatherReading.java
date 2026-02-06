package com.murray.weatherstationapi.model;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "readings")
public class WeatherReading {
    @Id
    @Column(name = "reading_id")
    private String readingId;
    @Column(name = "sensor_id")
    private String sensorId;
    @Column(name = "sensor_type")
    private String sensorType;
    @Column(name = "value")
    private double value;
    @Column(name = "sensor_unit")
    private String unit;
    @Column(name = "time_stamp")
    private String timestamp;

    public Instant convertStringUnixTimeToInstant(String timestampAsString){
        try{
            long timestampAsLong = Long.parseLong(timestampAsString);
            return Instant.ofEpochMilli(timestampAsLong);
        }
        catch (NumberFormatException e) {
            System.err.println("Could not convert timestamp, defaulting to now");
            return Instant.now();
        }
    }
    public String getReadingId() {return this.readingId; }
    public String getSensorId() {
        return this.sensorId;
    }
    public String getSensorType() {
        return this.sensorType;
    }
    public double getValue() {
        return this.value;
    }

    public String getSensorUnit() {
        return this.unit;
    }
    public Instant getTimestamp() {
        return convertStringUnixTimeToInstant(this.timestamp);
    }
}
