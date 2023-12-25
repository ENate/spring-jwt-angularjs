package com.minejava.jwtspringangular.dao;

import org.springframework.data.repository.CrudRepository;

import com.minejava.jwtspringangular.entity.Role;

public interface RoleDao extends CrudRepository<Role, String>{
    
}
