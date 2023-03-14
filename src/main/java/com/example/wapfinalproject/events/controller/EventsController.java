package com.example.wapfinalproject.events.controller;

import com.example.wapfinalproject.events.service.EventsService;
import com.example.wapfinalproject.events.utils.EventConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EventsController {

    @Autowired
    EventsService eventsService;

    @GetMapping(path="/pir/action")
    public String getPirAction() {
        return eventsService.getNextAction(EventConstants.PIR_DEVICE_ID, EventConstants.PIR_DEVICE_NAME);
    }

    @PostMapping(path="/pir/action")
    public void setNextAction(@RequestBody String action) throws IllegalArgumentException {
        eventsService.setNextAction(EventConstants.PIR_DEVICE_ID, EventConstants.PIR_DEVICE_NAME, action);
    }

    @GetMapping(path="/esp/action")
    public String getCamAction() {
        return eventsService.getNextAction(EventConstants.ESP_DEVICE_ID, EventConstants.ESP_DEVICE_NAME);
    }

    @PostMapping(path="/esp/action")
    public void setEspAction(@RequestBody String action) throws IllegalArgumentException {
        eventsService.setNextAction(EventConstants.ESP_DEVICE_ID, EventConstants.ESP_DEVICE_NAME, action);
    }
}
