package org.pushingbarriers.bgsystem.service.impl;

import org.pushingbarriers.bgsystem.dao.TripDao;
import org.pushingbarriers.bgsystem.model.Trip;
import org.pushingbarriers.bgsystem.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by baodong on 2020/2/2.
 */
@Service
public class TripServiceImpl implements TripService {
    @Autowired
    private TripDao tripDao;

    public Page<Trip> findAllTrips(Integer page, Integer pageSize){
        Pageable pageable = PageRequest.of(page - 1, pageSize, Sort.Direction.ASC, "tripDate");
        return tripDao.findAll(pageable);
    }

    public Page<Trip> findTripsBetweenDateRange(Date start, Date end, Integer page, Integer pageSize){
        Pageable pageable = PageRequest.of(page - 1, pageSize, Sort.Direction.ASC, "tripDate");
        return tripDao.findTripsByTripDateBetween(start,end, pageable);
    }

    public Page<Trip> findTripsByDriverName(String driverName, Integer pageSize, Integer page){
        Pageable pageable = PageRequest.of(page - 1, pageSize, Sort.Direction.ASC, "tripDate");
        return tripDao.findTripsByTripDriverContaining(driverName,pageable);
    }

    public Page<Trip> findTripsByPlayerName(String playerName, Integer pageSize, Integer page){
        Pageable pageable = PageRequest.of(page - 1, pageSize, Sort.Direction.ASC, "tripDate");
        return tripDao.findTripsByTripPlayerContaining(playerName,pageable);
    }

    public Page<Trip> findTripsByStatus(Integer status, Integer pageSize, Integer page){
        Pageable pageable = PageRequest.of(page - 1, pageSize, Sort.Direction.ASC, "tripDate");
        return tripDao.findTripsByTripStatus(status,pageable);
    }

    public Page<Trip> findTripsByDriverNameAndDateRange(String driverName, Date startDate, Date endDate, Integer pageSize, Integer page){
        Pageable pageable = PageRequest.of(page - 1, pageSize, Sort.Direction.ASC, "tripDate");
        return tripDao.findTripsByTripDriverContainingAndTripDateBetween(driverName,startDate,endDate,pageable);
    }

    public Page<Trip> findTripsByPlayerNameAndDateRange(String playerName, Date startDate, Date endDate, Integer pageSize, Integer page){
        Pageable pageable = PageRequest.of(page - 1, pageSize, Sort.Direction.ASC, "tripDate");
        return tripDao.findTripsByTripPlayerContainingAndTripDateBetween(playerName,startDate,endDate,pageable);
    }

    public Page<Trip> findTripsByStatusAndDateRange(Integer status, Date startDate, Date endDate, Integer pageSize, Integer page){
        Pageable pageable = PageRequest.of(page - 1, pageSize, Sort.Direction.ASC, "tripDate");
        return tripDao.findTripsByTripStatusAndTripDateBetween(status, startDate, endDate, pageable);
    }
}
