package com.example.wapfinalproject.intrusion.controller;

import com.example.wapfinalproject.intrusion.entity.Intrusion;
import com.example.wapfinalproject.intrusion.service.IntrusionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/esp")
public class IntrusionController {

    @Autowired
    IntrusionService intrusionService;

    @GetMapping(path="/latest")
    public Intrusion getLatestIntrusion() {
        return intrusionService.getLatestIntrusion();
    }

    @PostMapping(path="/capture")
    public String createIntrusion(@RequestBody byte[] image) {
        return intrusionService.createIntrusion(image);
    }

}
