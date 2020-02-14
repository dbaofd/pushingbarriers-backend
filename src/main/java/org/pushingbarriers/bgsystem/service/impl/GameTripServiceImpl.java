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

    public List<GameTrip> getGameTripsForDriver(String driverGender){
        if(driverGender.equals("Male")){
            return gameTripDao.findGameTripsForMaleDriver(driverGender);
        }
        return gameTripDao.findGameTripsForFemaleDriver();
    }

    public List<GameTrip> getConfirmedGamesByDriverId(Integer driverId){
        return gameTripDao.findConfirmedGamesByDriverId(driverId);
    }

    public void pickGame(Integer tripId, Integer tripType, Integer tripStatus, Integer tripDriverId, String tripDriver, String tripDriverGender, String tripNote){
        GameTrip gameTrip=gameTripDao.getOne(tripId);
        gameTrip.setTripType(tripType);
        gameTrip.setTripStatus(tripStatus);
        gameTrip.setTripDriverId(tripDriverId);
        gameTrip.setTripDriver(tripDriver);
        gameTrip.setTripDriverGender(tripDriverGender);
        gameTrip.setTripNote(tripNote);
        gameTripDao.save(gameTrip);
        if(tripType==2){
            GameTrip newGametrip=new GameTrip(gameTrip.getTripDate(),gameTrip.getTripDay(),gameTrip.getTripTime(),
                    gameTrip.getTripPlayerId(),gameTrip.getTripPlayer(),gameTrip.getTripPlayerGender(),
                    gameTrip.getTripTeam(),gameTrip.getTripPlayerAddress(),gameTrip.getTripAddress(),3);
            gameTripDao.save(newGametrip);
        }else if(tripType==3){
            GameTrip newGametrip=new GameTrip(gameTrip.getTripDate(),gameTrip.getTripDay(),gameTrip.getTripTime(),
                    gameTrip.getTripPlayerId(),gameTrip.getTripPlayer(),gameTrip.getTripPlayerGender(),
                    gameTrip.getTripTeam(),gameTrip.getTripPlayerAddress(),gameTrip.getTripAddress(),2);
            gameTripDao.save(newGametrip);
        }
    }
}
