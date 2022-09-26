package com.spring.boot.jdbc.SpringBootJDBCProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootJdbcProjectApplication implements CommandLineRunner {

	@Autowired
	PlayerDAO dao;

	@Override
	public void run(String... args) throws Exception {
		System.out.println(dao.getAllPlayers());
	}


	public static void main(String[] args) {

		SpringApplication.run(SpringBootJdbcProjectApplication.class, args);
	}



}
