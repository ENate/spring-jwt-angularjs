package com.minejava.jwtspringangular.controller;

import jakarta.annotation.PostConstruct;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.minejava.jwtspringangular.entity.User;
import com.minejava.jwtspringangular.service.UserService;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostConstruct // first runs when spring boot initializes before others
    public void initRolesAndusers() {
        userService.initRolesAndUser();
    }
    @PostMapping({"/registerNewUser"})
    public User registerNewUser(@RequestBody User user) {
        return userService.registerNewUser(user);
    }
    
    @GetMapping({"/forAdmin"})
    @PreAuthorize("hasRole('Admin')") // Forbids non-user admin: use hasAnyRole for multiple roles
    public String forAdmin() {
        return "URL accessible to admin only";
    }

    @GetMapping({"/forUser"})
    @PreAuthorize("hasRole('User')") // check as saved
    public String forUser() {
        return "URL accessible to user only";
    }
}
