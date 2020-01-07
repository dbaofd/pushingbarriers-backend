package org.pushingbarriers.bgsystem.service;

import org.pushingbarriers.bgsystem.model.Game;
import org.springframework.data.domain.Page;

import java.util.List;

public interface GameService {

    List<String> findAllTeams();

    Page<Game> getGamesByPage(String team, String period, Integer pageSize, String sortedValue, Integer page);

}
