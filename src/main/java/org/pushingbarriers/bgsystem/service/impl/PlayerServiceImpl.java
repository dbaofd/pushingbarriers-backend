package org.pushingbarriers.bgsystem.service.impl;

import org.pushingbarriers.bgsystem.dao.PlayerDao;
import org.pushingbarriers.bgsystem.model.Player;
import org.pushingbarriers.bgsystem.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by baodong on 2019/12/11.
 */
@Service
public class PlayerServiceImpl implements PlayerService {
    @Autowired
    private PlayerDao playerDao;

    public List<Player> findAllPlayers(){
        return playerDao.findAll();
    }

    public void updatePlayerInfo(String name, String gender, String phoneNum, Date birthday,
                                     String parentName, String parentPhoneNum, String address,Integer status, Integer id){
        playerDao.updatePlayerInfo(name, gender, phoneNum, birthday, parentName, parentPhoneNum, address, status, id);

    }

    public List<Player> findPlayersByPlayerName(String playerName){
        return playerDao.findPlayersByPlayerName(playerName);
    }

    public void insertNewPlayer(String playerName, String playerGender, String playerPhoneNum, Date playerBirthDay,
                           String playerParentName, String playerParentPhoneNum, String playerAddress){
        playerDao.insertNewPlayer(playerName,playerGender,playerPhoneNum,playerBirthDay,playerParentName,playerParentPhoneNum,playerAddress);
    }
}
