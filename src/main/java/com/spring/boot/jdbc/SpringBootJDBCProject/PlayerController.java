package com.spring.boot.jdbc.SpringBootJDBCProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class PlayerController {

    @Autowired
    PlayerDAO playerDAO;
    @GetMapping("/players")
    public List<Player> getAllPlayers(){

        return playerDAO.getAllPlayers();
    }

    PlayerDAO obj = new PlayerDAO();
    @GetMapping("/playerById")
    public Player getPlayerDataById(int id){
        return obj.getPlayerById(id);
    }

}
