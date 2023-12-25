package com.minejava.jwtspringangular.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Role {
    // Check Spring boot version
    @Id
    private String roleName;

    private String roleDescription;
    
}
