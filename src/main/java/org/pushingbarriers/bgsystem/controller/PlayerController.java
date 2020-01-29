package org.pushingbarriers.bgsystem.controller;

import com.alibaba.fastjson.JSONObject;
import com.sun.xml.internal.ws.client.sei.ResponseBuilder;
import org.pushingbarriers.bgsystem.annotation.AuthToken;
import org.pushingbarriers.bgsystem.model.Player;
import org.pushingbarriers.bgsystem.service.PlayerService;
import org.pushingbarriers.bgsystem.util.ImagePath;
import org.pushingbarriers.bgsystem.util.MyTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Response;
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
                                       String parentName, String parentPhoneNum, String address, Integer status, Integer id, Integer[] teams){
        String fileName=null;
        playerService.updatePlayerInfo(name,gender,phoneNum,birthday,parentName,parentPhoneNum,address,status, id,teams, fileName);
        JSONObject result = new JSONObject();
        result.put("msg","update player info successfully");
        return result;
    }

    @PostMapping(value="/updatePlayerInfo")
    @AuthToken
    public JSONObject updatePlayerInfo(@RequestParam("photo") MultipartFile photo, String name, String gender, String phoneNum, Date birthday,
                                       String parentName, String parentPhoneNum, String address, Integer status, Integer id, Integer[] teams){
        String prefix=photo.getOriginalFilename().substring(photo.getOriginalFilename().lastIndexOf(".")+1);//获取后缀名
        String fileName=name+System.currentTimeMillis()+"."+prefix;

        Player player=playerService.findPlayerByPlayerId(id);
        String oldImgName=player.getPlayerPhoto();
        if(oldImgName!=null) {
            MyTools.deleteImg(ImagePath.IMAGE_PATH_PLAYER_PHOTO, oldImgName);
        }

        MyTools.saveImg(photo,ImagePath.IMAGE_PATH_PLAYER_PHOTO,fileName);
        playerService.updatePlayerInfo(name,gender,phoneNum,birthday,parentName,parentPhoneNum,address,status, id,teams, fileName);
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
    public JSONObject insertNewPlayer(@RequestParam("playerPhoto") MultipartFile playerPhoto, String playerName, String playerGender, String playerPhoneNum, Date playerBirthDay,
                                      String playerParentName, String playerParentPhoneNum, String playerAddress, Integer[] teamList){
        //playerService.insertNewPlayer(playerName,playerGender,playerPhoneNum,playerBirthDay,playerParentName,playerParentPhoneNum,playerAddress);
        String prefix=playerPhoto.getOriginalFilename().substring(playerPhoto.getOriginalFilename().lastIndexOf(".")+1);//获取后缀名
        String fileName=playerName+System.currentTimeMillis()+"."+prefix;
        MyTools.saveImg(playerPhoto,ImagePath.IMAGE_PATH_PLAYER_PHOTO,fileName);
        playerService.saveNewPlayer(playerName,playerGender,playerPhoneNum,playerBirthDay,playerParentName,playerParentPhoneNum,playerAddress,teamList, fileName);
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
