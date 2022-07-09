package com.minejava.jwtspringangular.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minejava.jwtspringangular.dao.UserDao;
import com.minejava.jwtspringangular.entity.User;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User registerNewuser(User user) {
        return userDao.save(user);
    }
}
