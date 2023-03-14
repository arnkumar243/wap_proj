package com.example.wapfinalproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;

@SpringBootApplication
@EnableJdbcHttpSession
public class WapFinalProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(WapFinalProjectApplication.class, args);
    }

}
