package com.minejava.jwtspringangular.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minejava.jwtspringangular.dao.RoleDao;
import com.minejava.jwtspringangular.entity.Role;

@Service
public class RoleService {
    
    @Autowired
    private RoleDao roleDao;
    
    public Role createNewRole(Role role) {
        return roleDao.save(role);
    }
}
