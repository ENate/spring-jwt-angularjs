package com.minejava.jwtspringangular.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.minejava.jwtspringangular.dao.RoleDao;
import com.minejava.jwtspringangular.dao.UserDao;
import com.minejava.jwtspringangular.entity.Role;
import com.minejava.jwtspringangular.entity.User;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public void initRolesAndUser() {
        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin Role!!");
        roleDao.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Default  role for newly created record");
        roleDao.save(userRole);

        User adminUser = new User();
        adminUser.setUserName("admin123");
        adminUser.setUserPassword(getPasswordEncoder("admin@pass"));
        adminUser.setUserFirstName("admin");
        adminUser.setUserLastName("admin");
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userDao.save(adminUser);

        // User user = new User();
        // user.setUserName("nather");
        // user.setUserPassword(getPasswordEncoder("news@123"));
        // user.setUserFirstName("Jos");
        // user.setUserLastName("Harmer");
        // Set<Role> userRoles = new HashSet<>();
        // userRoles.add(userRole);
        // user.setRole(userRoles);
        // userDao.save(user);
    }

    public User registerNewUser(User user) {
        Role roleNewUser = roleDao.findById("User").get();
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(roleNewUser);
        user.setRole(userRoles);
        user.setUserPassword(getPasswordEncoder(user.getUserPassword()));
        return userDao.save(user);
    }

    public String getPasswordEncoder(String password) {
        return passwordEncoder.encode(password);
    }
}
