package org.pushingbarriers.bgsystem.service;

import org.pushingbarriers.bgsystem.model.Trip;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;

/**
 * Created by baodong on 2020/2/2.
 */
public interface TripService {
    Page<Trip> findAllTrips(Integer page, Integer pageSize);

    Page<Trip> findTripsBetweenDateRange(Date start, Date end, Integer page, Integer pageSize);

    Page<Trip> findTripsByDriverName(String driverName, Integer pageSize, Integer page);

    Page<Trip> findTripsByPlayerName(String playerName, Integer pageSize, Integer page);

    Page<Trip> findTripsByStatus(Integer status, Integer pageSize, Integer page);

    Page<Trip> findTripsByDriverNameAndDateRange(String driverName, Date startDate, Date endDate, Integer pageSize, Integer page);

    Page<Trip> findTripsByPlayerNameAndDateRange(String playerName, Date startDate, Date endDate, Integer pageSize, Integer page);

    Page<Trip> findTripsByStatusAndDateRange(Integer status, Date startDate, Date endDate, Integer pageSize, Integer page);
}
