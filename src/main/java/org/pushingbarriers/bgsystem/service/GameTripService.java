package org.pushingbarriers.bgsystem.service;

import org.pushingbarriers.bgsystem.model.GameTrip;

import java.util.List;

/**
 * Created by baodong on 2020/1/31.
 */
public interface GameTripService {
    List<GameTrip> getAllGameTrips();

    List<GameTrip> getGameTripsByStatus(Integer status);

    void updateGameTripStatus(String note, Integer status, Integer id);

    List<GameTrip> getGameTripsForDriver(String driverGender);

    List<GameTrip> getConfirmedGamesByDriverId(Integer driverId);

    void pickGame(Integer tripId, Integer tripType, Integer tripStatus, Integer tripDriverId, String tripDriver, String tripDriverGender, String tripNote );
}
