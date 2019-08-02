package org.pushingbarriers.bgsystem.service.impl;

import org.pushingbarriers.bgsystem.dao.AdminDao;
import org.pushingbarriers.bgsystem.model.Admin;
import org.pushingbarriers.bgsystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;

    public Boolean adminExistence(String adminName){
        return adminDao.existsAdminByAdminUsername(adminName);
    }

    @Override
    public Admin getAdmin(String adminName){
        return adminDao.findAdminByAdminUsername(adminName);
    }
}
