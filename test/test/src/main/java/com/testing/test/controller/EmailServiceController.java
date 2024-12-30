package com.testing.test.controller;

import com.testing.test.dto.EmailServiceResponse;
import com.testing.test.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmailServiceController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/emailservice")
    public ResponseEntity<EmailServiceResponse> getEmailDetails(@RequestHeader("Authorization") String authorizationHeader) {
        try {
            // Call the service to fetch email details
            String token = authorizationHeader.startsWith("Bearer ")
                    ? authorizationHeader.substring(7)
                    : authorizationHeader;

            EmailServiceResponse response = emailService.fetchEmailDetails(token.trim());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
    }
}
