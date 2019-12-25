package org.pushingbarriers.bgsystem.dao;

import org.pushingbarriers.bgsystem.dto.BasicDriver;
import org.pushingbarriers.bgsystem.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by baodong on 2019/12/11.
 */

@Repository
public interface DriverDao extends JpaRepository<Driver,Integer> {
    @Query(value="select new org.pushingbarriers.bgsystem.dto.BasicDriver(driverId, driverUserName, driverName, driverGender, driverPhoneNum, driverPlateNum, driverBirthday, driverAddress) from Driver ")
    public List<BasicDriver> findAllDrivers();
}
