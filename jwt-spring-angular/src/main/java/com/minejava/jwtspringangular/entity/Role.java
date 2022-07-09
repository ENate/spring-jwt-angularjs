package com.minejava.jwtspringangular.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Builder
@Data 
public class Role {

    @Id
    @Getter
    @Setter
    private String roleName;

    @Getter
    @Setter
    private String roleDescription;
}
