package org.pushingbarriers.bgsystem.service;

import org.pushingbarriers.bgsystem.dto.BasicDriver;
import org.pushingbarriers.bgsystem.model.Driver;

import java.util.Date;
import java.util.List;

/**
 * Created by baodong on 2019/12/11.
 */
public interface DriverService {
    List<Driver> findAllDrivers();

    List<Driver> findDriversByName(String driverName);

    List<Driver> findDriversByNameAndAvailability(String driverName, Integer driverAvailability);

    List<Driver> findDriversByDriverAvailability(Integer driverAvailability);

    List<Driver> findFreeDriversForTraining();

    List<Driver> findFreeDriversForGame();

    void resetDriverPassword(String password, Integer id);

    Boolean driverExistence(String driverUserName);

    Driver getDriver(String driverUserName);

    Driver findDriverById(Integer driverId);

    void insertNewDriver(String driverUserName, String driverPassword, String driverName,
                           String driverGender, Date driverBirthday, String driverPhonenum,
                           String driverPlateNum, String driverAddress);

    void updateAllDriverInfo(Integer driverId,String driverName, String driverGender,
                             Date driverBirthday, String driverPhoneNum, String driverPlateNum,
                             String driverAddress, String driverEmail, Date driverStartDate,
                             Date driverEndDate, Integer driverSeatCapacity, String driverNote);
    void updateSomeDriverInfo(Integer driverId, String driverPhoneNum, String driverPlateNum, String driverAddress);

    void updateDriverLicense(Integer driverId, String driverLicense);

    void updateDriverBluecard(Integer driverId, String driverBluecard);

    void updateDriverStatus(Integer driverId, Integer status);
}
