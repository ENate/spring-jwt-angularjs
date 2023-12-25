package com.minejava.jwtspringangular.dao;

import org.springframework.data.repository.CrudRepository;

import com.minejava.jwtspringangular.entity.User;


public interface UserDao extends CrudRepository<User, String> {
}
