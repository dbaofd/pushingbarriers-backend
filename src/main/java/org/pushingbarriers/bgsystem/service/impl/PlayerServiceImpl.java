package org.pushingbarriers.bgsystem.service.impl;

import org.pushingbarriers.bgsystem.dao.PlayerDao;
import org.pushingbarriers.bgsystem.dao.TeamDao;
import org.pushingbarriers.bgsystem.dto.PlayerTeam;
import org.pushingbarriers.bgsystem.model.Player;
import org.pushingbarriers.bgsystem.model.Team;
import org.pushingbarriers.bgsystem.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by baodong on 2019/12/11.
 */
@Service
public class PlayerServiceImpl implements PlayerService {
    @Autowired
    private PlayerDao playerDao;

    @Autowired
    private TeamDao teamDao;

    public List<Player> findAllPlayers(){
        return playerDao.findAll();
    }

    public void updatePlayerInfo(String name, String gender, String phoneNum, Date birthday,
                                     String parentName, String parentPhoneNum, String address,Integer status, Integer id, Integer[] teams, String photo){
        Player player=playerDao.findById(id).get();
        player.setPlayerName(name);
        player.setPlayerGender(gender);
        player.setPlayerPhoneNum(phoneNum);
        player.setPlayerBirthday(birthday);
        player.setPlayerParentName(parentName);
        player.setPlayerParentPhoneNum(parentPhoneNum);
        player.setPlayerAddress(address);
        player.setPlayerStatus(status);
        if(photo!=null){
            player.setPlayerPhoto(photo);
        }
        if(teams.length!=0){
            List<Team> teamList=new ArrayList<>();
            for(int i=0;i<teams.length;i++){
                Team team=teamDao.findById(teams[i]).get();
                teamList.add(team);
            }
            player.setTeamList(teamList);
        }
        playerDao.save(player);

    }

    public List<Player> findPlayersByPlayerName(String playerName){
        return playerDao.findPlayersByPlayerNameContaining(playerName);
    }

    public List<Player> findPlayersByPlayerNameAndPlayerStatus(String playerName, Integer playerStatus){
        return playerDao.findPlayersByPlayerNameContainingAndPlayerStatus(playerName,playerStatus);
    }

    public List<Player> findPlayersByPlayerStatus(Integer status){
        return playerDao.findPlayersByPlayerStatus(status);
    }

    public void saveNewPlayer(String playerName, String playerGender, String playerPhoneNum, Date playerBirthDay,
                              String playerParentName, String playerParentPhoneNum, String playerAddress, Integer playerStatus, Integer[] playerTeams, String playerPhoto){
        List<Team> teamList=new ArrayList<>();
        for(int i=0;i<playerTeams.length;i++){
            Team team=teamDao.findById(playerTeams[i]).get();
            teamList.add(team);
        }
        Player player=new Player();
        player.setTeamList(teamList);
        player.setPlayerName(playerName);
        player.setPlayerGender(playerGender);
        player.setPlayerPhoneNum(playerPhoneNum);
        player.setPlayerBirthday(playerBirthDay);
        player.setPlayerParentName(playerParentName);
        player.setPlayerParentPhoneNum(playerParentPhoneNum);
        player.setPlayerAddress(playerAddress);
        player.setPlayerStatus(playerStatus);
        player.setPlayerPhoto(playerPhoto);
        playerDao.save(player);
    }

    public Player findPlayerByPlayerId(Integer playerId){
        return playerDao.findPlayerByPlayerId(playerId);
    }

}
