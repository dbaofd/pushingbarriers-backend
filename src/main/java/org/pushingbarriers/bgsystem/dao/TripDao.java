package org.pushingbarriers.bgsystem.dao;

import org.pushingbarriers.bgsystem.model.Trip;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * Created by baodong on 2020/2/2.
 */
@Repository
public interface TripDao extends JpaRepository<Trip,Integer> {
    Page<Trip> findTripsByTripDateBetween(Date start, Date end, Pageable pageable);

    Page<Trip> findTripsByTripDriverContaining(String driverName, Pageable pageable);

    Page<Trip> findTripsByTripPlayerContaining(String playerName, Pageable pageable);

    Page<Trip> findTripsByTripStatus(Integer status, Pageable pageable);

    Page<Trip> findTripsByTripDriverContainingAndTripDateBetween(String driverName, Date startDate, Date endDate, Pageable pageable);

    Page<Trip> findTripsByTripPlayerContainingAndTripDateBetween(String playerName, Date startDate, Date endDate, Pageable pageable);

    Page<Trip> findTripsByTripStatusAndTripDateBetween(Integer status, Date startDate, Date endDate, Pageable pageable);

}
