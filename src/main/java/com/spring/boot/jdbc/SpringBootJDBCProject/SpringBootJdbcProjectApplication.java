package com.spring.boot.jdbc.SpringBootJDBCProject;

import com.spring.boot.jdbc.SpringBootJDBCProject.Entity.Player;
import com.spring.boot.jdbc.SpringBootJDBCProject.Repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;

@SpringBootApplication
public class SpringBootJdbcProjectApplication implements CommandLineRunner {

	@Autowired
	PlayerRepository repo;
//	PlayerDAO dao;

	@Override
	public void run(String... args) throws Exception {
//		System.out.println("\n\n-------GET All PLAYER------------");
//		System.out.println(dao.getAllPlayers());

//		System.out.println("-------GET PLAYER BY ID------------");
//		System.out.println(dao.getPlayerById(2));
//
//		System.out.println("--------INSERT PLAYER-------------------");
//		System.out.println(dao.insertPlayer(new Player(5, "Shiva", 24, "Indian", new Date(System.currentTimeMillis()), 10 )));
//
//		System.out.println("-------GET All UPDATED PLAYER------------");
//		System.out.println(dao.getAllPlayers());
//
//		System.out.println("-------UPDATE PLAYER BY ID------------");
//		System.out.println(dao.updatePlayerInfo(new Player(5, "Shivu", 20, "Indian", new Date(System.currentTimeMillis()), 2 )));
//
//		System.out.println("-------Delete PLAYER BY ID------------");
//		System.out.println(dao.deletePlayer(3));
//
//		System.out.println("-------GET All UPDATED PLAYER------------");
//		System.out.println(dao.getAllPlayers());



	// CRUD without DB queries

	//Insert
	repo.insertPlayer(new Player("Rohit" , 23 , "Indian" , Date.valueOf("1999-08-01") , 1 ));
	repo.insertPlayer(new Player( "Mohit" , 28 , "Indian" , Date.valueOf("1999-05-01") , 2 ));

	//Read
	System.out.println("Printing ID-2 details: "+repo.getPlayerById(2));

	//Update
	repo.updatePlayer(new Player(1,"MtEverest" , 28 , "British" , Date.valueOf("1999-05-01") , 2 ));

	// Delete
	repo.deleteById(2);


	}


	public static void main(String[] args) {

		SpringApplication.run(SpringBootJdbcProjectApplication.class, args);
	}



}
