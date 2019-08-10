package org.pushingbarriers.bgsystem.dao;

import org.pushingbarriers.bgsystem.model.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TrainingDao extends JpaRepository<Training,Integer> {
    @Query("update Training set trainingConfirmation=?1 where trainingId=?2")
    @Modifying
    @Transactional
    public void updateConfirmation(String status, Integer id);
    //Whenever you are trying to modify a record in db, you have to mark it
    //@Transactional as well as @Modifying, which instruct Spring that it can modify existing records.

    @Query("update Training set trainingDriver=?1,trainingTime=?2,trainingConfirmation=?3 where trainingId=?4")
    @Modifying
    @Transactional
    public void updateTrainingDetail(String driver, String time, String status, Integer id);
}
