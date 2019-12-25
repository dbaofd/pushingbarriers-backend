package org.pushingbarriers.bgsystem.controller;

import org.pushingbarriers.bgsystem.annotation.AuthToken;
import org.pushingbarriers.bgsystem.dto.BasicDriver;
import org.pushingbarriers.bgsystem.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by baodong on 2019/12/11.
 */
@RestController
public class DriverController {
    @Autowired
    private DriverService driverService;

    @GetMapping(value="/alldrivers")
    @AuthToken
    public List<BasicDriver> findAllDrivers(){
        return driverService.findAllDrivers();
    }
}
