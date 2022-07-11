package com.minejava.jwtspringangular.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponse {
    // returns user and angular will easily handle this.
    private User user;
    private String jwtToken;
}
