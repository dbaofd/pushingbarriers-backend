package org.pushingbarriers.bgsystem.service;

import org.pushingbarriers.bgsystem.model.Training;

import java.util.List;

public interface TrainingService {
    List<Training> findAllTrainings();

    void updateTrainingStatus(Integer id, Integer status);

    void updateTrainingDetail(String driver,Integer driverId, String driverGender, String time, Integer status, String note, Integer id);
}
