package org.pushingbarriers.bgsystem.dao;

import org.pushingbarriers.bgsystem.model.GameUpdateTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface UpdatetimeDao extends JpaRepository<GameUpdateTime,Integer> {
    public GameUpdateTime findGameUpdateTimeByGameupdatetimeId(Integer id);
}
