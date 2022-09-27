package com.spring.boot.jdbc.SpringBootJDBCProject;

import com.spring.boot.jdbc.SpringBootJDBCProject.Entity.Player;
import com.spring.boot.jdbc.SpringBootJDBCProject.Repository.PlayerSpringDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;

@SpringBootApplication
public class TennisPlayerSpringDataApplication implements CommandLineRunner {

    @Autowired
    PlayerSpringDataRepository repo;

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    public static void main(String[] args) {
        SpringApplication.run(TennisPlayerSpringDataApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("\nInserting a Player\n", repo.save(new Player("Rajvir" , 28 , "USA" , Date.valueOf("1999-08-01") , 3 )));
        logger.info("\nInserting a Player\n", repo.save(new Player("Shiva" , 24 , "British" , Date.valueOf("1999-08-01") , 10 )));
        logger.info("\nInserting a Player\n", repo.save(new Player("Jitu" , 22 , "USA" , Date.valueOf("1999-08-01") , 2 )));
        logger.info("\nInserting a Player\n", repo.save(new Player("Rahul" , 28 , "India" , Date.valueOf("1999-08-01") , 1 )));

        logger.info("\nFinding a Player by ID\n", repo.findById(1));

        logger.info("\n Delete by ID\n");
        repo.deleteById(2);

        logger.info("\n Find all players\n", repo.findAll());
    }
}
