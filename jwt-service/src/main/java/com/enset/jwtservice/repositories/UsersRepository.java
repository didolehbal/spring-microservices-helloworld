package com.enset.jwtservice.repositories;

import com.enset.jwtservice.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository  extends JpaRepository<User, Long>{
    User findByUsername(String username);
}
