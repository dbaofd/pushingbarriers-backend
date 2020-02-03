package org.pushingbarriers.bgsystem.service;

import org.pushingbarriers.bgsystem.model.GameTrip;

import java.util.List;

/**
 * Created by baodong on 2020/1/31.
 */
public interface GameTripService {
    List<GameTrip> getAllGameTrips();

    List<GameTrip> getGameTripsByStatus(Integer status);
}
