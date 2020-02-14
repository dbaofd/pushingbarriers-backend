package org.pushingbarriers.bgsystem.service;

import com.alibaba.fastjson.JSONObject;
import org.pushingbarriers.bgsystem.model.Training;

import java.util.List;

public interface TrainingService {
    List<Training> findAllTrainings();

    void updateTrainingStatus(Integer id, Integer status);

    void updateTrainingDetail(String driver,Integer driverId, String driverGender, String time, Integer status, String note, Integer id);

    List<Training> findTrainingsByStatus(Integer status);

    List<Training> findUnconfirmedTrainingsByDriverId(Integer driverId);

    List<Training> findConfirmedTrainingByDriverId(Integer driverId);

    void confirmTraining(Integer trainingId, Integer trainingStatus, Integer trainingType, String trainingNote);
}
