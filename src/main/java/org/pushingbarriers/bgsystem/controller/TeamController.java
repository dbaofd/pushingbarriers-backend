package org.pushingbarriers.bgsystem.controller;

import org.pushingbarriers.bgsystem.annotation.AuthToken;
import org.pushingbarriers.bgsystem.model.Team;
import org.pushingbarriers.bgsystem.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    public List<Team> findAllTeams(){
        return teamService.findAllTeams();
    }
}
