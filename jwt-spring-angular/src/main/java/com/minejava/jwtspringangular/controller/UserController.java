package com.minejava.jwtspringangular.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.minejava.jwtspringangular.entity.User;
import com.minejava.jwtspringangular.service.UserService;

@RestController
public class UserController {
    
    @Autowired
    private UserService userService;
    

    @PostConstruct // run every time we run
    public void initRolesAndusers() {
        userService.initRolesAndUser();
    }
    @PostMapping({"/registerNewUser"})
    public User registerNewUser(@RequestBody User user) {
        return userService.registerNewuser(user);
    }
    
    @GetMapping({"/forAdmin"})
    public String forAdmin() {
        return "URL accessible to admin only";
    }

    @GetMapping({"/forUser"})
    public String forUser() {
        return "URL accessible to user only";
    }
}
