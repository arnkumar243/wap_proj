package com.example.wapfinalproject.users.controller;

import com.example.wapfinalproject.users.entity.User;
import com.example.wapfinalproject.users.service.CustomUserService;
import com.example.wapfinalproject.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/user")
public class UserController {

    @Autowired
    CustomUserService customUserService;

    @PostMapping(path="/signup")
    public User signUp(@RequestParam String url, @RequestBody User user) {
        return customUserService.createUser(url, user);
    }

    @GetMapping(path="/verify/{username}/{otp}")
    public String validateUserOtp(@PathVariable String username, @PathVariable Integer otp) {
        return customUserService.validateUserOtp(username, otp);
    }

    @GetMapping(path="/emails")
    public String getUserEmails() {
        return customUserService.getUsersEmail();
    }


}
