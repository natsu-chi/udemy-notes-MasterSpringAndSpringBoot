package com.chi.demo03.web02;

import org.apache.commons.lang3.text.translate.NumericEntityUnescaper.OPTION;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;


// Basic Authentication Configuration
// @Configuration
public class SpringSecurityConfiguration {
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // Version 1

        // // All Requests should be authenticated
        // http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
        
        // // If a request is not authenticated, a web page is shown
        // http.httpBasic();

        // http.csrf().disable();

        // return http.build();

        // Version 2
        http.authorizeHttpRequests(auth -> auth
                .anyRequest().authenticated()
                .requestMatchers(HttpMethod.OPTIONS, "/**"))
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(
                        session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .csrf(csrf -> csrf.disable());
        return http.build();

    }
}
