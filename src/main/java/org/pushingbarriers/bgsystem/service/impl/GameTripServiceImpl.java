package org.pushingbarriers.bgsystem.service.impl;

import org.pushingbarriers.bgsystem.dao.GameTripDao;
import org.pushingbarriers.bgsystem.model.GameTrip;
import org.pushingbarriers.bgsystem.service.GameTripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by baodong on 2020/1/31.
 */
@Service
public class GameTripServiceImpl implements GameTripService {
    @Autowired
    private GameTripDao gameTripDao;

    public List<GameTrip> getAllGameTrips(){
        return gameTripDao.findAll();
    }

    public List<GameTrip> getGameTripsByStatus(Integer status){
        return gameTripDao.findGameTripsByTripStatus(status);
    }
}
