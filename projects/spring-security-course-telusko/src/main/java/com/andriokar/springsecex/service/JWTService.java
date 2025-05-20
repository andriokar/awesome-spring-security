package com.andriokar.springsecex.service;

import org.springframework.stereotype.Service;

@Service
public class JWTService {


    public String generateToken() {
        return "eyJhbGciOiJIUzI1NiJ9.eyJSb2xlIjoiQWRtaW4iLCJVc2VybmFtZSI6ImFkbWluIn0.RM_e3p_w_XEdAlKHcnD5eX1dknb741d1bn22r_X3Nak";
    }
}
