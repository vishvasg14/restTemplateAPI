package com.testing.test.service;

import com.testing.test.dto.EmailServiceResponse;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    // Mock email service logic
    public EmailServiceResponse fetchEmailDetails(String token) {
        // Verify the token (mock verification)
        if ("mock-token-12345".equals(token)) {
            return new EmailServiceResponse("user@example.com", "mock-token-12345", "some-data");
        } else {
            throw new RuntimeException("Invalid token");
        }
    }
}
