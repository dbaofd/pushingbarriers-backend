package org.pushingbarriers.bgsystem.controller;

import com.alibaba.fastjson.JSONObject;
import org.pushingbarriers.bgsystem.annotation.AuthToken;
import org.pushingbarriers.bgsystem.model.Player;
import org.pushingbarriers.bgsystem.service.PlayerService;
import org.pushingbarriers.bgsystem.util.ImagePath;
import org.pushingbarriers.bgsystem.util.MyTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
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

    @PostMapping(value="/updatePlayerInfoWithoutPhoto")
    @AuthToken
    public JSONObject updatePlayerInfoWithoutPhoto(String name, String gender, String phoneNum, Date birthday,
                                                   String parentName, String parentPhoneNum, String address,
                                                   String referralPerspon, Integer status, Integer id,
                                                   Integer[] teams, String school, String consent,
                                                   String coachManager, String visa, String note, String sport){
        String fileName=null;
        playerService.updatePlayerInfo(name,gender,phoneNum,birthday,parentName,parentPhoneNum,address,referralPerspon,status, id,teams, fileName, school,consent,coachManager,visa,note, sport);
        JSONObject result = new JSONObject();
        result.put("msg","update player info successfully");
        return result;
    }

    @PostMapping(value="/updatePlayerInfo")
    @AuthToken
    public JSONObject updatePlayerInfo(@RequestParam("photo") MultipartFile photo, String name, String gender,
                                       String phoneNum, Date birthday,String parentName, String parentPhoneNum,
                                       String address, String referralPerspon, Integer status, Integer id,
                                       Integer[] teams,  String school, String consent,
                                       String coachManager, String visa, String note, String sport){
        String prefix=photo.getOriginalFilename().substring(photo.getOriginalFilename().lastIndexOf(".")+1);//获取后缀名
        String fileName=name+System.currentTimeMillis()+"."+prefix;

        Player player=playerService.findPlayerByPlayerId(id);
        String oldImgName=player.getPlayerPhoto();
        if(oldImgName!=null) {
            MyTools.deleteImg(ImagePath.IMAGE_PATH_PLAYER_PHOTO, oldImgName);
        }

        MyTools.saveImg(photo,ImagePath.IMAGE_PATH_PLAYER_PHOTO,fileName);
        playerService.updatePlayerInfo(name,gender,phoneNum,birthday,parentName,parentPhoneNum,address,referralPerspon,status, id,teams, fileName, school,consent,coachManager,visa,note, sport);
        JSONObject result = new JSONObject();
        result.put("msg","update player info successfully");
        return result;
    }

    @GetMapping(value = "/findPlayersByPlayerName/{playerName}/{playerStatus}")
    @AuthToken
    public List<Player> findPlayersByPlayerName(@PathVariable(value = "playerName") String playerName, @PathVariable(value = "playerStatus") Integer playerStatus){
        if(playerStatus==3) {
            return playerService.findPlayersByPlayerName(playerName);
        }
        return playerService.findPlayersByPlayerNameAndPlayerStatus(playerName,playerStatus);
    }

    @GetMapping(value = "/findPlayersByPlayerStatus/{playerStatus}")
    @AuthToken
    public List<Player> findPlayersByPlayerStatus(@PathVariable(value = "playerStatus") Integer playerStatus){
        return playerService.findPlayersByPlayerStatus(playerStatus);
    }

    @PostMapping(value="/insertNewPlayer")
    @AuthToken
    public JSONObject insertNewPlayer(@RequestParam("playerPhoto") MultipartFile playerPhoto, String playerName,
                                      String playerGender, String playerPhoneNum, Date playerBirthDay,
                                      String playerParentName, String playerParentPhoneNum, String playerAddress,
                                      Integer playerStatus, Integer[] teamList, String playerReferralPerspon, String playerSchool, String playerConsent,
                                      String playerCoachManager, String playerVisa, String playerNote, String playerSport){
        //playerService.insertNewPlayer(playerName,playerGender,playerPhoneNum,playerBirthDay,playerParentName,playerParentPhoneNum,playerAddress);
        String prefix=playerPhoto.getOriginalFilename().substring(playerPhoto.getOriginalFilename().lastIndexOf(".")+1);//获取后缀名
        String fileName=playerName+System.currentTimeMillis()+"."+prefix;
        MyTools.saveImg(playerPhoto,ImagePath.IMAGE_PATH_PLAYER_PHOTO,fileName);
        playerService.saveNewPlayer(playerName,playerGender,playerPhoneNum,
                playerBirthDay,playerParentName,playerParentPhoneNum,
                playerAddress,playerStatus,teamList, fileName,
                playerReferralPerspon,playerSchool,playerConsent,playerCoachManager,playerVisa,playerNote, playerSport);
        JSONObject result = new JSONObject();
        result.put("msg","insert new player successfully");
        return result;
    }


    @GetMapping(value = "/downloadPlayerPhoto/{playerId}")
    @AuthToken
    public ResponseEntity<FileSystemResource> downloadDriverPhoto(@PathVariable("playerId") Integer playerId) throws FileNotFoundException {
        Player player=playerService.findPlayerByPlayerId(playerId);
        String imgName=player.getPlayerPhoto();
        return MyTools.exportImg(ImagePath.IMAGE_PATH_PLAYER_PHOTO,imgName);
    }
}
