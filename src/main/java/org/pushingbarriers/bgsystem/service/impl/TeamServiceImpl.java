package org.pushingbarriers.bgsystem.service.impl;

import org.pushingbarriers.bgsystem.dao.TeamDao;
import org.pushingbarriers.bgsystem.model.Team;
import org.pushingbarriers.bgsystem.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by baodong on 2019/12/27.
 */
@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamDao teamDao;

    public List<Team> findAllTeams(){
        return teamDao.findAll();
    }
}
