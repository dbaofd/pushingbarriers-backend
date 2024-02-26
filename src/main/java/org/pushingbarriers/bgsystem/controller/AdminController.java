package org.pushingbarriers.bgsystem.controller;

import com.alibaba.fastjson.JSONObject;
import org.pushingbarriers.bgsystem.model.Admin;
import org.pushingbarriers.bgsystem.service.AdminService;
import org.pushingbarriers.bgsystem.util.ConstantKit;
import org.pushingbarriers.bgsystem.util.MD5TokenGenerator;
import org.pushingbarriers.bgsystem.util.MyTools;
import org.pushingbarriers.bgsystem.util.RedisHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;


@RestController
@RequestMapping("/")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private MD5TokenGenerator tokenGenerator;

    @PostMapping(value = "/login")
    public JSONObject adminLogin(String adminName, String adminPassword){
        Admin admin;
        JSONObject result = new JSONObject();
        RedisHelper redisHelper=new RedisHelper();
        if(adminService.adminExistence(adminName)) {
            admin=adminService.getAdmin(adminName);
            if (admin.getAdminPassword().equals(adminPassword)) {
                try {
                    Jedis jedis = redisHelper.initializeJedis();
                    if(jedis.exists(adminName)){
                        result.put("msg", "already_logged_in");
                    }else {
                        String token = tokenGenerator.generate(adminName, adminPassword);
                        jedis.set(adminName, token);
                        //set key expire time
                        jedis.expire(adminName, ConstantKit.TOKEN_EXPIRE_TIME);
                        jedis.set(token, adminName);
                        jedis.expire(token, ConstantKit.TOKEN_EXPIRE_TIME);
                        Long currentTime = System.currentTimeMillis();
                        jedis.set(token + adminName, currentTime.toString());
                        jedis.expire(token + adminName, ConstantKit.TOKEN_EXPIRE_TIME);
                        jedis.set(adminName + "type", "admin");
                        jedis.expire(adminName + "type", ConstantKit.TOKEN_EXPIRE_TIME);
                        //close jedis
                        redisHelper.closeJedis(jedis);
                        result.put("msg", "success");
                        result.put("token",token);
                    }
                }catch (Exception e){
                    result.put("msg", "fail_to_connect_radis");
                }
            }else{
                result.put("msg","wrong_password");
            }
        }else{
            result.put("msg","wrong_admin_name");
        }
        return result;
    }

    @PostMapping(value = "/checkToken")
    public JSONObject checkToken(String token, String adminName){
        String admin="";
        JSONObject result = new JSONObject();
        try {
            RedisHelper redisHelper = new RedisHelper();
            Jedis jedis = redisHelper.initializeJedis();
            admin = jedis.get(token);
            redisHelper.closeJedis(jedis);
        }catch(Exception e){
            result.put("msg","fail_to_connect_redis");
            return result;
        }
        if(admin!=null){
            if(!admin.equals(adminName)){
                result.put("msg","unmarched_adminname");
            }else{
                result.put("msg","success");
            }
        }else{
            result.put("msg","wrong_token");
        }
        return result;
    }

    @GetMapping(value = "/")
    public String myTest(){
        return "success!!!";
    }

}
