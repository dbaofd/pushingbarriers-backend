package org.pushingbarriers.bgsystem.dao;

import org.pushingbarriers.bgsystem.dto.BasicTeam;
import org.pushingbarriers.bgsystem.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Parameter;
import java.util.List;

/**
 * Created by baodong on 2019/12/27.
 */
@Repository
public interface TeamDao extends JpaRepository<Team,Integer> {
    @Query(value="select new org.pushingbarriers.bgsystem.dto.BasicTeam(teamId, teamName, clubName, clubAddress, teamStatus, teamCoachName, teamCoachPhoneNum, teamManagerName, teamManagerPhoneNum) from Team")
    List<BasicTeam> findBasicTeams();

    @Query(value="select new org.pushingbarriers.bgsystem.dto.BasicTeam(teamId, teamName, clubName, clubAddress, teamStatus, teamCoachName, teamCoachPhoneNum, teamManagerName, teamManagerPhoneNum) from Team where teamName like concat('%',:teamName,'%') ")
    List<BasicTeam> findBasicTeamsByTeamNameContaining(@Param("teamName") String teamName);

    @Query(value="select new org.pushingbarriers.bgsystem.dto.BasicTeam(teamId, teamName, clubName, clubAddress, teamStatus, teamCoachName, teamCoachPhoneNum, teamManagerName, teamManagerPhoneNum) from Team where teamStatus=?1")
    List<BasicTeam> findBasicTeamsByStatus(Integer status);

    List<Team> findTeamsByTeamStatus(Integer status);

    List<Team> findTeamByTeamName(String name);

    List<Team> findTeamsByClubName(String name);

    Team getTeamByTeamId(Integer id);
}
