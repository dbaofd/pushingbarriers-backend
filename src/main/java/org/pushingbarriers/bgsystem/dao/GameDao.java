package org.pushingbarriers.bgsystem.dao;

import org.pushingbarriers.bgsystem.model.Game;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface GameDao extends JpaRepository<Game,Integer> {
    @Query("select distinct gameTeam from Game")
    public List<String> findAllTeams();

    public Page<Game> findGamesByGameTeam(String gameTeam, Pageable pageable);

    public Page<Game> findGamesByGameDateBetween(Date startDate, Date endDate, Pageable pageable);

    public Page<Game> findGamesByGameDateBetweenAndGameTeam(Date startDate, Date endDate, String gameTeam, Pageable pageable);



}
