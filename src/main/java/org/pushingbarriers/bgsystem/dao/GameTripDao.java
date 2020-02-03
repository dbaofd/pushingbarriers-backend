package org.pushingbarriers.bgsystem.dao;

import org.pushingbarriers.bgsystem.model.GameTrip;
import org.pushingbarriers.bgsystem.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by baodong on 2020/1/31.
 */

@Repository
public interface GameTripDao extends JpaRepository<GameTrip,Integer> {
    @Modifying
    @Transactional
    @Query(value = "truncate table gametrip", nativeQuery = true)
    void truncateMyTable();

    List<GameTrip> findGameTripsByTripStatus(Integer status);

    @Query(value="select new org.pushingbarriers.bgsystem.model.Trip(tripDate, tripDay, tripTime, tripPlayerId, tripPlayer, tripPlayerGender, tripDriverId, tripDriver, tripDriverGender, tripTeam, tripPlayerAddress, tripAddress, tripStatus, tripNote) from GameTrip ")
    List<Trip> findAllGameTrips();
}
