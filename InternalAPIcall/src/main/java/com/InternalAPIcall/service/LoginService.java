package com.InternalAPIcall.service;

import com.InternalAPIcall.dao.ExternalLoginResponse;
import com.InternalAPIcall.dao.LoginRequest;
import com.InternalAPIcall.dao.UserDetailsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LoginService {

    @Autowired
    private RestTemplate restTemplate;

    // Step 1: Validate static credentials
    public void validateStaticCredentials(LoginRequest loginRequest) {
        String staticUsername = "admin";
        String staticPassword = "password";

        if (!staticUsername.equals(loginRequest.getUsername()) || !staticPassword.equals(loginRequest.getPassword())) {
            throw new RuntimeException("Invalid static credentials");
        }
    }

    // Step 2: Call external login API to get token
    public String fetchTokenFromExternalLoginAPI(LoginRequest loginRequest) {
        ResponseEntity<ExternalLoginResponse> response = restTemplate.postForEntity(
                "http://localhost:8081/api/login",
                loginRequest,
                ExternalLoginResponse.class
        );

        if (!response.getStatusCode().is2xxSuccessful() || response.getBody() == null) {
            throw new RuntimeException("Failed to fetch token from external login API");
        }

        return response.getBody().getToken();
    }

    // Step 3: Fetch user details using the token
    public UserDetailsResponse fetchUserDetails(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        HttpEntity<Void> entity = new HttpEntity<>(headers);

        ResponseEntity<UserDetailsResponse> response = restTemplate.exchange(
                "http://localhost:8081/api/emailservice",
                HttpMethod.GET,
                entity,
                UserDetailsResponse.class
        );

        if (!response.getStatusCode().is2xxSuccessful() || response.getBody() == null) {
            throw new RuntimeException("Failed to fetch user details");
        }

        return response.getBody();
    }
}
