package com.chi.demo02.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name") // 為前面 Demo 程式保留，如果可用 getLoggedinUsername() 就不用另存 session
public class LoginController {

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String login(ModelMap model) {
        model.put("name", getLoggedinUsername());
        return "home";
    }

    public static String getLoggedinUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

}
