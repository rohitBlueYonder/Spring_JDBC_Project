package com.spring.boot.jdbc.SpringBootJDBCProject.Controller;

import com.spring.boot.jdbc.SpringBootJDBCProject.Entity.Player;
import com.spring.boot.jdbc.SpringBootJDBCProject.Repository.PlayerDAO;
import com.spring.boot.jdbc.SpringBootJDBCProject.ServiceLayer.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @PostMapping("/addPlayer")
//    @RequestMapping(method=RequestMethod.POST)
    public Player addPlayer(@RequestBody Player p){
        //p.setName("Sam");
        return service.addPlayer(p);
    }


    @PutMapping("/updatePlayer/{id}")
    public Player updatePlayer(@PathVariable int id,@RequestBody Player p){
        return service.updatePlayerById(id, p);
    }


    @PatchMapping("/patchPlayer/{id}")
    public Player patchPlayer(@PathVariable int id, @RequestBody Map<String, Object> playerPatch){
        return service.patchPlayerById(id, playerPatch);
    }

    //updating with query(only for nationality)
    @PatchMapping("/patchPlayer/{id}/nationality")
    public void patchNationality(@PathVariable int id, @RequestBody String nat){
        service.updateNationality(id, nat);
    }


    @DeleteMapping("/deletePlayer")
    public void deletePlayer(@PathVariable int id){
        service.deletePlayer(id);
    }
}
