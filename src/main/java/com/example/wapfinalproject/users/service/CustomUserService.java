package com.example.wapfinalproject.users.service;

import com.example.wapfinalproject.mail.service.EmailServiceImpl;
import com.example.wapfinalproject.users.entity.User;
import com.example.wapfinalproject.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class CustomUserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    EmailServiceImpl emailService;

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public User createUser(String url, User user) {

        int randomNumber = new Random().nextInt(9000) + 1000;

        User existingUser = userRepository.findByEmail(user.getEmail());
        if(existingUser != null) {
            throw new IllegalArgumentException("User already exists. Try different Username.");
        }

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setOtp(randomNumber);
        User createdUser = userRepository.save(user);
        emailService.sendEmail(user.getEmail(), "User verification Email.", "Click here to verify your email " + url + "/api/user/verify/" + user.getUsername()+ "/" + randomNumber);

        return createdUser;
    }

    public String validateUserOtp(String username, Integer otp) {

        User existingUser = userRepository.findByusername(username);

        if(existingUser == null) {
            throw new IllegalArgumentException("User does not exist.");
        }

        if(!existingUser.getOtp().equals(otp)) {
            throw new IllegalArgumentException("Otp does not match.");
        }

        existingUser.setVerified(true);
        userRepository.save(existingUser);

        return "Success";

    }

    public String getUsersEmail() {
        String emails = "";
        Iterable<User> users = userRepository.findAll();
        for(User user : users) {
            emails = emails + user.getEmail() + ",";
        }
        return emails;
    }

}
