package org.pushingbarriers.bgsystem.dao;

import org.pushingbarriers.bgsystem.dto.BasicTeam;
import org.pushingbarriers.bgsystem.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by baodong on 2019/12/27.
 */
@Repository
public interface TeamDao extends JpaRepository<Team,Integer> {
    @Query(value="select new org.pushingbarriers.bgsystem.dto.BasicTeam(teamId, teamName) from Team")
    List<BasicTeam> findTeams();

    List<Team> findTeamByTeamName(String name);

    List<Team> findTeamsByClubName(String name);
}
