package org.pushingbarriers.bgsystem.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.pushingbarriers.bgsystem.annotation.AppAPI;
import org.pushingbarriers.bgsystem.annotation.AuthToken;
import org.pushingbarriers.bgsystem.dto.BasicDriver;
import org.pushingbarriers.bgsystem.model.Driver;
import org.pushingbarriers.bgsystem.model.Player;
import org.pushingbarriers.bgsystem.service.DriverService;
import org.pushingbarriers.bgsystem.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import redis.clients.jedis.Jedis;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.List;

/**
 * Created by baodong on 2019/12/11.
 */
@RestController
public class DriverController {
    @Autowired
    private DriverService driverService;

    @Autowired
    private MD5TokenGenerator tokenGenerator;

    @GetMapping(value="/allDrivers")
    @AuthToken
    public List<Driver> findAllDrivers(){
        return driverService.findAllDrivers();
    }

    @GetMapping(value="/findDriversByName/{driverName}/{driverAvailability}")
    @AuthToken
    public List<Driver> findDriversByName(@PathVariable(value = "driverName")String driverName, @PathVariable(value = "driverAvailability")Integer driverAvailability){
        if(driverAvailability==3) {
            return driverService.findDriversByName(driverName);
        }
        return driverService.findDriversByNameAndAvailability(driverName,driverAvailability);
    }

    @GetMapping(value="/findDriversByDriverAvailability/{driverAvailability}")
    @AuthToken
    public List<Driver> findDriversByDriverAvailability(@PathVariable(value = "driverAvailability")Integer driverAvailability){
        return driverService.findDriversByDriverAvailability(driverAvailability);
    }

    @PostMapping(value="/resetDriverPassword")
    @AuthToken
    public JSONObject resetDriverPassword(String password, Integer id){
        driverService.resetDriverPassword(password,id);
        JSONObject result =new JSONObject();
        result.put("msg","reset driver password successfully");
        return result;
    }

    @PostMapping(value="/uploadDriverLicense")
    @AuthToken
    public JSONObject uploadDriverLicense(@RequestParam("driverLicense") MultipartFile driverLicense, Integer driverId, String driverUserName){
        String prefix=driverLicense.getOriginalFilename().substring(driverLicense.getOriginalFilename().lastIndexOf(".")+1);//获取后缀名
        String fileName=driverUserName+"driverLicense"+System.currentTimeMillis()+"."+prefix;

        Driver driver=driverService.findDriverById(driverId);
        String oldImgName=driver.getDriverLicense();
        if(oldImgName!=null) {
            MyTools.deleteImg(ImagePath.IMAGE_PATH_DRIVER_LICENSE, oldImgName);
        }

        MyTools.saveImg(driverLicense,ImagePath.IMAGE_PATH_DRIVER_LICENSE,fileName);
        driverService.updateDriverLicense(driverId,fileName);
        JSONObject result =new JSONObject();
        result.put("msg","upload driver license successfully");
        return result;
    }

    @PostMapping(value="/uploadDriverBluecard")
    @AuthToken
    public JSONObject uploadDriverBluecard(@RequestParam("driverBluecard") MultipartFile driverBluecard, Integer driverId,String driverUserName){
        String prefix=driverBluecard.getOriginalFilename().substring(driverBluecard.getOriginalFilename().lastIndexOf(".")+1);//获取后缀名
        String fileName=driverUserName+"driverBluecard"+System.currentTimeMillis()+"."+prefix;

        Driver driver=driverService.findDriverById(driverId);
        String oldImgName=driver.getDriverBlueCard();
        if(oldImgName!=null) {
            MyTools.deleteImg(ImagePath.IMAGE_PATH_DRIVER_BLUECARD, oldImgName);
        }

        MyTools.saveImg(driverBluecard,ImagePath.IMAGE_PATH_DRIVER_BLUECARD,fileName);
        driverService.updateDriverBluecard(driverId,fileName);
        JSONObject result =new JSONObject();
        result.put("msg","upload driver blue card successfully");
        return result;
    }

    @GetMapping(value = "/downloadDriverLicense/{driverId}")
    @AuthToken
    public ResponseEntity<FileSystemResource> downloadDriverLicense(@PathVariable("driverId") Integer driverId) throws FileNotFoundException {
        Driver driver=driverService.findDriverById(driverId);
        String imgName=driver.getDriverLicense();
        return MyTools.exportImg(ImagePath.IMAGE_PATH_DRIVER_LICENSE, imgName);
    }

    @GetMapping(value = "/downloadDriverBluecard/{driverId}")
    @AuthToken
    public ResponseEntity<FileSystemResource> downloadDriverBluecard(@PathVariable("driverId") Integer driverId) throws FileNotFoundException {
        Driver driver=driverService.findDriverById(driverId);
        String imgName=driver.getDriverBlueCard();
        return MyTools.exportImg(ImagePath.IMAGE_PATH_DRIVER_BLUECARD, imgName);
    }

    @GetMapping(value="/driverLogin/{userName}/{password}")
    @AppAPI
    public JSONObject driverLogin(@PathVariable(value = "userName")String userName, @PathVariable(value = "password")String password){
        Driver driver;
        JSONObject result=new JSONObject();
        RedisHelper redisHelper=new RedisHelper();
        if(driverService.driverExistence(userName)){
            driver=driverService.getDriver(userName);
            if(password.equals(driver.getDriverPassword())){
                try {
                    Jedis jedis = redisHelper.initializeJedis();
                    String token = tokenGenerator.generate(userName, password);
                    jedis.set(userName, token);
                    //set key expire time
                    jedis.expire(userName, ConstantKit.TOKEN_EXPIRE_TIME_FOR_APP);
                    jedis.set(token, userName);
                    jedis.expire(token, ConstantKit.TOKEN_EXPIRE_TIME_FOR_APP);
                    Long currentTime = System.currentTimeMillis();
                    jedis.set(token + userName, currentTime.toString());
                    //close jedis
                    redisHelper.closeJedis(jedis);
                    result.put("msg", "success");
                    result.put("token",token);
                }catch (Exception e){
                    result.put("msg", "fail_to_connect_radis");
                }
            }else{
                result.put("msg", "wrong_password");
            }
        }else{
            result.put("msg", "wrong_username");
        }
        return result;
    }

    @GetMapping(value="/getDriverInfo/{driverUserName}")
    @AppAPI
    public Driver getDriverInfo(@PathVariable(value = "driverUserName") String driverUserName){
        return driverService.getDriver((driverUserName));
    }

    @PostMapping(value="/updateDriverInfo")
    @AppAPI
    public JSONObject updateDriverInfo(Integer driverId, String driverPhoneNum, String driverPlateNum, String driverAddress){
        driverService.updateDriverInfo(driverId, driverPhoneNum, driverPlateNum, driverAddress);
        JSONObject result=new JSONObject();
        result.put("msg", "success");
        return result;
    }

    @GetMapping(value="/checkExistedUserName/{driverUserName}")
    @AppAPI
    public JSONObject checkExistedUserName(@PathVariable(value = "driverUserName") String driverUserName){
        JSONObject jsonObject=new JSONObject();
        if(driverService.driverExistence(driverUserName)){
            jsonObject.put("msg","existed");
        }else{
            jsonObject.put("msg","non-existed");
        }
        return jsonObject;
    }
}
