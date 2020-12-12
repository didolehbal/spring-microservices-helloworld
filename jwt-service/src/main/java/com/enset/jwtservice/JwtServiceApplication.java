package com.enset.jwtservice;

import java.util.ArrayList;

import com.enset.jwtservice.entities.Role;
import com.enset.jwtservice.entities.User;
import com.enset.jwtservice.services.UsersService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class JwtServiceApplication {

	@Bean
	PasswordEncoder bcrypt(){
		return new BCryptPasswordEncoder();
	}


	public static void main(String[] args) {
		SpringApplication.run(JwtServiceApplication.class, args);
	}

	@Bean 
	CommandLineRunner start(UsersService usersService){
		return args ->{
			usersService.addRole(new Role(null, "Admin"));
			usersService.addRole(new Role(null, "User"));
			usersService.addRole(new Role(null, "Customer"));
			usersService.addRole(new Role(null, "Customers-manager"));
			usersService.addRole(new Role(null, "Bills-manager"));
			usersService.addRole(new Role(null, "Products-manager"));

			usersService.addUser(new User(null, "mehdi", "123456", new ArrayList<>()));
			usersService.addUser(new User(null, "Prof_youssfy", "123456", new ArrayList<>()));

			User mehdi = usersService.findUserByUsername("mehdi");
			User prof = usersService.findUserByUsername("Prof_youssfy");

			Role admin = usersService.findRoleByName("Admin");
			Role billsManager = usersService.findRoleByName("Bills-manager");

			usersService.addRoleUser(prof.getId(), admin.getId());
			usersService.addRoleUser(mehdi.getId(), billsManager.getId());
		
		};
	}

}
