package org.pushingbarriers.bgsystem.dao;

import org.pushingbarriers.bgsystem.model.Trainingtemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by baodong on 2019/12/3.
 */

@Repository
public interface TrainingtemplateDao extends JpaRepository<Trainingtemplate,Integer> {
    @Modifying
    @Transactional
    public void deleteByTrainingId(Integer id);
}
