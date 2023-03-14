package com.example.wapfinalproject.events.service;

import com.example.wapfinalproject.events.entity.Device;
import com.example.wapfinalproject.events.repository.EventRepository;
import com.example.wapfinalproject.events.utils.EventConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
public class EventsService {

    @Autowired
    EventRepository eventRepository;

    public String getNextAction(Long id, String deviceName) {
        Device device = eventRepository.findById(id).orElseGet(() -> {
                    Device myDevice = new Device(id, deviceName, EventConstants.DEFAULT_ACTION);
                    return eventRepository.save(myDevice);
                }
        );
        return device.getNextEvent();
    }

    public String setNextAction(Long id, String deviceName, String action) {
        Device device = eventRepository.findById(id).orElseGet(() -> {
                    return new Device(id, deviceName, action);
                }
        );
        device.setNextEvent(action);
        eventRepository.save(device);
        return "Success";
    }

}
