package org.pushingbarriers.bgsystem.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.pushingbarriers.bgsystem.annotation.AuthToken;
import org.pushingbarriers.bgsystem.dto.BasicTeam;
import org.pushingbarriers.bgsystem.model.Team;
import org.pushingbarriers.bgsystem.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by baodong on 2019/12/27.
 */
@RestController
public class TeamController {
    @Autowired
    private TeamService teamService;

    @GetMapping(value="/findAllTeams")
    @AuthToken
    public List<BasicTeam> findAllTeams(){
        return teamService.findAllTeams();
    }

    @GetMapping(value="findTeamsByTeamNameContaining/{teamname}")
    @AuthToken
    public List<BasicTeam> findTeamsByTeamNameContaining(@PathVariable(value = "teamname") String teamName){
        return teamService.findTeamsByTeamNameContaining(teamName);
    }

    @GetMapping(value="findTeamsByStatus/{status}")
    @AuthToken
    public List<BasicTeam> findTeamsByStatus(@PathVariable(value = "status") Integer status){
        return teamService.findTeamsByStatus(status);
    }

    @GetMapping(value = "/getAllPlayerTeamMapping")
    @AuthToken
    public List<Team> getAllPlayerTeamMapping(){
        return teamService.getAllPlayerTeamMapping();
    }

    @GetMapping(value = "/findTeamByName/{name}")
    @AuthToken
    public List<Team> getTeamByName(@PathVariable(value = "name") String name){
        return teamService.findTeamByName(name);
    }

    @GetMapping(value = "/findTeamsByClubName/{name}")
    @AuthToken
    public List<Team> getTeamsByClubName(@PathVariable(value = "name") String name){
        return teamService.findTeamsByClubName(name);
    }

    @PostMapping(value="/insertNewTeam")
    @AuthToken
    public JSONObject insertNewTeam(String teamName, String teamClub, String teamClubAddress,
                                    String teamCoachName, String teamCoachPhoneNum, String teamManagerName, String teamManagerPhoneNum){
        JSONObject result=new JSONObject();
        teamService.insertNewTeam(teamName,teamClub,teamClubAddress, teamCoachName, teamCoachPhoneNum, teamManagerName, teamManagerPhoneNum);
        result.put("msg", "add new team successfully");
        return result;
    }

    @PostMapping(value="/updateTeamInfo")
    @AuthToken
    public JSONObject updateTeamInfo(Integer teamId, String teamName, String teamClub, String teamClubAddress, Integer teamStatus,
                                     String teamCoachName, String teamCoachPhoneNum, String teamManagerName, String teamManagerPhoneNum){
        JSONObject result=new JSONObject();
        teamService.updateTeamInfo(teamId,teamName,teamClub,teamClubAddress,teamStatus, teamCoachName, teamCoachPhoneNum, teamManagerName, teamManagerPhoneNum);
        result.put("msg", "update team info successfully");
        return result;
    }


}
