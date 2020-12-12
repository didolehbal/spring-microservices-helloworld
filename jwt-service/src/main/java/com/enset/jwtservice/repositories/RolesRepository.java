package com.enset.jwtservice.repositories;

import com.enset.jwtservice.entities.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
