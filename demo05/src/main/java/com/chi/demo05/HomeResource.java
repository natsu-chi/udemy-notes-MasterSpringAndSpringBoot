package com.chi.demo05;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {
    
    @GetMapping("/")
    public String home(Authentication authentication) {
        System.out.println("Authentication info: " + authentication);
        System.out.println("Account info: " + authentication.getPrincipal());
        return "Hello";
    }
}
