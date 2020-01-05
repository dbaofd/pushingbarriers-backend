package org.pushingbarriers.bgsystem.controller;

import com.alibaba.fastjson.JSONObject;
import org.pushingbarriers.bgsystem.annotation.AuthToken;
import org.pushingbarriers.bgsystem.dto.PlayerTeam;
import org.pushingbarriers.bgsystem.model.Player;
import org.pushingbarriers.bgsystem.model.Team;
import org.pushingbarriers.bgsystem.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Created by baodong on 2019/12/11.
 */
@RestController
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @GetMapping(value="/allPlayers")
    @AuthToken
    public List<Player> findAllPlayers(){
        return playerService.findAllPlayers();
    }

    @PostMapping(value="/updatePlayerInfo")
    @AuthToken
    public JSONObject updatePlayerInfo(String name, String gender, String phoneNum, Date birthday,
                                       String parentName, String parentPhoneNum, String address, Integer status, Integer id, Integer[] teams){
        playerService.updatePlayerInfo(name,gender,phoneNum,birthday,parentName,parentPhoneNum,address,status, id,teams);
        JSONObject result = new JSONObject();
        result.put("msg","update player info successfully");
        return result;
    }

    @GetMapping(value = "/findPlayersByPlayerName/{playerName}")
    @AuthToken
    public List<Player> findPlayersByPlayerName(@PathVariable(value = "playerName") String playerName){
        return playerService.findPlayersByPlayerName(playerName);
    }

    @PostMapping(value="/insertNewPlayer")
    @AuthToken
    public JSONObject insertNewPlayer(String playerName, String playerGender, String playerPhoneNum, Date playerBirthDay,
                                      String playerParentName, String playerParentPhoneNum, String playerAddress, Integer[] teamList){
        //playerService.insertNewPlayer(playerName,playerGender,playerPhoneNum,playerBirthDay,playerParentName,playerParentPhoneNum,playerAddress);
        playerService.saveNewPlayer(playerName,playerGender,playerPhoneNum,playerBirthDay,playerParentName,playerParentPhoneNum,playerAddress,teamList);
        JSONObject result = new JSONObject();
        result.put("msg","insert new player successfully");
        return result;
    }
}
