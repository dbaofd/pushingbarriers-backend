package org.pushingbarriers.bgsystem.service;

import org.pushingbarriers.bgsystem.dto.BasicTeam;
import org.pushingbarriers.bgsystem.model.Team;

import java.util.List;

/**
 * Created by baodong on 2019/12/27.
 */
public interface TeamService {
    List<BasicTeam> findAllTeams();

    List<Team> getAllPlayerTeamMapping();

    List<Team> findTeamByName(String name);
}
