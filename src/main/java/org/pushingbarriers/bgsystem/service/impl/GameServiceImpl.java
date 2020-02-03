package org.pushingbarriers.bgsystem.service.impl;

import org.pushingbarriers.bgsystem.dao.GameDao;
import org.pushingbarriers.bgsystem.model.Game;
import org.pushingbarriers.bgsystem.service.GameService;
import org.pushingbarriers.bgsystem.util.MyTools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.sql.SQLOutput;
import java.util.Date;
import java.util.List;

@Service
public class GameServiceImpl implements GameService {
    enum Period {WHOLESEASON, THISWEEK, NEXTWEEK}

    @Autowired
    private GameDao gameDao;

    @Override
    public List<String> findAllTeams() {
        return gameDao.findAllTeams();
    }

    @Override
    public Page<Game> getGamesByPage(String team, String period, Integer pageSize, String sortedValue, Integer page) {
        Date startDate = new Date();
        Date endDate = new Date();
        if (sortedValue.equals("date")) {
            sortedValue = "gameDate";
        } else if (sortedValue.equals("team")) {
            sortedValue = "gameId";
        }
        if (period.equals(Period.THISWEEK.toString())) {//this weeks game info
            startDate = MyTools.getLastWeekSunday();
            endDate = MyTools.getThisWeekSunday();
        } else if (period.equals(Period.NEXTWEEK.toString())) {//next weeks game info
            startDate = MyTools.getThisWeekSunday();
            endDate = MyTools.getNextWeekSunday();
        }
        Pageable pageable = PageRequest.of(page - 1, pageSize, Sort.Direction.ASC, sortedValue);
        if (!team.equals("AllTeams") && period.equals(Period.WHOLESEASON.toString())) {
            return gameDao.findGamesByGameTeam(team, pageable);
            //return whole season game info for one team with pages
        } else if (!team.equals("AllTeams") && !period.equals(Period.WHOLESEASON.toString())) {
            return gameDao.findGamesByGameDateBetweenAndGameTeam(startDate, endDate, team, pageable);
            //return this week/next week game info for one team with pages
        } else if (team.equals("AllTeams") && !period.equals(Period.WHOLESEASON.toString())) {
            return gameDao.findGamesByGameDateBetween(startDate, endDate, pageable);
            //return this week/next week game info for all teams with pages
        }
        return gameDao.findAll(pageable);
        //return whole season game info for all teams with pages
    }


}
