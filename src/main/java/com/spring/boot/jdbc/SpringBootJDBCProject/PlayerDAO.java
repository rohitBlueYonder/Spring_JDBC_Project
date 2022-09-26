package com.spring.boot.jdbc.SpringBootJDBCProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlayerDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Player> getAllPlayers(){
        String getPlayerQuery = "select * from Player";
        return jdbcTemplate.query(getPlayerQuery,new BeanPropertyRowMapper<Player>(Player.class));
    }
}
