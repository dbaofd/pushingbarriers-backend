package org.pushingbarriers.bgsystem.service.impl;

import org.pushingbarriers.bgsystem.dao.TrainingtemplateDao;
import org.pushingbarriers.bgsystem.model.Trainingtemplate;
import org.pushingbarriers.bgsystem.service.TrainingtemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    public void updateTrainingtemplate(String day, String time, Integer playerId, String playerName,
                                      String playerGender, Integer driverId, String driverName,
                                      String driverGender, String club, String playerAddress,
                                      String trainingAddress, Integer id){
        Trainingtemplate trainingtemplate=trainingtemplateDao.findById(id).get();
        trainingtemplate.setTrainingDay(day);
        trainingtemplate.setTrainingTime(time);
        trainingtemplate.setTrainingPlayerId(playerId);
        trainingtemplate.setTrainingPlayer(playerName);
        trainingtemplate.setTrainingPlayerGender(playerGender);
        trainingtemplate.setTrainingDriverId(driverId);
        trainingtemplate.setTrainingDriver(driverName);
        trainingtemplate.setTrainingDriverGender(driverGender);
        trainingtemplate.setTrainingClub(club);
        trainingtemplate.setTrainingPlayerAddress(playerAddress);
        trainingtemplate.setTrainingAddress(trainingAddress);
        trainingtemplateDao.save(trainingtemplate);
    }

    public void saveNewTraining(String day, String time, Integer playerId, String playerName,
                                String playerGender, Integer driverId, String driverName,
                                String driverGender, String club, String playerAddress,
                                String trainingAddress){
        Trainingtemplate trainingtemplate=new Trainingtemplate(day,time, playerId,playerName,
                playerGender,driverId,driverName,driverGender,club,playerAddress,trainingAddress);
        trainingtemplateDao.save(trainingtemplate);

    }

    public void deleteTraining(Integer id){
        trainingtemplateDao.deleteByTrainingId(id);
    }
}
