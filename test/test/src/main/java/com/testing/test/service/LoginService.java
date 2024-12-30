package com.testing.test.service;

import com.testing.test.dto.LoginRequest;
import com.testing.test.dto.LoginResponse;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    // Mock authentication logic
    public LoginResponse authenticateUser(LoginRequest loginRequest) {
        // Static credentials for demo purposes
        String staticUsername = "admin";
        String staticPassword = "password";

        if (staticUsername.equals(loginRequest.getUsername()) && 
            staticPassword.equals(loginRequest.getPassword())) {
            // Return mock token
            return new LoginResponse(loginRequest.getUsername(), "mock-token-12345");
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }
}
