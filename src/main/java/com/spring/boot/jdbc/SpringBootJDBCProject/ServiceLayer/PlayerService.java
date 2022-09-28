package com.spring.boot.jdbc.SpringBootJDBCProject.ServiceLayer;

import com.spring.boot.jdbc.SpringBootJDBCProject.Entity.Player;
import com.spring.boot.jdbc.SpringBootJDBCProject.Repository.PlayerRepository;
import com.spring.boot.jdbc.SpringBootJDBCProject.Repository.PlayerSpringDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    PlayerSpringDataRepository repo;

    //getAllPayers
    public List<Player> getAllPlayer(){
        return repo.findAll();
    }


    // PAth variable - to access it in the url
    // eg: http://localhost:8080/{{"fname"}}

    //Find By ID
    public Player findPlayerById(@PathVariable("id") int id){
        Optional<Player> tempPlayer = repo.findById(id);
//        repo.getOne(id);

        Player p = null;
        if(tempPlayer.isPresent()){
            p = tempPlayer.get();
        }
        else {
            throw new RuntimeException("Player with Id: "+id+" not found!!!");
        }
        return p;
    }



}
