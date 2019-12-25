package org.pushingbarriers.bgsystem.service.impl;

import org.pushingbarriers.bgsystem.dao.DriverDao;
import org.pushingbarriers.bgsystem.dto.BasicDriver;
import org.pushingbarriers.bgsystem.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by baodong on 2019/12/11.
 */
@Service
public class DriverServiceImpl implements DriverService {
    @Autowired
    private DriverDao driverDao;

    @Override
    public List<BasicDriver> findAllDrivers(){
        return driverDao.findAllDrivers();
    }
}
