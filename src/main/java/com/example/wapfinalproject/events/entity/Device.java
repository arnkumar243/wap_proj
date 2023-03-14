package com.example.wapfinalproject.events.entity;

import jakarta.persistence.*;

@Entity
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String deviceName;

    private String nextEvent;

    public Device() {}

    public Device(Long id, String deviceName, String nextEvent) {
        this.id = id;
        this.deviceName = deviceName;
        this.nextEvent = nextEvent;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getNextEvent() {
        return nextEvent;
    }

    public void setNextEvent(String nextEvent) {
        this.nextEvent = nextEvent;
    }
}
