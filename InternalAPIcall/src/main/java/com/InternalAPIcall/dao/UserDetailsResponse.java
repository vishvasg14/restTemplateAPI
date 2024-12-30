package com.InternalAPIcall.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsResponse {
    private String userEmail;
    private String accessToken;
    private String someData;
}