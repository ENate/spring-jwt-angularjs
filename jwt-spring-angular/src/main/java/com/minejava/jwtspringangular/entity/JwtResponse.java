package com.minejava.jwtspringangular.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class JwtResponse {
    // returns user and angular will easily handle this.
    private User user;
    private String jwtToken;
}
