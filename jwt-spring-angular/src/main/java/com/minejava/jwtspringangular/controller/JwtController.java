package com.minejava.jwtspringangular.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.minejava.jwtspringangular.configuration.JwtRequestFilter;
import com.minejava.jwtspringangular.entity.JwtRequest;
import com.minejava.jwtspringangular.entity.JwtResponse;
import com.minejava.jwtspringangular.service.JwtService;

@RestController
@CrossOrigin
public class JwtController {
    @Autowired
    private JwtService jwtService;

    // Use to authenticate
    @PostMapping({"/authenticate"})
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        return jwtService.createJwtToken(jwtRequest);
    }
}
