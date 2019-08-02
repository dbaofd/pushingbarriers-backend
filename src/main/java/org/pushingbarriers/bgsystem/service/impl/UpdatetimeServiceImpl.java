package org.pushingbarriers.bgsystem.service.impl;

import org.pushingbarriers.bgsystem.dao.UpdatetimeDao;
import org.pushingbarriers.bgsystem.model.GameUpdateTime;
import org.pushingbarriers.bgsystem.service.UpdatetimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdatetimeServiceImpl implements UpdatetimeService {
    @Autowired
    private UpdatetimeDao updatetimeDao;

    public GameUpdateTime getUpdateTime(Integer id){
        return updatetimeDao.findGameUpdateTimeByGameupdatetimeId(id);
    }
}
