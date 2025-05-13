package com.andriokar.springsecex;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

@GetMapping("/")
    public String greet(HttpServletRequest httpServletRequest) {
        return "Welcome to Telusko, your sessionId is %s".formatted(httpServletRequest.getSession().getId());
    }

}
