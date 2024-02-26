package org.pushingbarriers.bgsystem.service;

import org.pushingbarriers.bgsystem.model.Trainingtemplate;

import java.util.List;

/**
 * Created by baodong on 2019/12/3.
 */
public interface TrainingtemplateService {
    List<Trainingtemplate> findAllTrainingTemplateInfo();

    void updateTrainingtemplate(String day, String time, Integer playerId, String playerName,
                                       String playerGender, Integer driverId, String driverName,
                                       String driverGender, String club, String playerAddress,
                                       String trainingAddress, Integer id);

    void saveNewTraining(String day, String time, Integer playerId, String playerName,
                                String playerGender, Integer driverId, String driverName,
                                String driverGender, String club, String playerAddress,
                                String trainingAddress);

    void deleteTraining(Integer id);
}

