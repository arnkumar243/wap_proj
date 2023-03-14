package com.example.wapfinalproject.users.service;

import com.example.wapfinalproject.users.entity.User;
import com.example.wapfinalproject.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);

        if(!user.isVerified()) {
            throw new IllegalArgumentException("Email is not verified.");
        }

        List<SimpleGrantedAuthority> myList = new ArrayList<>();

        myList.add(new SimpleGrantedAuthority("ADMIN"));
        myList.add(new SimpleGrantedAuthority("USER"));

        Collection<SimpleGrantedAuthority> collection = myList;

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), collection);

    }
}
