package org.pushingbarriers.bgsystem.service.impl;

import org.pushingbarriers.bgsystem.dao.TeamDao;
import org.pushingbarriers.bgsystem.dto.BasicTeam;
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

    public List<Team> getAllPlayerTeamMapping(){
        return teamDao.findTeamsByTeamStatus(1);
    }

    public List<BasicTeam> findAllTeams() {
        return teamDao.findBasicTeams();
    }

    public List<BasicTeam> findTeamsByTeamNameContaining(String teamName){
        return teamDao.findBasicTeamsByTeamNameContaining(teamName);
    }

    public List<BasicTeam> findTeamsByStatus(Integer status){
        return teamDao.findBasicTeamsByStatus(status);
    }

    public List<Team> findTeamByName(String name){
        return teamDao.findTeamByTeamName(name);
    }

    public List<Team> findTeamsByClubName(String name){
        return teamDao.findTeamsByClubName(name);
    }

    public void insertNewTeam(String teamName, String teamClub, String teamClubAddress,
                              String teamCoachName, String teamCoachPhoneNum, String teamManagerName, String teamManagerPhoneNum){
        Team team=new Team();
        team.setTeamName(teamName);
        team.setClubName(teamClub);
        team.setClubAddress(teamClubAddress);
        team.setTeamCoachName(teamCoachName);
        team.setTeamCoachPhoneNum(teamCoachPhoneNum);
        team.setTeamManagerName(teamManagerName);
        team.setTeamManagerPhoneNum(teamManagerPhoneNum);
        teamDao.save(team);
    }

    public void updateTeamInfo(Integer teamId, String teamName, String teamClub, String teamClubAddress, Integer teamStatus,
                               String teamCoachName, String teamCoachPhoneNum, String teamManagerName, String teamManagerPhoneNum){
        Team team=teamDao.getTeamByTeamId(teamId);
        team.setTeamName(teamName);
        team.setClubName(teamClub);
        team.setClubAddress(teamClubAddress);
        team.setTeamStatus(teamStatus);
        team.setTeamCoachName(teamCoachName);
        team.setTeamCoachPhoneNum(teamCoachPhoneNum);
        team.setTeamManagerName(teamManagerName);
        team.setTeamManagerPhoneNum(teamManagerPhoneNum);
        teamDao.save(team);
    }
}
