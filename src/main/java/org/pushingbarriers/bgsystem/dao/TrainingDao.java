package org.pushingbarriers.bgsystem.dao;

import org.pushingbarriers.bgsystem.model.Training;
import org.pushingbarriers.bgsystem.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface TrainingDao extends JpaRepository<Training,Integer> {
    @Query("update Training set trainingStatus=?1 where trainingId=?2")
    @Modifying
    @Transactional
    void updateConfirmation(Integer status, Integer id);
    //Whenever you are trying to modify a record in db, you have to mark it
    //@Transactional as well as @Modifying, which instruct Spring that it can modify existing records.

    @Query("update Training set trainingDriver=?1,trainingDriverId=?2,trainingDriverGender=?3,trainingTime=?4,trainingStatus=?5, trainingNote=?6 where trainingId=?7")
    @Modifying
    @Transactional
    void updateTrainingDetail(String driver, Integer driverId, String driverGender, String time, Integer status, String note, Integer id);

    @Modifying
    @Transactional
    @Query(value = "truncate table training", nativeQuery = true)
    void truncateMyTable();

    List<Training> findTrainingsByTrainingStatus(Integer status);

    @Query(value="select new org.pushingbarriers.bgsystem.model.Trip(trainingDate, trainingDay, trainingTime, trainingPlayerId, trainingPlayer, trainingPlayerGender, trainingDriverId, trainingDriver, trainingDriverGender, trainingClub, trainingPlayerAddress, trainingAddress, trainingStatus, trainingNote) from Training")
    List<Trip> findAllTrainings();
}
