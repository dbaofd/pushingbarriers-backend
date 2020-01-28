package org.pushingbarriers.bgsystem.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.pushingbarriers.bgsystem.annotation.AppAPI;
import org.pushingbarriers.bgsystem.annotation.AuthToken;
import org.pushingbarriers.bgsystem.dto.BasicDriver;
import org.pushingbarriers.bgsystem.model.Driver;
import org.pushingbarriers.bgsystem.service.DriverService;
import org.pushingbarriers.bgsystem.util.ConstantKit;
import org.pushingbarriers.bgsystem.util.MD5TokenGenerator;
import org.pushingbarriers.bgsystem.util.RedisHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

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

    @GetMapping(value="/findDriversByName/{driverName}")
    @AuthToken
    public List<Driver> findDriversByName(@PathVariable(value = "driverName")String driverName){
        return driverService.findDriversByName(driverName);
    }

    @PostMapping(value="/resetDriverPassword")
    @AuthToken
    public JSONObject resetDriverPassword(String password, Integer id){
        driverService.resetDriverPassword(password,id);
        JSONObject result =new JSONObject();
        result.put("msg","reset driver password successfully");
        return result;
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
