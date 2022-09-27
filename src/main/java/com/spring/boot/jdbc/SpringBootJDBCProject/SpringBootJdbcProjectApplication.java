package com.spring.boot.jdbc.SpringBootJDBCProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SpringBootJdbcProjectApplication implements CommandLineRunner {

	@Autowired
	PlayerDAO dao;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("\n\n-------GET All PLAYER------------");
		System.out.println(dao.getAllPlayers());

		System.out.println("-------GET PLAYER BY ID------------");
		System.out.println(dao.getPlayerById(2));

		System.out.println("--------INSERT PLAYER-------------------");
		System.out.println(dao.insertPlayer(new Player(5, "Shiva", 24, "Indian", new Date(System.currentTimeMillis()), 10 )));

		System.out.println("-------GET All UPDATED PLAYER------------");
		System.out.println(dao.getAllPlayers());

		System.out.println("-------UPDATE PLAYER BY ID------------");
		System.out.println(dao.updatePlayerInfo(new Player(5, "Shivu", 20, "Indian", new Date(System.currentTimeMillis()), 2 )));

		System.out.println("-------Delete PLAYER BY ID------------");
		System.out.println(dao.deletePlayer(3));

		System.out.println("-------GET All UPDATED PLAYER------------");
		System.out.println(dao.getAllPlayers());

	}


	public static void main(String[] args) {

		SpringApplication.run(SpringBootJdbcProjectApplication.class, args);
	}



}
