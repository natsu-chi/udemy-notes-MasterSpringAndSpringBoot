package com.chi.demo03.web02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        
        // All Requests should be authenticated
        http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
        
        // If a request is not authenticated, a web page is shown
        http.httpBasic();

        http.csrf().disable();

        return http.build();
    }
}
