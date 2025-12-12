package com.example.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class UserServiceApplication {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceApplication.class);

    public static void main(String[] args) {
        logger.info("Starting User Service...");
        SpringApplication.run(UserServiceApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void onReady() {
        logger.info("✓ User Microservice successfully running on http://localhost:8081");
        logger.info("Available endpoints:");
        logger.info("  GET  /users - Get all users");
        logger.info("  GET  /users/{id} - Get user by ID");
        logger.info("  POST /login - User login");
        System.out.println("✓ User Microservice successfully running on http://localhost:8081");
    }
}