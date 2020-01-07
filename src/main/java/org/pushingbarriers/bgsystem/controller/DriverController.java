package org.pushingbarriers.bgsystem.controller;

import com.alibaba.fastjson.JSONObject;
import org.pushingbarriers.bgsystem.annotation.AuthToken;
import org.pushingbarriers.bgsystem.dto.BasicDriver;
import org.pushingbarriers.bgsystem.model.Driver;
import org.pushingbarriers.bgsystem.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by baodong on 2019/12/11.
 */
@RestController
public class DriverController {
    @Autowired
    private DriverService driverService;

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
}
