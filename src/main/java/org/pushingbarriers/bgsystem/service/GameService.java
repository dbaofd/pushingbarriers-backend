package org.pushingbarriers.bgsystem.service;

import org.omg.CORBA.INTERNAL;
import org.pushingbarriers.bgsystem.model.Game;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.Date;
import java.util.List;

public interface GameService {

    public List<String> findAllTeams();

    public Page<Game> getGamesByPage(String team, String period, Integer pageSize, String sortedValue, Integer page);

}
