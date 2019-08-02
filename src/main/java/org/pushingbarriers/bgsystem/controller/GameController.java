package org.pushingbarriers.bgsystem.controller;

import org.pushingbarriers.bgsystem.annotation.AuthToken;
import org.pushingbarriers.bgsystem.model.Game;
import org.pushingbarriers.bgsystem.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class GameController {
    @Autowired
    private GameService gameService;

    @GetMapping(value = "/games/{page}/{size}/{team}/{period}/{sortedValue}")
    @AuthToken
    public Page<Game> getGamesByPages(@PathVariable(value = "page") Integer page,
                                      @PathVariable(value = "size") Integer size,
                                      @PathVariable(value = "team") String team,
                                      @PathVariable(value = "period") String period,
                                      @PathVariable(value = "sortedValue") String sortedValue) {
        return gameService.getGamesByPage(team, period, size, sortedValue, page);
    }

    @GetMapping(value = "/allteams")
    @AuthToken
    public List<String> findAllTeams() {
        return gameService.findAllTeams();
    }


}
