package org.pushingbarriers.bgsystem.controller;

import org.pushingbarriers.bgsystem.annotation.AuthToken;
import org.pushingbarriers.bgsystem.model.GameTrip;
import org.pushingbarriers.bgsystem.service.GameTripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
}
