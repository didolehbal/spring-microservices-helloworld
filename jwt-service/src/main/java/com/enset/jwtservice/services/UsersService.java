package com.enset.jwtservice.services;

import java.util.List;

import com.enset.jwtservice.entities.Role;
import com.enset.jwtservice.entities.User;

public interface UsersService {
    User addUser(User user);
    Role addRole(Role role);
    User addRoleUser(Long userId, Long roleId);
    User findUserByUsername(String username);
    Role findRoleByName(String name);
    List<User> findAllUsers();
    List<Role> findAllRoles();
}
