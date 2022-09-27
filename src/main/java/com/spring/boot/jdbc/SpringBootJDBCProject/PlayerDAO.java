package com.spring.boot.jdbc.SpringBootJDBCProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class PlayerDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Player> getAllPlayers(){
        String getPlayerQuery = "select * from Player";

        // JDBC Template -> Query -> DB -> Result Set -> Row Mapped -> Player.class -> List<Object>
        return jdbcTemplate.query(getPlayerQuery,new BeanPropertyRowMapper<Player>(Player.class));
    }

    // getPlayer By Id
    public Player getPlayerById(int id){
        String getPlayerByIdQuery = "select * from Player where id = ?";

        // JDBC Template -> Query -> Id is being substituted as Primary Key -> DB-> result set
        return jdbcTemplate.queryForObject(getPlayerByIdQuery, new BeanPropertyRowMapper<Player>(Player.class),
                new Object[]{id});
    }

    // insert Player
    public int insertPlayer(Player player){
        String insertPlayerQuery = "insert into Player values (?, ?, ?, ?, ?, ?)";

        return jdbcTemplate.update(insertPlayerQuery, new Object[]{player.getid(),
        player.getName(), player.getAge(), player.getNationality(), new Timestamp(player.getDob().getTime()),
        player.getDesignation()});
    }



}
