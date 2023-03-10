package com.example.wapfinalproject.controller;

import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
public class EventsController {

    private static String nextAction = "None";
    private static LocalDateTime nextActionDate = LocalDateTime.now();

    @GetMapping(path="/next-action")
    public String getNextAction() {
        LocalDateTime currentTime = LocalDateTime.now();
        Duration duration = Duration.between(currentTime, nextActionDate);

        if(duration.toMinutes() >= 10) {
            nextAction = "None";
        }
        return nextAction;
    }

    @PostMapping(path="/next-action")
    public void setNextAction(@RequestBody String action) throws IllegalAccessException {
        if(action.equalsIgnoreCase("Open") || action.equalsIgnoreCase("Close") || action.equalsIgnoreCase("Take Pictures")) {
            nextAction = action;
            nextActionDate = LocalDateTime.now();
        } else {
            throw new IllegalAccessException("Action type is not supported.");
        }

    }
}
