package org.pushingbarriers.bgsystem.service;

import org.pushingbarriers.bgsystem.dto.BasicDriver;
import org.pushingbarriers.bgsystem.model.Driver;

import java.util.List;

/**
 * Created by baodong on 2019/12/11.
 */
public interface DriverService {
    List<Driver> findAllDrivers();

    List<Driver> findDriversByName(String driverName);

    void resetDriverPassword(String password, Integer id);
}
