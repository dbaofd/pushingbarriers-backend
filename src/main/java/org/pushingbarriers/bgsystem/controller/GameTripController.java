package org.pushingbarriers.bgsystem.controller;

import com.alibaba.fastjson.JSONObject;
import org.pushingbarriers.bgsystem.annotation.AppAPI;
import org.pushingbarriers.bgsystem.annotation.AuthToken;
import org.pushingbarriers.bgsystem.model.GameTrip;
import org.pushingbarriers.bgsystem.service.GameTripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by baodong on 2020/1/31.
 */
@RestController
public class GameTripController {
    @Autowired
    private GameTripService gameTripService;

    @GetMapping("/allGameTrips")
    @AuthToken
    public List<GameTrip> getAllGameTrips(){
        return gameTripService.getAllGameTrips();
    }

    @GetMapping("/getGameTripsByStatus/{status}")
    @AuthToken
    public List<GameTrip> getGameTripsByStatus(@PathVariable(value = "status") Integer status){
        return gameTripService.getGameTripsByStatus(status);
    }

    @GetMapping("/getGameTripsForDriver/{drivergender}")
    @AuthToken
    @AppAPI
    public List<GameTrip> getGameTripsForDriver(@PathVariable(value = "drivergender") String drivergender){
        return gameTripService.getGameTripsForDriver(drivergender);
    }

    @GetMapping("/getConfirmedGameTripsByDriverId/{driverid}")
    @AuthToken
    @AppAPI
    public List<GameTrip> getConfirmedGameTripsByDriverId(@PathVariable(value = "driverid") Integer driverId){
        return gameTripService.getConfirmedGamesByDriverId(driverId);
    }

    @PostMapping(value="/pickGame")
    @AuthToken
    @AppAPI
    public JSONObject pickGame(Integer tripId, Integer tripType, Integer tripStatus, Integer tripDriverId, String tripDriver, String tripDriverGender, String tripNote){
        JSONObject result = new JSONObject();
        gameTripService.pickGame(tripId,tripType,tripStatus,tripDriverId,tripDriver,tripDriverGender,tripNote);
        result.put("msg","pick game successfully");
        return result;
    }


}
