package com.enset.inventoryservice;

import com.enset.inventoryservice.entities.Product;
import com.enset.inventoryservice.repositories.ProductsRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(ProductsRepository productsRepository){
		return args -> {
			productsRepository.save(new Product(null, "Product1",788,10));
			productsRepository.save(new Product(null, "Product2",1788,10));
			productsRepository.save(new Product(null, "Product3",988,10));
			productsRepository.save(new Product(null, "Product4",288,10));
		};
	}
}
