package org.pushingbarriers.bgsystem.controller;

import org.pushingbarriers.bgsystem.annotation.AuthToken;
import org.pushingbarriers.bgsystem.model.Trip;
import org.pushingbarriers.bgsystem.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Created by baodong on 2020/2/2.
 */
@RestController
public class TripController {
    @Autowired
    private TripService tripService;

    @GetMapping("/allTrips/{page}/{pagesize}")
    @AuthToken
    public Page<Trip> getAllTrips(@PathVariable(value = "page") Integer page,
                                  @PathVariable(value = "pagesize") Integer pagesize) {
        return tripService.findAllTrips(page,pagesize);
    }

    @GetMapping("/getTripsBetweenDateRange/{page}/{pagesize}/{start}/{end}")
    @AuthToken
    public Page<Trip> getTripsBetweenDateRange(@PathVariable(value = "page") Integer page,
                                 @PathVariable(value = "pagesize") Integer pagesize,
                                 @PathVariable(value = "start") Date start,
                                 @PathVariable(value = "end") Date end) {
        return tripService.findTripsBetweenDateRange(start,end,page,pagesize);
    }

    @GetMapping("/getTripsByDriverName/{page}/{pagesize}/{drivername}")
    @AuthToken
    public Page<Trip> getTripsByDriverName(@PathVariable(value = "page") Integer page,
                                           @PathVariable(value = "pagesize") Integer pagesize,
                                           @PathVariable(value = "drivername") String drivername) {
        return tripService.findTripsByDriverName(drivername, pagesize, page);
    }

    @GetMapping("/getTripsByPalyerName/{page}/{pagesize}/{playername}")
    @AuthToken
    public Page<Trip> getTripsByPlayerName(@PathVariable(value = "page") Integer page,
                                           @PathVariable(value = "pagesize") Integer pagesize,
                                           @PathVariable(value = "playername") String playername) {
        return tripService.findTripsByPlayerName(playername, pagesize, page);
    }

    @GetMapping("/getTripsByStatus/{page}/{pagesize}/{status}")
    @AuthToken
    public Page<Trip> getTripsByStatus(@PathVariable(value = "page") Integer page,
                                       @PathVariable(value = "pagesize") Integer pagesize,
                                       @PathVariable(value = "status") Integer status) {
        return tripService.findTripsByStatus(status, pagesize, page);
    }

    @GetMapping("/getTripsByDriverNameAndDateRange/{page}/{pagesize}/{drivername}/{start}/{end}")
    @AuthToken
    public Page<Trip> getTripsByDriverNameAndDateRange(@PathVariable(value = "page") Integer page,
                                                       @PathVariable(value = "pagesize") Integer pagesize,
                                                       @PathVariable(value = "drivername") String drivername,
                                                       @PathVariable(value = "start") Date start,
                                                       @PathVariable(value = "end") Date end) {
        return tripService.findTripsByDriverNameAndDateRange(drivername, start, end, pagesize, page);
    }

    @GetMapping("/getTripsByPlayerNameAndDateRange/{page}/{pagesize}/{playername}/{start}/{end}")
    @AuthToken
    public Page<Trip> getTripsByPlayerNameAndDateRange(@PathVariable(value = "page") Integer page,
                                                       @PathVariable(value = "pagesize") Integer pagesize,
                                                       @PathVariable(value = "playername") String playername,
                                                       @PathVariable(value = "start") Date start,
                                                       @PathVariable(value = "end") Date end) {
        return tripService.findTripsByPlayerNameAndDateRange(playername, start, end, pagesize, page);
    }

    @GetMapping("/getTripsByStatusAndDateRange/{page}/{pagesize}/{status}/{start}/{end}")
    @AuthToken
    public Page<Trip> getTripsByStatusAndDateRange(@PathVariable(value = "page") Integer page,
                                                   @PathVariable(value = "pagesize") Integer pagesize,
                                                   @PathVariable(value = "status") Integer status,
                                                   @PathVariable(value = "start") Date start,
                                                   @PathVariable(value = "end") Date end) {
        return tripService.findTripsByStatusAndDateRange(status, start, end, pagesize, page);
    }

}
