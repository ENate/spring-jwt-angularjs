package com.minejava.jwtspringangular.service;

import org.springframework.stereotype.Service;

import com.minejava.jwtspringangular.dao.RoleDao;
import com.minejava.jwtspringangular.entity.Role;

@Service
public class RoleService {

    private final RoleDao roleDao;

    public RoleService(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public Role createNewRole(Role role) {
        return roleDao.save(role);
    }
}
