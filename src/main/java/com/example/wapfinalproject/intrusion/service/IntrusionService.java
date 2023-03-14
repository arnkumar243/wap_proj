package com.example.wapfinalproject.intrusion.service;

import com.example.wapfinalproject.events.service.EventsService;
import com.example.wapfinalproject.events.utils.EventConstants;
import com.example.wapfinalproject.intrusion.entity.Intrusion;
import com.example.wapfinalproject.intrusion.repository.IntrusionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class IntrusionService {

    @Autowired
    IntrusionRepository intrusionRepository;

    @Autowired
    EventsService eventsService;

    public Intrusion getLatestIntrusion() {
        return intrusionRepository.findFirstByOrderByDateDesc();
    }

    public String createIntrusion(byte[] image) {

        Intrusion intrusion = new Intrusion();
        intrusion.setImage(image);
        intrusion.setDate(new Date());

        intrusionRepository.save(intrusion);

        eventsService.setNextAction(EventConstants.ESP_DEVICE_ID, EventConstants.ESP_DEVICE_NAME, EventConstants.DEFAULT_ACTION);

        return "Success";
    }

}
