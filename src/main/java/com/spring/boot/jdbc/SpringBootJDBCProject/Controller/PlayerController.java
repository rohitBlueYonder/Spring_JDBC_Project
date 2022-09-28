package com.spring.boot.jdbc.SpringBootJDBCProject.Controller;

import com.spring.boot.jdbc.SpringBootJDBCProject.Entity.Player;
import com.spring.boot.jdbc.SpringBootJDBCProject.Repository.PlayerDAO;
import com.spring.boot.jdbc.SpringBootJDBCProject.ServiceLayer.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlayerController {

//    @Autowired
//    PlayerDAO playerDAO = new PlayerDAO();


    @Autowired
    PlayerService service;


    @GetMapping("/players")
    public List<Player> getAllPlayers(){

        return service.getAllPlayer();
    }

    PlayerDAO obj = new PlayerDAO();
    @GetMapping("/playerById")
    public Player getPlayerDataById(int id){
        return obj.getPlayerById(id);
    }


     @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to player entity";
     }

     @GetMapping("/player/{id}")
    public Player getPlayer(@PathVariable int id){
        return service.findPlayerById(id);
     }
}
