package org.pushingbarriers.bgsystem.service;

import org.pushingbarriers.bgsystem.dto.BasicTeam;
import org.pushingbarriers.bgsystem.model.Team;

import java.util.List;

/**
 * Created by baodong on 2019/12/27.
 */
public interface TeamService {
    List<BasicTeam> findAllTeams();

    List<BasicTeam> findTeamsByTeamNameContaining(String teamName);

    List<BasicTeam> findTeamsByStatus(Integer status);

    List<Team> getAllPlayerTeamMapping();

    List<Team> findTeamByName(String name);

    List<Team> findTeamsByClubName(String name);

    void insertNewTeam(String teamName, String teamClub, String teamClubAddress,
                       String teamCoachName, String teamCoachPhoneNum, String teamManagerName, String teamManagerPhoneNum);

    void updateTeamInfo(Integer teamId, String teamName, String teamClub, String teamClubAddress, Integer teamStatus,
                        String teamCoachName, String teamCoachPhoneNum, String teamManagerName, String teamManagerPhoneNum);
}
