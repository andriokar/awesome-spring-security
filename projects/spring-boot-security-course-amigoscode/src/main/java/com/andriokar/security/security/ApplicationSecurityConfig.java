package com.andriokar.security.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig {

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests((auth) ->
                        auth
                                .requestMatchers(HttpMethod.GET, "/api/v1/students/*").authenticated()
                                .anyRequest().permitAll()
                )
                .httpBasic(withDefaults());

        return httpSecurity.build();
    }
}
