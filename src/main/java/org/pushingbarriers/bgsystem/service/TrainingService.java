package org.pushingbarriers.bgsystem.service;

import org.pushingbarriers.bgsystem.model.Training;

import java.util.List;

public interface TrainingService {
    public List<Training> findAllTrainings();

    public void updateConfirmationStatus(Integer id, String status);

    public void updateTrainingDetail(String driver, String time, String status, String note, Integer id);
}
