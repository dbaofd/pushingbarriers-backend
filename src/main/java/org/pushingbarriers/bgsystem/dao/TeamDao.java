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
    public List<BasicTeam> findTeams();

    public List<Team> findTeamByTeamName(String name);

    public List<Team> findTeamsByClubName(String name);
}
