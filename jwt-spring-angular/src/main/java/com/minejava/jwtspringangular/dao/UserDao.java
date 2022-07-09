package com.minejava.jwtspringangular.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.minejava.jwtspringangular.entity.User;

@Repository
public interface UserDao extends CrudRepository<User, String> {
    

}
