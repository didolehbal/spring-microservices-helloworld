package com.enset.customerservice;

import com.enset.customerservice.entities.Customer;
import com.enset.customerservice.repositories.CustomerRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerRepository customerRepository){
		return args -> {
			customerRepository.save(new Customer(null,"client1","client1@gmail.com"));
			customerRepository.save(new Customer(null,"client2","client2@gmail.com"));
			customerRepository.save(new Customer(null,"client3","client3@gmail.com"));
			customerRepository.save(new Customer(null,"client4","client4@gmail.com"));
		};
	}	

}
