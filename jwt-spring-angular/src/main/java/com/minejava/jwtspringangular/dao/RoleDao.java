package com.minejava.jwtspringangular.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.minejava.jwtspringangular.entity.Role;

@Repository
public interface RoleDao extends CrudRepository<Role, String>{
    
}
