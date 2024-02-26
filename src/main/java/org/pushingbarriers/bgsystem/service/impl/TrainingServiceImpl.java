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
        trainingDao.updateStatus(status,id);
    }

    public void updateTrainingDetail(String driver,Integer driverId, String driverGender, String time, Integer status,String note, Integer id){
        trainingDao.updateTrainingDetail(driver,driverId, driverGender, time, status,note, id);
    }

    public List<Training> findTrainingsByStatus(Integer status){
        return trainingDao.findTrainingsByTrainingStatus(status);
    }

    public List<Training> findUnconfirmedTrainingsByDriverId(Integer driverId){
        return trainingDao.findUnconfirmedTrainingsByDriverId(driverId);
    }

    public List<Training> findConfirmedTrainingByDriverId(Integer driverId){
        return trainingDao.findConfirmedTrainingByDriverId(driverId);
    }

    public void confirmTraining(Integer trainingId, Integer trainingStatus, Integer trainingType, String trainingNote){
        if(trainingStatus==2||(trainingStatus==1&&trainingType==1)){
            Training training=trainingDao.findTrainingByTrainingId(trainingId);
            training.setTrainingStatus(trainingStatus);
            training.setTrainingNote(trainingNote);
            trainingDao.save(training);
        }else if(trainingStatus==1&&trainingType==2){
            Training training=trainingDao.findTrainingByTrainingId(trainingId);
            training.setTrainingStatus(trainingStatus);
            training.setTrainingType(trainingType);
            training.setTrainingNote(trainingNote);
            trainingDao.save(training);

            Training newTraining =new Training(training.getTrainingDate(),training.getTrainingDay(),
                    training.getTrainingTime(),training.getTrainingPlayerId(),training.getTrainingPlayer(),
                    training.getTrainingPlayerGender(),training.getTrainingClub(),training.getTrainingPlayerAddress(),
                    training.getTrainingAddress(),3);
            trainingDao.save(newTraining);
        }else if(trainingStatus==1&&trainingType==3){
            Training training=trainingDao.findTrainingByTrainingId(trainingId);
            training.setTrainingStatus(trainingStatus);
            training.setTrainingType(trainingType);
            training.setTrainingNote(trainingNote);
            trainingDao.save(training);

            Training newTraining =new Training(training.getTrainingDate(),training.getTrainingDay(),
                    training.getTrainingTime(),training.getTrainingPlayerId(),training.getTrainingPlayer(),
                    training.getTrainingPlayerGender(),training.getTrainingClub(),training.getTrainingPlayerAddress(),
                    training.getTrainingAddress(),2);
            trainingDao.save(newTraining);
        }
    }
}
