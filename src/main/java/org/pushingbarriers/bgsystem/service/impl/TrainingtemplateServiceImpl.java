package org.pushingbarriers.bgsystem.service.impl;

import org.pushingbarriers.bgsystem.dao.TrainingtemplateDao;
import org.pushingbarriers.bgsystem.model.Trainingtemplate;
import org.pushingbarriers.bgsystem.service.TrainingtemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by baodong on 2019/12/3.
 */
@Service
public class TrainingtemplateServiceImpl implements TrainingtemplateService {

    @Autowired
    private TrainingtemplateDao trainingtemplateDao;

    public List<Trainingtemplate> findAllTrainingTemplateInfo(){
        return trainingtemplateDao.findAll();
    }

}
