package com.enset.billingservice.repositories;

import com.enset.billingservice.entities.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface OrdersRepository extends JpaRepository<Order, Long> {
    
}
