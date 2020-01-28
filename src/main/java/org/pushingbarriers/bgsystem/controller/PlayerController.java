package org.pushingbarriers.bgsystem.controller;

import com.alibaba.fastjson.JSONObject;
import com.sun.xml.internal.ws.client.sei.ResponseBuilder;
import org.pushingbarriers.bgsystem.annotation.AuthToken;
import org.pushingbarriers.bgsystem.model.Player;
import org.pushingbarriers.bgsystem.service.PlayerService;
import org.pushingbarriers.bgsystem.util.ImagePath;
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
        try {
            //获取输出流
            OutputStream os=new FileOutputStream(ImagePath.IMAGE_PATH+fileName);
            //获取输入流 CommonsMultipartFile 中可以直接得到文件的流
            InputStream is=photo.getInputStream();
            int temp;
            //一个一个字节的读取并写入
            while((temp=is.read())!=(-1))
            {
                os.write(temp);
            }
            os.flush();
            os.close();
            is.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        try {
            //获取输出流
            OutputStream os=new FileOutputStream(ImagePath.IMAGE_PATH+fileName);
            //获取输入流 CommonsMultipartFile 中可以直接得到文件的流
            InputStream is=playerPhoto.getInputStream();
            int temp;
            //一个一个字节的读取并写入
            while((temp=is.read())!=(-1))
            {
                os.write(temp);
            }
            os.flush();
            os.close();
            is.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        playerService.saveNewPlayer(playerName,playerGender,playerPhoneNum,playerBirthDay,playerParentName,playerParentPhoneNum,playerAddress,teamList, fileName);
        JSONObject result = new JSONObject();
        result.put("msg","insert new player successfully");
        return result;
    }


    @GetMapping(value = "/download/{playerId}")
    @AuthToken
    public ResponseEntity<FileSystemResource> getFile(@PathVariable("playerId") Integer playerId) throws FileNotFoundException {
        Player player=playerService.findPlayerByPlayerId(playerId);
        String imgName=player.getPlayerPhoto();
        File file = new File(ImagePath.IMAGE_PATH, imgName);
        if (file.exists()) {
            return export(file);
        }
        System.out.println(file);
        return null;
    }


    public ResponseEntity<FileSystemResource> export(File file) {
        if (file == null) {
            return null;
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Content-Disposition", "attachment; filename=" + file.getName());
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        headers.add("Last-Modified", new Date().toString());
        headers.add("ETag", String.valueOf(System.currentTimeMillis()));
        return ResponseEntity.ok().headers(headers).contentLength(file.length()).contentType(MediaType.parseMediaType("application/octet-stream")).body(new FileSystemResource(file));
    }

}
