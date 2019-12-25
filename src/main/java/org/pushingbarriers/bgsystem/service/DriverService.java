package org.pushingbarriers.bgsystem.service;

import org.pushingbarriers.bgsystem.dto.BasicDriver;

import java.util.List;

/**
 * Created by baodong on 2019/12/11.
 */
public interface DriverService {
    public List<BasicDriver> findAllDrivers();
}
