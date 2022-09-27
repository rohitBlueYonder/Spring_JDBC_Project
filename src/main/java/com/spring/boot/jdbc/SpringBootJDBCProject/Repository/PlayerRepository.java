package com.spring.boot.jdbc.SpringBootJDBCProject.Repository;


import com.spring.boot.jdbc.SpringBootJDBCProject.Entity.Player;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;



//jpa - java persistence api
@Repository
@Transactional // to make transactions b/w java classes and DB
public class PlayerRepository {

    @PersistenceContext
    EntityManager entityManager;

    public Player insertPlayer(Player player){
        return entityManager.merge(player);
    }

    public Player updatePlayer(Player player){
        return entityManager.merge(player);
    }

    public Player getPlayerById(int id){
        return entityManager.find(Player.class, id);
    }

    public void deleteById(int id){
        Player player = entityManager.find(Player.class, id);
        entityManager.remove(player);

    }

}
