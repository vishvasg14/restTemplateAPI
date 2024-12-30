package com.InternalAPIcall.controller;

import com.InternalAPIcall.dao.LoginRequest;
import com.InternalAPIcall.dao.UserDetailsResponse;
import com.InternalAPIcall.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/mylogin")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            // Validate static credentials
            loginService.validateStaticCredentials(loginRequest);

            // Fetch token from external login API
            String token = loginService.fetchTokenFromExternalLoginAPI(loginRequest);

            // Fetch user details using the token
            UserDetailsResponse userDetails = loginService.fetchUserDetails(token);

            // Return the final response
            return ResponseEntity.ok(userDetails);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
