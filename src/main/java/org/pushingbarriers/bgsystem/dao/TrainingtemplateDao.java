package org.pushingbarriers.bgsystem.dao;

import org.pushingbarriers.bgsystem.model.Training;
import org.pushingbarriers.bgsystem.model.Trainingtemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by baodong on 2019/12/3.
 */

@Repository
public interface TrainingtemplateDao extends JpaRepository<Trainingtemplate,Integer> {
    @Modifying
    @Transactional
    void deleteByTrainingId(Integer id);

    @Query(value="select new org.pushingbarriers.bgsystem.model.Training(trainingDate, trainingDay, trainingTime, trainingPlayerId, trainingPlayer, trainingPlayerGender, trainingDriverId, trainingDriver, trainingDriverGender, trainingClub, trainingPlayerAddress, trainingAddress) from Trainingtemplate")
    List<Training> findAllTrainingTemplate();
}
