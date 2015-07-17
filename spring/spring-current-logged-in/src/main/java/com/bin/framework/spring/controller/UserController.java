package com.bin.spring.controller;

import java.security.Principal;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class UserController {
 
    @RequestMapping(value="/userinfo", method = RequestMethod.GET)
    public String sayHelloAgain(ModelMap model) {
    	
    	User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = user.getUsername();
   
        model.addAttribute("username", name);
    	
        return "userinfo";
    }
    
    @RequestMapping(value="/userinfo2", method = RequestMethod.GET)
    public String printWelcome(ModelMap model, Principal principal ) {
   
        String name = principal.getName(); //get logged in username
        model.addAttribute("username", name);
        return "userinfo";
   
    }
   
 
}