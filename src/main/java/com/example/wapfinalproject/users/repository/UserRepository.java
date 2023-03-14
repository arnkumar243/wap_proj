package com.example.wapfinalproject.users.repository;

import com.example.wapfinalproject.users.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, String> {
    public User findByEmail(String email);

    public User findByusername(String username);

}
