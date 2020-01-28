package org.pushingbarriers.bgsystem.service.impl;

import org.pushingbarriers.bgsystem.dao.TrainingDao;
import org.pushingbarriers.bgsystem.model.Training;
import org.pushingbarriers.bgsystem.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingServiceImpl implements TrainingService {
    @Autowired
    private TrainingDao trainingDao;

    public List<Training> findAllTrainings(){
        return trainingDao.findAll();
    }

    public void updateTrainingStatus(Integer id, Integer status){
        trainingDao.updateConfirmation(status,id);
    }

    public void updateTrainingDetail(String driver,Integer driverId, String driverGender, String time, Integer status,String note, Integer id){
        trainingDao.updateTrainingDetail(driver,driverId, driverGender, time, status,note, id);
    }
}
