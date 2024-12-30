package com.testing.test.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailServiceResponse {
    private String userEmail;
    private String accessToken;
    private String someData;
}
