package com.chi.demo02.mvc;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authenticate(String id, String password) {
        boolean isValidId = id.equalsIgnoreCase("usera");
        boolean isValidPassword = password.equalsIgnoreCase("123456");

        return (isValidId && isValidPassword);
    }
}
