package org.pushingbarriers.bgsystem.service.impl;

import org.pushingbarriers.bgsystem.dao.DriverDao;
import org.pushingbarriers.bgsystem.dto.BasicDriver;
import org.pushingbarriers.bgsystem.model.Driver;
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
    public List<Driver> findAllDrivers(){
        //return driverDao.findAllDrivers();
        return driverDao.findAll();
    }

    @Override
    public List<Driver> findDriversByName(String driverName){
        return driverDao.findDriversByDriverNameContaining(driverName);
    }

    @Override
    public void resetDriverPassword(String password, Integer id){
        driverDao.resetDriverPassword(password,id);
    }
}
