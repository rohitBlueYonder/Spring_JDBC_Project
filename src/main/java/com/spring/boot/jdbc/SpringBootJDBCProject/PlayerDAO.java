package com.spring.boot.jdbc.SpringBootJDBCProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class PlayerDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;


    // get list of all players
    public List<Player> getAllPlayers(){
        String getPlayerQuery = "select * from Player";

        // JDBC Template -> Query -> DB -> Result Set -> Row Mapped -> Player.class -> List<Object>
        return jdbcTemplate.query(getPlayerQuery,new BeanPropertyRowMapper<Player>(Player.class));
//        return jdbcTemplate.query(getPlayerQuery,new PlayerMapper());
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

        // result: 1:success, 0: failure
        return jdbcTemplate.update(insertPlayerQuery,new PlayerMapper(), new Object[]{player.getid(),
        player.getName(), player.getAge(), player.getNationality(), new Timestamp(player.getDob().getTime()),
        player.getDesignation()});
    }


    // update player by id
    public int updatePlayerInfo(Player player){
        String updatePlayerQuery = "update player "+"set name = ?, age = ?, designation = ?"+"where id = ?";

        return jdbcTemplate.update(updatePlayerQuery,new PlayerMapper(), new Object[]{
                player.getName(), player.getAge(),
                player.getDesignation(),player.getid()});

//        return jdbcTemplate.update(updatePlayerQuery, new Object[]{
//                player.getName(), player.getAge(),
//                player.getDesignation(),player.getid()});

    }

    //delete player by id
    public int deletePlayer(int id){
        String deletePlayerQuery = "delete from Player where id = ?";

        return jdbcTemplate.update(deletePlayerQuery,new PlayerMapper(), new Object[]{id});
    }


    private static final class PlayerMapper implements RowMapper{

        @Override
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            Player player = new Player();

            player.setid(rs.getInt("ID"));
            player.setName(rs.getString("Name"));
            player.setAge(rs.getInt("Age"));
            player.setNationality(rs.getString("Nationality"));
            player.setDob(rs.getDate("DOB"));
            player.setDesignation(rs.getInt("Designation"));



            return player;
        }
    }

}
