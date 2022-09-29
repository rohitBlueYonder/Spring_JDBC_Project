package com.spring.boot.jdbc.SpringBootJDBCProject.Repository;

import com.spring.boot.jdbc.SpringBootJDBCProject.Entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlayerSpringDataRepository extends JpaRepository<Player, Integer> {

    public List<Player> findByNationality(String Nationality);

    @Modifying
    @Query("UPDATE Player p SET p.nationality = :nationality where p.id = :id")
    void updateNationality(@Param("id") int id, @Param("nationality")String nationality);


}
