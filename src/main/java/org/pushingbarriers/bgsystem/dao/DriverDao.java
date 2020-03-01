package org.pushingbarriers.bgsystem.dao;

import org.pushingbarriers.bgsystem.dto.BasicDriver;
import org.pushingbarriers.bgsystem.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by baodong on 2019/12/11.
 */

@Repository
public interface DriverDao extends JpaRepository<Driver,Integer> {
//    @Query(value="select new org.pushingbarriers.bgsystem.dto.BasicDriver(driverId, driverUserName, driverName, driverGender, driverPhoneNum, driverPlateNum, driverBirthday, driverAddress, driverAvailability) from Driver where driverName like concat('%',?1,'%')")
//    public List<BasicDriver> findDriversByName(String driverName);
    List<Driver> findDriversByDriverNameContaining(String driverName);

    List<Driver> findDriversByDriverNameContainingAndDriverAvailability(String driverName, Integer driverAvailability);

    List<Driver> findDriversByDriverAvailability(Integer driverAvailability);

    @Query("update Driver set driverPassword=?1 where driverId=?2")
    @Modifying
    @Transactional
    void resetDriverPassword(String password, Integer id);

    Boolean existsDriverByDriverUserName(String driverUserName);

    //@Query(value="select new org.pushingbarriers.bgsystem.dto.BasicDriver(driverId, driverUserName, driverName, driverGender, driverPhoneNum, driverPlateNum, driverBirthday, driverAddress, driverAvailability) from Driver where driverUserName = ?1")
    Driver findDriverByDriverUserName(String driverUserName);

    Driver findDriverByDriverId(Integer id);

    @Query("select d from Driver d where d.driverId not in (select t.trainingDriverId from Training t where t.trainingDriverId is not null)")
    List<Driver> findFreeDriversForTraining();

    //when use 'not in', make sure both right side and left side has no null value
    @Query("select d from Driver d where d.driverId not in (select g.tripDriverId from GameTrip g where g.tripDriverId is not null )")
    List<Driver> findFreeDriversForGame();
}
