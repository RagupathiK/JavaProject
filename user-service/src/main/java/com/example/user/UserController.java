package com.example.user;

import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;

@RestController
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    
    private final List<User> users = Arrays.asList(
        new User(1L, "admin", "admin123", "Administrator"),
        new User(2L, "user1", "pass123", "John Doe"),
        new User(3L, "user2", "pass456", "Jane Smith")
    );

    @GetMapping("/users")
    public List<User> getAllUsers() {
        logger.info("GET /users - Fetching all users");
        return users;
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id) {
        logger.info("GET /users/{} - Fetching user by ID", id);
        return users.stream()
            .filter(user -> user.getId().equals(id))
            .findFirst()
            .orElse(null);
    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody LoginRequest request) {
        logger.info("POST /login - Login attempt for username: {}", request.getUsername());
        
        User user = users.stream()
            .filter(u -> u.getUsername().equals(request.getUsername()) && 
                        u.getPassword().equals(request.getPassword()))
            .findFirst()
            .orElse(null);

        Map<String, Object> response = new HashMap<>();
        if (user != null) {
            logger.info("Login successful for user: {}", user.getUsername());
            response.put("success", true);
            response.put("message", "Login successful");
            response.put("user", Map.of("id", user.getId(), "username", user.getUsername(), "name", user.getName()));
        } else {
            logger.warn("Login failed for username: {}", request.getUsername());
            response.put("success", false);
            response.put("message", "Invalid credentials");
        }
        return response;
    }
}