package org.pushingbarriers.bgsystem.service;

import org.pushingbarriers.bgsystem.model.Training;

import java.util.List;

public interface TrainingService {
    List<Training> findAllTrainings();

    void updateConfirmationStatus(Integer id, Integer status);

    void updateTrainingDetail(String driver, String time, String status, String note, Integer id);
}
