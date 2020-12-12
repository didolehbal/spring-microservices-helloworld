package com.enset.jwtservice.services;

import java.util.List;

import com.enset.jwtservice.entities.Role;
import com.enset.jwtservice.entities.User;
import com.enset.jwtservice.repositories.RolesRepository;
import com.enset.jwtservice.repositories.UsersRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {

    private UsersRepository usersRepository;
    private RolesRepository rolesRepository;
    private PasswordEncoder passwordEncoder;

    public UsersServiceImpl(UsersRepository usersRepository, RolesRepository rolesRepository,
            PasswordEncoder passwordEncoder) {
        this.rolesRepository = rolesRepository;
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User addUser(User user) {
        String hashedPassword = this.passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        return this.usersRepository.save(user);
    }

    @Override
    public Role addRole(Role role) {
        return this.rolesRepository.save(role);
    }

    @Override
    public User addRoleUser(Long userId, Long roleId) {
        // TODO Auto-generated method stub
        Role role = this.rolesRepository.getOne(roleId);
        User user = this.usersRepository.getOne(userId);
        user.getRoles().add(role);

        return user;
    }

    @Override
    public User findUserByUsername(String username) {
        return this.usersRepository.findByUsername(username);
    }

    @Override
    public List<User> findAllUsers() {
        return this.usersRepository.findAll();
    }

    @Override
    public List<Role> findAllRoles() {
        return this.rolesRepository.findAll();
    }

    @Override
    public Role findRoleByName(String name) {
        return this.rolesRepository.findByName(name);
    }

}
