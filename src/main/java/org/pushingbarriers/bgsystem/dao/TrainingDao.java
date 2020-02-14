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
    void updateStatus(Integer status, Integer id);
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

    @Query(value="select new org.pushingbarriers.bgsystem.model.Trip(trainingDate, trainingDay, trainingTime, trainingPlayerId, trainingPlayer, trainingPlayerGender, trainingDriverId, trainingDriver, trainingDriverGender, trainingClub, trainingPlayerAddress, trainingAddress, trainingStatus, trainingNote, trainingType) from Training")
    List<Trip> findAllTrainings();

    @Query(value="select * from training where training_driver_id=?1 and (training_status=0 or training_status=3)", nativeQuery = true)
    List<Training> findUnconfirmedTrainingsByDriverId(Integer driverId);

    Training findTrainingByTrainingId(Integer id);

    @Query(value="select t from Training t  where t.trainingDriverId=?1 and (t.trainingStatus = 1 or t.trainingStatus = 2)")
    List<Training> findConfirmedTrainingByDriverId(Integer driverId);
}
